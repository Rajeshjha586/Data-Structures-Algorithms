import java.util.List;
import java.util.ArrayList;

public class Recursion_Part_10
{
    public static void Lexicographical_Order(int st, int end)
    {
        if(st > end)
        {
            return;
        }

        System.out.println(st);

        for(int i=0; i<10; i++)
        {
            if(st * 10 + i < end)
            {
                Lexicographical_Order(st*10+i, end);
            }
            else
            {
                break;
            }
        }

        if(st+1 < 10)
        {
            Lexicographical_Order(st+1, end);
        }
    }

    public static List<String> res;
    public static List<String> generateParenthesis(int n)
    {
        res = new ArrayList<>();

        generateParenthesis("", 0, 0, n);

        return res;
    }
    public static void generateParenthesis(String ans, int OB, int CB, int n)
    {
        if(OB+CB == 2*n)
        {
            res.add(ans);
            return;
        }
        if(OB < n)
        {
            generateParenthesis(ans+"(", OB+1, CB, n);
        }

        if(CB < OB)
        {
            generateParenthesis(ans+")", OB, CB+1, n);
        }
    }
    public static void Leetcode_22()
    {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }
    public static void Questions_Set_01()
    {
        //Lexicographical_Order(1, 20);

        Leetcode_22();
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