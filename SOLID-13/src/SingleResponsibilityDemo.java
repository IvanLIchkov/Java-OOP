import java.util.Scanner;

public class SingleResponsibilityDemo {
    public String readLine(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public void printLine(String str){  //TODO it's not good one class thi have two function
        System.out.println(str);       // in our case readLine and printLine that need to be two different classes and layer merged in one
    }
}