package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

public class DriverImpl implements Driver{
//    •	name - String
//    o	If the name is null, empty or less than 5 symbols throw an IllegalArgumentException with message "Name {name} cannot be less than 5 symbols."
//    o	All names are unique
//•	car - Car
//•	numberOfWins - int
//•	canParticipate - boolean
//    o	Default behaviour is false
//    o	Driver can participate in race, ONLY if he has a Car (Car is not null)
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    public void setName(String name) {
            if (name == null || name.trim().isEmpty() || name.length()<5){
                throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.",name));
            }
            this.name = name;
    }

    public void setCanParticipate(boolean canParticipate) {
        if(this.car!=null){
            this.canParticipate=true;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car==null){
            throw new IllegalArgumentException("Car cannot be null.");
        }
        this.car = car;
        setCanParticipate(canParticipate);
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
