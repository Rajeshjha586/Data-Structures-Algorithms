#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;

string str1 = "send";
string str2 = "more";
string str3 = "money";
int is_Number_Used = 0;
vector<int> assigned_Number(26, 0);

int stringToNumber(string str)
{
    int res = 0;
    for(int i=0; i<str.length(); i++)
    {
        res = res * 10 + assigned_Number[str[i]-'a'];
    }
    return res;
}

string Unique_Character(string str1, string str2, string str3)
{
    string str = str1 + str2 + str3;
    vector<int> freq(26, 0);

    for(int i=0; i<str.length(); i++)
    {
        freq[str[i]-'a']++;
    }

    str = "";
    for(int i=0; i<26; i++)
    {
        if(freq[i]>0)
        {
            str += (char)(i+'a');
        }
    }

    return str;
}

int crypto_Solver(string str, int idx)
{
    if(idx == str.length())
    {
        int num1 = stringToNumber(str1);
        int num2 = stringToNumber(str2);
        int num3 = stringToNumber(str3);

        //check for non-zero leader
        if(assigned_Number[str1[0]-'a']!=0 && assigned_Number[str2[0]-'a'] && assigned_Number[str3[0]-'a'] && num1 + num2 == num3)
        {
            cout << " " << num1 << endl
                 << "+" << num2 << endl
                 << "-----" << endl
                 << num3 << endl
                 << endl;

            return 1;
        }
        return 0;
    }

    int count = 0;
    for(int num=0; num<=9; num++)
    {
        int mask = 1 << num;
        if((is_Number_Used & mask) == 0)
        {
            is_Number_Used ^= mask;
            assigned_Number[str[idx]-'a']=num;

            count += crypto_Solver(str, idx+1);

            is_Number_Used ^= mask;
            assigned_Number[str[idx]-'a']=0;
        }
    }
    return count;
}

void crypto_Arithmetic()
{
    string unique = Unique_Character(str1, str2, str3);

    cout << crypto_Solver(unique, 0) << endl;
}

//Leetcode 40
void combination_Sum_2_solver(vector<int>& arr, int idx, int target, vector<vector<int>>& res, vector<int>& ans)
{
    if(target == 0)
    {
        vector<int> base;
        for(int ele : ans)
        {
            base.push_back(ele);
        }
        res.push_back(base);
        return;
    }

    int prev=-1;
    for(int i=idx; i<arr.size(); i++)
    {
        if(prev == arr[i])
        {
            continue;
        }

        prev=arr[i];
        if(target-arr[i] >= 0)
        {
            ans.push_back(arr[i]);
            combination_Sum_2_solver(arr, i+1, target-arr[i], res, ans);
            ans.pop_back();
        }
    }


}
vector<vector<int>> combinationSum2(vector<int>& arr, int target)
{
    sort(arr.begin(), arr.end());
    
    vector<vector<int>> res;
    vector<int> ans;

    combination_Sum_2_solver(arr, 0, target, res, ans);

    return res;
}
void Leetcode_40()
{
    vector<int> arr{10,1,2,7,6,1,5};
    int target = 8;

    vector<vector<int>> myans = combinationSum2(arr, target);
    for(vector<int> a : myans)
    {
        cout << "[ ";
        for(int ele : a)
        {
            cout << ele << " ";
        }
        cout << "]" << endl;
       
    }
}
void solve()
{
    //crypto_Arithmetic();

    Leetcode_40();
}
int main()
{
    solve();
    return 0;
}