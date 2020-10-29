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
    public static void Questions_Set_01()
    {
        Lexicographical_Order(1, 20);
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