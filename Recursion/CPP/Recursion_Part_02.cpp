#include<iostream>
#include<vector>


using namespace std;
vector<string> words = {
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

vector<string> get_KeyPad_Combination(string str)
{
    if(str.length() == 0)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    char ch = str[0];
    string ros = str.substr(1);
    vector<string> rres = get_KeyPad_Combination(ros);
    vector<string> mres;

    string word = words[ch-'0'];
    for(string s : rres)
    {
        for(int i=0; i<word.length(); i++)
        {
            mres.push_back(word[i] + s);
        }
    }
    return mres;
}

int get_KeyPad_Combination_Void_Type(string str, string ans)
{
    if(str.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }

    char ch = str[0];
    string ros = str.substr(1);

    string word = words[ch-'0'];
    int count = 0;

    for(int i=0; i<word.length(); i++)
    {
        count+=get_KeyPad_Combination_Void_Type(ros, ans+word[i]);
    }

    return count;
}

int get_KeyPad_Combination_Void_Type_02(string str, int idx, string ans)
{
    if(idx == str.length())
    {
        cout << ans << endl;
        return 1;
    }

    char ch = str[idx];

    string word = words[ch-'0'];
    int count = 0;

    for(int i=0; i<word.length(); i++)
    {
        count+=get_KeyPad_Combination_Void_Type_02(str, idx+1, ans+word[i]);
    }

    if(idx+1 < str.length())
    {
        int num = (ch - '0') * 10 + (str[idx+1] - '0');
        if(num == 10 || num == 11)
        {
            word = words[num];
            for(int i=0; i<word.length(); i++)
            {
                count+=get_KeyPad_Combination_Void_Type_02(str, idx+2, ans+word[i]);
            }   
        }
    } 

    return count;
}

vector<string> get_KeyPad_Combination_02(string str, int idx)
{
    if(idx == str.length())
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    char ch = str[idx];
    
    vector<string> rres = get_KeyPad_Combination_02(str, idx+1);
    vector<string> mres;

    string word = words[ch-'0'];
    for(string s : rres)
    {
        for(int i=0; i<word.length(); i++)
        {
            mres.push_back(word[i] + s);
        }
    }

    if(idx+1 < str.length())
    {
        int num = (ch - '0') * 10 + (str[idx+1] - '0');
        if(num == 10 || num == 11)
        {
            word = words[num];
            vector<string> rres1 = get_KeyPad_Combination_02(str, idx+2);
            for(string s : rres1)
            {
                for(int i=0; i<word.length(); i++)
                {
                    mres.push_back(word[i] + s);
                }
            }
        }
    }

    return mres;
}

int Decode_Ways_Leetcode_91(string str, int idx, string ans)
{
    if(idx == str.length())
    {
        cout << ans << endl;
        return 1;
    }

    char ch = str[idx];
    int count = 0;

    if(ch != '0')
    {
        char ch_ = (char)((ch-'1') + 'a');
        count += Decode_Ways_Leetcode_91(str, idx+1, ans+ch_);
    }

    if(idx+1 < str.length())
    {
        int num = (ch - '0')*10 + (str[idx+1] - '0');
        if(num>=10 && num<=26)
        {
            char ch_ = (char)(num + 'a' - 1);
            count += Decode_Ways_Leetcode_91(str, idx+2, ans+ch_);
        }
    }

    return count;

}

vector<string> Decode_Ways_Leetcode_91_02(string str, int idx)
{
    if(idx == str.length())
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    vector<string> mres;
    char ch = str[idx];
    if(ch != '0')
    {
        char ch_ = (char)((ch-'1') + 'a');
        vector<string> rres = Decode_Ways_Leetcode_91_02(str, idx+1);
        for(string s : rres)
        {
            mres.push_back(ch_ + s);
        }
    }

    if(idx+1 < str.length())
    {
        int num = (ch - '0')*10 + (str[idx+1] - '0');
        if(num>=10 && num<=26)
        {
            char ch_ = (char)(num + 'a' - 1);
            vector<string> rres1 = Decode_Ways_Leetcode_91_02(str, idx+2);
            for(string s : rres1)
            {
                mres.push_back(ch_ + s);
            }
        }
    }

    return mres;

}

// steps : Horizontal Vertical(Return Type)
vector<string> MazePath_HV(int sr, int sc, int er, int ec)
{
    if(sr==er && sc==ec)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    vector<string> mres;
    
    if(sc+1<=ec)
    {
        vector<string> Horizontal = MazePath_HV(sr, sc+1, er, ec);
        for(string s : Horizontal)
        {
            mres.push_back("H" + s);
        }
    }

    if(sr+1<=er)
    {
        vector<string> Vertical = MazePath_HV(sr+1, sc, er, ec);
        for(string s : Vertical)
        {
            mres.push_back("V" + s);
        }
    }

    return mres;
}

// steps : Horizontal Vertical Diagonal(Return Type)
vector<string> MazePath_HVD(int sr, int sc, int er, int ec)
{
    if(sr==er && sc==ec)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    vector<string> mres;
    
    if(sc+1<=ec)
    {
        vector<string> Horizontal = MazePath_HVD(sr, sc+1, er, ec);
        for(string s : Horizontal)
        {
            mres.push_back("H" + s);
        }
    }

    if(sr+1<=er)
    {
        vector<string> Vertical = MazePath_HVD(sr+1, sc, er, ec);
        for(string s : Vertical)
        {
            mres.push_back("V" + s);
        }
    }

    if(sr+1<=er && sc+1<=ec)
    {
        vector<string> Diagnoal = MazePath_HVD(sr+1, sc+1, er, ec);
        for(string s : Diagnoal)
        {
            mres.push_back("D" + s);
        }
    }

    return mres;
}

// steps : Horizontal Vertical(Void Type)
int MazePath_HV_01(int sr, int sc, int er, int ec, string ans)
{
    if(sr==er && sc==ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    
    if(sc+1<=ec)
    {
        count += MazePath_HV_01(sr, sc+1, er, ec, ans+"H");
    }

    if(sr+1<=er)
    {
        count += MazePath_HV_01(sr+1, sc, er, ec, ans+"V");
    }

    return count;
}

// steps : Horizontal Vertical Diagonal(Void Type)
int MazePath_HVD_01(int sr, int sc, int er, int ec, string ans)
{
    if(sr==er && sc==ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    
    if(sc+1<=ec)
    {
        count += MazePath_HVD_01(sr, sc+1, er, ec, ans+"H");
    }

    if(sr+1<=er)
    {
        count += MazePath_HVD_01(sr+1, sc, er, ec, ans+"V");
    }

    if(sr+1<=er && sc+1<=ec)
    {
        count += MazePath_HVD_01(sr+1, sc+1, er, ec, ans+"D");
    }

    return count;
}

// steps : Multimove --> Horizontal Vertical(Void Type)
int MazePath_Multimove_HV(int sr, int sc, int er, int ec, string ans)
{
    if(sr==er && sc==ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    
    for(int jump=1; sc+jump<=ec; jump++)
    {
        count += MazePath_Multimove_HV(sr, sc+jump, er, ec, ans + "H" + to_string(jump));
    }

    for(int jump=1; sr+jump<=er; jump++)
    {
        count += MazePath_Multimove_HV(sr+jump, sc, er, ec, ans + "V" + to_string(jump));
    }

    return count;
}

// steps : Multimove --> Horizontal Vertical Diagonal(Void Type)
int MazePath_Multimove_HVD(int sr, int sc, int er, int ec, string ans)
{
    if(sr==er && sc==ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    
    for(int ms=1; ms<=ec-sc; ms++)
    {
        count += MazePath_Multimove_HVD(sr, sc+ms, er, ec, ans+"H"+to_string(ms));
    }

    for(int ms=1; ms<=er-sr; ms++)
    {
        count += MazePath_Multimove_HVD(sr+ms, sc, er, ec, ans+"V"+to_string(ms));
    }

    for(int ms=1; ms<=er-sr && ms<=ec-sc; ms++)
    {
        count += MazePath_Multimove_HVD(sr+ms, sc+ms, er, ec, ans+"D"+to_string(ms));
    }

    return count;
}

// steps : Multimove --> Horizontal Vertical(Return Type)
vector<string> MazePath_Multimove_HV_01(int sr, int sc, int er, int ec)
{
    if(sr==er && sc==ec)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    vector<string> mres;
    
    for(int ms=1; ms<=ec-sc; ms++)
    {
        vector<string> Horizontal = MazePath_Multimove_HV_01(sr, sc+ms, er, ec);
        for(string s : Horizontal)
        {
            mres.push_back(s + "H" + to_string(ms));
        }
    }

    for(int ms=1; ms<=er-sr; ms++)
    {
        vector<string> vertical = MazePath_Multimove_HV_01(sr+ms, sc, er, ec);
        for(string s : vertical)
        {
            mres.push_back(s + "V" + to_string(ms));
        }
    }

    return mres;
}

// steps : Multimove --> Horizontal Vertical Diagonal(Return Type)
vector<string> MazePath_Multimove_HVD_01(int sr, int sc, int er, int ec)
{
    if(sr==er && sc==ec)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    }

    vector<string> mres;
    
    for(int ms=1; ms<=ec-sc; ms++)
    {
        vector<string> Horizontal = MazePath_Multimove_HV_01(sr, sc+ms, er, ec);
        for(string s : Horizontal)
        {
            mres.push_back(s + "H" + to_string(ms));
        }
    }

    for(int ms=1; ms<=er-sr; ms++)
    {
        vector<string> vertical = MazePath_Multimove_HV_01(sr+ms, sc, er, ec);
        for(string s : vertical)
        {
            mres.push_back(s + "V" + to_string(ms));
        }
    }

    for(int ms=1; ms<=er-sr && ms<=ec-sc; ms++)
    {
        vector<string> vertical = MazePath_Multimove_HVD_01(sr+ms, sc+ms, er, ec);
        for(string s : vertical)
        {
            mres.push_back(s + "D" + to_string(ms));
        }
    }

    return mres;
}


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

int Rat_In_Maze(int sr, int sc, int er, int ec, vector<vector<int>>& board, string ans)
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
            count+=Rat_In_Maze(x, y, er, ec, board, ans+dirS[d]);
        }
    }
    board[sr][sc] = 0; //unmarked

    return count;
}

int Rat_In_Maze_With_Multiple_Steps(int sr, int sc, int er, int ec, vector<vector<int>>& board, string ans)
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
        for(int rad=1; rad<=board.size(); rad++)
        {
            int x = sr + rad * dirA[d][0];
            int y = sc + rad * dirA[d][1];

            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]==0)
            {
                count+=Rat_In_Maze_With_Multiple_Steps(x, y, er, ec, board, ans+dirS[d]+to_string(rad));
            }
        }
    }
    board[sr][sc] = 0; //unmarked

    return count;
}


//Path Type Problem
void Question_Set_02()
{
    /*
    vector<string> res = MazePath_HV(0, 0, 2, 2);
    for(string ans : res)
    {
        cout << ans << endl;
    }
    */

    /*
    vector<string> res = MazePath_HVD(0, 0, 2, 2);
    for(string ans : res)
    {
        cout << ans << endl;
    }
    */

    //cout << MazePath_HV_01(0, 0, 2, 2, "") << endl;
    //cout << MazePath_HVD_01(0, 0, 2, 2, "") << endl;

    
    //cout << MazePath_Multimove_HV(0, 0, 2, 2, "") << endl;
    //cout << MazePath_Multimove_HVD(0, 0, 2, 2, "") << endl;

    /*
    vector<string> res = MazePath_Multimove_HV_01(0, 0, 2, 2);
    for(string ans : res)
    {
        cout << ans << endl;
    }
    */

    /*
    vector<string> res = MazePath_Multimove_HVD_01(0, 0, 2, 2);
    for(string ans : res)
    {
        cout << ans << endl;
    }
    */

    //vector<vector<int>> board(3, vector<int>(3, 0));
    //cout << Flood_Fill(0, 0, 2, 2, board, "") << endl;
    
    /*
    
    vector<vector<int>> board = {
        {0, 1, 1, 1},
        {0, 0, 1, 0},
        {1, 0, 1, 1},
        {0, 0, 0, 0}
    };
    
    cout << Rat_In_Maze(0, 0, 3, 3, board, "") << endl;

    */

   vector<vector<int>> board = {
        {0, 1, 1, 1},
        {0, 0, 1, 0},
        {1, 0, 1, 1},
        {0, 0, 0, 0}
    };
    
    cout << Rat_In_Maze_With_Multiple_Steps(0, 0, 3, 3, board, "") << endl;

    
}

void Question_Set_01()
{
    /*

    vector<string> ans = get_KeyPad_Combination("489");
    for(string res : ans)
    {
        cout << res << " " << endl;
    }

    */
    
    //cout << get_KeyPad_Combination_Void_Type("489", "") << endl;

    //cout << get_KeyPad_Combination_Void_Type_02("10", 0, "") << endl;

    /*

    vector<string> ans = get_KeyPad_Combination_02("10", 0);
    for(string res : ans)
    {
        cout << res << " " << endl;
    }
    
    */

    //cout << Decode_Ways_Leetcode_91("1148", 0, "") << endl;

    /*
                                   
    vector<string> ans = Decode_Ways_Leetcode_91_02("1148", 0);
    for(string res : ans)
    {
        cout << res << " " << endl;
    }

    */
}
void solve()
{
    //Question_Set_01();

    //Path Type Problem
    Question_Set_02();
}
int main()
{
    solve();
    return 0;
}