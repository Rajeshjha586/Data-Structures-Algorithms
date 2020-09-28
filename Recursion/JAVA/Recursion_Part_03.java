import java.util.ArrayList;

public class Recursion_Part_03
{
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

    public static int Longest_Path_of_Flood_Fill(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return 0;
        }

        int myheight=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                myheight = Math.max(myheight, Longest_Path_of_Flood_Fill(x, y, er, ec, board));
            }
        }
        board[sr][sc] = 0;

        return myheight+1;

    }

    public static int Longest_Path_of_Flood_Fill_with_Multimove(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return 0;
        }

        int myheight=0;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    myheight = Math.max(myheight, Longest_Path_of_Flood_Fill_with_Multimove(x, y, er, ec, board));
                }
            }
        }
        board[sr][sc] = 0;

        return myheight+1;
    }

    public static int Smallest_Path_of_Flood_Fill(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return 0;
        }

        int myheight=board.length * board[0].length;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                myheight = Math.min(myheight, Smallest_Path_of_Flood_Fill(x, y, er, ec, board));
            }
        }
        board[sr][sc] = 0;

        return myheight+1;

    }

    public static int Smallest_Path_of_Flood_Fill_with_Multimove(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return 0;
        }

        int myheight=board.length * board[0].length;

        board[sr][sc] = 1;
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    myheight = Math.min(myheight, Smallest_Path_of_Flood_Fill(x, y, er, ec, board));
                }
            }
        }
        board[sr][sc] = 0;

        return myheight+1;

    }

    static class Pair
    {
        String path = "";
        int len = 0;

        Pair(String path, int len)
        {
            this.path = path;
            this.len = len;
        }
    }

    public static Pair Longest_Path_of_Flood_Fill_01(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return new Pair("", 0);
        }

        board[sr][sc] = 1;
        Pair myAns = new Pair("", 0);
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                Pair smallAns = Longest_Path_of_Flood_Fill_01(x, y, er, ec, board);
                if(myAns.len < smallAns.len+1)
                {
                    myAns.len = smallAns.len + 1;
                    myAns.path = dirS[d] + smallAns.path;
                }
            }
        }
        board[sr][sc] = 0;

        return myAns;

    }

    public static Pair Longest_Path_of_Flood_Fill_with_Multimove_01(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return new Pair("", 0);
        }

        board[sr][sc] = 1;
        Pair myAns = new Pair("", 0);
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    Pair smallAns = Longest_Path_of_Flood_Fill_with_Multimove_01(x, y, er, ec, board);
                    if(myAns.len < smallAns.len+1)
                    {
                        myAns.len = smallAns.len + 1;
                        myAns.path = dirS[d] + jump + smallAns.path;
                    }
                }
            }
        }
        board[sr][sc] = 0;

        return myAns;

    }

    public static Pair Smallest_Path_of_Flood_Fill_01(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return new Pair("", 0);
        }

        board[sr][sc] = 1;
        Pair myAns = new Pair("", (int) 1e7);
        for(int d=0; d<dirA.length; d++)
        {
            int x = sr + dirA[d][0];
            int y = sc + dirA[d][1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
            {
                Pair smallAns = Smallest_Path_of_Flood_Fill_01(x, y, er, ec, board);
                if(smallAns.len+1 < myAns.len)
                {
                    myAns.len = smallAns.len + 1;
                    myAns.path = dirS[d] + smallAns.path;
                }
            }
        }
        board[sr][sc] = 0;

        return myAns;

    }

    public static Pair Smallest_Path_of_Flood_Fill_with_Multimove_01(int sr, int sc, int er, int ec, int[][] board)
    {
        if(sr==er && sc==ec)
        {
            return new Pair("", 0);
        }

        board[sr][sc] = 1;
        Pair myAns = new Pair("", board.length*board[0].length);
        for(int d=0; d<dirA.length; d++)
        {
            for(int jump=1; jump<board.length; jump++)
            {
                int x = sr + jump * dirA[d][0];
                int y = sc + jump * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==0)
                {
                    Pair smallAns = Smallest_Path_of_Flood_Fill_with_Multimove_01(x, y, er, ec, board);
                    if(myAns.len > smallAns.len+1)
                    {
                        myAns.len = smallAns.len + 1;
                        myAns.path = dirS[d] + jump + smallAns.path;
                    }
                }
            }
        }
        board[sr][sc] = 0;

        return myAns;

    }

    public static void Question_Set_01()
    {
        //int[][] board = new int[3][3];
        //System.out.println(Flood_Fill(0, 0, 2, 2, board, ""));

        //int[][] board = new int[3][3];
        //System.out.println(Flood_Fill_with_MultiMove(0, 0, 2, 2, board, ""));

        //int[][] board = new int[3][3];
        //System.out.println(Longest_Path_of_Flood_Fill(0, 0, 2, 2, board));
        //System.out.println(Longest_Path_of_Flood_Fill_with_Multimove(0, 0, 2, 2, board));

        //int[][] board = new int[3][3];
        //System.out.println(Smallest_Path_of_Flood_Fill(0, 0, 2, 2, board));   
        //System.out.println(Smallest_Path_of_Flood_Fill_with_Multimove(0, 0, 2, 2, board));  

        //int[][] board = new int[3][3];
        //Pair ans = Longest_Path_of_Flood_Fill_01(0, 0, 2, 2, board); 
        //Pair ans = Longest_Path_of_Flood_Fill_with_Multimove_01(0, 0, 2, 2, board); 
        //System.out.println(ans.path + " " + ans.len + " ");

        //int[][] board = new int[3][3];
        //Pair ans = Smallest_Path_of_Flood_Fill_01(0, 0, 3, 3, board); 
        //Pair ans = Smallest_Path_of_Flood_Fill_with_Multimove_01(0, 0, 2, 2, board); 
        //System.out.println(ans.path + " " + ans.len + " ");
    }
    public static void solve()
    {
        Question_Set_01();
    }
    public static void main(String[] args)
    {
        solve();
    }
}