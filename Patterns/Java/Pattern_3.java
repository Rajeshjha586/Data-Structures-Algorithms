public class Pattern_3{
    public static void Pattern_3(int n)
    {
        int sp = n-1;
        int st = 1;
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

            sp--;
            st++;
            System.out.println();
        }
    }
    public static void solve(){
        /**
        
                        *	
                    *	*	
                *	*	*	
            *	*	*	*	
        *	*	*	*	*	
        
        */

        Pattern_3(5);

    }
    public static void main(String[] args)
    {
        solve();
    }
}