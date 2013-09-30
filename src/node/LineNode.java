package node;
/** The <code>LineNode</code> class creates Node objects 
 * to be used in a list and accessor methods for them.
 *    
 *
 * @author Rezaul Hassan 
 *    e-mail: rezaul_h@ymail.com
 *    Stony Brook ID: 108822849
 **/
public class LineNode {
	private String data;
	private LineNode next;
	private LineNode prev;
	
	public LineNode(){
		data = null;
		prev = null;
		next = null;
	}
	
	public LineNode(String data){
		this.data = data;
		prev = null;
		next = null;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public void setNext(LineNode next){
		this.next = next;
	}
	
	public void setPrev(LineNode prev){
		this.prev = prev;
	}
	
	public String getData(){
		return data;
	}
	
	public LineNode getNext(){
		return next;
	}
	
	public LineNode getPrev(){
		return prev;
	}

}
