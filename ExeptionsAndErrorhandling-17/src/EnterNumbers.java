import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {

    public static int start=1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> numberList=new ArrayList<>();
        while (numberList.size()<10){
            String number = scan.nextLine();
            try {
                int n=Integer.parseInt(number);
                readNumber(n);
                numberList.add(number);
            }catch (NumberFormatException formatException){
                System.out.println("Invalid Number!");
            }catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        System.out.println(String.join(", ", numberList));
    }

    private static void readNumber(int s) {
        if (s>start){
            start=s;
        }else {
            throw new IllegalArgumentException("Your number is not in range "+start+" - "+100+"!");
        }
    }
}
