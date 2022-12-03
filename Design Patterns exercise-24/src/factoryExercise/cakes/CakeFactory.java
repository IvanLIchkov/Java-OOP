package factoryExercise.cakes;

import factoryExercise.cakes.BiscuitCake;
import factoryExercise.cakes.Cake;
import factoryExercise.cakes.ChocolateCake;
import factoryExercise.cakes.SpinachCake;

public class CakeFactory {
    public static Cake createCake(String cakeType) {
        Cake cake = null;
        switch (cakeType) {
            case "Spinach":
                cake = new SpinachCake(12, 12, 12);
                break;
            case "Chocolate":
                cake = new ChocolateCake(12, 12, 12);
                break;
            case "Biscuit":
                cake = new BiscuitCake(12, 12, 12);
                break;
        }
        return cake;
    }
}
