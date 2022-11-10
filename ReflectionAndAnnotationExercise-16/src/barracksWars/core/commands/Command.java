package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public abstract class Command implements Executable {
    private final String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return null;
    }
}
