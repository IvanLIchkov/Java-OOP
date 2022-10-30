import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        if (input.matches(".*\\d.*")){
            System.out.println("da");
        }else{
            System.out.println("ne");
        }
    }
}