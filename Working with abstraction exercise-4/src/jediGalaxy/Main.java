package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getPosition(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        StarsField starsField = new StarsField(rows, cols);
        Galaxy galaxy = new Galaxy(starsField);

        String command = scanner.nextLine();
        long sumOfStarsValues=0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = getPosition(command);
            int[] evilPosition = getPosition(scanner.nextLine());

            int rowEvil = evilPosition[0];
            int cowEvil = evilPosition[1];

            galaxy.moveEvil(rowEvil, cowEvil);

            int rowJedi = jediPosition[0];
            int colJedi = jediPosition[1];
            sumOfStarsValues = galaxy.moveJedi(rowJedi,colJedi);

            command = scanner.nextLine();

        }
        System.out.println(sumOfStarsValues);

    }

    private static int[] getPosition(String command) {
        return Arrays.stream(command
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
