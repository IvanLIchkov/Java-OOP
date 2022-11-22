package easterRaces.entities.cars;

public class MuscleCar extends BaseCar{
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
        setHorsePower(horsePower);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower<400 || horsePower>600){
            throw new IllegalArgumentException(String.format("Invalid horse power: %d.",horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
