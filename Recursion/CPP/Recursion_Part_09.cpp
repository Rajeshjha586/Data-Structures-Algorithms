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

    cout << Equi_Set_02(arr, 0, 0, 0, "", "") << endl;
}
void solve()
{
    Equi_Set_Problem();
}
int main()
{
    solve();
    return 0;
}