public class Recursion_Part_06
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

    static int rows=0;
    static int cols=0;
    static int diag=0;
    static int adiag=0;
    public static int N_Queen_Problem_combination_07(int n, int m, int idx, int tnq, String ans)
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
            if((rows & (1<<x))==0 && (cols & (1<<y))==0 && (diag & (1<<(x+y)))==0 && (adiag & (1<<(x-y+(m-1))))==0)
            {
                rows ^= (1<<x);
                cols ^= (1<<y);
                diag ^= (1<<(x+y));
                adiag ^= (1<<(x-y + (m-1)));

                count+=N_Queen_Problem_combination_07(n, m, r+1, tnq-1, ans+"("+x+","+y+") ");
                
                rows ^= (1<<x);
                cols ^= (1<<y);
                diag ^= (1<<(x+y));
                adiag ^= (1<<(x-y + (m-1)));
            }
        }
        return count;
    }


    
    // Not Optimized
    public static int count_All_sets_bits_01(int num)
    {
        int count=0;
        for(int i=0; i<32; i++)
        {
            int mask = (1 << i);
            if( (num & mask) != 0)
            {
                count++;
            }
        }

        return count;
    }

    //optimized
    public static int count_All_sets_bits_02(int num)
    {
        int count=0;
        
        // infinte loop i.e for case -1 or -value
        while(num != 0)
        {
            if( (num & 1) != 0)
            {
                count++;
            }

            num >>= 1;
        }

        return count;
    }

    //optimized
    public static int count_All_sets_bits_03(int num)
    {
        int count=0;
        
        // infinte loop i.e for case -1 or -value
        while(num != 0)
        {
            if( (num & 1) != 0)
            {
                count++;
            }

            num >>>= 1;
        }

        return count;
    }

    // leetcode :- 191 Number of 1 bits
    //more optimized
    public static int count_All_sets_bits_04(int num)
    {
        int count=0;
        
        while(num != 0)
        {
            count++;
            num &= (num-1);
        }

        return count;
    }

    public static int Unique_Number_in_Array(int[] arr)
    {
        int res=0;
        for(int ele : arr)
        {
            res ^= ele;
        }
        return res;
    }

    //Leetcode :- 231 Power of two
    public static boolean isPowerOfTwo(int n) 
    {
        return n>0 && (n & (n-1)) == 0;
    }

    //Leetcode :- 338 counting bits
    public static int[] counting_bits(int num)
    {
        int[] ans = new int[num+1];
        for(int i=1; i<=num; i++)
        {
            ans[i] = ans[(i & (i-1))] + 1;
        }

        return ans;
    }



    public static void Bits_Questions_Set_02()
    {
        //System.out.println(count_All_sets_bits_01(13));
        //System.out.println(count_All_sets_bits_02(15));
        //System.out.println(count_All_sets_bits_03(-1));
        //System.out.println(count_All_sets_bits_04(15));
        //System.out.println(count_All_sets_bits_04(00000000000000000000000000001011));

        //int[] arr = {2, 2, 4, 3, 4, 5, 7, 5, 3};
        //System.out.println(Unique_Number_in_Array(arr));

        //System.out.println(isPowerOfTwo(15));

        /*

        int[] res = counting_bits(10);
        for(int i=0; i<res.length; i++)
        {
            System.out.print(res[i] + " ");
        }

        */
    }

    public static void Questions_Set_01()
    {
        int n=4;
        int m=4;
        int tnq = 4;
        ROWS = new boolean[n];
        COLS = new boolean[m];
        DIAG = new boolean[n+m-1];
        ADIAG = new boolean[n+m-1];

        //System.out.println(N_Queen_Problem_combination_06(n, m, 0, tnq, ""));
        
        System.out.println(N_Queen_Problem_combination_07(n, m, 0, tnq, ""));
    }

    public static void solve()
    {
        Questions_Set_01();

        //Bits_Questions_Set_02();
    }
    public static void main(String[] args)
    {
        solve();
    }
}