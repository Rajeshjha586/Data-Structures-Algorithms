#include<iostream>
#include<vector>

using namespace std;

//*****************************************************************
//                   Recursion_Basics_Problems

void Print_Increasing(int a, int b)
{
    if(a == b+1)
    {
        return;
    }

    cout << a << " ";
    Print_Increasing(a+1, b);
}

void Print_Decreasing(int a, int b)
{
    if(a == b+1)
    {
        return;
    }

    Print_Decreasing(a+1, b);
    cout << a << " ";
}

void Print_Increasing_Decreasing(int a, int b)
{
    if(a == b+1)
    {
        return;
    }

    cout << a << " hi" << endl;
    Print_Increasing_Decreasing(a+1, b);
    cout << a << " bye" << endl;
}

void Print_Increasing_Decreasing_Even_Odd(int a, int b)
{
    if(a == b+1)
    {
        return;
    }

    if(a%2==0)
    {
        cout << a << " hi" << endl;
    }
    Print_Increasing_Decreasing_Even_Odd(a+1, b);
    if(a%2!=0)
    {
        cout << a << " bye" << endl;
    }
}

int Factorial(int n)
{
    if(n<=1)
    {
        return 1;
    }
    int fnm1 = Factorial(n-1);
    int fn = n * fnm1;
    return fn;
}

int Power(int a, int n)
{
    if(n<=0)
    {
        return 1;
    }
    int pwnm1 = Power(a, n-1);
    int pwn = a * pwnm1;
    return pwn;
}

int Power_Better(int a, int n)
{
    if(n<=0)
    {
        return 1;
    }
    int pwnb2 = Power_Better(a, n/2) * Power_Better(a, n/2);

    if(n%2!=0)
    {
        return pwnb2 * a;
    }
    else
    {
        return pwnb2;
    }
    
}

//***********************************************************************

//-----------------------------------------------------------------------
//               Recursion_With_Array

void display_Array(vector<int>& arr, int idx)
{
    if(idx==arr.size()) return;
    cout << arr[idx] << " ";
    display_Array(arr, idx+1);
}

int maximum(vector<int>& arr, int idx)
{
    if(idx==arr.size()-1) return arr[idx];
    return max(arr[idx], maximum(arr, idx+1));
}

int minimum(vector<int>& arr, int idx)
{
    if(idx==arr.size()-1) return arr[idx];
    return min(arr[idx], minimum(arr, idx+1));
}

bool Find(vector<int>& arr, int idx, int data)
{
    if(idx==arr.size()) return false;
    if(arr[idx] == data) return true;
    return Find(arr, idx+1, data);
}

int First_Index(vector<int>& arr, int idx, int data)
{
    if(idx==arr.size()) return -1;
    if(arr[idx] == data) return idx;
    return First_Index(arr, idx+1, data);
}

int Last_Index(vector<int>& arr, int idx, int data)
{
    if(idx==arr.size()) return -1;
    int ans = Last_Index(arr, idx+1, data);
    if(ans!=-1) return ans;
    return arr[idx]==data ? idx : -1;
}

//-----------------------------------------------------------------------

void Recursion_With_Array()
{
    //vector<int> arr{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    //display_Array(arr, 0);

    //vector<int> arr{8, 4, 3, 9, 2, 5, 7, 1};
    //cout << "Maximum of Array : " << maximum(arr, 0) << endl;
    //cout << "Minimum of Array : " << minimum(arr, 0) << endl;

    //vector<int> arr{21, 5, 8, 2, 3, 2, 6, 12, 8};
    //cout << Find(arr, 0, 2) << endl;
    //cout << "First_Index : " << First_Index(arr, 0, 2) << endl;
    //cout << "Last_Index : " << Last_Index(arr, 0, 2) << endl;
}
void Recursion_Basics_Problems()
{
    //Print_Increasing(0, 100);

    //Print_Decreasing(0, 20);

    //int a, b;
    //cin >> a >> b;

    //Print_Increasing_Decreasing(a, b);

    //Print_Increasing_Decreasing_Even_Odd(a, b);

    //cout << "Factorial is : " << Factorial(5) << endl;

    //cout << Power(2, 8) << endl;

    //cout << Power_Better(2, 10) << endl;
}
void solve()
{
    //Recursion_Basics_Problems();

    Recursion_With_Array();
}
int main()
{
    solve();
    return 0;
}