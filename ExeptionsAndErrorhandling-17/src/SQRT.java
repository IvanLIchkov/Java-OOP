import java.util.Scanner;

public class SQRT {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input= scan.nextLine();

        try {
            int n = Integer.parseInt(input);
            System.out.printf("%.2f%n", sqrt(n));
        }catch (IllegalArgumentException e){
            System.out.println("Invalid ");
        }
        System.out.println("Goodbye");
    }

    public static double sqrt(int n){
        if (n<0){
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(n);
    }
}
