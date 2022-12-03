package singleton.ZooExample;

public class Owner {
    public void buyAnimal(String animalType, Integer count){
        Zoo.getInstance().getAnimals().put(animalType,count);
    }
}
