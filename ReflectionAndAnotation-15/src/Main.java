import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         Class<?> clazz= Class.forName("Reflection");

        Method[] declaredMethods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = filterMethodsBy(declaredMethods,"get");
        TreeSet<Method> setters = filterMethodsBy(declaredMethods,"set");

        getters.forEach(m->{
            System.out.printf("%s will return class %s%n",m.getName(),m.getReturnType());
        });
        setters.forEach(m->{
            System.out.printf("%s and will set field of class %s%n",m.getName(),m.getParameterTypes()[0]);
        });
    }
    public static TreeSet<Method> filterMethodsBy(Method[] methods,String filter){
        return Arrays.stream(methods)
                .filter(m -> m.getName().contains(filter))
                .collect(Collectors.toCollection(() -> {
                    return new TreeSet<>(Comparator.comparing(Method::getName));
                }));
    }
}