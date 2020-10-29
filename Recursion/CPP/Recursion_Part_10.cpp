#include<iostream>

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

void Questions_Set_01()
{
    Lexographical_Order(1, 20);
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