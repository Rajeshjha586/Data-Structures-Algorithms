import java.util.ArrayList;
public class Recursion_Part_07
{
    public static void display2D(char[][] board)
    {
        for(char[] ar: board){
            for(char ele: ar){
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }

    public static boolean is_Safe_To_Place_Number(char[][] board, int x, int y, int num)
    {
        //row
        for(int i=0; i<9; i++)
        {
            if(board[x][i]-'0' == num)
            {
                return false;
            }
        } 

        //col
        for(int j=0; j<9; j++)
        {
            if(board[j][y]-'0' == num)
            {
                return false;
            }
        }

        //small matrix
        x = (x / 3) * 3; // x -= x % 3; 
        y = (y / 3) * 3; // y -= y % 3; 

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(board[x+i][y+j]-'0' == num)
                {
                    return false;
                }
            }
        }

        return true;
    }

    //Leetcode Submition :- 37
    public static boolean solve_Sudoku_Problem(char[][] board, ArrayList<Integer> calls, int idx)
    {
        if(idx==calls.size())
        {
            return true;
        }

        int r = calls.get(idx) / 9;
        int c = calls.get(idx) % 9;

        for(int num=1; num<=9; num++)
        {
            if(is_Safe_To_Place_Number(board, r, c, num))
            {
                board[r][c] = (char)(num + '0');
                
                if(solve_Sudoku_Problem(board, calls, idx+1))
                {
                    return true;
                }

                board[r][c] = '.';
            }
        }

        return false;
    }
    public static void solveSudoku(char[][] board)
    {
        ArrayList<Integer> calls = new ArrayList<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] == '.')
                {
                    calls.add(i * 9 + j);
                }
            }
        }

        //System.out.println(solve_Sudoku_Problem(board, calls, 0));
    }


    public static int solve_Sudoku_Problem_01(char[][] board, ArrayList<Integer> calls, int idx)
    {
        if(idx==calls.size())
        {
            display2D(board);
            return 1;
        }

        int r = calls.get(idx) / 9;
        int c = calls.get(idx) % 9;
 
        int count=0;
        for(int num=1; num<=9; num++)
        {
            if(is_Safe_To_Place_Number(board, r, c, num))
            {
                board[r][c] = (char)(num + '0');
                
                count += solve_Sudoku_Problem_01(board, calls, idx+1);

                board[r][c] = '.';
            }
        }

        return count;
    }
    public static void solveSudoku_01(char[][] board)
    {
        ArrayList<Integer> calls = new ArrayList<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] == '.')
                {
                    calls.add(i * 9 + j);
                }
            }
        }

        System.out.println(solve_Sudoku_Problem_01(board, calls, 0));
    }


    //Using Bitwise Operator
    static int[] rows;
    static int[] cols;
    static int[][] mat;
    public static boolean solve_Sudoku_Problem_02(char[][] board, ArrayList<Integer> calls, int idx)
    {
        if(idx==calls.size())
        {
            display2D(board);
            return true;
        }

        int r = calls.get(idx) / 9;
        int c = calls.get(idx) % 9;
 
        boolean res = false;
        for(int num=1; num<=9; num++)
        {
            int mask = 1 << num;
            if((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r/3][c/3] & mask) == 0)
            {
                board[r][c] = (char)(num + '0');
                // set the number
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;

                res = res || solve_Sudoku_Problem_02(board, calls, idx+1);

                board[r][c] = '.';
                // Unset the number
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;
            }
        }

        return res;
    }
    public static void solveSudoku_02(char[][] board)
    {
        rows = new int[9];
        cols = new int[9];
        mat = new int[3][3];

        ArrayList<Integer> calls = new ArrayList<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] == '.')
                {
                    calls.add(i * 9 + j);
                }
                else
                {
                    int num = board[i][j]-'0';
                    int mask = 1 << num;
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    mat[i/3][j/3] ^= mask;
                }
            }
        }

        System.out.println(solve_Sudoku_Problem_02(board, calls, 0));
    }

    //Leetcode 36
    public static boolean isValidSudoku(char[][] board)
    {
        rows = new int[9];
        cols = new int[9];
        mat = new int[3][3];
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] != '.')
                {
                    int num = board[i][j]-'0';
                    int mask = 1 << num;

                    if(( (rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (mat[i/3][j/3] & mask) != 0 ))
                    {
                        return false;
                    }
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    mat[i/3][j/3] ^= mask;
                }
            }
        }
        return true;
    }


    public static void Sudoku_Problem()
    {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };  

        //solveSudoku(board);

        //solveSudoku_01(board);

        //solveSudoku_02(board);

        System.out.println(isValidSudoku(board));
    }


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

    public static void Word_Break_Problem()
    {
        String str = "ilikesamsungandmangoandicecream";
        System.out.println(Word_Break(str, 0, ""));
    }

    public static void Questions_Set_01()
    {
        Sudoku_Problem();

        //Word_Break_Problem();
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