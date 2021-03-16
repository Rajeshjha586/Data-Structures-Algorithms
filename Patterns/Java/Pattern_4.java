public class Pattern_4{
    public static void Pattern_4(int n)
    {
        int sp = 0;
        int st = n;
        for(int i=1; i<=5; i++)
        {
            for(int j=1; j<=sp; j++)
            {
                System.out.print("\t");
            }
            for(int j=1; j<=st; j++)
            {
                System.out.print("*\t");
            }

            sp++;
            st--;
            System.out.println();
        }
    }
    public static void solve(){
        /**
        
        *	*	*	*	*	
            *	*	*	*	
                *	*	*	
                    *	*	
                        *	
        
        */

        Pattern_4(5);

    }
    public static void main(String[] args)
    {
        solve();
    }
}