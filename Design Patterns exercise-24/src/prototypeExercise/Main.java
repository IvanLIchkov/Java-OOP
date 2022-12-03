package prototypeExercise;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord pesho = new EmployeeRecord(1, "pesho", "more", 150, "Sofia");
        Prototype pesho1 = pesho.getCLone();
        EmployeeRecord peshoClone = pesho;
        pesho.showRecord();

    }
}
