import java.lang.reflect.*;
import java.util.TreeSet;
import java.util.function.Function;

public class GettersAndSetters {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         Class<?> clazz= Class.forName("Reflection");

        Method[] declaredMethods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(declaredMethods,"get"));
        TreeSet<Method> setters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(declaredMethods,"set"));

        Function<Class<?>, String>formatType=c->c==int.class?"class int": c.toString();

        getters.forEach(m->{
            System.out.printf("%s will return %s%n",m.getName(),formatType.apply(m.getReturnType()));
        });
        setters.forEach(m->{
            System.out.printf("%s and will set field of %s%n",m.getName(),formatType.apply(m.getParameterTypes()[0]));
        });
    }
}