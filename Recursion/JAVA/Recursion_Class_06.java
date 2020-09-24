public class Recursion_Class_06
{

    static boolean[] ROWS;
    static boolean[] COLS;
    static boolean[] DIAG;
    static boolean[] ADIAG;

    //optimized code of NQueen o(1)
    public static int N_Queen_Problem_combination_06(int n, int m, int idx, int tnq, String ans)
    {
        if (tnq==0)
        {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int r=idx; r<n*m; r++)
        {
            int x = r / m;
            int y = r % m;
            if(!ROWS[x] && !COLS[y] && !DIAG[x+y] && !ADIAG[x-y+(m-1)])
            {
                ROWS[x]=true; COLS[y]=true; DIAG[x+y]=true; ADIAG[x-y+(m-1)]=true;
                count+=N_Queen_Problem_combination_06(n, m, r+1, tnq-1, ans+"("+x+","+y+") ");
                ROWS[x]=false; COLS[y]=false; DIAG[x+y]=false; ADIAG[x-y+(m-1)]=false;
            }
        }
        return count;
    }
    public static void Questions_Set_01()
    {
        int n=10;
        int m=10;
        int tnq = 10;
        ROWS = new boolean[n];
        COLS = new boolean[m];
        DIAG = new boolean[n+m-1];
        ADIAG = new boolean[n+m-1];

        System.out.println(N_Queen_Problem_combination_06(n, m, 0, tnq, ""));
    }
    public static void solve()
    {
        Questions_Set_01();
    }
    public static void main(String[] args)
    {
        solve();
    }
}