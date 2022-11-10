import java.util.Scanner;

public class NumberInRange {
    private static Scanner scan = new Scanner(System.in);
    private  final static int a= scan.nextInt();
    private  final static int b= scan.nextInt();
    public static void main(String[] args) {
        scan.nextLine();
        System.out.printf("Range: [%d...%d]%n",a,b);


        while (!validateNumber()){
            validateNumber();
        }
    }
    public static boolean validateNumber(){
        try {
            System.out.printf("Valid number: %d",readNumber());
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static int readNumber(){
        String n= scan.nextLine();
        try {
            int number=Integer.parseInt(n);
            if (a <= number && b >= number) {
                return number;
            } else {
                throw new NumberFormatException("Invalid number: " + n);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("Invalid number: " + n);
        }
    }
}
