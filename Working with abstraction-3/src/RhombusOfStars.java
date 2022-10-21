import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        printRhombus(n);
    }
    private static void printRhombus(int n){
        printTop(n);
        printBottom(n-1);
    }

    private static void printTop(int n) {
        int stars=1;
        while (n>0){
            for (int i = 0; i <n-1 ; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <stars ; i++) {
                System.out.print("* ");
            }
            System.out.println();
            stars++;
            n--;
        }
    }

    private static void printBottom(int n) {
        int space=1;
        while (n>0){
            for (int i = 0; i <space; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <n ; i++) {
                System.out.print("* ");
            }
            System.out.println();
            space++;
            n--;
        }
    }
}