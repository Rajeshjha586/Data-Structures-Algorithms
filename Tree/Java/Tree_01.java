public class Tree_01
{
    public static class Node
    {
        int data;
        Node left = null;
        Node right = null;

        Node(int data)
        {
            this.data=data;
        }
    }

    static int idx = 0;
    public static Node construct_Tree(int[] arr)
    {
        if(idx == arr.length || arr[idx] == -1)
        {
            idx++;
            return null;
        }

        Node node = new Node(arr[idx++]);
        node.left = construct_Tree(arr);
        node.right = construct_Tree(arr);

        return node;
    }

    public static void display(Node node)
    {
        if(node == null)
        {
            return;
        }

        String str = "";
        str += ((node.left != null) ? node.left.data : ".");
        str += " <- " + node.data + " -> ";
        str += ((node.right != null) ? node.right.data : ".");
        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    public static void Tree_Basics()
    {
        int[] arr = {10, 20, 40, -1, -1, 50, 80, -1, -1, 90, -1, -1, 30, 60, 100, -1, -1, -1, 70, 110, -1, -1, 120, -1, -1};
        Node root = construct_Tree(arr);
        display(root);
    }
    public static void solve()
    {
        Tree_Basics();
    }
    public static void main(String[] args)
    {
        solve();
    }
}