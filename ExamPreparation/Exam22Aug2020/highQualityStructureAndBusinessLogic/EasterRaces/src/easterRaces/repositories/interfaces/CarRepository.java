package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;

public class CarRepository<T extends Car> implements Repository{

    private Collection<T> cars = new ArrayList<>();

    @Override
    public Object getByName(String name) {
        return cars.stream()
                .filter(c->c.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection getAll() {
        return cars;
    }

    @Override
    public void add(Object model) {
        cars.add((T) model);
    }

    @Override
    public boolean remove(Object model) {
        return cars.remove(model);
    }
}
