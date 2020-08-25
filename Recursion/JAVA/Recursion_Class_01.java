import java.util.Scanner;
import java.util.ArrayList;
public class Recursion_Class_01
{
    //******************************************************* */
    //             Recursion Basics Problems

    public static void Print_Increasing(int a, int b)
    {
        if(a == b+1)
        {
            return;
        }

        System.out.print(a + " ");
        Print_Increasing(a+1, b);
    }

    public static void Print_Decreasing(int a, int b)
    {
        if(a == b+1)
        {
            return;
        }

        Print_Decreasing(a+1, b);
        System.out.print(a + " ");
    }

    public static int Factorial(int n)
    {
        if(n<=1) return 1;
        return Factorial(n-1) * n;
    }

    public static int Power(int a, int n)
    {
        if(n<=0) return 1;
        return Power(a, n-1) * a;
    }

    public static int Power_Better(int a, int n)
    {
        if(n<=0)
        {
            return 1;
        }
        int pwnb2 = Power_Better(a, n/2) * Power_Better(a, n/2);
        return pwnb2 * (n%2 != 0 ? a : 1);
    }

    //******************************************************* */


    //----------------------------------------------------------
    //                   Recursion_With_Array

    public static void display_Array(int[] arr, int idx)
    {
        if(idx == arr.length)
        {
            return;
        }
        System.out.print(arr[idx] + " ");
        display_Array(arr, idx+1);
    }

    public static int multiply_All_Array_Ele(int[] arr, int idx)
    {
        if(idx == arr.length) return 1;
        return multiply_All_Array_Ele(arr, idx+1) * arr[idx];
    }

    public static int maximum(int[] arr, int idx)
    {
        if(idx == arr.length-1) return arr[idx];
        return Math.max(arr[idx], maximum(arr, idx+1));
    }

    public static int minimum(int[] arr, int idx)
    {
        if(idx == arr.length-1) return arr[idx];
        return Math.min(arr[idx], minimum(arr, idx+1));
    }

    public static boolean Find(int[] arr, int idx, int data)
    {
        if(idx == arr.length) return false;
        if(arr[idx] == data) return true;
        return Find(arr, idx+1, data);
    }

    public static int firstIndex(int[] arr, int idx, int data)
    {
        if(idx == arr.length) return -1;
        if(arr[idx] == data) return idx;
        return firstIndex(arr, idx+1, data);
    }

    public static int lastIndex(int[] arr, int idx, int data)
    {
        if(idx == arr.length) return -1;
        
        int ans = lastIndex(arr, idx+1, data);
        if(ans!=-1) return ans;
        return arr[idx]==data ? idx : -1;
    }

    public static int[] All_Index(int[] arr, int idx, int data, int count)
    {
        if(idx==arr.length)
        {
            return new int[count];
        }

        if(arr[idx] == data) count++;

        int[] ans = All_Index(arr, idx+1, data, count);

        if(arr[idx] == data)
        {
            ans[count-1] = idx;
        }
        return ans;
    }

    //-----------------------------------------------------------

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //            Recursion_Question_Set1

    public static ArrayList<String> get_Subsequence(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = get_Subsequence(ros);
        ArrayList<String> myAns = new ArrayList<>();

        for(String s : rres)
        {
            myAns.add('-' + s);
            myAns.add(ch + s);
        }

        return myAns;
    }

    public static ArrayList<String> get_Permutation_of_Subsequence(String str)
    {
        if(str.length() == 1)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add(str);
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = get_Permutation_of_Subsequence(ros);
        ArrayList<String> myAns = new ArrayList<>();

        for(String s : rres)
        {
            for(int i=0; i<=s.length(); i++)
            {
                String ans = s.substring(0, i) + ch + s.substring(i);
                myAns.add(ans);
            }
        }

        return myAns;
    }

    public static int subseq(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        int count = 0;
        
        count += subseq(ros, ans+'-');
        count += subseq(ros, ans+ch);

        return count;
    }

    public static int permutation(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            String rres = str.substring(0, i) + str.substring(i+1);
            count+=permutation(rres, ans+ch);
        }
        return count;
    }

    public static int Unique_Permutation(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[26];
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(!vis[ch-'a'])
            {
                vis[ch-'a'] = true;
                String rres = str.substring(0, i) + str.substring(i+1);
                count+=Unique_Permutation(rres, ans+ch);
            }
        }
        return count;
    }




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void Recursion_Question_Set1()
    {
        //ArrayList<String> list = get_Subsequence("abcd");
        //System.out.println(list);

        //ArrayList<String> list = get_Permutation_of_Subsequence("abcd");
        //System.out.println(list);

        //System.out.println(subseq("abcd", ""));
        //System.out.println(permutation("aba", ""));
        System.out.println(Unique_Permutation("aba", ""));
    }
    public static void Recursion_With_Array()
    {
        //int[] arr = {10, 20, 30, 40, 50};
        //display_Array(arr, 0);

        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //System.out.println(multiply_All_Array_Ele(arr, 0));

        //int[] arr = {2, 3, 8, 9, 1, 6, 7, 4};
        //System.out.println("Maximum of Array: " + maximum(arr, 0));
        //System.out.println("Minimum of Array: " + minimum(arr, 0));

        //int[] arr = {21, 5, 8, 2, 3, 2, 6, 2, 7, 11, 2, 9, 14, 8};
        //System.out.println(Find(arr, 0, 2));
        //System.out.println("First_Index : " + firstIndex(arr, 0, 2));
        //System.out.println("Last_Index : " + lastIndex(arr, 0, 2));

        //int[] ans = All_Index(arr, 0, 2, 0);
        //for(int i=0; i<ans.length; i++)
        //{
            //System.out.print(ans[i] + " ");
        //}
    }
    public static void Recursion_Basics()
    {
        //Print_Increasing(0, 10);

        //Print_Decreasing(0, 20);
        
        //System.out.print(Factorial(5));

        //Scanner scn = new Scanner(System.in);
        //int a = scn.nextInt();
        //int n = scn.nextInt();

        //System.out.println("Power : " + Power(a, n));
        //System.out.print("Power_Better : " + Power_Better(a, n));

    }
    public static void solve()
    {
        //Recursion_Basics();

        //Recursion_With_Array();

        Recursion_Question_Set1();
    }
    public static void main(String[] args)
    {
        solve();
    }
}