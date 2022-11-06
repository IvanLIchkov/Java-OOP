package blackBoxInteger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final static Scanner SCAN = new Scanner(System.in);
    private final static Map<String, Method> NAME_METHOD_MAP =
            Arrays.stream(BlackBoxInt.class.getDeclaredMethods())
                    .peek(method -> method.setAccessible(true))
                    .collect(Collectors.toMap(Method::getName, method -> method));
    private final static String END_COMMAND = "END";

    private final static String RESULT = "innerValue";


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        final Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);

        final BlackBoxInt blackBoxInt = constructor.newInstance(0);

        String input;
        while (!END_COMMAND.equals(input = SCAN.nextLine())) {
            final String[] tokens = input.split("_");
            final String methodName = tokens[0];
            final int value = Integer.parseInt(tokens[1]);

            final Method currentMethod = NAME_METHOD_MAP.get(methodName);
            currentMethod.invoke(blackBoxInt, value);

            final Field result = blackBoxInt.getClass().getDeclaredField(RESULT);
            result.setAccessible(true);
            System.out.println(result.get(blackBoxInt));

        }
        SCAN.close();
    }
}
