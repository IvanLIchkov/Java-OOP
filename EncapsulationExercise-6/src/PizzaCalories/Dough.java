package PizzaCalories;

public class Dough {
    private String flourType;
    private String bankingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 1200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
            case "Chewy":
            case "Wholegrain":
            case "Crispy":
            case "Homemade":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bankingTechnique = bakingTechnique;
                break;
            case "Chewy":
                this.bankingTechnique = bakingTechnique;
                break;
            case "Homemade":
                this.bankingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        DoughModifiers doughModifiersFlour = DoughModifiers.parse(flourType);
        DoughModifiers doughModifiersTechnique = DoughModifiers.parse(bankingTechnique);
        return (2 * weight) * doughModifiersFlour.getModifier() * doughModifiersTechnique.getModifier();
    }
}
