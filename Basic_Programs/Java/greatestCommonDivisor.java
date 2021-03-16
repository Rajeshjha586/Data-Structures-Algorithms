import java.util.Scanner;

public class greatestCommonDivisor{
    public static void greatest_Common_Divisor(int a, int b){
        while(b % a != 0){
            int c = b % a;
            b = a;
            a = c;
        }
        System.out.println(a);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        greatest_Common_Divisor(a, b);
    }
}