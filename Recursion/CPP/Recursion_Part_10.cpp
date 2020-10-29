#include<iostream>
#include<vector>

using namespace std;

void Lexographical_Order(int st, int end)
{
    if(st > end)
    {
        return;
    }

    cout << st << endl;

    for(int i=0; i<10; i++)
    {
        if(st*10+i < end)
        {
            Lexographical_Order(st*10+i, end);
        }
        else
        {
            break;
        } 
    }

    if(st+1 < 10)
    {
        Lexographical_Order(st+1, end);
    }
}

int Letter_Tile_Possibilities(string str)
{
    if(str.length() == 0)
    {
        return 0;
    }

    int count = 0;
    vector<bool> vis(26, false);
    for(int i=0; i<str.length(); i++)
    {
        int chIdx = str[i] - 'A';
        if(vis[chIdx] == false)
        {
            vis[chIdx] = true;
            string nstr = str.substr(0, i) + str.substr(i+1);
            count += Letter_Tile_Possibilities(nstr) + 1;
        }
    }
    return count;
}
int Letter_Tile_Possibilities_01(string str)
{
    if(str.length() == 0)
    {
        return 0;
    }

    int count = 0;
    int vis=0;
    for(int i=0; i<str.length(); i++)
    {
        int mask = 1 << (str[i] - 'A'); 
        if((vis & mask) == 0)
        {
            vis ^= mask;
            string nstr = str.substr(0, i) + str.substr(i+1);
            count += Letter_Tile_Possibilities_01(nstr) + 1;
        }
    }
    return count;
}
int Letter_Tile_Possibilities_02(string str, string ans)
{
    cout << ans << endl;
    if(str.length() == 0)
    {
        return 0;
    }

    int count = 0;
    int vis=0;
    for(int i=0; i<str.length(); i++)
    {
        int mask = 1 << (str[i] - 'A'); 
        if((vis & mask) == 0)
        {
            vis ^= mask;
            string nstr = str.substr(0, i) + str.substr(i+1);
            count += Letter_Tile_Possibilities_02(nstr, ans+str[i]+" ") + 1;
        }
    }
    return count;
}
void Leetcode_1079()
{
    //cout << Letter_Tile_Possibilities("AAB") << endl;
    //cout << Letter_Tile_Possibilities_01("AAABBC") << endl;
    cout << Letter_Tile_Possibilities_02("AAB", "") << endl;
}
void Questions_Set_01()
{
    //Lexographical_Order(1, 20);

    Leetcode_1079();
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