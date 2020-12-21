import java.util.Scanner;

public class isPrime
{
    public static void isPrime_Number_01(int n)
    {
        int count = 0;
        for(int div=2; div*div<=n; div++)
        {
            if(n % div == 0)
            {
                count++;
                break;
            }
        }

        if(count == 0)
        {
            System.out.println("IS Prime Number");
        }
        else
        {
            System.out.println("Not Prime Number"); 
        }
    }
    public static void isPrime_Number(int n)  
    {
        int count = 0;
        for(int div=1; div<=n; div++)
        {
            if(n % div == 0)
            {
                count++;
            }
        }

        if(count == 2)
        {
            System.out.println("IS Prime Number");
        }
        else
        {
            System.out.println("Not Prime Number"); 
        }
    }
    public static void solve()
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for(int i=1; i<=t; i++)  // t=10 pow 4
        {
            int n = scn.nextInt();

            //isPrime_Number(n);  // n=10 pow 9        =>  which is 10 pow 13
            isPrime_Number_01(n); 
        }
    }
    public static void main(String[] args)
    {
        solve();
    }
}