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
    Question_Set_01();
}
int main()
{
    solve();
    return 0;
}