package barracksWars.core.factories;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";
    private final Repository repository;
    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("all")
    public Executable interpretCommand(String[] data, String commandName)  {
        final String finalCommandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        Executable executable = null;
        try {
            Class<? extends Executable> commandClass = (Class<? extends Executable>) Class.forName(COMMAND_PACKAGE + finalCommandName);

            Constructor<? extends Executable> wantedConstructor = commandClass.getDeclaredConstructor(String[].class);
            wantedConstructor.setAccessible(true);

            executable = wantedConstructor.newInstance(new Object[]{data});

            final Field[] wantedFields = executable.getClass().getDeclaredFields();

            final Field[] curenntFields = this.getClass().getDeclaredFields();

            for (Field wantedField : wantedFields) {
                if (wantedField.isAnnotationPresent(Inject.class)){
                    for (Field field : curenntFields) {
                        if (wantedField.getType().equals(field.getType())){
                            wantedField.setAccessible(true);
                            wantedField.set(executable, field.get(this));
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return executable;
    }
}
