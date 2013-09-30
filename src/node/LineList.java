package node;
/** The <code>LineList</code> class creates a doubly-linked list 
 * of LineNodes and methods for manipulating these nodes.
 *    
 *
 * @author Rezaul Hassan 
 *    e-mail: rezaul_h@ymail.com
 *    Stony Brook ID: 108822849
 **/
public class LineList {
	private LineNode head;
	private LineNode tail;
	private LineNode cursor;
	private int count;
	private int pos;
	
	public LineList(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		return head == null; 
	}
	
	public LineNode getCursor(){
		return cursor;
	}
	
	public boolean insertBeforeCursor(String data){
		LineNode newNode = new LineNode(data);
		if(isEmpty())
			return false;
	    if(cursor == null){ //insert before tail
	    	newNode.setPrev(tail);
	    	tail.setNext(newNode);
	    	tail = newNode;
	    	count++;
	    	return true;
	    }
	    else if (cursor == head.getPrev()){ //insert before head
	    	newNode.setNext(head);
	    	head.setPrev(newNode);
	    	head = newNode;
	    	count++;
	    	return true;
	    }
	    else{ //insert between other nodes
	    	newNode.setPrev(cursor.getPrev());
	    	newNode.setNext(cursor);
	    	cursor.getPrev().setNext(newNode);
	    	cursor.setPrev(newNode);
	    	count++;
	    	return true;
	    }
	}
	
	public void append(String data){
		LineNode newNode = new LineNode(data);
		if(isEmpty()){
			head = newNode;
			count++;
		}
		else{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			count++;
		}
		tail = newNode;
		cursor = newNode;
	}
	
	public boolean removeCursor(){
	    if (isEmpty()) {
	        throw new IndexOutOfBoundsException("empty list.");
	    }
	    if(cursor == head){
	    	head = cursor.getNext();
	    	count--;
	    	return true;
	    }
	    else if(cursor == tail){
	    	tail = cursor.getPrev();
	    	count--;
	    	return true;
	    }
	    else{
	    	cursor.getPrev().setNext(cursor.getNext());
	    	cursor = cursor.getPrev();
	    	cursor.getNext().setPrev(cursor);
	    	count--;
	    	return true;
	    }
	}
	
	public String nextLine(){
		if(cursor == tail)
			return null;
		else{
			cursor = cursor.getNext();
			return cursor.getData();
		}
	}
	
	public String prevLine(){
		if(cursor == head)
			return null;
		else{
			cursor = cursor.getPrev();
			return cursor.getData();
		}
	}
	
	public int cursorLineNo(){
		if(cursor == null)
			return 0;
		else{
			pos = 1;
			LineNode newNode = head;
			while(newNode != cursor){
				newNode = newNode.getNext();
				pos++;
			}
			return pos;
		}
	}
	
	public void printCursor(){
		System.out.println(cursorLineNo() + "*" + cursor.getData());
	}
	
	public LineNode printList(int startingLine, int endingLine){
		if((startingLine > endingLine) || (startingLine <= 0) || (startingLine > count))
			throw new IndexOutOfBoundsException("Invalid indexes given.");
		if(isEmpty())
			throw new IndexOutOfBoundsException("List is empty");
		if(endingLine > count)
			endingLine = count;
		cursor = head;
		for (int i = 1; i < startingLine; i++){			
			cursor = cursor.getNext();
		}
		for(int j = startingLine; j <= endingLine; j++){
			printCursor();
			cursor = cursor.getNext();
			if(cursor.getNext() == null){
				printCursor();
				break;
			}
		}
		return cursor;
		
	}
	
	public int getSize(){
		return count;
	}

}
