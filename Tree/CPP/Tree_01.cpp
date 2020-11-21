#include<iostream>
#include<vector>

using namespace std;

class Node
{

public:
    
    int data;
    Node* left=nullptr;
    Node* right=nullptr;

    Node(int data)
    {
        this->data = data;
    }
    
};

int idx = 0;
Node* construct_Tree(vector<int>& arr)
{
    if(idx == arr.size() || arr[idx] == -1)
    {
        idx++;
        return nullptr; //NULL
    }

    Node* node = new Node(arr[idx++]);
    node->left = construct_Tree(arr);
    node->right = construct_Tree(arr);

    return node;
}

void display(Node* node)
{
    if(node == nullptr)
    {
        return;
    }

    string str = "";
    str += ((node->left != nullptr) ? to_string(node->left->data) : ".");
    str += " <- " + to_string(node->data) + " -> ";
    str += ((node->right != nullptr) ? to_string(node->right->data) : ".");
    cout << str << endl;

    display(node->left);
    display(node->right);

}

void Tree_Basics()
{
    vector<int> arr = {10, 20, 40, -1, -1, 50, 80, -1, -1, 90, -1, -1, 30, 60, 100, -1, -1, -1, 70, 110, -1, -1, 120, -1, -1};
    Node* root = construct_Tree(arr);
    display(root);
}
void solve()
{
    Tree_Basics();
}
int main()
{
    solve();
    return 0;
}