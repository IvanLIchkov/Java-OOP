package singleton.DatabseExample;

public class DatabaseConnection {

    private static DatabaseConnection insatnce;

    private DatabaseConnection() {
        try {
            Thread.sleep(5_00);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static DatabaseConnection getInstance(){
        if (insatnce == null){
            insatnce = new DatabaseConnection();
        }
        return insatnce;
    }
    public void readData(){
        System.out.println("Reading from DB");
    }
    public void writeData(){
        System.out.println("Writing to DB");
    }
}
