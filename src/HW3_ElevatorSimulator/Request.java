package HW3_ElevatorSimulator;

public class Request {
	private int sourceFloor;
	private int destinationFloor;
	private int timeEntered; //time request was placed on the queue
	
	public Request(int numFloors){
		sourceFloor = (int)(Math.random() * numFloors + 1);
		destinationFloor = (int)(Math.random() * numFloors + 1);
		if(sourceFloor == destinationFloor){
			destinationFloor = (int)(Math.random() * numFloors + 1);	
		}
	}
	
	public int getSrcFloor(){
		return sourceFloor;
	}
	
	public int getDestFloor(){
		return destinationFloor;
	}
	
	public int getTimeEntered(){
		return timeEntered;
	}
	
	public void setSrcfloor(int srcFloor){
		sourceFloor = srcFloor;
	}
	
	public void setDestfloor(int destFloor){
		destinationFloor = destFloor;
	}
	
	public void setTimeEntered(int enteredTime){
		timeEntered = enteredTime;
	}
	
}
