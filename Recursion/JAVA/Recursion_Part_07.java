import java.util.*;
public class Recursion_Part_07
{
    static String[] words = {"mobile","samsung","sam","sung", 
                             "man","mango","icecream","and", 
                             "go","i","like","ice","cream"}; 

    
    public static boolean isContains(String word)
    {
        for(String s : words)
        {
            if(s.equals(word))
            {
                return true;
            }
        }

        return false;
    }
    public static int Word_Break(String str, int idx, String ans)
    {
        if(idx == str.length())
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx+1; i<=str.length(); i++)
        {
            String smallStr = str.substring(idx, i);
            if(isContains(smallStr))
            {
                count += Word_Break(str, i, ans + "-" + smallStr);
            }
        }
        return count;
    }

    
    public static void Questions_Set_01()
    {
        //Sudoku_Problem();

        String str = "ilikesamsungandmangoandicecream";
        System.out.println(Word_Break(str, 0, ""));

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