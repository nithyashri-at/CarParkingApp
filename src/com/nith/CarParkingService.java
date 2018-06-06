package com.nith;

import java.util.*;

public class CarParkingService {

	List<String> availableSlots = new ArrayList<String>();
	Map<String, String> parkedCars = new HashMap<String, String>();
	Scanner input = new Scanner(System.in);

	public CarParkingService() {
		initialize();
	}

	/**
	 * Initialize the n number of slots.
	 */
	private void initialize() {
		availableSlots.add("slot-1");
		availableSlots.add("slot-2");
		availableSlots.add("slot-3");
		availableSlots.add("slot-4");
		availableSlots.add("slot-5");
		availableSlots.add("slot-6");
		availableSlots.add("slot-7");
		availableSlots.add("slot-8");
		availableSlots.add("slot-9");
		availableSlots.add("slot-10");
	}

	/**
	 * Methods executes the function through command prompt inputs 
	 * @throws InterruptedException
	 */
	public void execute() throws InterruptedException {
		int menu = 0;
		do {
			System.out.println("\n\nCar parking System");
			System.out.println("1: To Park the Car");
			System.out.println("2: To Depart the Car");
			System.out.println("3: Show All Parked Cars");
			System.out.println("4: Show available Slots");
			System.out.println("0: To Exit");

			System.out.print("Enter your choice: ");

			menu = input.nextInt();
			System.out.println("Got: " + menu);

			switch (menu) {
			case 1: {
				System.out.println("Enter the car name");
				String carName = input.next();
				String carSlotID = availableSlots.isEmpty() ? null : availableSlots.get(0);
				if (null != carSlotID) {
					parkCar(carName, carSlotID);
				} else {
					System.out.println("\n**********All the parking lots are full*********");
				}
				break;
			}
			case 2: {
				System.out.println("Enter the car name to be out: ");
				String crName = input.next();
				departcar(crName);
				break;
			}
			case 3: {
				getAllParkedVechicles();
				break;
			}
			case 4: {
				System.out.println("Available slots: " + availableSlots);
				break;
			}
			
			}

		} while (menu != 0);
	}

	/**
	 * Adds the newly parking car in to the map
	 * @param carName
	 * @param carSlotID
	 */
	public void parkCar(String carName, String carSlotID) {
		try {
			if (parkedCars.containsKey(carName)) {
				System.out.println("Car is already parked");
				return;
			}
			parkedCars.put(carName, carSlotID);
			availableSlots.remove(carSlotID);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove the parked car from the map
	 * @param carName
	 */
	public void departcar(String carName) {
		String carSlot = parkedCars.get(carName);
		if(null == carSlot){
			System.out.println("No car parked as "+carName);
			return;
		}
		parkedCars.remove(carName);
		availableSlots.add(carSlot);
	}

	public void getAllParkedVechicles() {
		System.out.println("\nList All parked vehicles: ");
		Iterator<String> s = parkedCars.keySet().iterator();
		while (s.hasNext()) {
			String key = s.next();
			System.out.println("Car " + key + " is parked in lot number " + parkedCars.get(key));
		}
	}

	public static void main(String[] args) {
		try {
			new CarParkingService().execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
