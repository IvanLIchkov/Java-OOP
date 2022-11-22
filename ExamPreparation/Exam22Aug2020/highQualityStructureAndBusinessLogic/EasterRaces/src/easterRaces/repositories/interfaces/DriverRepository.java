package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class DriverRepository<T extends Driver> implements Repository{

    private Collection<T> drivers = new ArrayList<>();

    @Override
    public Object getByName(String name) {
        return drivers.stream()
                .filter(d->d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection getAll() {
        return drivers;
    }

    @Override
    public void add(Object model) {
        drivers.add((T) model);
    }

    @Override
    public boolean remove(Object model) {
        return drivers.remove(model);
    }
}
