package easterRaces;

import easterRaces.core.ControllerImpl;
import easterRaces.core.EngineImpl;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarRepository<Car> motorcycleRepository = new CarRepository<>(); // TODO: new CarRepository<>();
        RaceRepository<Race> raceRepository = new RaceRepository<>(); // TODO: new RaceRepository<>();
        DriverRepository<Driver> riderRepository = new DriverRepository<>(); // TODO: new DriverRepository<>();

        Controller controller = new ControllerImpl(motorcycleRepository,raceRepository,riderRepository); // TODO: new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
