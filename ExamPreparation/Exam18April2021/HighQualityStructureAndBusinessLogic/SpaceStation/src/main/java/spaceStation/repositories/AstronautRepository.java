package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;

public class AstronautRepository implements Repository<Astronaut>{

    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return astronauts.stream().filter(astronaut -> astronaut.getName().equals(name)).findFirst().orElse(null);
    }

}
