import BuilderPattern.Address;
import PrototypeDesignPatternDemo.Car;
import SingeltonDesignPatternDemo.SingletonDesignPatternDatabase;

public class Main {
    public static void main(String[] args) {
        SingletonDesignPatternDatabase singletonDesignPatternDatabase = SingletonDesignPatternDatabase.getInstance();
        SingletonDesignPatternDatabase singletonDesignPatternDatabase1 = SingletonDesignPatternDatabase.getInstance();
        SingletonDesignPatternDatabase singletonDesignPatternDatabase2 = SingletonDesignPatternDatabase.getInstance();
        SingletonDesignPatternDatabase singletonDesignPatternDatabase3 = SingletonDesignPatternDatabase.getInstance();
        SingletonDesignPatternDatabase singletonDesignPatternDatabase4 = SingletonDesignPatternDatabase.getInstance();
        SingletonDesignPatternDatabase singletonDesignPatternDatabase5 = SingletonDesignPatternDatabase.getInstance();

        singletonDesignPatternDatabase.create(13);

        Car car = new Car("Ford", "Mustang", 2023, "Black", 245);

        Car car2 = car.clone();

        Address address = Address.builder()
                .withCity("Sofia")
                .withCountry("Bulgaria")
                .withPhoneNumber("1234")
                .withRecipientName("Martin")
                .withPostcode("1234")
                .build();

    }
}