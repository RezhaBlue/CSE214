package HW3_ElevatorSimulator;

public class Simulator {
	
	public static void simulate(double prob, int numFloors, 
			int numLifts, int simTime){
		RequestQueue trial = new RequestQueue();
		
		BooleanSource arrival = new BooleanSource(prob);
		
		Elevator[] elevators = new Elevator[numLifts];
		for(int i = 0; i < elevators.length; i++){
			elevators[i] = new Elevator();
		}
		
		int totalWaitTime = 0;
		
		int requestsProcessed = 0;
		
		double avgWaitTime = Math.round(((double) totalWaitTime/requestsProcessed)*100.0)/100.0;
		
		int curTime;
		
		//loop simulates each time unit
		
		for(curTime = 1; curTime <= simTime; curTime++){
			//has request arrived?
			if(arrival.requestArrived())
				trial.enqueue(new Request(numFloors));
			//can we process request?
			for(int i = 0; i < elevators.length; i++){
				if (elevators[i].getElevatorState() == -2){
					elevators[i].setRequest((Request) trial.get(0));
					elevators[i].setElevatorState(-1);
					trial.dequeue();
					while(elevators[i].getCurrentFloor() != elevators[i].getRequest().getSrcFloor()){
						if(elevators[i].getRequest().getSrcFloor() > elevators[i].getCurrentFloor())
							elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
						else elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
						totalWaitTime++;
					}
					requestsProcessed++;
					elevators[i].setElevatorState(0);
				}
				if (elevators[i].getElevatorState() == 0){
					while(elevators[i].getCurrentFloor() != elevators[i].getRequest().getDestFloor()){
						if(elevators[i].getRequest().getDestFloor() > elevators[i].getCurrentFloor())
							elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
						else elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
					}
					elevators[i].setElevatorState(-2);
					elevators[i].setRequest(null);
				}
				
			}
		}
		
		System.out.println("Total Wait Time: " + totalWaitTime + 
				"\nTotal Requests: " + requestsProcessed + 
				"\nAverage Wait Time: " + avgWaitTime);
	}
}
