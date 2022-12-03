package factoryExercise;

import factoryExercise.cakes.Cake;
import factoryExercise.cakes.CakeFactory;

public class PastryShop {

    public static Cake orderCake(String cakeType){
        Cake cake = CakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();
        return cake;
    }
}
