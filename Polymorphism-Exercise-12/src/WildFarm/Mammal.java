package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();
        DecimalFormat format=new DecimalFormat("#.##");
        output.append(String.format("%s[%s, %s, %s, %d]",getAnimalType(),getAnimalName(),format.format(getAnimalWeight()),getLivingRegion(),getFoodEaten()));
        return String.valueOf(output);
    }
}
