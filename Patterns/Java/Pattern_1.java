public class Pattern_1{
    public static void Pattern_1(int n)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
    public static void solve(){
        /**
        
        *
        * *
        * * *
        * * * *
        * * * * *

        */

        Pattern_1(5);

    }
    public static void main(String[] args)
    {
        solve();
    }
}