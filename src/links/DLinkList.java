package links;

public class DLinkList {
	private LinkNode head; //points to the first node
	private LinkNode tail; //points to the last node
	private LinkNode cursor; //points to current node
	private int size;
	
	public DLinkList(){
		head = null;
		tail = null;
		cursor = null;
		size = 0;
	}
	
	public LinkNode getHead(){
		return head;
	}
	
	public LinkNode getTail(){
		return tail;
	}
	
	public LinkNode getCursor(){
		return cursor;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public boolean insertBeforeCursor(String line){//BUGGED, prevLine also?   
		LinkNode temp = head; 
		LinkNode newNode = new LinkNode(line);
		
		if (isEmpty()){   
			return false;
		}
		
		else if(cursor == null){   
			newNode.setPrev(tail); tail.setNext(newNode); tail = newNode;
			cursor = newNode;
			return true;
		}
		
		else{    
			newNode.setPrev(cursor.getPrev());
			newNode.setNext(cursor);
			cursor.getPrev().setNext(newNode);
			cursor.setPrev(newNode);
			cursor = newNode;
			return true;
		}
	}
	
/**	public boolean insertBeforeCursor(String line){
		LinkNode newNode = new LinkNode(line);   // make newNode
		if( isEmpty() )              // if list is empty
			return false;           // head -> newNode
		else
		{
			newNode.setPrev(cursor.getPrev());    // cursor.getPrev() -> newNode
			cursor.getPrev().setNext(newNode);    // cursor.getPrev() <- newNode
			cursor.setPrev(newNode);    // old cursor -> newNode
			newNode.setNext(cursor);    // old cursor <- newNode
			
		}
		cursor = newNode;              // newNode <- cursor
		size++;
		return true;

	}
*/
	public void append(String line){
		LinkNode newNode = new LinkNode(line);   // make newNode
		if( isEmpty() )              // if list is empty
			head = newNode;           // head -> newNode
		else
		{
			tail.setNext(newNode);    // old tail -> newNode
			newNode.setPrev(tail);    // old tail <- newNode
		}
		tail = newNode;              // newNode <- tail
		cursor = newNode;              // newNode <- cursor
		size++;
	}
	
	/**public void iterate(){
		System.out.println("List (first-->last): ");
		cursor = head;          // start at beginning
		while(cursor != null)         // until end of list,
		{
			System.out.print(cursorLineNo()+"*");
			System.out.println(cursor.getLine());      // display data
			cursor = cursor.getNext();     // move to next link
		}
		System.out.println("");
	}*/
	
	public boolean removeCursor(){
		size--;
		return false;

	}
	
	public String nextLine(){
		String s = cursor.getNext().getLine();
		return s;
	}
	
	public String previousLine(){
		String s = cursor.getPrev().getLine();
		return s;
	}
	
	public int cursorLineNo(){
		int counter = 0;
		cursor = head;          // start at beginning
		while(cursor != null)         // until end of list,
		{
			counter++;      // display data
			cursor = cursor.getNext();     // move to next link
		}
		return counter;
	}
	
	public void printCursor(){
		if(cursor == null)
			System.out.print("null cursor");
		else
			System.out.println(cursorLineNo() + "*" + getCursor().getLine());
	}
	
	public LinkNode printList(int startingLine, int endingLine){
		return null;
		
	}
}
