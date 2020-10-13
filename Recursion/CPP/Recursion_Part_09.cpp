#include<iostream>
#include<vector>

using namespace std;

int Equi_Set_01(vector<int>& arr, int idx, int set1, int set2, string set1S, string set2S)
{
    if(idx == arr.size())
    {
        if(set1 == set2)
        {
            cout << set1S << " = " << set2S << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    count += Equi_Set_01(arr, idx+1, set1+arr[idx], set2, set1S+" "+to_string(arr[idx]), set2S);
    count += Equi_Set_01(arr, idx+1, set1, set2+arr[idx], set1S, set2S+" "+to_string(arr[idx]));
    return count;
}

int Equi_Set_02(vector<int>& arr, int idx, int set1, int set2, string set1S, string set2S)
{
    // we can't use return statement bcz every answer there may be chance of more answer we get

    if(idx == arr.size())
    {
        if(set1 == set2 && set1 != 0)
        {
            cout << set1S << " = " << set2S << endl;
            return 1;
        }
        return 0;
    }
    
    int count = 0;
    count += Equi_Set_02(arr, idx+1, set1+arr[idx], set2, set1S+to_string(arr[idx])+" ", set2S);
    count += Equi_Set_02(arr, idx+1, set1, set2+arr[idx], set1S, set2S+to_string(arr[idx])+" ");

    count += Equi_Set_02(arr, idx+1, set1, set2, set1S, set2S);
    return count;
}

void Equi_Set_Problem()
{
    vector<int> arr{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    // All answer with duplicacy
    //cout << Equi_Set_01(arr, 0, 0, 0, "", "") << endl;

    //To Stop Duplicacy in Sets to fix one element which is common for set
    //cout << Equi_Set_01(arr, 1, 10, 0, "10 ", "") << endl;

    //cout << Equi_Set_02(arr, 0, 0, 0, "", "") << endl;
}


//CrossWord_Problem
vector<vector<char>> board{{'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};
vector<string> words = {"agra", "norway", "england", "gwalior"};

bool can_Place_Word_Horizontal(string word, int x, int y)
{
    if (y == 0 && word.length() < board[0].size())
    {
        if (board[x][y + word.length()] != '+')
            return false;
    }
    else if ((y + word.length()) == board[0].size() && word.length() != board[0].size())
    {
        if (board[x][y - 1] != '+')
            return false;
    }
    else
    {
        if (((y - 1) >= 0 && board[x][y - 1] != '+') || ((y + word.length()) < board[0].size() && board[x][y + word.length()] != '+'))
            return false;
    }
    for(int i=0; i<word.length(); i++)
    {
        if((y+i) == board[0].size())
        {
            return false;
        }
        if(board[x][y+i] != '-' && board[x][y+i] != word[i])
        {
            return false;
        }
    }
    return true;
}
vector<bool> Place_Word_Horizontal(string word, int x, int y)
{
    vector<bool> loc(word.length(), false);
    for(int i=0; i<word.length(); i++)
    {
        if(board[x][y+i] == '-')
        {
            loc[i] = true;
            board[x][y+i] = word[i];
        }
    }
    return loc;
}
void unPlace_Word_Horizontal(string word, int x, int y, vector<bool>& loc)
{
    for(int i=0; i<word.length(); i++)
    {
        if(loc[i])
        {
            board[x][y+i] = '-';
        }
    }
}
bool can_Place_Word_Vertical(string word, int x, int y)
{
    if (x == 0 && x + word.length() < board.size())
    {
        if (board[x + word.length()][y] != '+')
            return false;
    }
    else if ((x + word.length()) == board.size() && word.length() != board.size())
    {
        if (board[x - 1][y] != '+')
            return false;
    }
    else
    {
        if (((x - 1) >= 0 && board[x - 1][y] != '+') || ((x + word.length()) < board.size() && board[x + word.length()][y] != '+'))
            return false;
    }

    for(int i=0; i<word.length(); i++)
    {
        if((x+i) == board.size())
        {
            return false;
        }
        if(board[x+i][y] != '-' && board[x+i][y] != word[i])
        {
            return false;
        }
    }
    return true;
}
vector<bool> Place_Word_Vertical(string word, int x, int y)
{
    vector<bool> loc(word.length(), false);
    for(int i=0; i<word.length(); i++)
    {
        if(board[x+i][y] == '-')
        {
            loc[i] = true;
            board[x+i][y] = word[i];
        }
    }
    return loc;
}
void unPlace_Word_Vertical(string word, int x, int y, vector<bool>& loc)
{
    for(int i=0; i<word.length(); i++)
    {
        if(loc[i])
        {
            board[x+i][y] = '-';
        }
    }
}
int crossword_Solver(int idx)
{
    if(idx == words.size())
    {
        for(int i=0; i<board.size(); i++)
        {
            for(int j=0; j<board[0].size(); j++)
            {
                cout << board[i][j] << "\t";
            }
            cout << endl;
        }
    }

    int count = 0;
    string word = words[idx];
    for(int i=0; i<board.size(); i++)
    {
        for(int j=0; j<board[0].size(); j++)
        {
            if(board[i][j] == '-' || board[i][j] == word[0])
            {
                if(can_Place_Word_Horizontal(word, i, j))
                {
                    vector<bool> loc = Place_Word_Horizontal(word, i, j);
                    count += crossword_Solver(idx+1);
                    unPlace_Word_Horizontal(word, i, j, loc);
                }

                if(can_Place_Word_Vertical(word, i, j))
                {
                    vector<bool> loc = Place_Word_Vertical(word, i, j);
                    count += crossword_Solver(idx+1);
                    unPlace_Word_Vertical(word, i, j, loc);
                }
            }
        }
    }
    return count;
}
void crossword()
{
    cout << crossword_Solver(0) << endl;
}

void solve()
{
    //Equi_Set_Problem();

    crossword();
}
int main()
{
    solve();
    return 0;
}