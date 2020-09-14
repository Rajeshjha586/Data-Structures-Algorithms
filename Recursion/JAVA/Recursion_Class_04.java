public class Recursion_Class_04
{
    public static int coinChange_Combination_1_coin_atA_Time(int[] arr, int idx, int tar, String ans)
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
            count+=coinChange_Combination_1_coin_atA_Time(arr, idx+1, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Combination_1_coin_atA_Time(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Combination_INF(int[] arr, int idx, int tar, String ans)
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
            count+=coinChange_Combination_INF(arr, idx, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Combination_INF(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Permutation_INF(int[] arr, int idx, int tar, String ans)
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
            count+=coinChange_Permutation_INF(arr, 0, tar-arr[idx], ans+arr[idx]+" ");
        }
        count+=coinChange_Permutation_INF(arr, idx+1, tar, ans);

        return count;
    }

    public static int coinChange_Permutation_1_coin_atA_Time(int[] arr, int idx, int tar, String ans)
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
            count+=coinChange_Permutation_1_coin_atA_Time(arr, 0, tar-temp, ans+temp+" ");
            arr[idx] = -arr[idx];
        }
        count+=coinChange_Permutation_1_coin_atA_Time(arr, idx+1, tar, ans);

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
        boolean[][] rooms = new boolean[4][4];
        int tnq=4;
        System.out.println(queen_Combination_2D(rooms, 0, tnq, ""));
    }
    public static void Coinchange_Problems()
    {
        int[] arr = {2, 3, 5, 7};
        int tar = 10;

        //System.out.println(coinChange_Combination_1_coin_atA_Time(arr, 0, tar, ""));
        //System.out.println(coinChange_Combination_INF(arr, 0, tar, ""));
        //System.out.println(coinChange_Permutation_INF(arr, 0, tar, ""));
        //System.out.println(coinChange_Permutation_1_coin_atA_Time(arr, 0, tar, ""));
    }
    public static void solve()
    {
        //Coinchange_Problems();

        Queens_Problems();
    }
    public static void main(String[] args)
    {
        solve();
    }
}