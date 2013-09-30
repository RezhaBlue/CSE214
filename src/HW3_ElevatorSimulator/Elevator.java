package HW3_ElevatorSimulator;

public class Elevator {
	private int currentFloor;
	private int elevatorState;
	private final int IDLE = -2;
	private final int TO_SOURCE = -1;
	private final int TO_DESTINATION = 0;
	private Request request;
	
	public Elevator(){
		request = null;
		setElevatorState(IDLE);
		setCurrentFloor(1);
	}
	
	/**public int getIDLE(){
		return IDLE;
	}
	
	public int getTO_SOURCE(){
		return TO_SOURCE;
	}
	
	public int getTO__DEST(){
		return TO_DESTINATION;
	}*/
	
	public Request getRequest(){
		return request;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getElevatorState() {
		return elevatorState;
	}
	
	public void setRequest(Request req){
		request = req;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public void setElevatorState(int elevatorState) {
		this.elevatorState = elevatorState;
	}
	
}
