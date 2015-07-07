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

import java.util.ArrayList;

/**
 * This class represents the line of passengers waiting for a bus (or a list of passengers on a bus). 
 */
public class PassengerQueue extends ArrayList<Passenger>{
	private int size; //the number of passengers in the queue (not number of groups, which is the number of elements in the queue)
	private int waitTime;
	
	public PassengerQueue() {
		size = 0;
		waitTime = 0;
	}
	
	public PassengerQueue(int size, int waitTime)
	{
		this.size = size;
		this.waitTime = waitTime;
	}
	
	public void enqueue(Passenger p) { //a new group of passengers will join the line
		add(p);
		size += p.getSize();
	}
	
	public Passenger dequeue() { //remove and return the group of passengers if the group is allowed on board
		if (!super.isEmpty()) {
			size -= get(0).getSize();
			return remove(0);
		}
		return null;
	}

	public int size() {
		return size;
	}
	
	public Passenger peek() {
		return get(0);
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//isEmpty() is in the super class, no need to redefine it
	
	/*NOTE 1: The group at the head of the line will not always be the first group to be dequeued

	NOTE 2: The wait time should be calculated by subtracting the arrival time from the current time. 
		The wait time does not include the time spent on the bus.*/
	}
