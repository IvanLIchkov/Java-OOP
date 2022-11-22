package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ControllerImpl implements Controller {

    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Car> carRepository, Repository<Race> raceRepository, Repository<Driver> driverRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public String createDriver(String driver) {
        DriverImpl driver1 = new DriverImpl(driver);
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException("Driver " + driver + " is already created.");
        }
        driverRepository.add(driver1);
        return "Driver " + driver + " is created.";
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException("Car " + model + " is already created.");
        }else{
            carRepository.add(car);
        }
        return String.format("%sCar %s is created.", type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) != null) {
            if (carRepository.getByName(carModel) != null) {
                driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));
                return "Driver " + driverName + " received car " + carModel + ".";
            } else {
                throw new IllegalArgumentException("Car " + carModel + " could not be found.");
            }
        } else {
            throw new IllegalArgumentException("Driver " + driverName + " could not be found.");
        }
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) != null) {
            if (driverRepository.getByName(driverName) != null) {
                raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));
                return String.format("Driver %s added in %s race.", driverName, raceName);
            } else {
                throw new IllegalArgumentException("Driver " + driverName + " could not be found.");
            }
        } else {
            throw new IllegalArgumentException("Race " + raceName + " could not be found.");
        }
    }

//    This method is the big deal. If everything is valid, you should arrange all Drivers and then return the three fastest
//    Drivers. To do this you should sort all Drivers in descending order by the result of CalculateRacePoints method in
//    the Car object. At the end, if everything is valid remove this Race from the race repository.
//    If the Race does not exist in RaceRepository, throw an IllegalArgumentException with message:
//            •	"Race {name} could not be found."
//    If the participants in the race are less than 3, throw an IllegalArgumentException with message:
//            •	"Race {race name} cannot start with less than 3 participants."
//    If everything is successful, you should return the following message:
//            •	"Driver {first driver name} wins {race name} race."
//            "Driver {second driver name} is second in {race name} race."
//            "Driver {third driver name} is third in {race name} race."


    @Override
    public String startRace(String raceName) {
        StringBuilder output = new StringBuilder();
        if (raceRepository.getByName(raceName) != null) {
            if (raceRepository.getByName(raceName).getDrivers().size() >= 3) {
                List<Car> carList = new ArrayList<>();
                Map<Double, Driver> racePointsAndDriver = new TreeMap<>(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2.compareTo(o1);
                    }
                });
                Collection<Driver> drivers = raceRepository.getByName(raceName)
                        .getDrivers();
                drivers.stream().forEach(driver -> {
                    double points = driver.getCar().calculateRacePoints(raceRepository.getByName(raceName).getLaps());
                    racePointsAndDriver.put(points, driver);
                });
                AtomicInteger counter = new AtomicInteger(1);
                racePointsAndDriver.entrySet()
                        .forEach(e->{
                            if (counter.get() ==1){
                                output.append(String.format("Driver %s wins %s race.",e.getValue().getName(),raceName));
                                output.append(System.lineSeparator());
                            }else if (counter.get()==2){
                                output.append(String.format("Driver %s is second in %s race.",e.getValue().getName(),raceName));
                                output.append(System.lineSeparator());
                            }else if (counter.get()==3){
                                output.append(String.format("Driver %s is third in %s race.",e.getValue().getName(),raceName));
                            }
                            counter.getAndIncrement();
                        });

            } else {
                throw new IllegalArgumentException("Race " + raceName + " cannot start with less than 3 participants.");
            }
        } else {
            throw new IllegalArgumentException("Race " + raceName + " could not be found.");
        }
        return String.valueOf(output);
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name)==null){
            raceRepository.add(new RaceImpl(name,laps));
            return "Race "+name+" is created.";
        }else {
            throw new IllegalArgumentException("Race "+name+" is already created.");
        }
    }
}
