public class LinkedList
{
    public class Node 
    {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public int size()
    {
        return this.size;
    }
    public boolean is_Empty()
    {
        return this.size==0;
    }

    public void addLast(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;

        if(this.size == 0)
        {
            this.head = this.tail = temp;
        }
        else
        {
            tail.next = temp;
            tail = temp;
        }

        this.size++;
    }
    public void display()
    {
        Node temp = this.head;
        while(temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print(".");
    }
    public static void LL_AddLast()
    {
        LinkedList list = new LinkedList();
        list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40); 
        list.addLast(50);
        list.display(); 
    }
    public static void LinkedList_Problems()
    {
        LL_AddLast();
    }
    public static void solve()
    {
        LinkedList_Problems();
    }
    public static void main(String[] args)
    {
        solve();
    }
}