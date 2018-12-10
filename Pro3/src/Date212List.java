public abstract class Date212List {
    // declear 2 nodes head and tail
public Date212Node head , tail;
public int length;
// Default constructor
public Date212List()
    {
    this.head = new Date212Node(null);
    this.tail=this.head;
    this.length = 0;
    }
    public boolean isEmpty()
    {// return 0 if empty
    return length == 0;
    }
    public void insert(Date212 d)
    {// insert the new node 
    tail.next = new Date212Node(d);
    tail = tail.next;
     length++;
    }
    // To String method.
    public String toString()
    {
    Date212Node curr = head.next;
     String s = "";
     // Iterate through linked list until we hit null, adding the string 
        // that's inside each node to string
    while(curr != null)
     {
     s += curr.data.toString() + "\n";
     curr = curr.next;
     }
      return s;
     }
    }