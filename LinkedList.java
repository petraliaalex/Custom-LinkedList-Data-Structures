public class LinkedList {
    
    // 2. Fields
    node front;
    //node tail;
    int size;

    // 1. Node class

    private class node {
	
	int data;
	node next;

	//constructors
	//1. default
	public node (){
	}

	//2. data
	public node (int newData){
	    this.data = newData;
	}

	//3. data + next
	public node (int newData, node newNext){
	    this.data = newData;
	    this.next = newNext;
	}

    }

    // 3. Constructors
    public LinkedList(){
	this.size = 0;
	this.front = null;
    }

    // 4. Methods

    //append
    public void append (int data){
	
	this.size++;

	if (front == null){
	    front = new node(data);
	    return;
	}

	node curr = front;
	while (curr.next != null){
	    curr = curr.next;
	}
	
	curr.next = new node(data);
	
    }

    //prepend
    public void prepend (int data){
	/*node temp = new node(data);
	temp.next = front;
	front = temp;*/

	front = new node(data, front);
	size++;
    }

    //delete
    public void delete(int index){
	//assume that index is valid
	if (index == 0){
	    front = front.next;
	} else {
	    node curr = front;
	    for (int i = 0; i < index - 1; i++){
		curr = curr.next;
	    }
	    curr.next = curr.next.next;
	}
	size--;
	
    }

    //toString
    public String toString(){
	StringBuilder result = new StringBuilder();
	result.append('[');
	
	node curr = front;
	while (curr != null){
	    result.append(curr.data);
	    if (curr.next != null){
	        result.append(',');
	    }
	    curr = curr.next;
	}

        result.append(']');
	return result.toString();
    }

    //add (at an index)
    public void add(int index, int data){
        if (index == 0){
            front = ned node(data, front){
        } else {
            node curr = front;
            for (int i = 0; i < index - 1; i++){
                curr = curr.next;
            }
            curr.next = new node(data, curr.next);
        }
    }
   
}
