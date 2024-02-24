package edu.mu.VehicleProject;

import java.util.ArrayList;

import edu.mu.VehicleProject.Vehicles.*;

public class Main {
	

	public static void main(String[] args) {
		VehicleManager manager = new VehicleManager();

        // Initialize stock from file
        boolean initialized = manager.initializeStock();
        if (!initialized) {
            System.out.println("Failed to initialize stock.");
            return;
        }

        // Display all car information
        manager.displayAllCarInformation();

        // Display all truck information
        manager.displayAllTruckInformation();

        // Display all SUV information
        manager.displayAllSUVInformation();

        // Display all motorbike information
        manager.displayAllMotorBikeInformation();

        // Display information for a specific vehicle
        Vehicle testcar = null;
		ArrayList<Vehicle> inventory = manager.getInventory();
		for( Vehicle v : inventory) {
			if( v instanceof MotorBike) {
				testcar = v;
				break;
			}
		}
		manager.displayVehicleInformation(testcar);
        // Remove a vehicle (replace "vehicleToRemove" with the actual vehicle object)
        // boolean removed = manager.removeVehicle(vehicleToRemove);

        // Save vehicle list to file
        boolean saved = manager.saveVehicleList();
        if (saved) {
            System.out.println("\nVehicle list saved successfully.");
        } else {
            System.out.println("\nFailed to save vehicle list.");
        }
	}
}
