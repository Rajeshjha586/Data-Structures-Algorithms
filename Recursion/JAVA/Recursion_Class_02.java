import java.util.ArrayList;

public class Recursion_Class_02
{

    static String[] words ={
        ":;/",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wx",
        "yz",
        "@#$",
        "&*%"
    };
    public static ArrayList<String> get_KeyPad_Combination(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = get_KeyPad_Combination(ros);
        ArrayList<String> mres = new ArrayList<>();

        String word = words[ch-'0'];
        for(String s : rres)
        {
            for(int i=0; i<word.length(); i++)
            {
                mres.add(word.charAt(i) + s);
            }
        }

        return mres;
    }

    public static int get_KeyPad_Combination_Void_Type(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String word = words[ch-'0'];
        int count = 0;
        for(int i=0; i<word.length(); i++)
        {
            count+=get_KeyPad_Combination_Void_Type(ros, ans+word.charAt(i));
        }

        return count;
    }

    public static int get_KeyPad_Combination_Void_Type_02(String str, int idx, String ans)
    {
        if(idx == str.length())
        {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(idx);
        String word = words[ch-'0'];

        int count = 0;
        for(int i=0; i<word.length(); i++)
        {
            count+=get_KeyPad_Combination_Void_Type_02(str, idx+1, ans+word.charAt(i));
        }

        if(idx+1 < str.length())
        {
            int num = (ch - '0')*10 + (str.charAt(idx+1) - '0');
            if(num == 10 || num == 11)
            {
                word = words[num];
                for(int i=0; i<word.length(); i++)
                {
                    count+=get_KeyPad_Combination_Void_Type_02(str, idx+2, ans+word.charAt(i));
                }
            }
        }

        return count;
    }

    public static ArrayList<String> get_KeyPad_Combination_02(String str, int idx)
    {
        if(idx == str.length())
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(idx);
        ArrayList<String> rres = get_KeyPad_Combination_02(str, idx+1);
        ArrayList<String> mres = new ArrayList<>();

        String word = words[ch-'0'];
        for(String s : rres)
        {
            for(int i=0; i<word.length(); i++)
            {
                mres.add(word.charAt(i) + s);
            }
        }

        if(idx+1 < str.length())
        {
            int num = (ch - '0')*10 + (str.charAt(idx+1) - '0');
            if(num == 10 || num == 11)
            {
                word = words[num];
                ArrayList<String> rres1 = get_KeyPad_Combination_02(str, idx+2);
                for(String s : rres1)
                {
                    for(int i=0; i<word.length(); i++)
                    {
                        mres.add(word.charAt(i) + s);
                    }
                }
            }
        }

        return mres;
    }

    public static int Decode_Ways_Leetcode_91(String str, int idx, String ans)
    {
        if(idx == str.length())
        {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(idx);
        int count = 0;

        if(ch != '0')
        {
            char ch_ = (char)((ch-'1') + 'a');
            count += Decode_Ways_Leetcode_91(str, idx+1, ans+ch_);
        }

        if(idx+1 < str.length())
        {
            int num = (ch - '0')*10 + (str.charAt(idx+1) - '0');
            if(num>=10 && num<=26)
            {
                char ch_ = (char)(num + 'a' - 1);
                count += Decode_Ways_Leetcode_91(str, idx+2, ans+ch_);
            }
        }

        return count;

    }

    public static ArrayList<String> Decode_Ways_Leetcode_91_02(String str, int idx)
    {
        if(idx == str.length())
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        char ch = str.charAt(idx);
        if(ch != '0')
        {
            char ch_ = (char)((ch-'1') + 'a');
            ArrayList<String> rres = Decode_Ways_Leetcode_91_02(str, idx+1);
            for(String s : rres)
            {
                mres.add(ch_ + s);
            }
        }

        if(idx+1 < str.length())
        {
            int num = (ch - '0')*10 + (str.charAt(idx+1) - '0');
            if(num>=10 && num<=26)
            {
                char ch_ = (char)(num + 'a' - 1);
                ArrayList<String> rres1 = Decode_Ways_Leetcode_91_02(str, idx+2);
                for(String s : rres1)
                {
                    mres.add(ch_ + s);
                }
            }
        }

        return mres;

    }


    public static void Questions_Set_01()
    {
        //ArrayList<String> list = get_KeyPad_Combination("489");
        //System.out.println(list);

        //System.out.println(get_KeyPad_Combination_Void_Type("489", ""));

        //System.out.println(get_KeyPad_Combination_Void_Type_02("10", 0, ""));

        //ArrayList<String> list = get_KeyPad_Combination_02("10", 0);
        //System.out.println(list);

        //System.out.println(Decode_Ways_Leetcode_91("1148", 0, ""));

        //ArrayList<String> list = Decode_Ways_Leetcode_91_02("1148", 0);
        //System.out.println(list);
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