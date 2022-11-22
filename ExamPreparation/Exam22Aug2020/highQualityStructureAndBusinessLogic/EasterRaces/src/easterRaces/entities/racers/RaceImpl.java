package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public  class RaceImpl implements Race {

    //    •	name - String
//    o	If the name is null, empty or less than 5 symbols throw an IllegalArgumentException with message "Name {name} cannot be less than 5 symbols."
//    o	All names are unique
//•	laps - int
//    o	Throws IllegalArgumentException with message "Laps cannot be less than 1.", if the laps are less than 1.
//            •	drivers -  A collection of Drivers
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException("Laps cannot be less than 1.");
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver != null) {
            if (driver.getCanParticipate()) {
                if (drivers.contains(driver)) {
                    throw new IllegalArgumentException(String.format("Driver %s is already added in %s race", driver.getName(), this.name));
                } else {
                    drivers.add(driver);
                }
            } else {
                throw new IllegalArgumentException(String.format("Driver %s could not participate in race.", driver.getName()));
            }
        } else {
            throw new IllegalArgumentException("Driver cannot be null.");
        }
    }
}
