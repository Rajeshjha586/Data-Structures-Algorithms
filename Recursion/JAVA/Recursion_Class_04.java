public class Recursion_Class_04
{
    public static int coinChange_Permutation_INF(int[] arr, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int ele : arr)
        {
            if(tar-ele>=0)
            {
                count+=coinChange_Permutation_INF(arr, tar-ele, ans + ele + " ");
            }
        }
        return count;
    }

    public static int coinChange_Permutation_INF_001(int[] arr, int idx, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx; i<arr.length; i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=coinChange_Permutation_INF_001(arr, 0, tar-arr[i], ans + arr[i] + " ");
            }
        }
        return count;
    }

    public static int coinChange_Permutation_1_coin_atA_Time(int[] arr, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=0; i<arr.length; i++)
        {
            int temp = arr[i];
            if(arr[i] > 0 && tar-arr[i]>=0)
            {
                arr[i] = -arr[i];
                count+=coinChange_Permutation_1_coin_atA_Time(arr, tar-temp, ans + temp + " ");
                arr[i] = -arr[i];
            }
        }
        return count;
    }

    public static int coinChange_Permutation_1_coin_atA_Time_001(int[] arr, int idx, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx; i<arr.length; i++)
        {
            int temp = arr[i];
            if(arr[i] > 0 && tar-arr[i]>=0)
            {
                arr[i] = -arr[i];
                count+=coinChange_Permutation_1_coin_atA_Time_001(arr, 0, tar-temp, ans + temp + " ");
                arr[i] = -arr[i];
            }
        }
        return count;
    }

    public static int coinChange_Combination_INF(int[] arr, int idx, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx; i<arr.length; i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=coinChange_Combination_INF(arr, i, tar-arr[i], ans + arr[i] + " ");
            }
        }
        return count;
    }

    public static int coinChange_Combination_1_coin_atA_Time(int[] arr, int idx, int tar, String ans)
    {
        if(tar == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx; i<arr.length; i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=coinChange_Combination_1_coin_atA_Time(arr, i+1, tar-arr[i], ans + arr[i] + " ");
            }
        }
        return count;
    }







    public static int coinChange_Combination_1_coin_atA_Time_01(int[] arr, int idx, int tar, String ans)
    {
        if(idx==arr.length || tar==0)
        {
            if(tar==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0)
        {
            count+=coinChange_Combination_1_coin_atA_Time_01(arr, idx+1, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Combination_1_coin_atA_Time_01(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Combination_INF_01(int[] arr, int idx, int tar, String ans)
    {
        if(idx==arr.length || tar==0)
        {
            if(tar==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0)
        {
            count+=coinChange_Combination_INF_01(arr, idx, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Combination_INF_01(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Permutation_INF_01(int[] arr, int idx, int tar, String ans)
    {
        if(idx==arr.length || tar==0)
        {
            if(tar==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0)
        {
            count+=coinChange_Permutation_INF_01(arr, 0, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Permutation_INF_01(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Permutation_1_coin_atA_Time_01(int[] arr, int idx, int tar, String ans)
    {
        if(idx==arr.length || tar==0)
        {
            if(tar==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(arr[idx]>0 && tar-arr[idx]>=0)
        {
            int temp = arr[idx];
            arr[idx] = -arr[idx];
            count+=coinChange_Permutation_1_coin_atA_Time_01(arr, 0, tar-temp, ans+temp+" ");
            arr[idx] = -arr[idx];
        }
        count+=coinChange_Permutation_1_coin_atA_Time_01(arr, idx+1, tar, ans);

        return count;
    }

    public static int queen_Combination_1D(boolean[] rooms, int room, int qpsf, int tnq, String ans)
    {
        if(qpsf == tnq)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int r=room; r<rooms.length; r++)
        {
            count+=queen_Combination_1D(rooms, r+1, qpsf+1, tnq, ans+"Q"+qpsf+"R"+r+" ");
        }
        return count;
    }

    public static int queen_Permutation_1D(boolean[] rooms, int room, int qpsf, int tnq, String ans)
    {
        if(qpsf == tnq)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int r=room; r<rooms.length; r++)
        {
            if(!rooms[r])
            {
                rooms[r] = true;
                count+=queen_Permutation_1D(rooms, 0, qpsf+1, tnq, ans+"Q"+qpsf+"R"+r+" ");
                rooms[r] = false;
            }
        }
        return count;
    }

    public static int queen_Combination_2D(boolean[][] rooms, int room, int tnq, String ans)
    {
        if(tnq==0)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;
        for(int r=room; r<rooms.length*rooms[0].length; r++)
        {
            int x = r / rooms[0].length;
            int y = r % rooms[0].length;

            count+=queen_Combination_2D(rooms, r+1, tnq-1, ans+"("+x+","+y+") ");
        }

        return count;
    }

    public static int queen_Permutation_2D(boolean[][] rooms, int tnq, String ans)
    {
        if (tnq==0)
        {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int r=0; r<rooms.length*rooms[0].length; r++)
        {
            int x = r / rooms[0].length;
            int y = r % rooms[0].length;
            if(!rooms[x][y])
            {
                rooms[x][y] = true;
                count+=queen_Permutation_2D(rooms, tnq-1, ans+"("+x+","+y+") ");
                rooms[x][y] = false;
            }
        }
        return count;
    }
    
    public static void Queens_Problems()
    {
        //boolean[] rooms = new boolean[4];
        //int tnq = 2;
        //System.out.println(queen_Combination_1D(rooms, 0, 0, tnq, ""));
        //System.out.println(queen_Permutation_1D(rooms, 0, 0, tnq, ""));

        //boolean[][] rooms = new boolean[4][4];
        //int tnq=4;
        //System.out.println(queen_Combination_2D(rooms, 0, tnq, ""));
        //System.out.println(queen_Permutation_2D(rooms, tnq, ""));
    }
    public static void Coinchange_Problems_02()
    {
        int[] arr = {2, 3, 5, 7};
        int tar = 10;

        //System.out.println(coinChange_Combination_1_coin_atA_Time_01(arr, 0, tar, ""));
        //System.out.println(coinChange_Combination_INF_01(arr, 0, tar, ""));
        //System.out.println(coinChange_Permutation_INF_01(arr, 0, tar, ""));
        //System.out.println(coinChange_Permutation_1_coin_atA_Time_01(arr, 0, tar, ""));
    }

    public static void Coinchange_Problems_01()
    {
        int[] arr = {2, 3, 5, 7};
        int tar = 10;

        //System.out.println(coinChange_Permutation_INF(arr, tar, ""));
        //System.out.println(coinChange_Permutation_INF_001(arr, 0, tar, ""));
        //System.out.println(coinChange_Permutation_1_coin_atA_Time(arr, tar, ""));
        //System.out.println(coinChange_Permutation_1_coin_atA_Time_001(arr, 0, tar, ""));
        
        
        //System.out.println(coinChange_Combination_INF(arr, 0, tar, ""));
        //System.out.println(coinChange_Combination_1_coin_atA_Time(arr, 0, tar, ""));
    }
    public static void solve()
    {
        //Coinchange_Problems_01();

        //Coinchange_Problems_02();

        //Queens_Problems();
    }
    public static void main(String[] args)
    {
        solve();
    }
}