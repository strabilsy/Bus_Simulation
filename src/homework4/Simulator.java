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

import java.util.Scanner;

public class Simulator {
	private static final int NUM_BUS_STOPS = 8;
	private int numInBusses; //number of In Route busses
	private int numOutBusses; //number of Out Route busses
	private int minGroupSize; //the minimum amount of passengers in a group
	private int maxGroupSize; //the maximum amount of passengers in a group
	//int capacity; //the maximum number of passengers a Bus can hold
	private double arrivalProb; //the probability of a group of passengers lining up for a particular bus stop
	private int groupsServed; //the number of groups that successfully reached their destinations boarded a Bus
	private int totalTimeWaited; //the total time groups spent waiting on a line
  
	public Simulator(int numInBusses, int numOutBusses, int minGroupSize, int maxGroupSize, int capacity, double arrivalProb) {
		this.numInBusses = numInBusses;
		this.numOutBusses = numOutBusses;
		this.minGroupSize = minGroupSize;
		this.maxGroupSize = maxGroupSize;
		Bus.setCapacity(capacity);
		this.arrivalProb = arrivalProb;
	}
	
	/* 
    Create the bus stop queues 

    0 - In Route South P
    1 - In Route West
    2 - In Route SAC
    3 - In Route Chapin
    4 - Out Route South P
    5 - Out Route PathMart
    6 - Out Route Walmart
    7 - Out Route Target     
	*/
	
	public double[] simulate(int duration) {
		double[] results = new double[2];
		
		PassengerQueue[] busStops = new PassengerQueue[NUM_BUS_STOPS]; // NUM_BUS_STOPS = 8
		
		for(int i = 0; i < NUM_BUS_STOPS; i++) {
		    busStops[i] = new PassengerQueue();
		}
		
		
		// Add passengers to the bus stop queues 
		String inRoute[]  = {"South P", "West", "SAC", "Chapin"};
		String outRoute[] = {"South P", "PathMart", "Walmart", "Target"};
		
		int stopNum, numOfPass; //variables for random numbers for the bus stop and the number of passengers
		for(int i = 0; i < NUM_BUS_STOPS; i++) {
		    if (i < inRoute.length)
		       // it's In Route bus: generate a random number from 1 to inRoute.length - i 
		    	stopNum = randInt(1, inRoute.length - i);
		    else
		       // it's Out Route bus: generate a random number from 1 to outRoute.length - (i - inRoute.length) 
		    	stopNum = randInt(1, outRoute.length - (i - inRoute.length));
		    // generate a random number for number of passengers in group
		    numOfPass = randInt(minGroupSize, maxGroupSize);
		    // add this passenger to busStops[i] queue
		    busStops[i].enqueue(new Passenger(numOfPass, stopNum, 0));
		}
		
		// NOTE: The first stop and last stop of all busses are South P. So, the South P should be a legitimate destination stop. 
		// However, South P cannot be the destination stop if passengers entered on that stop!
		
		
		// Print the name of all bus stops 
		
		for (int i = 0; i < NUM_BUS_STOPS; i++) {
		    System.out.println(i + " (" + ((i < inRoute.length) ? inRoute[i] : outRoute[i - inRoute.length]) + ")");
		}
		
		
		return results;
	}
	
	private static int randInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of In Route busses: ");
		int numInBusses = input.nextInt();
		System.out.print("Enter the number of Out Route busses: ");
		int numOutBusses = input.nextInt();
		System.out.print("Enter the minimum group size of passengers: ");
		int minGroupSize = input.nextInt();
		System.out.print("Enter the maximum group size of passengers: ");
		int maxGroupSize = input.nextInt();
		System.out.print("Enter the capacity of a bus: ");
		int capacity = input.nextInt();
		System.out.print("Enter the arrival probability: ");
		double arrivalProb = input.nextDouble();
		System.out.print("Enter the duration of the simulation: ");
		int duration = input.nextInt();
		
		Simulator a = new Simulator(numInBusses, numOutBusses, minGroupSize, maxGroupSize, capacity, arrivalProb);
		a.simulate(duration);
	}

}
