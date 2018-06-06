package com.nith;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


public class CarParkingServiceJunit {

	CarParkingService cp = new CarParkingService();

	String carTobeparked = "AC-2341";
	String parkingSlot = "slot-1";
	
	@Test
	public void parkCar() {	
		cp.parkedCars = new HashMap<String, String>();
		cp.availableSlots = new ArrayList<String>();
		cp.availableSlots.add(parkingSlot);
		cp.parkCar(carTobeparked, parkingSlot);
		Assert.assertTrue(cp.parkedCars.containsKey(carTobeparked));
		Assert.assertTrue(!cp.availableSlots.contains(parkingSlot));
	}
	
	@Test
	public void departcar() {	
		cp.parkedCars = new HashMap<String, String>();
		cp.availableSlots = new ArrayList<String>();
		cp.availableSlots.add(parkingSlot);		
		cp.parkCar(carTobeparked, parkingSlot);
		cp.departcar(carTobeparked);
		Assert.assertTrue(!cp.parkedCars.containsKey(carTobeparked));	
		Assert.assertTrue(cp.availableSlots.contains(parkingSlot));
	}

}
