/*
Alex Petralia | CSCI 145
Lab 6 | Java Terminal IO
Authoured: 3-9-15
*/

public class LinkedList<E> {

   //private/public members
   public int size;
   private node front;
   private node tail;

   //node class
   private class node {
   
      //private members
      private E data;
      private node next;
   
      //constructor
      public node() {
      }  

         // newData & newNext
         public node(node newNext, E newData) {
            this.data = newData;
            this.next = newNext;
         }
         
         // new Data
         public node(E newData) {
            this.data = newData;
         }
         
         // new Next
         public void setNext(node newNext) {
            this.next = newNext;
         }
         
         // return data
         public E data() {
            return data;
         }
         
         // return next
         public node getNext() {
            return next;
         }      
         
         public boolean hasNext() {
            if(this.next == null) {
               return false;
            }
            return true;
         }
      }
   
   //constructors
   public LinkedList(){
	   front = null;
      tail = null;
   }
    
   //size 
   public int size() {
      return size;
   }
   
   //isEmpty
   public boolean isEmpty() {
      if (this.size == 0 || this == null) {
         return true;
      }
   return false;
   }
   
   //add
   public void add(E value) {
      if (front == null) {
         front = new node(value);
         size++;
      }else{
         node current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new node(value);
         size++;
      } 
   }
   
   //get
   public E get(int index) {
      node curr = front;
      if (size() > index && index >= 0) {
         for(int i = 0; i < index; i++) {
            curr = curr.next;
         }
      }
      return curr.data;
   }
   
   //add(2)
   public void add(int index, E value) {
      if (index > size) {
         throw new IndexOutOfBoundsException();
      }
      node current = front;
      node current2 = front;
      if (0 <= index && index <= size()) {
         if (front == null) {
            front = new node(value);
            size++;
         }else if(index == 0) {
            front = new node(value);
            front.next = current;
            size++;
         }else{
            for(int i = 1; i < index; i++) {
               current = current.next;
            }
            current2 = current.next;
            current.next = new node(value);
            current.next.next = current2;
            size++;
         }
      }
   }

   //remove
   public E remove() {
      if(size() > 0) {
         node current = front;
         front = front.next;
         size--;   
         return current.data;
      }
      return null;
   }
   
   //remove(2)
   public E remove(int index) {
      if (index > size) {
         throw new IndexOutOfBoundsException("Can't remove a node");
      }else if (size() == 0) {
         throw new NullPointerException("Empty List");
      }
      node curr = front;
      node temp = front;
      if (0 <= index && index <= size()) {
         if (front == null) {
            return null;
         }else if(index == 0) {
            front = front.next;
         }else{
            for(int i = 0; i < index - 1; i++) {
               curr = curr.next;
            }
            temp = curr.next;
            curr.next = curr.next.next;
         }
      }
      size--;
      return temp.data;
   }
}