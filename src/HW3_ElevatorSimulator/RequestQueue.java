package HW3_ElevatorSimulator;

import java.util.ArrayList;

public class RequestQueue extends ArrayList{
	public int CAPACITY = 10;
	private ArrayList<Request> queue = new ArrayList<Request>();
	private int size = queue.size();
	private int first;
	private int last;
	
	public RequestQueue(){
		first = -1;
		last = -1;
		queue = new ArrayList<Request>(CAPACITY);
	}
	public void enqueue(Request req){
		queue.add(req);
		if(size == 1){
			first = indexOf(req);
			last = indexOf(req);
		}
		else{
			last = indexOf(req);
		}
	}
	
	public void dequeue(){
		if(size == 0){
			System.out.print("No more requests to handle");
		}
		else{
			queue.remove(0);
		}
	}
	
	
	
	public int size(){
		return queue.size();
	}
	
	public boolean isEmpty(){
		return (first == -1); 
	}
}
