
import java.lang.*;
import java.util.*;

//END LIBRARY IMPORTS

public abstract class Date212List extends LinkedList{
	// declear 2 nodes head and tail
	Date212Node head;
	Date212Node tail;
	int length;
	// Default constructor
	public Date212List(){
		this.head = null;
		this.tail = null;
		length = 0;
	}

	public void append(Date212 d){
		// insert the new node 
		if(head == null){
			head = new Date212Node(d);
			tail = new Date212Node(d);
			length = 1;
			return;
		}
		Date212Node curr = head;
		 // Iterate through linked list until we hit null, adding the string 
        // that's inside each node to string
		while(curr.next!=null){
			curr = curr.next;
		}
		curr.next = new Date212Node(d);
		tail = curr.next;
		length++;
	}

}