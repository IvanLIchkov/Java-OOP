package SingeltonDesignPatternDemo;

public class SingletonDesignPatternDatabase {

    private static SingletonDesignPatternDatabase instance;

    private SingletonDesignPatternDatabase(){
    }

    public static SingletonDesignPatternDatabase getInstance() {

        if (instance == null){
            System.out.println("Creating database");
            instance = new SingletonDesignPatternDatabase();
        }

        return instance;
    }
    public <T> void create(T object){
        System.out.println("Saving in database "+ object.toString());
    }
}
