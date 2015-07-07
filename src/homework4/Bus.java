/**
 * Samier Trabilsy
 * Student ID: 109839226
 * Homework #4
 * Thursday: R04
 * Gustavo Poscidonio
 * Mahsa Torkaman
 * @author Samier
 */
package homework4;
/**
 * This class will represent a bus used in the transportation system.
 */
/*
 * The class should contain a static variable capacity, that stores the maximum number of passengers a Bus is 
 * allowed to carry. Include a variable route that represents the type of Bus, a variable nextStop that stores the 
 * name of the next bus stop, and a variable toNextStop that represents the amount of time required to reach the next stop. 
 * Keep a variable timeToRest, which means the Bus is not operating if the value is greater than 0. 
 * Finally, keep track of all passengers in the Bus. Any list would be acceptable; you may use the PassengerQueue 
 * by adding the following method:
 * 
 * public int unload(int dest) Ð remove the group of passengers from the bus if the group has reached the destination. 
 * Return the number of passengers taken off the bus. (type of the argument can be changed as you wish)
 * 
 * NOTE: The group at the head of the line will not always be the first group to be dequeued. 
 * This method is specific to a Bus. If you don't use a PassengerQueue for a Bus, you can omit this method.
 */
public class Bus extends PassengerQueue{
	private static int capacity;
	private String type;
	private String nextStop = "South P";
	private int toNextStop;
	private int timeToRest;
	
	public Bus(String type, String nextStop, int toNextStop, int timeToRest){
		this.type = type;
		this.nextStop = nextStop;
		this.toNextStop = toNextStop;
		this.timeToRest = timeToRest;
	}
	
	public int unload(int dest) {
		int unload = 0;
		for (Passenger p : this) {
			if (p.getDest() == dest) {
				setSize(size() - p.getSize());
				unload += p.getSize();
				remove(p);
			}
		}
		return unload;
	}
	
	public void enqueue(Passenger p) { //must override and factor in the capacity
		if (size() + p.getSize() <= capacity) {
			add(p);
			setSize(size() + p.getSize());
		}
		else
			System.out.println("\nThe bus is full\n");
	}

	public static int getCapacity() {
		return capacity;
	}

	public static void setCapacity(int capacity) {
		Bus.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNextStop() {
		return nextStop;
	}

	public void setNextStop(String nextStop) {
		this.nextStop = nextStop;
	}

	public int getToNextStop() {
		return toNextStop;
	}

	public void setToNextStop(int toNextStop) {
		this.toNextStop = toNextStop;
	}

	public int getTimeToRest() {
		return timeToRest;
	}

	public void setTimeToRest(int timeToRest) {
		this.timeToRest = timeToRest;
	}
}
