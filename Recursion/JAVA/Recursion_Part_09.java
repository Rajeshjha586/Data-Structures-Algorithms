import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Recursion_Part_09
{
    //Leetcode 39
    public static void Combination_Sum_Solver(int[] arr, int idx, int target, List<List<Integer>> res, List<Integer> ans)
    {
        if(target == 0)
        {
            List<Integer> base = new ArrayList<Integer>();
            for(int ele : ans)
            {
                base.add(ele);
            }
            res.add(base);
            return;
        }
        
        int prev=-1;
        for(int i=idx; i<arr.length; i++)
        {
            if(prev == arr[i])
            {
                continue;
            }

            prev=arr[i];
            if(target-arr[i] >= 0)
            {
                ans.add(arr[i]);
                Combination_Sum_Solver(arr, i, target-arr[i], res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target)
    {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();

        Combination_Sum_Solver(arr, 0, target, res, ans);

        return res;
    }
    public static void Leetcode_39()
    {
        int[] arr = {2,3,6,7};
        int target = 7;

        List<List<Integer>> myans = combinationSum(arr, target);
        System.out.println(myans);
    }

    //Leetcode 39
    public static void K_Sum_2_Solver(int[] arr, int idx, int target,int k, List<List<Integer>> res, List<Integer> ans)
    {
        if(k==0)
        {
            if(target == 0)
            {
                List<Integer> base = new ArrayList<Integer>();
                for(int ele : ans)
                {
                    base.add(ele);
                }
                res.add(base);
                return;
            }
            return;
        }
        
        int prev=-1;
        for(int i=idx; i<arr.length; i++)
        {
            if(prev == arr[i])
            {
                continue;
            }

            prev=arr[i];
            if(target-arr[i] >= 0)
            {
                ans.add(arr[i]);
                K_Sum_2_Solver(arr, i, target-arr[i], k-1, res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static List<List<Integer>> K_Sum_2(int[] arr, int target, int k)
    {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();

        K_Sum_2_Solver(arr, 0, target, k, res, ans);

        return res;
    }
    public static void LintCode_90()
    {
        int[] arr = {1,3,4,6};
        int target = 8;
        int k = 3;

        List<List<Integer>> myans = K_Sum_2(arr, target, k);
        System.out.println(myans);
    }
    public static void solve()
    {
        //Leetcode_39();

        LintCode_90();
    }
    public static void main(String[] args)
    {
        solve();
    }
}