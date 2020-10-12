import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Recursion_Part_08
{
    static String str1 = "send";
    static String str2 = "more";
    static String str3 = "money";
    static int is_Number_Used = 0;
    static int[] assigned_Number = new int[26];



    public static int string_To_Number(String str)
    {
        int res = 0;
        for(int i=0; i<str.length(); i++)
        {
            res = res * 10 + assigned_Number[str.charAt(i)-'a'];
        }
        return res;
    }

    public static String Unique_Chararcter(String str1, String str2, String str3)
    {
        String str = str1 + str2 + str3;
        int[] freq = new int[26];

        for(int i=0; i<str.length(); i++)
        {
            freq[str.charAt(i)-'a']++;
        }

        str = "";
        for(int i=0; i<26; i++)
        {
            if(freq[i] > 0)
            {
                str += (char)(i + 'a');
            }
        }

        return str;
    }

    public static int Crypto_Arithmetic_Solver(String str, int idx)
    {
        if(idx == str.length())
        {
            int num1 = string_To_Number(str1);
            int num2 = string_To_Number(str2);
            int num3 = string_To_Number(str3);

            if(assigned_Number[str1.charAt(0)-'a']!=0 && assigned_Number[str2.charAt(0)-'a']!=0 && assigned_Number[str3.charAt(0)-'a']!=0 && num1 + num2 == num3)
            {
                System.out.println(" " + num1);
                System.out.println("+" + num2);
                System.out.println("------");
                System.out.println(num3);
                System.out.println();
                return 1;
            }
            return 0;
        }


        int count=0;
        for(int num=0; num<=9; num++)
        {
            int mask = 1 << num;
            if((is_Number_Used & mask) == 0)
            {
                is_Number_Used ^= mask;
                assigned_Number[str.charAt(idx)-'a']=num;
                
                count += Crypto_Arithmetic_Solver(str, idx+1);

                is_Number_Used ^= mask;
                assigned_Number[str.charAt(idx)-'a']=0;
            }

        }
        return count;
    }

    public static void Crypto_Arithmetic()
    {
        String Unique = Unique_Chararcter(str1, str2, str3);
        System.out.println(Crypto_Arithmetic_Solver(Unique, 0));

    }
    
    public static void Combination_Sum_2_Solver(int[] arr, int idx, int target, List<List<Integer>> res, List<Integer> ans)
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
                Combination_Sum_2_Solver(arr, i+1, target-arr[i], res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[] arr, int target)
    {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();

        Combination_Sum_2_Solver(arr, 0, target, res, ans);

        return res;
    }
    public static void Leetcode_40()
    {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> myans = combinationSum2(arr, target);
        System.out.println(myans);
    }
    public static void solve()
    {
        //Crypto_Arithmetic();

        Leetcode_40();
    }
    public static void main(String[] args)
    {
        solve();
    }
}