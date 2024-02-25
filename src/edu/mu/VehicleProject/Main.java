package edu.mu.VehicleProject;

import java.util.ArrayList;

import edu.mu.VehicleProject.Vehicles.*;
import edu.mu.VehicleProject.enums.FuelType;
import edu.mu.VehicleProject.enums.StartMechanism;
import edu.mu.VehicleProject.enums.VehicleColor;

public class Main {
	

	public static void main(String[] args) {
		// Creates instance of class
		VehicleManager manager = VehicleManager.getInstance();

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
        
		// Remove vehicle from inventory
		manager.removeVehicle(testcar);
		
		// Add vehicle to inventory
		Car car = new Car("Lincoln", "MKS", 2009, 10000, VehicleColor.GRAY, FuelType.GASOLINE, 192000, 2, 6, 17, StartMechanism.KEYSTART);
		manager.addVehicle(car);

        // Save vehicle list to file
        boolean saved = manager.saveVehicleList();
        if (saved) {
            System.out.println("\nVehicle list saved successfully.");
        } else {
            System.out.println("\nFailed to save vehicle list.");
        }
        
        // Check number of cars
        int cars = manager.getNumberOfVehiclesByType(Car.class);
        System.out.println("\nNumber of cars: " + cars);
        
        // Tests get vehicle methods
        System.out.println("\nVehicle with lowest maintenence cost: " + manager.getVehicleWithLowestMaintenanceCost(1000));
        System.out.println("Vehicle with highest maintenence cost: " + manager.getVehicleWithHighestMaintenanceCost(1000));
        System.out.println("\nVehicle(s) with lowest fuel efficiency: ");
        for(Vehicle v : manager.getVehicleWithLowestFuelEfficiency(1000, 3.2)) {
        	System.out.println("   " + v);
        }
        System.out.println("\nVehicle(s) with highest fuel efficiency: ");
        for(Vehicle v : manager.getVehicleWithHighestFuelEfficiency(1000, 3.2)) {
        	System.out.println("   " + v);
        }
        
        System.out.println("\nAverage fuel efficiency of SUVs: " + manager.getAverageFuelEfficiencyOfSUVs(1000, 3.2));
	}
}
