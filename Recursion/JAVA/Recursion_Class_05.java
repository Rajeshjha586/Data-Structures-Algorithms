import java.util.Arrays;
public class Recursion_Class_05
{
    public static boolean isValidMove(boolean[][] board, int r, int c)
    {
        int[][] dirA = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        for(int d=0; d<dirA.length; d++)
        {
            for(int rad=1; rad<=board.length; rad++)
            {
                int x = r + rad * dirA[d][0];
                int y = c + rad * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length)
                {
                    if(board[x][y])
                    {
                        return false;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return true;
    }

    public static int N_Queen_Problem_Combination_01(boolean[][] board, int lqsf, int tnq, String ans)
    {
        if(tnq==0)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;
        for(int r=lqsf; r<board.length*board[0].length; r++)
        {
            int x = r / board[0].length;
            int y = r % board[0].length;

            if(isValidMove(board, x, y))
            {
                board[x][y] = true;
                count+=N_Queen_Problem_Combination_01(board, r+1, tnq-1, ans+"("+x+","+y+") ");
                board[x][y] = false;
            }
        }

        return count;
    }

    public static int N_Queen_Problem_Combination_SubSeq_02(boolean[][] board, int idx, int tnq, String ans)
    {
        if(idx==board.length*board[0].length || tnq==0)
        {
            if(tnq==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count=0;

        int x = idx / board[0].length;
        int y = idx % board[0].length;

        if(isValidMove(board, x, y))
        {
            board[x][y] = true;
            count+=N_Queen_Problem_Combination_SubSeq_02(board, idx+1, tnq-1, ans+"("+x+","+y+") ");
            board[x][y] = false;
        }
        count+=N_Queen_Problem_Combination_SubSeq_02(board, idx+1, tnq, ans);

        return count;
    }

    public static boolean isValid(boolean[][] board, int r, int c)
    {
        int[][] dirA = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
        for(int d=0; d<dirA.length; d++)
        {
            for(int rad=1; rad<=board.length; rad++)
            {
                int x = r + rad * dirA[d][0];
                int y = c + rad * dirA[d][1];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length)
                {
                    if(board[x][y])
                    {
                        return false;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return true;
    }

    public static int N_Queen_Problem_Permutation_SubSeq_03(boolean[][] board, int idx, int tnq, String ans)
    {
        if(idx==board.length*board[0].length || tnq==0)
        {
            if(tnq==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count=0;

        int x = idx / board[0].length;
        int y = idx % board[0].length;

        if(!board[x][y] && isValid(board, x, y))
        {
            board[x][y] = true;
            count+=N_Queen_Problem_Permutation_SubSeq_03(board, 0, tnq-1, ans+"("+x+","+y+") ");
            board[x][y] = false;
        }
        count+=N_Queen_Problem_Permutation_SubSeq_03(board, idx+1, tnq, ans);

        return count;
    }

    public static int N_Queen_Problem_Permutation_04(boolean[][] board, int idx, int tnq, String ans)
    {
        if (tnq==0)
        {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int r=idx; r<board.length*board[0].length; r++)
        {
            int x = r / board[0].length;
            int y = r % board[0].length;
            if(!board[x][y] && isValid(board, x, y))
            {
                board[x][y] = true;
                count+=N_Queen_Problem_Permutation_04(board, 0, tnq-1, ans+"("+x+","+y+") ");
                board[x][y] = false;
            }
        }
        return count;
    }

    // For 1 Answer
    public static boolean N_Queen_Problem_Permutation_05(boolean[][] board, int idx, int tnq, String ans)
    {
        if (tnq==0)
        {
            System.out.println(ans);
            return true;
        }
        
        boolean res = false;
        for(int r=idx; r<board.length*board[0].length; r++)
        {
            int x = r / board[0].length;
            int y = r % board[0].length;
            if(!board[x][y] && isValid(board, x, y))
            {
                board[x][y] = true;
                res = res || N_Queen_Problem_Permutation_05(board, 0, tnq-1, ans+"("+x+","+y+") ");
                board[x][y] = false;
            }
        }
        return res;
    }



    public static boolean Knight_Tour_Problem(int[][] board, int r, int c, int move)
    {
        board[r][c] = move;
        if(move == (board.length*board[0].length)-1)    //63
        {
            //board[r][c] = move;
            for(int[] b:board)
            {
                for(int ele : b)
                {
                    System.out.print(ele + "\t");
                }
                System.out.println();
            }
            return true;
        }

        

        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 }; 

        boolean res = false;
        //board[r][c] = move;
        for(int d=0; d<8; d++)
        {
            int x = r + xMove[d];
            int y = c + yMove[d];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==-1)
            {
                res = res || Knight_Tour_Problem(board, x, y, move+1);
            }
        }

        board[r][c] = -1;

        return res;
    }





    public static void Questions_Set_02()
    {
        int[][] board = new int[8][8];
        for(int i=0; i<board.length; i++)
        {
            Arrays.fill(board[i], -1);
        }
        System.out.println(Knight_Tour_Problem(board, 0, 0, 0));
    }

    public static void Questions_Set_01()
    {
        boolean[][] board = new boolean[4][4];
        int tnq = 4;
        //System.out.println(N_Queen_Problem_Combination_01(board, 0, tnq, ""));
        //System.out.println(N_Queen_Problem_Combination_SubSeq_02(board, 0, tnq, ""));

        //System.out.println(N_Queen_Problem_Permutation_SubSeq_03(board, 0, tnq, ""));
        //System.out.println(N_Queen_Problem_Permutation_04(board, 0, tnq, ""));
        //System.out.println(N_Queen_Problem_Permutation_05(board, 0, tnq, ""));
    }
    public static void solve()
    {
        //Questions_Set_01();

        Questions_Set_02();
    }
    public static void main(String[] args)
    {
        solve();
    }
}