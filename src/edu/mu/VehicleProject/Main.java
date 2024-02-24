package edu.mu.VehicleProject;

import java.util.ArrayList;

import edu.mu.VehicleProject.Vehicles.*;

public class Main {

	public static void main(String[] args) {
		// Instantiate VehicleManager, perform operations based on the requirements.
		VehicleManager manager = new VehicleManager();
		manager.initializeStock();
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		// TODO
		// Display all vehicle information.
		// TODO
		// Display all car information.
		manager.displayAllCarInformation();
		// Display all Truck information.
		manager.displayAllTruckInformation();
		// Display all SUV information.
		manager.displayAllSUVInformation();
		// Display all motorbike information.
		manager.displayAllMotorBikeInformation();
		// TODO Auto-generated method stub
//		ArrayList<Vehicle> vehicles = manager.getInventory();
//		for(Vehicle vehicle : vehicles) {
//			System.out.println(vehicle);
//		}
	}
}
