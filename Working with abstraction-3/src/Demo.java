import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DayOfWeek dayOfWeek=DayOfWeek.TUESDAY;

        System.out.println(dayOfWeek.getDayNumber());
    }
}