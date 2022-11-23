package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet{

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name, Collection<String> items) {
        setName(name);
        this.items = items;
    }

    public void setName(String name) {
        if (name == null||name.trim().isEmpty()){
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
