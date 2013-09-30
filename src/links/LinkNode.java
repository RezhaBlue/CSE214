package links;

public class LinkNode {
	private String line;
	private LinkNode prev;
	private LinkNode next;
	//Constructor for LineNode
	public LinkNode(){
		line = null;
		next = null;
		prev = null;
	}
	
	public LinkNode(String line){
		this.line = line;
		next = null;
		prev = null;
	}
	
	//setLine
	public void setLine(String line){
		this.line = line;
	}
	//getLine
	public String getLine(){
		return line;
		
	}
	//setNext
	public void setNext(LinkNode node){
		next = node;
	}
	//setPrev
	public void setPrev(LinkNode node){
		prev = node;
	}
	//getNext
	public LinkNode getNext(){
		return next;
		
	}
	//getPrev
	public LinkNode getPrev(){
		return prev;
		
	}
}

