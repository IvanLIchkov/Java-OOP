public class Main {
    public static void main(String[] args) {
        Animal dog=new Dog();
        Animal cat=new Cat();

        feedAnimal(dog);
        feedAnimal(cat );
    }
    public static void feedAnimal(Animal animal){
        animal.eat();
    }
}
