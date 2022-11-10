import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] range = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int begin=range[0];
        int end=range[1];

        String input= scan.nextLine();

        boolean isInRange = false;
        System.out.printf("Range: [%d...%d]%n",begin,end);

        while (!isInRange){
            Optional<Integer> number = Optional.empty();
            try{
                number =Optional.of(Integer.parseInt(input));
            }catch (NumberFormatException ignored){
            }

            if (number.isEmpty() || number.get()<begin || number.get()>end){
                System.out.println("Invalid number: "+input);
                input = scan.nextLine();
            }else{
                isInRange = true;
            }
        }
        System.out.println("Valid number: "+ input);
    }
}
