#include<iostream>
#include<vector>

using namespace std;

int coinChange_Permutation_INF(vector<int>& arr, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int ele : arr)
    {
        if(tar-ele>=0)
        {
            count+=coinChange_Permutation_INF(arr, tar-ele, ans + to_string(ele)+" ");
        }
    }
    return count;
}

int coinChange_Permutation_INF_001(vector<int>& arr, int idx, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=idx; i<arr.size(); i++)
    {
        if(tar-arr[i]>=0)
        {
            count+=coinChange_Permutation_INF_001(arr, 0, tar-arr[i], ans + to_string(arr[i])+" ");
        }
    }
    return count;
}

int coinChange_Permutation_1_Coin_atA_Times(vector<int>& arr, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=0; i<arr.size(); i++)
    {
        int temp = arr[i];
        if(arr[i] > 0 && tar-arr[i]>=0)
        {
            arr[i] = -arr[i];
            count+=coinChange_Permutation_1_Coin_atA_Times(arr, tar-temp, ans + to_string(temp)+" ");
            arr[i] = -arr[i];
        }
    }
    return count;
}

int coinChange_Permutation_1_Coin_atA_Times_01(vector<int>& arr, int idx, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=idx; i<arr.size(); i++)
    {
        int temp = arr[i];
        if(arr[i] > 0 && tar-arr[i]>=0)
        {
            arr[i] = -arr[i];
            count+=coinChange_Permutation_1_Coin_atA_Times_01(arr, 0, tar-temp, ans + to_string(temp)+" ");
            arr[i] = -arr[i];
        }
    }
    return count;
}

int coinChange_Combination_INF(vector<int>& arr, int idx, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=idx; i<arr.size(); i++)
    {
        if(tar-arr[i]>=0)
        {
            count+=coinChange_Combination_INF(arr, i, tar-arr[i], ans + to_string(arr[i])+" ");
        }
    }
    return count;
}

int coinChange_Combination_1_coin_atA_Time(vector<int>& arr, int idx, int tar, string ans)
{
    if(tar == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for(int i=idx; i<arr.size(); i++)
    {
        if(tar-arr[i]>=0)
        {
            count+=coinChange_Combination_1_coin_atA_Time(arr, i+1, tar-arr[i], ans + to_string(arr[i])+" ");
        }
    }
    return count;
}



//***********************************************************************************
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


int coinChange_Combination_1_coin_atA_Time_01(vector<int>& arr, int idx, int tar, string ans)
{
    if(idx==arr.size() || tar==0)
    {
        if(tar==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0)
    {
        count+=coinChange_Combination_1_coin_atA_Time_01(arr, idx+1, tar-arr[idx], ans+to_string(arr[idx])+" ");
    }
    count+=coinChange_Combination_1_coin_atA_Time_01(arr, idx+1, tar, ans);

    return count;
}

int coinChange_Combination_INF_01(vector<int>& arr, int idx, int tar, string ans)
{
    if(idx==arr.size() || tar==0)
    {
        if(tar==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0)
    {
        count+=coinChange_Combination_INF_01(arr, idx, tar-arr[idx], ans+to_string(arr[idx])+" ");
    }
    count+=coinChange_Combination_INF_01(arr, idx+1, tar, ans);

    return count;
}

int coinChange_Permutation_INF_01(vector<int>& arr, int idx, int tar, string ans)
{
    if(idx==arr.size() || tar==0)
    {
        if(tar==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0)
    {
        count+=coinChange_Permutation_INF_01(arr, 0, tar-arr[idx], ans+to_string(arr[idx])+" ");
    }
    count+=coinChange_Permutation_INF_01(arr, idx+1, tar, ans);

    return count;
}

int coinChange_Permutation_1_coin_atA_Time_01(vector<int>& arr, int idx, int tar, string ans)
{
    if(idx==arr.size() || tar==0)
    {
        if(tar==0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(arr[idx]>0 && tar-arr[idx]>=0)
    {
        int temp = arr[idx];
        arr[idx] = -arr[idx];
        count+=coinChange_Permutation_1_Coin_atA_Times_01(arr, 0, tar-arr[idx], ans+to_string(arr[idx])+" ");
        arr[idx] = -arr[idx];
    }
    count+=coinChange_Permutation_1_Coin_atA_Times_01(arr, idx+1, tar, ans);

    return count;
}


int queen_Combination_1D(vector<bool>& rooms, int room, int qpsf, int tnq, string ans)
{
    if (qpsf == tnq)
    {
        cout << ans << endl;
        return 1;
    }
    
    int count = 0;
    for(int r=room; r<rooms.size(); r++)
    {
        count+=queen_Combination_1D(rooms, r+1, qpsf+1, tnq, ans+"Q"+to_string(qpsf)+"R"+to_string(r)+" ");
    }
    return count;
}

int queen_Permutation_1D(vector<bool>& rooms, int room, int qpsf, int tnq, string ans)
{
    if (qpsf == tnq)
    {
        cout << ans << endl;
        return 1;
    }
    
    int count = 0;
    for(int r=room; r<rooms.size(); r++)
    {
        if(!rooms[r])
        {
            rooms[r] = true;
            count+=queen_Permutation_1D(rooms, 0, qpsf+1, tnq, ans+"Q"+to_string(qpsf)+"R"+to_string(r)+" ");
            rooms[r] = false;
        }
    }
    return count;
}

int queen_Combination_2D(vector<vector<bool>>& rooms, int room, int tnq, string ans)
{
    if (tnq==0)
    {
        cout << ans << endl;
        return 1;
    }
    
    int count = 0;
    for(int r=room; r<rooms.size()*rooms[0].size(); r++)
    {
        int x = r / rooms[0].size();
        int y = r % rooms[0].size();

        count+=queen_Combination_2D(rooms, r+1, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
    }
    return count;
}

int queen_Permutation_2D(vector<vector<bool>>& rooms, int room, int tnq, string ans)
{
    if (tnq==0)
    {
        cout << ans << endl;
        return 1;
    }
    
    int count = 0;
    for(int r=room; r<rooms.size()*rooms[0].size(); r++)
    {
        int x = r / rooms[0].size();
        int y = r % rooms[0].size();

        if(!rooms[x][y])
        {
            rooms[x][y] = true;
            count+=queen_Permutation_2D(rooms, 0, tnq-1, ans+"("+to_string(x)+","+to_string(y)+") ");
            rooms[x][y] = false;
        }
    }
    return count;
}

void Queen_Problems()
{
    //vector<bool> rooms(16, false);
    //int tnq = 4;
    //cout << queen_Combination_1D(rooms, 0, 0, tnq, "") << endl;
    //cout << queen_Permutation_1D(rooms, 0, 0, tnq, "") << endl;

    //vector<vector<bool>> rooms(4, vector<bool>(4, 0));
    //int tnq = 4;
    //cout << queen_Combination_2D(rooms, 0, tnq, "") << endl;
    //cout << queen_Permutation_2D(rooms, 0, tnq, "") << endl;
}

void Coinchange_Problems_01()
{
    vector<int> arr{2, 3, 5, 7};
    int tar = 10;
    //cout << coinChange_Permutation_INF(arr, tar, "") << endl;
    cout << coinChange_Permutation_INF_001(arr, 0, tar, "") << endl;

    //cout << coinChange_Permutation_1_Coin_atA_Times(arr, tar, "") << endl;
    //cout << coinChange_Permutation_1_Coin_atA_Times_01(arr, 0, tar, "") << endl;
    
    //cout << coinChange_Combination_INF(arr, 0, tar, "") << endl;
    //cout << coinChange_Combination_1_coin_atA_Time(arr, 0, tar, "") << endl;
    
    //cout << coinChange_Combination(arr, 0, tar, "") << endl;
}

void Coinchange_Problems_02()
{
    vector<int> arr{2, 3, 5, 7};
    int tar = 10;

    //cout << coinChange_Combination_1_coin_atA_Time_01(arr, 0, tar, "") << endl;
    //cout << coinChange_Combination_INF_01(arr, 0, tar, "") << endl;
    //cout << coinChange_Permutation_INF_01(arr, 0, tar, "") << endl;
    //cout << coinChange_Permutation_1_Coin_atA_Times_01(arr, 0, tar, "") << endl;
}

void solve()
{
    //Coinchange_Problems_01();

    //Coinchange_Problems_02();

    //Queen_Problems();
}

int main()
{
    solve();
    return 0;
}