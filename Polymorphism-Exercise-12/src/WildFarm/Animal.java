package WildFarm;

public abstract class Animal implements AnimalInterface {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }


    @Override
    public void eat(Food food) {
        String foodType= String.valueOf(food.getClass().getSimpleName());
        String animalType=getAnimalType();
       switch (animalType){
           case "Tiger":
               switch (foodType){
                   case "Vegetable":
                       System.out.println("Tigers are not eating that type of food!");
                       break;
                   case "Meat":
                       setFoodEaten(food.getQuantity());
                       break;
               }
               break;
           case "Mouse":
               switch (foodType){
                   case "Vegetable":
                       setFoodEaten(food.getQuantity());
                       break;
                   case "Meat":
                       System.out.println("Mice are not eating that type of food!");
                       break;
               }
               break;
           case "Zebra":
               switch (foodType){
                   case "Vegetable":
                       setFoodEaten(food.getQuantity());
                       break;
                   case "Meat":
                       System.out.println("Zebras are not eating that type of food!");
                       break;
               }
               break;
           default:
               setFoodEaten(food.getQuantity());
               break;
       }
    }
}
