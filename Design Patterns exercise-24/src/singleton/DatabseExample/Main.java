package singleton.DatabseExample;

import singleton.DatabseExample.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connectionForReading = DatabaseConnection.getInstance();
        connectionForReading.readData();
        DatabaseConnection connectionForWriting = DatabaseConnection.getInstance();
        connectionForWriting.writeData();
        System.out.println("Finished");
    }
}