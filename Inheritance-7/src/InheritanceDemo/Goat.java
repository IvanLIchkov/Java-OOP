package InheritanceDemo;

public class Goat extends Organism{
    int milkGiven;

    public Goat(int weight, int height, int milkGiven) {
        super(weight, height);
        this.milkGiven = milkGiven;
    }

    @Override
    public void move() {
        System.out.print("Goat is ");
        super.move();

    }
}
