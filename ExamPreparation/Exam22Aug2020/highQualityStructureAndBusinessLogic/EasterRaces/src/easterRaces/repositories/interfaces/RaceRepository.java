package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository<T extends Race> implements Repository{

    private Collection<T> races = new ArrayList<>();


    @Override
    public T getByName(String name) {
        return races.stream()
                .filter(r->r.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection getAll() {
        return races;
    }

    @Override
    public void add(Object model) {
        races.add((T) model);
    }

    @Override
    public boolean remove(Object model) {
        return races.remove(model);
    }
}
