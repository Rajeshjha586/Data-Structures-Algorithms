import java.util.Scanner;

public class reverseNumber{
    public static void reverse_Number(int num){
        while(num != 0){
            int q = num / 10;
            int r = num % 10;
            System.out.print(r + " ");
            num = q;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        reverse_Number(num);
    }
}