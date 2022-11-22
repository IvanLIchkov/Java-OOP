package aquarium.entities.fish;

public abstract class BaseFish implements Fish{

    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }


    public void setSpecies(String species) {
        if (species==null || species.trim().isEmpty()){
            throw new NullPointerException("Fish name cannot be null or empty.");
        }
        this.species = species;
    }

    @Override
    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new NullPointerException("Fish species cannot be null or empty.");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException("Fish price cannot be below or equal to 0.");
        }
        this.price = price;
    }

    @Override
    public void eat() {
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
