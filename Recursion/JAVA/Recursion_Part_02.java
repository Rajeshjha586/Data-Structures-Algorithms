import java.util.ArrayList;

public class Recursion_Part_02
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

    

    // steps : Horizontal Vertical(Return Type)
    public static ArrayList<String> MazePath_HV(int sr, int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();

        if(sc+1<=ec)
        {
            ArrayList<String> Horizontal = MazePath_HV(sr, sc+1, er, ec);
            for(String s : Horizontal)
            {
                mres.add("H" + s);
            }
        }

        if(sr+1<=er)
        {
            ArrayList<String> Horizontal = MazePath_HV(sr+1, sc, er, ec);
            for(String s : Horizontal)
            {
                mres.add("V" + s);
            }
        }

        return mres;
    }

    // steps : Horizontal Vertical Diagonal(Return Type)
    public static ArrayList<String> MazePath_HVD(int sr, int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();

        if(sc+1<=ec)
        {
            ArrayList<String> Horizontal = MazePath_HVD(sr, sc+1, er, ec);
            for(String s : Horizontal)
            {
                mres.add("H" + s);
            }
        }

        if(sr+1<=er)
        {
            ArrayList<String> Horizontal = MazePath_HVD(sr+1, sc, er, ec);
            for(String s : Horizontal)
            {
                mres.add("V" + s);
            }
        }
        
        if(sr+1<=er && sc+1<=ec)
        {
            ArrayList<String> Horizontal = MazePath_HVD(sr+1, sc+1, er, ec);
            for(String s : Horizontal)
            {
                mres.add("D" + s);
            }
        }
        return mres;
    }

    // steps : Horizontal Vertical(Void Type)
    public static int MazePath_HV_01(int sr, int sc, int er, int ec, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        if(sc+1<=ec)
        {
            count+=MazePath_HV_01(sr, sc+1, er, ec, ans+"H");
        }

        if(sr+1<=er)
        {
            count+=MazePath_HV_01(sr+1, sc, er, ec, ans+"V");
        }

        return count;
    }

    // steps : Horizontal Vertical Diagonal(Void Type)
    public static int MazePath_HVD_01(int sr, int sc, int er, int ec, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        if(sc+1<=ec)
        {
            count+=MazePath_HVD_01(sr, sc+1, er, ec, ans+"H");
        }

        if(sr+1<=er)
        {
            count+=MazePath_HVD_01(sr+1, sc, er, ec, ans+"V");
        }

        if(sr+1<=er && sc+1<=ec)
        {
            count+=MazePath_HVD_01(sr+1, sc+1, er, ec, ans+"D");
        }

        return count;
    }

    // steps : Multimove --> Horizontal Vertical(Void Type)
    public static int MazePath_Multimove_HV(int sr, int sc, int er, int ec, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int ms=1; ms<=ec-sc; ms++)
        {
            count += MazePath_Multimove_HV(sr, sc+ms, er, ec, ans+"H"+ms);
        }

        for(int ms=1; ms<=er-sr; ms++)
        {
            count += MazePath_Multimove_HV(sr+ms, sc, er, ec, ans+"V"+ms);
        }

        return count;
    }

    // steps : Multimove --> Horizontal Vertical Diagonal(Void Type)
    public static int MazePath_Multimove_HVD(int sr, int sc, int er, int ec, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int ms=1; ms<=ec-sc; ms++)
        {
            count += MazePath_Multimove_HVD(sr, sc+ms, er, ec, ans+"H"+ms);
        }

        for(int ms=1; ms<=er-sr; ms++)
        {
            count += MazePath_Multimove_HVD(sr+ms, sc, er, ec, ans+"V"+ms);
        }

        for(int ms=1; ms<=er-sr && ms<=ec-sc; ms++)
        {
            count += MazePath_Multimove_HVD(sr+ms, sc+ms, er, ec, ans+"D"+ms);
        }

        return count;
    }

    // steps : Multimove --> Horizontal Vertical(Return Type)
    public static ArrayList<String> MazePath_Multimove_HV_01(int sr, int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> mres = new ArrayList<>();

        for(int ms=1; ms<=ec-sc; ms++)
        {
            ArrayList<String> Horizontal = MazePath_Multimove_HV_01(sr, sc+ms, er, ec);
            for(String s : Horizontal)
            {
                mres.add(s + "H" + ms);
            }
        }

        for(int ms=1; ms<=er-sr; ms++)
        {
            ArrayList<String> Vertical = MazePath_Multimove_HV_01(sr+ms, sc, er, ec);
            for(String s : Vertical)
            {
                mres.add(s + "V" + ms);
            }
        }

        return mres;
    }

    // steps : Multimove --> Horizontal Vertical(Return Type)
    public static ArrayList<String> MazePath_Multimove_HVD_01(int sr, int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> mres = new ArrayList<>();

        for(int ms=1; ms<=ec-sc; ms++)
        {
            ArrayList<String> Horizontal = MazePath_Multimove_HVD_01(sr, sc+ms, er, ec);
            for(String s : Horizontal)
            {
                mres.add(s + "H" + ms);
            }
        }

        for(int ms=1; ms<=er-sr; ms++)
        {
            ArrayList<String> Vertical = MazePath_Multimove_HVD_01(sr+ms, sc, er, ec);
            for(String s : Vertical)
            {
                mres.add(s + "V" + ms);
            }
        }

        for(int ms=1; ms<=er-sr && ms<=ec-sc; ms++)
        {
            ArrayList<String> Diagonal = MazePath_Multimove_HVD_01(sr+ms, sc+ms, er, ec);
            for(String s : Diagonal)
            {
                mres.add(s + "D" + ms);
            }
        }

        return mres;
    }

    static int[][] dirA = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static String[] dirS = {"L", "N", "U", "E", "R", "S", "D", "W"};

    public static int Flood_Fill(int sr, int sc, int er, int ec, int[][] board, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                count += Flood_Fill(x, y, er, ec, board, ans+dirS[d]);
            }
        }
        board[sr][sc] = 0;

        return count;

    }

    public static int Flood_Fill_with_MultiMove(int sr, int sc, int er, int ec, int[][] board, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    count += Flood_Fill_with_MultiMove(x, y, er, ec, board, ans+dirS[d]+jump);
                }
            }
        }
        board[sr][sc] = 0;

        return count;

    }
    
    public static int Rat_In_Maze(int sr, int sc, int er, int ec, int[][] board, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                count += Rat_In_Maze(x, y, er, ec, board, ans+dirS[d]);
            }
        }
        board[sr][sc] = 0;

        return count;

    }
    
    public static int Rat_In_Maze_with_Multimove(int sr, int sc, int er, int ec, int[][] board, String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    count += Rat_In_Maze_with_Multimove(x, y, er, ec, board, ans+dirS[d]+jump);
                }
            }
        }
        board[sr][sc] = 0;

        return count;

    }


    public static void Questions_Set_02()
    {
        //ArrayList<String> list = MazePath_HV(0, 0, 2, 2);
        //System.out.println(list);

        //ArrayList<String> list = MazePath_HVD(0, 0, 2, 2);
        //System.out.println(list);

        //System.out.println(MazePath_HV_01(0, 0, 2, 2, ""));
        //System.out.println(MazePath_HVD_01(0, 0, 2, 2, ""));

        //System.out.println(MazePath_Multimove_HV(0, 0, 2, 2, ""));
        //System.out.println(MazePath_Multimove_HVD(0, 0, 2, 2, ""));

        //ArrayList<String> ans = MazePath_Multimove_HV_01(0, 0, 2, 2);
        //System.out.println(ans);

        //ArrayList<String> ans = MazePath_Multimove_HVD_01(0, 0, 2, 2);
        //System.out.println(ans);

        //int[][] board = new int[3][3];
        //System.out.println(Flood_Fill(0, 0, 2, 2, board, ""));

        //int[][] board = new int[3][3];
        //System.out.println(Flood_Fill_with_MultiMove(0, 0, 2, 2, board, ""));

        int[][] board = {
            {0, 1, 1, 1},
            {0, 0, 1, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 0}
        };
        //System.out.println(Rat_In_Maze(0, 0, 3, 3, board, ""));
        System.out.println(Rat_In_Maze_with_Multimove(0, 0, 3, 3, board, ""));
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
        //Questions_Set_01();

        //PATH TYPE
        Questions_Set_02();
    }
    public static void main(String[] args)
    {
        solve();
    }
}