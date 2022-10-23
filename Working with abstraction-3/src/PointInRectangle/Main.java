package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates= getCoordinates(scan);
        Point A=new Point(coordinates[0],coordinates[1]);
        Point C=new Point(coordinates[2],coordinates[3]);
        Rectangle rect=new Rectangle(A, C);

        int n=Integer.parseInt(scan.nextLine());
        while (n-- >0){
            int[] pointCoordinates=getCoordinates(scan);
            Point x=new Point(pointCoordinates[0], pointCoordinates[1]);
            boolean isInside=rect.contains(x);
            System.out.println(isInside);
        }
    }

    private static int[] getCoordinates(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
