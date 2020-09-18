#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> dirA = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
vector<string> dirS = {"L", "N", "U", "E", "R", "S", "D", "W"};


int Flood_Fill(int sr, int sc, int er, int ec, vector<vector<int>>& board, string ans)
{
    // 0 free cell
    // 1 blocked cell
    if(sr==er && sc==ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        int x = sr + dirA[d][0];
        int y = sc + dirA[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
        {
            count+=Flood_Fill(x, y, er, ec, board, ans+dirS[d]);
        }
    }
    board[sr][sc] = 0; //unmarked

    return count;
}

int Longest_path_of_Flood_Fill(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        return 0; // if src==destination then longest path is 0 that's why we return 0
    }

    int myHeight = 0;

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        int x = sr + dirA[d][0];
        int y = sc + dirA[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
        {
            myHeight = max(myHeight, Longest_path_of_Flood_Fill(x, y, er, ec, board));
        }
    }
    board[sr][sc] = 0; //unmarked

    return myHeight+1;
}

int Longest_path_of_Flood_Fill_with_Multimove(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        return 0; // if src==destination then longest path is 0 that's why we return 0
    }

    int myHeight = 0;

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        for(int jump=1; jump<board.size(); jump++)
        {
            int x = sr + jump * dirA[d][0];
            int y = sc + jump * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
            {
                myHeight = max(myHeight, Longest_path_of_Flood_Fill_with_Multimove(x, y, er, ec, board));
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myHeight+1;
}

int Smallest_Path_of_Flood_Fill(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        return 0; // if src==destination then longest path is 0 that's why we return 0
    }

    int myHeight = board.size() * board[0].size();

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        int x = sr + dirA[d][0];
        int y = sc + dirA[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
        {
            myHeight = min(myHeight, Smallest_Path_of_Flood_Fill(x, y, er, ec, board));
        }
    }
    board[sr][sc] = 0; //unmarked

    return myHeight+1;
}

int Smallest_Path_of_Flood_Fill_with_Multimove(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        return 0; // if src==destination then longest path is 0 that's why we return 0
    }

    int myHeight = board.size() * board[0].size();

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        for(int jump=1; jump<board.size(); jump++)
        {
            int x = sr + jump * dirA[d][0];
            int y = sc + jump * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
            {
                myHeight = min(myHeight, Smallest_Path_of_Flood_Fill_with_Multimove(x, y, er, ec, board));
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myHeight+1;
}

class Pair
{
    public :
        string path = "";
        int len;
    
        Pair(string path_, int len_)
        {
            path = path_;
            len = len_;
        }
};

Pair Longest_path_of_Flood_Fill_01(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        Pair base("", 0);
        return base;
    }

    Pair myPair("", 0);

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        int x = sr + dirA[d][0];
        int y = sc + dirA[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
        {
            Pair smallAns = Longest_path_of_Flood_Fill_01(x, y, er, ec, board);

            if(myPair.len < smallAns.len+1)
            {
                myPair.len = smallAns.len+1;
                myPair.path = dirS[d] + smallAns.path;
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myPair;
}

Pair Longest_path_of_Flood_Fill_with_Multimove_01(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        Pair base("", 0);
        return base;
    }

    Pair myPair("", 0);

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        for(int rad = 1; rad<board.size(); rad++)
        {
            int x = sr + rad * dirA[d][0];
            int y = sc + rad * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
            {
                Pair smallAns = Longest_path_of_Flood_Fill_with_Multimove_01(x, y, er, ec, board);

                if(myPair.len < smallAns.len+1)
                {
                    myPair.len = smallAns.len+1;
                    myPair.path = dirS[d] + to_string(rad) + smallAns.path;
                }
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myPair;
}

Pair Smallest_Path_of_Flood_Fill_01(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        Pair base("", 0);
        return base;
    }

    Pair myPair("", board.size() * board[0].size());

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        int x = sr + dirA[d][0];
        int y = sc + dirA[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
        {
            Pair smallAns = Smallest_Path_of_Flood_Fill_01(x, y, er, ec, board);

            if(myPair.len > smallAns.len+1)
            {
                myPair.len = smallAns.len+1;
                myPair.path = dirS[d] + smallAns.path;
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myPair;
}

Pair Smallest_Path_of_Flood_Fill_with_Multimove_01(int sr, int sc, int er, int ec, vector<vector<int>>& board)
{
    if(sr==er && sc==ec)
    {
        Pair base("", 0);
        return base;
    }

    Pair myPair("", board.size() * board[0].size());

    board[sr][sc] = 1; //mark
    for(int d=0; d<dirA.size(); d++)
    {
        for(int jump=1; jump<board.size(); jump++)
        {
            int x = sr + jump * dirA[d][0];
            int y = sc + jump * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
            {
                Pair smallAns = Smallest_Path_of_Flood_Fill_01(x, y, er, ec, board);

                if(myPair.len > smallAns.len+1)
                {
                    myPair.len = smallAns.len+1;
                    myPair.path = dirS[d] + to_string(jump) + smallAns.path;
                }
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return myPair;
}

//Leetcode-1219
int Leetcode_1219_get_Maximum_Gold(int r, int c, vector<vector<int>>& board, vector<vector<int>>& dir)
{
    board[r][c] = -board[r][c];
    int res=0;

    for(int d=0; d<4; d++)
    {
        int x = r + dir[d][0];
        int y = c + dir[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y] > 0)
        {
            res = max(res, Leetcode_1219_get_Maximum_Gold(x, y, board, dir));
        }
    }
    
    board[r][c] = -board[r][c];
    return res + board[r][c];
}
int get_Max_Gold(vector<vector<int>>& board)
{
    vector<vector<int>> dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    int res = 0;
    for(int i=0; i<board.size(); i++)
    {
        for(int j=0; j<board[0].size(); j++)
        {
            if(board[i][j] > 0)
            {
                res = max(res, Leetcode_1219_get_Maximum_Gold(i, j, board, dir));  
            }
        }
    }
    return res;
}

int Leetcode_980_UniquePath_III(int sr, int sc, int er, int ec, int freeCell, vector<vector<int>>& board, vector<vector<int>>& dir) 
{
    if(sr==er && sc==ec)
    {
        if(freeCell==1)
        {
            return 1;
        }
        return 0;
    }

    int count = 0;
    int temp = board[sr][sc];
    board[sr][sc] = -2;

    for(int d=0; d<4; d++)
    {
        int x = sr + dir[d][0];
        int y = sc + dir[d][1];

        if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y] >= 0)
        {
            count += Leetcode_980_UniquePath_III(x, y, er, ec, freeCell-1, board, dir);
        }
    }

    board[sr][sc] = temp;
    return count;
}
int UniquePath_III(vector<vector<int>>& board)
{
    vector<vector<int>> dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    int sr, sc, er, ec, freeCell=0;
    for(int i=0; i<board.size(); i++)
    {
        for(int j=0; j<board[0].size(); j++)
        {
            if(board[i][j] != -1)
            {
                freeCell++;
            }
            if(board[i][j] == 1)
            {
                sr = i;
                sc = j;
            }
            if(board[i][j] == 2)
            {
                er=i;
                ec=j;
            }
        }
    }
    return Leetcode_980_UniquePath_III(sr, sc, er, ec, freeCell, board, dir);
}

void Questions_Set_02()
{
    /*
    
    vector<vector<int>> board = {
        {1, 0, 7},
        {2, 0, 6},
        {3, 4, 5},
        {0, 3, 0},
        {0, 0, 20},
    };

    cout << get_Max_Gold(board) << endl;

    */

    vector<vector<int>> board = {
        //{1,0,0,0},
        //{0,0,0,0},   //output for this test case is -> 2
        //{0,0,2,-1}

        {1,0,0,0},
        {0,0,0,0},   //output for this test case is -> 4
        {0,0,0,2}
    };

    cout << UniquePath_III(board) << endl;
}

void Questions_Set_01()
{
    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Flood_Fill(0, 0, 2, 2, board, "") << endl;

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Longest_path_of_Flood_Fill(0, 0, 2, 2, board) << endl;

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Longest_path_of_Flood_Fill_with_Multimove(0, 0, 2, 2, board) << endl;

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Smallest_Path_of_Flood_Fill(0, 0, 2, 2, board) << endl;

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Smallest_Path_of_Flood_Fill_with_Multimove(0, 0, 2, 2, board) << endl;
    
    //vector<vector<int>> board(3, vector<int>(3, 0));
    //Pair ans = Longest_path_of_Flood_Fill_01(0, 0, 2, 2, board);
    //cout << ans.path << " " << ans.len << " ";

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //Pair ans = Longest_path_of_Flood_Fill_with_Multimove_01(0, 0, 2, 2, board);
    //cout << ans.path << " " << ans.len << " ";

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //Pair ans = Smallest_Path_of_Flood_Fill_01(0, 0, 2, 2, board);
    //cout << ans.path << " " << ans.len << " ";

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //Pair ans = Smallest_Path_of_Flood_Fill_with_Multimove_01(0, 0, 2, 2, board);
    //cout << ans.path << " " << ans.len << " ";

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


