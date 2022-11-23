package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private MissionImpl mission;
    private int exploredPlanets = 0;


    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException("Astronaut type doesn't exists!");
        }
        astronautRepository.add(astronaut);
        return String.format("Successfully added %s: %s!",type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        planetRepository.add(new PlanetImpl(planetName, List.of(items)));
        return String.format("Successfully added Planet: %s!",planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautForRetire = astronautRepository.findByName(astronautName);
        if (astronautForRetire==null){
            throw new IllegalArgumentException(String.format("Astronaut %s doesn't exists!",astronautName));
        }
        astronautRepository.remove(astronautForRetire);
        return String.format("Astronaut %s was retired!",astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planetToExplore = planetRepository.findByName(planetName);

        List<Astronaut> astronautsThatCanGoOnAMission = astronautRepository.getModels().stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());
        if (astronautsThatCanGoOnAMission.size()==0){
            throw new IllegalArgumentException("You need at least one astronaut to explore the planet!");
        }
        int countOfAstronautsOnStart = astronautsThatCanGoOnAMission.size();
        mission.explore(planetToExplore,astronautsThatCanGoOnAMission);
        this.exploredPlanets++;
        long deadAstronauts = astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() <= 0).count();
        return String.format("Planet: %s was explored! Exploration finished with %d" +
                " dead astronauts!",planetName,deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder(String.format("%d planets were explored!%n", exploredPlanets));
        output.append("Astronauts info:");
        astronautRepository.getModels().forEach(astronaut -> {
            output.append(System.lineSeparator());
            output.append("Name: ").append(astronaut.getName()).append(System.lineSeparator());
            output.append("Oxygen: ").append(String.format("%.0f",astronaut.getOxygen())).append(System.lineSeparator());
            output.append("Bag items: ");
            Collection<String> items = astronaut.getBag().getItems();
            if (items.size()==0){
                output.append("none");
            }else{
                output.append(String.join(", ",items));
            }
        });
        return String.valueOf(output);
    }
}
