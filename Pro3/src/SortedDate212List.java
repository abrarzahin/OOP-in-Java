public class SortedDate212List extends Date212List {
    // Default constructor
public SortedDate212List()
    {
      super();
    }
    // Add sorted to  the list
    public void add(Date212 d)
    {
    Date212Node prev = head, curr = head.next;
    Date212Node n = new Date212Node(d);
    // Look for the place where we want to insert the new node between
     while(curr != null && d.toString().compareTo(curr.data.toString()) > 0)
    {
      prev = curr;
      curr = curr.next;
      }
    // Insert the new node between current node and the next node
     n.next = curr;
     prev.next = n;
     if(n.next == null)
     tail = n;
      length++;
     }
    }