public class Pattern {
    /**
      Pattern :-
        *	*	*	*	*	
            *	*	*	*	
                *	*	*	
                    *	*	
                        *	
     */
    public static void Pattern(int n) {
        int sp = 0;
        int st = n;
        for(int i=1; i<=n; i++){
            // System.out.print(sp + " : " + st);
            for(int j=1; j<=sp; j++) {
                System.out.print("\t");
            }

            for(int j=1; j<=st; j++) {
                System.out.print("*\t");
            }

            sp++;
            st--;
            System.out.println();
        }
    }
    public static void solve() {
        Pattern(5);
    }
    public static void main(String[] args) {
        solve();
    }
}