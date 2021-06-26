public class Pattern {
    /**
      Pattern :-
        * 
        *  * 
        *  *  * 
        *  *  *  * 
        *  *  *  *  * 
     */
    public static void Pattern(int n) {
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++) {
                System.out.print("*" + " ");
            }
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