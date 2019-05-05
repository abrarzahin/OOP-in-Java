
//Name : Abrar Zahin

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Stack<E> {
   private Node<E> first, last;
   private int size = 0;
   
   // Construct a new empty list.
   public LinkedList() {
   first = last = null; //Empty List
   }

   // Adds element e to the end of the list.
   public void add(E e) {
   if(first==null) { 
	   //Add in the first position if the list 
		// is empty
       first=last=new Node<>(e, null);
   } 
   	else { 
	 // If not empty then add in the last position.
    last.next = new Node<>(e, null);
    last = last.next;
    }
   size++; 
   }
   
   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   public E get(int index) {
   if (index < 0 || index >= size)
   throw new IndexOutOfBoundsException();
   // target 0th index.
   Node<E> t = first;
   for (int i = 0; i < index; ++i) {
   t = t.next;
   }
   return t.data;
   }
   
   // Returns a string representation of the linked list.
   public String toString() {
   StringBuilder sbuilder = new StringBuilder();
   Node<E> node = first;
   while(node!=null) {
   if(sbuilder.length()==0) { 
      // Empty string dosent need any comma
   } else { 
      // Add comma if it has content
       sbuilder.append(",");
   }
       sbuilder.append(node.data);
   node=node.next;
   }
   return "["+sbuilder.toString()+"]";
   }
   
   // Removes all elements.
   public void clear() {
     first=last=null;
     //set firt and last to null and also updated the size.
	   size=0;
  }
   
   // Removes the first occurrence of the specified element, if it is present.
   // Returns true if the list has been modified.
   public boolean remove(E e) {
   Node<E> node = first, current=null;
   if(first.data.equals(e)) { 
      // If the specific node is the first node
       if(first==last) { 
          //if the list has only one node then 
          //set the list to empty list
           first=last=null;
           size=0;
       } else { 
          //Or skip that node to remove it from the list
           first=first.next;
           node.next=null;
           size--;
       }
       return true;
   }
   current=node;
   node=node.next;
   while(node!=null) { 
      // iterate through the list till the end
   if(node.data.equals(e)) { 
      // If found then skip that node and refer to the next one 
       current.next=node.next;
       node.next=null;
    if(node==last) { 
       // if reaches the last node then update last.
    	 last=current;
       }
    size--;
    return true;
   }
   current = node;
   node=node.next;
   }
   return false;
   }
   
   // Returns the number of elements.
   public int size() {
      return size;
   }
   
   // Adds element e to the top of the stack.
   public void push(E e) {
      if(first==null) {
         //if the list is empty then push on the top
      first=last=new Node<>(e, null);
	   } 
      else {
         //even if the list has elements in it, push new 
         //node at the top
      first = new Node<>(e, first);
      }
      size++;
     }

   // Removes and returns the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E pop() {
   if(first==null) { 
      // Throw exception if empty list has found.
    throw new NoSuchElementException();
   }
   // Skip the first node and refer to the next node as first .
   Node<E> node = first;
   first=first.next;
   node.next=null;
   size--;
   return node.data;
   }

   // Returns but does not remove the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E top() {
   if(first==null) {
      // Throw execption if the list is empty
   throw new NoSuchElementException();
   }
   //Return first node with its value
   return first.data;
   }
   
   private static class Node<E> {
	E data;
	Node<E> next;
	Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
    }
   }
