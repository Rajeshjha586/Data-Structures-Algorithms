#include<iostream>
#include<vector>

using namespace std;

vector<bool> ROWS;
vector<bool> COLS;
vector<bool> DIAG;
vector<bool> ADIAG;
int N_Queen_Problem_Combination_06(int n, int m, int idx, int tnq, string ans)
{
    if(tnq==0)
    {
        cout << ans << endl;
        return 1;
    }

    int count=0;
    for(int r=idx; r<n*m; r++)
    {
        int x = r / m;
        int y = r % m;

        if(!ROWS[x] && !COLS[y] && !DIAG[x+y] && !ADIAG[x-y+(m-1)])
        {
            ROWS[x]=true; COLS[y]=true; DIAG[x+y]=true; ADIAG[x-y+(m-1)]=true;

            count += N_Queen_Problem_Combination_06(n, m, r+1, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
            
            ROWS[x]=false; COLS[y]=false; DIAG[x+y]=false; ADIAG[x-y+(m-1)]=false;
            
        }
    }

    return count;
}


int off_To_On(int num, int k)
{
    int mask = (1 << k);
    return (num | mask);
}

int on_To_Off_01(int num, int k)
{
    int mask = (~(1 << k)); //1"s Compliment of mask
    return (num & mask); 
}

int on_To_Off_02(int num, int k)
{
    int mask = (1 << k); 
    
    if((num & mask) == 0)
    {
        return num;
    }
    else
    {
        return (num ^ mask);
    }
    
}

// insert from starting is zero => always append zero from left
int count_All_Set_Bits(unsigned num)
{
    int count = 0;
    while (num != 0)
    {
        if((num & 1) != 0)
        {
            count++;
        }
        num >>= 1;
    }
    
    return count;
}


//Leetcode :- 338 conting bits
vector<int> counting_bits(int num)
{
    vector<int> ans(num+1, 0);
    for (int i = 1; i <= num; i++)
    {
        ans[i] = ans[(i & (i-1))] + 1;
    }
    return ans;
    
}


void Bits_Questions_Set_02()
{
    int num = 123;
    int k = 3;

    //cout << off_To_On(num, k) << endl;

    //cout << (on_To_Off_01(num, k) == on_To_Off_02(num, k)) << endl;

    //cout << count_All_Set_Bits(13) << endl;

    vector<int> res = counting_bits(10);
    for(int i=0; i<res.size(); i++)
    {
        cout << res[i] << " ";
    }
}

void Questions_Set_01()
{
    int n=4;
    int m=4;
    int tnq=4;

    ROWS.resize(n, false);
    COLS.resize(m, false);
    DIAG.resize(n+m-1, false);
    ADIAG.resize(n+m-1, false);

    cout << N_Queen_Problem_Combination_06(n, m, 0, tnq, "") << endl;
}

void solve()
{
    //Questions_Set_01();
    
    Bits_Questions_Set_02();
}

int main()
{
    solve();
    return 0;
}