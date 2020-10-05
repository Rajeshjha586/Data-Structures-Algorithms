#include<iostream>
#include<vector>
#include<unordered_set>

using namespace std;

void display2D(vector<vector<char>> board)
{
    for(vector<char> ar: board){
        for(char ele: ar){
            cout << ele << "\t";
        }
        cout << endl;
    }
}


bool is_Safe_To_Place_Number(vector<vector<char>>& board, int x, int y, int num)
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
/*
bool solve_Sudoku_Problem(vector<vector<char>>& board, vector<int>& calls, int idx)
{
    if(idx==calls.size())
    {
        return true;
    }

    int r = calls[idx] / 9;
    int c = calls[idx] % 9;

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

*/


int solve_Sudoku_Problem_01(vector<vector<char>>& board, vector<int>& calls, int idx)
{
    if(idx==calls.size())
    {
        display2D(board);
        return 1;
    }

    int r = calls[idx] / 9;
    int c = calls[idx] % 9;
    bool res = false;
    for(int num=1; num<=9; num++)
    {
        if(is_Safe_To_Place_Number(board, r, c, num))
        {
            board[r][c] = (char)(num + '0');
            
            res = res || solve_Sudoku_Problem_01(board, calls, idx+1);

            board[r][c] = '.';
        }
    }

    return res;
}

// It mapped 2-D Array into 1-D Array
void solveSudoku(vector<vector<char>>& board)
{
    vector<int> calls;
    for(int i=0; i<9; i++)
    {
        for(int j=0; j<9; j++)
        {
            if(board[i][j] == '.')
            {
                calls.push_back(i * 9 + j);
            }
        }
    }

    cout << solve_Sudoku_Problem_01(board, calls, 0) << endl;
}





// Using Bitwise Operator

vector<int> rows;
vector<int> cols;
vector<vector<int>> mat;
int solve_Sudoku_Problem_02(vector<vector<char>>& board, vector<int>& calls, int idx)
{
    if(idx==calls.size())
    {
        display2D(board);
        return 1;
    }

    int r = calls[idx] / 9;
    int c = calls[idx] % 9;
    bool res = false;
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
            //Unset the Number
            rows[r] ^= mask;
            cols[c] ^= mask;
            mat[r/3][c/3] ^= mask;
        }
    }

    return res;
}

// It mapped 2-D Array into 1-D Array
void solveSudoku_01(vector<vector<char>>& board)
{
    rows.assign(9, 0);
    cols.assign(9, 0);
    mat.assign(3, vector<int>(3, 0));


    vector<int> calls;
    for(int i=0; i<9; i++)
    {
        for(int j=0; j<9; j++)
        {
            if(board[i][j] == '.')
            {
                calls.push_back(i * 9 + j);
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

    cout << solve_Sudoku_Problem_02(board, calls, 0) << endl;
}


//Leetcode:-36
bool isValidSudoku(vector<vector<char>>& board)
{
    int rows[9] = {0};
    int cols[9] = {0};
    int mat[3][3] = {0};

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

void Sudoku_Problem()
{
    vector<vector<char>> board{
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

    //cout << isValidSudoku(board) << endl;
}

vector<string> words{"mobile","samsung","sam","sung", 
                    "man","mango","icecream","and", 
                    "go","i","like","ice","cream"};   
bool isContains(string word)
{
    for(string s : words)
    {
        if(s.compare(word)==0)
        {
            return true;
        }
    }

    return false;
}
int Word_Break(string str, string ans)
{
    if(str.length()==0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=1; i<=str.length(); i++)
    {
        string smallStr = str.substr(0, i);
        if(isContains(smallStr))
        {
            count += Word_Break(str.substr(i), ans + "-" + smallStr);
        }
    }
    return count;
}
void Word_Break_Problem()
{
    string str = "ilikesamsungandmangoandicecream";
    cout << Word_Break(str, "") << endl;
}
void Questions_Set_01()
{
    //Sudoku_Problem();

    Word_Break_Problem();
}
void solve()
{
    Questions_Set_01();
}
int main()
{
    solve();
    return 0;
}