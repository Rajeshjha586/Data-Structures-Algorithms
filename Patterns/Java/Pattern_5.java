public class Pattern_5{
    public static void Pattern_5(int n)
    {
        int sp = n/2;
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

            if(i<=n/2){
                sp--;
                st+=2;
            }else{
                sp++;
                st-=2;
            }
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

        Pattern_5(5);

    }
    public static void main(String[] args)
    {
        solve();
    }
}