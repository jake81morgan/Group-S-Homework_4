package edu.mu.VehicleProject;

import java.util.ArrayList;

import edu.mu.VehicleProject.Vehicles.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleManager manager = new VehicleManager();
		manager.initializeStock();
		ArrayList<Vehicle> vehicles = manager.getInventory();
		for(Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
	}

}
