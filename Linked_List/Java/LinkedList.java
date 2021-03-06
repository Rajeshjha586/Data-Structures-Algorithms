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
    public void removeFirst()
    {
        if(this.size==0)
        {
            System.out.println("List is Empty");
        }
        else if(this.size==1)
        {
            this.head = this.tail = null;
            this.size = 0;
        }
        else
        {
            this.head = head.next;
            this.size--;
        }
    }
    public int getFirst()
    {
        if(this.size==0)
        {
            System.out.println("List is Empty");
            return -1;
        }
        else
        { 
            return head.data;
        }
    }
    public int getLast()
    {
        if(this.size==0)
        {
            System.out.println("List is Empty");
            return -1;
        }
        else
        { 
            return tail.data;
        }
    }
    public int getAt(int idx)
    {
        if(this.size==0)
        {
            System.out.println("List is Empty");
            return -1;
        }
        else if(idx < 0 || idx > this.size)
        {
            System.out.println("Invalid Arguments");
            return -1;
        }
        else
        {
            Node temp = this.head;
            for(int i=0; i<idx; i++)
            {
                temp = temp.next;
            }
            return temp.data;
        }
    }
    public void addFirst(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;

        if(this.size == 0)
        {
            tail = temp;
        }
        this.size++;
    }
    public void addAt(int idx, int data)
    {
        if(idx<0 || idx>size)
        {
            System.out.println("Invalid Argument");
        }
        else if(idx == 0)
        {
            addFirst(data);
        }
        else if(idx==size)
        {
            addLast(data);
        }
        else
        {
            Node node = new Node();
            node.data = data;

            Node temp = head;
            for(int i=0; i<idx-1; i++)
            {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;

            this.size++;
        }
    }
    public void display()
    {
        Node temp = this.head;
        while(temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
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
        System.out.println("Size of List :- " + list.size);
    }
    public static void LL_RemoveFirst()
    {
        LinkedList list = new LinkedList();
        list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40); 
        list.addLast(50);
        list.display();
        list.removeFirst();
        list.display();

        System.out.println("Size of List :- " + list.size);
    }
    public static void LL_GetElements()
    {
        LinkedList list = new LinkedList();
        list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40); 
        list.addLast(50);
        list.display();
        
        System.out.println("First Node of List :- " + list.getFirst());
        System.out.println("Last Node of List :- " + list.getLast());
        System.out.println("Get Any Node of List :- " + list.getAt(2));

    }
    public static void LL_addFirst()
    {
        LinkedList list = new LinkedList();
        list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40); 
        list.addLast(50);
        list.display();
        System.out.println("Size of List :- " + list.size);
        list.addFirst(60);
        list.addFirst(70);
        list.display();
        System.out.println("Size of List :- " + list.size);
    }
    public static void LL_addAt()
    {
        LinkedList list = new LinkedList();
        list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40); 
        list.addLast(50);
        list.display();
        System.out.println("Size of List :- " + list.size);
        list.addAt(2, 300);
        list.addAt(5, 400);
        list.display();
        System.out.println("Size of List :- " + list.size);
    }
    public static void LinkedList_Problems()
    {
        //LL_AddLast();

        //LL_RemoveFirst();

        /* Get_First --> Get_Last --> Get_At_IDX */
        //LL_GetElements();

        //LL_addFirst();

        LL_addAt();
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