import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz=Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();
        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Field> fields = ReflectionUtils.collectByName(Arrays.stream(declaredFields));
        ReflectionUtils.filterMembers(fields.stream(), f-> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f-> System.out.printf("%s must be private!%n",f.getName()));


        TreeSet<Method> getters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods,"get"));
        ReflectionUtils.filterMembers(getters.stream(), g-> !Modifier.isPublic(g.getModifiers()))
                .forEach(f-> System.out.printf("%s have to be public!%n",f.getName()));

        TreeSet<Method> setters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods,"set"));
        ReflectionUtils.filterMembers(setters.stream(), s-> !Modifier.isPrivate(s.getModifiers()))
                .forEach(f-> System.out.printf("%s have to be private!%n",f.getName()));
    }
}
