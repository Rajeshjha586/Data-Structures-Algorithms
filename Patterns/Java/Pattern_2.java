public class Pattern_2{
    public static void Pattern_2(int n)
    {
        int sp = 0;
        int st = n;
        for(int i=5; i>=1; i--)
        {
            for(int j=1; j<=st; j++)
            {
                System.out.print("*\t");
            }

            for(int j=1; j<=sp; j++)
            {
                System.out.print("\t");
            }

            sp++;
            st--;
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