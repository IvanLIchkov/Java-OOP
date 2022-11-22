package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
       return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size()>=capacity){
            throw new IllegalStateException("Not enough capacity.");
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder(String.format("%s (%s):%nFish: ",this.name,getClass().getSimpleName()));
        if (fish.size()==0){
            output.append(String.format("none%n"));
        }else{
            fish.forEach(fish -> output.append(fish.getName()).append(" "));
        }
        output.append(System.lineSeparator()).append("Decorations: ").append(decorations.size());
        output.append(System.lineSeparator()).append("Comfort: ").append(calculateComfort());
        return String.valueOf(output);
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }

    public int getCapacity() {
        return capacity;
    }
}
