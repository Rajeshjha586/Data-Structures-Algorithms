#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int find_kth_Smallest(vector<int>& list, int k) {
    priority_queue<int, vector<int>> pq;

    for(int i=0; i<list.size(); i++) {
        pq.push(list[i]);

        if(pq.size() > k) {
            pq.pop();
        }
    }

    return pq.top();
}

int main() {
    vector<int> list = { 7, 10, 4, 3, 20, 15, 26, 85, 1 };
    cout << "Kth Smallest: " << find_kth_Smallest(list, 3);
    return 0;
}