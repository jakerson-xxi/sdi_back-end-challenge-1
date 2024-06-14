
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	// create an object of Scanner
	static Scanner input = new Scanner(System.in);
	// initial value for Small , Medium and Large
	static Car_Rental small = new Car_Rental("S", 5, 5000);
	static Car_Rental medium = new Car_Rental("M", 10, 8000);
	static Car_Rental large = new Car_Rental("L", 15, 12000);

	public static void main(String[] args) {

		Car_Rental[] car_rental = { small, medium, large };
		// use while loop to keep asking the user
		System.out.println("Welcomw to Toyota Mobility Solutions Philippines");
		while (true) {
			try {

				System.out.println("Please choose: \n1 - Calculate Car Rental Cost, \n2 - Edit the values.");
				System.out.print("Answer: ");
				int option = input.nextInt();

				if (option == 1) {
					System.out.print("Please input number (seat):");
					int seat = input.nextInt();
					getRental(seat, car_rental);
				}

				else if (option == 2) {
					modifyTable();
				} else {
					System.out.println("Invalid option. Please enter a valid option.");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid integer.");
				input.nextLine();
			}

		}
	}

	public static void getRental(int seat, Car_Rental[] car_rental) {

		// var for the optimized size, count and total cost
		String opt_size = null;
		int opt_count = 0;
		double opt_total_cost = Integer.MAX_VALUE;

		// iterate the car rental array to check each object based on size
		for (Car_Rental car : car_rental) {
			String size = car.getSize();
			int cap = car.getSeat_cap();
			double cost = car.getCost();

			// check how many cars of this size are needed
			int car_count = seat / cap;
			if (seat % cap != 0) {
				car_count += 1;
			}

			// calculate the cost
			double totalcost = car_count * cost;

			// update if found cheaper price
			if (totalcost < opt_total_cost) {
				opt_size = size;
				opt_count = car_count;
				opt_total_cost = totalcost;
			}

		}

		System.out.println("---------------------------------------");
		System.out.println(opt_size + " x " + opt_count);
		System.out.println("Total = PHP " + opt_total_cost);
		System.out.println("---------------------------------------");

	}

	//prompt to ask the user if to change the table value for rental
	public static void modifyTable() {
		System.out.println("---------------------------------------");
		System.out.println("Which size would you like tp modify:");
		System.out.println("1: " + small.getSize() + " (" + small.getSeat_cap() + " cap)- PHP." + small.getCost());
		System.out.println("2: " + medium.getSize() + " (" + medium.getSeat_cap() + " cap)- PHP." + medium.getCost());
		System.out.println("3: " + large.getSize() + " (" + large.getSeat_cap() + " cap)- PHP." + large.getCost());
		System.out.println("4: EXIT");
		System.out.println("Which size would you like tp modify:");
		int option = input.nextInt();
		switch (option) {
		case 1:
			updateCarRental(small);
			break;
		case 2:
			updateCarRental(medium);
			break;
		case 3:
			updateCarRental(large);
			break;
		case 4:
			return;
		default:
			System.out.println("Invalid option. Please try again.");
		}

	}

	//to update the table for rental
	public static void updateCarRental(Car_Rental carRental) {
		System.out.println("Updating " + carRental.getSize());
		System.out.print("Enter new seat capacity: ");
		int newSeatCap = input.nextInt();
		System.out.print("Enter new cost: ");
		int newCost = input.nextInt();

		carRental.setSeat_cap(newSeatCap);
		carRental.setCost(newCost);

		System.out.println(carRental.getSize() + " updated to (" + carRental.getSeat_cap() + " cap) - PHP "
				+ carRental.getCost() + "\n");
	}

}

class Car_Rental {

	// States for the Car_Rental Class
	private String size;
	private int seat_cap;
	private double cost;

	// Constructor for carrental class with 3 params for the requirements
	// size: string, seat_capacity: int, cost: double
	public Car_Rental(String size, int seat_cap, double cost) {
		this.size = size;
		this.seat_cap = seat_cap;
		this.cost = cost;
	}

	// setter for seat_cap
	public void setSeat_cap(int seat_cap) {
		this.seat_cap = seat_cap;
	}

	// getter for seat_cap
	public int getSeat_cap() {
		return this.seat_cap;
	}

	// setter for cost
	public void setCost(double cost) {
		this.cost = cost;
	}

	// getter for cost
	public double getCost() {
		return this.cost;
	}

	// getter for size name
	public String getSize() {
		return this.size;
	}
}
