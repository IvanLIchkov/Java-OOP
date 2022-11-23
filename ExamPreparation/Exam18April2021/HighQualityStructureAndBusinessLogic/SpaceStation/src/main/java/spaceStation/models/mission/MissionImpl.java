package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> items = new ArrayList<>(planet.getItems());
        while (items.size() > 0 && astronauts.size()>0) {
            Astronaut astronautToExplore = astronauts.stream().filter(Astronaut::canBreath).findFirst().get();
            while (astronautToExplore.canBreath() && items.size() > 0) {
                String item = items.stream().findFirst().get();
                astronautToExplore.getBag().getItems().add(item);
                items.remove(item);
                astronautToExplore.breath();
            }
        }

    }
}
