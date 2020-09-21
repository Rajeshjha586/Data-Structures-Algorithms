#include<iostream>
#include<vector>

using namespace std;

bool isValidMove(vector<vector<bool>>& board, int r, int c)
{
    vector<vector<int>> dirA = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}};
    for(int d=0; d<dirA.size(); d++)
    {
        for(int rad=1; rad<=board.size(); rad++)
        {
            int x = r + rad * dirA[d][0];
            int y = c + rad * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size())
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

int N_Queen_Problem_Combination_01(vector<vector<bool>>& board, int lqsf, int tnq, string ans)
{
    if(tnq==0)
    {
        cout << ans << endl;
        return 1;
    }

    int count=0;
    for(int r=lqsf; r<board.size()*board[0].size(); r++)
    {
        int x = r / board[0].size();
        int y = r % board[0].size();

        if(isValidMove(board, x, y))
        {
            board[x][y] = true;
            count+=N_Queen_Problem_Combination_01(board, r+1, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
            board[x][y] = false;
        }
    }

    return count;
}

int N_Queen_Problem_Combination_SubSeq_02(vector<vector<bool>>& board, int idx, int tnq, string ans)
{
    if(idx==board.size()*board[0].size() || tnq==0)
    {
        if(tnq==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }

    int count=0;

    int x = idx / board[0].size();
    int y = idx % board[0].size();

    if(isValidMove(board, x, y))
    {
        board[x][y] = true;
        count+=N_Queen_Problem_Combination_SubSeq_02(board, idx+1, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
        board[x][y] = false;
    }
    count+=N_Queen_Problem_Combination_SubSeq_02(board, idx+1, tnq, ans);

    return count;
}

bool isValid(vector<vector<bool>>& board, int r, int c)
{
    vector<vector<int>> dirA = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
    for(int d=0; d<dirA.size(); d++)
    {
        for(int rad=1; rad<=board.size(); rad++)
        {
            int x = r + rad * dirA[d][0];
            int y = c + rad * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size())
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

int N_Queen_Problem_Permutation_SubSeq_03(vector<vector<bool>>& board, int idx, int tnq, string ans)
{
    if(idx==board.size()*board[0].size() || tnq==0)
    {
        if(tnq==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }

    int count=0;

    int x = idx / board[0].size();
    int y = idx % board[0].size();

    if(!board[x][y] && isValid(board, x, y))
    {
        board[x][y] = true;
        count+=N_Queen_Problem_Permutation_SubSeq_03(board, 0, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
        board[x][y] = false;
    }
    count+=N_Queen_Problem_Permutation_SubSeq_03(board, idx+1, tnq, ans);

    return count;
}

int N_Queen_Problem_Permutation_04(vector<vector<bool>>& board, int idx, int tnq, string ans)
{
    if(tnq==0)
    {
        cout << ans << endl;
        return 1;
    }

    int count=0;
    for(int r=idx; r<board.size()*board[0].size(); r++)
    {
        int x = r / board[0].size();
        int y = r % board[0].size();

        if(!board[x][y] && isValid(board, x, y))
        {
            board[x][y] = true;
            count+=N_Queen_Problem_Permutation_04(board, 0, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
            board[x][y] = false;
        }
    }

    return count;
}

//For 1 answer in Permutation
int N_Queen_Problem_Permutation_05(vector<vector<bool>>& board, int idx, int tnq, string ans)
{
    if(tnq==0)
    {
        cout << ans << endl;
        return 1;
    }

    bool res = false;
    for(int r=idx; r<board.size()*board[0].size(); r++)
    {
        int x = r / board[0].size();
        int y = r % board[0].size();

        if(!board[x][y] && isValid(board, x, y))
        {
            board[x][y] = true;
            res = res || N_Queen_Problem_Permutation_05(board, 0, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
            board[x][y] = false;
        }
    }

    return res;
}



bool Knight_Tour_Problem(vector<vector<int>>& board, int r, int c, int move)
{
    board[r][c] = move;
    if(move == (board.size() * board[0].size())-1)//63
    {
        for(vector<int> b : board)
        {
            for(int ele : b)
            {
                cout << ele << "\t";
            }  
            cout << endl;  
        }
        return true;
    }

    vector<int> xMove = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
    vector<int> yMove = { 1, 2, 2, 1, -1, -2, -2, -1 }; 

    bool res = false;
    //board[r][c] = move;
    for(int d=0; d<8; d++)
    {
        int x = r + xMove[d];
        int y = c + yMove[d];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==-1)
        {
            res = res || Knight_Tour_Problem(board, x, y, move+1);
        }
    }

    board[r][c] = -1;

    return res;
}

void Questions_Set_02()
{
    vector<vector<int>> board(8, vector<int>(8, -1));
    //cout << Knight_Tour_Problem(board, 0, 0, 0) << endl;
}

void Questions_Set_01()
{
    vector<vector<bool>> board(4, vector<bool>(4, 0));
    int tnq = 4;
    //cout << N_Queen_Problem_Combination_01(board, 0, tnq, "") << endl;
    //cout << N_Queen_Problem_Combination_SubSeq_02(board, 0, tnq, "") << endl;

    //cout << N_Queen_Problem_Permutation_SubSeq_03(board, 0, tnq, "") << endl;
    //cout << N_Queen_Problem_Permutation_04(board, 0, tnq, "") << endl;
    //cout << N_Queen_Problem_Permutation_05(board, 0, tnq, "") << endl;
}

void solve()
{
    //Questions_Set_01();

    Questions_Set_02();
}

int main()
{
    solve();
    return 0;
}