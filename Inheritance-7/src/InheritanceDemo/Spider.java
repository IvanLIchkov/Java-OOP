package InheritanceDemo;

public class Spider extends Organism{
    int fliesEaten;

    public Spider(int weight, int height, int fliesEaten) {
        super(weight, height);
        this.fliesEaten = fliesEaten;
    }
}
