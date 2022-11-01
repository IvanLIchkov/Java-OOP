package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();
        DecimalFormat format=new DecimalFormat("#.##");
        output.append(String.format("%s[%s, %s, %s, %s, %d]",getAnimalType(),getAnimalName(),breed,format.format(getAnimalWeight()),getLivingRegion(),getFoodEaten()));
        return String.valueOf(output);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
