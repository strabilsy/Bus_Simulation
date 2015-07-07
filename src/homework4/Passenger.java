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
 * This class represents a group of passengers; the group can be a single person as well. 
 * This class should keep instance variables that represents the size of the group, the destination, and the time arrived at bus stop (int).
 */
public class Passenger {
	private int size;
	private int dest; //destination
	private int arrival;
	
	public Passenger() {
		size = 1;
		dest = 1;
		arrival = 0;
	}
	
	public Passenger(int size, int dest, int arrival) {
		this.size = size;
		this.dest = dest;
		this.arrival = arrival;
	}
	
	public int getSize() {
		return size;
	}
	public int getDest() {
		return dest;
	}
	public int getArrival() {
		return arrival;
	}
}
