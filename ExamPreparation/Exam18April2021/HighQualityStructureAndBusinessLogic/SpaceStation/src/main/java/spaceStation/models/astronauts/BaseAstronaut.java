package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.name = name;
        this.oxygen = oxygen;
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen>0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen = getOxygen()-10;
    }

    public void setOxygen(double oxygen) {
        if (oxygen<0){
            canBreath();
            throw new IllegalArgumentExeption("Cannot create Astronaut with negative oxygen!");
        }
        this.oxygen=oxygen;
    }
}
