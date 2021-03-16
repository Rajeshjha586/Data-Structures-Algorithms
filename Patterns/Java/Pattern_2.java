public class Pattern_2{
    public static void Pattern_2(int n)
    {
        for(int i=5; i>=1; i--)
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
        
        * * * * * 
        * * * * 
        * * * 
        * * 
        * 
        
        */

        Pattern_2(5);

    }
    public static void main(String[] args)
    {
        solve();
    }
}