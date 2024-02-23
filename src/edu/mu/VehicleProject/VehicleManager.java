package edu.mu.VehicleProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.VehicleProject.Vehicles.*;
import edu.mu.VehicleProject.enums.FuelType;
import edu.mu.VehicleProject.enums.StartMechanism;
import edu.mu.VehicleProject.enums.VehicleColor;

public class VehicleManager {
	
	private static final String vehicleFilePath = "vehicleList.csv";
	private ArrayList<Vehicle> inventory;
	
	
	// Initialization of singleton
	
	// Initializes vehicle stock from file
	public boolean initializeStock() {
		
		inventory = new ArrayList<Vehicle>();
		
		try {
			
			// Initializes the file reader and skips header line
			Scanner scanner = new Scanner(new FileInputStream(vehicleFilePath));
			scanner.nextLine();
			
			// Reads product info from file
			while(scanner.hasNext()) {
				
				// Read product info off file
				String[] info;
				info = scanner.nextLine().split(",");
				
				// Add product to inventory
				if(info[0].equals("Car")) {
					inventory.add(new Car(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]), VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), 
							Double.parseDouble(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]), StartMechanism.valueOf(info[11])));
				} else if(info[0].equals("MotorBike")) {
					inventory.add(new MotorBike(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]), VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), 
							Double.parseDouble(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]), StartMechanism.valueOf(info[11])));
				} else if(info[0].equals("SUV")) {
					inventory.add(new SUV(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]), VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), 
							Double.parseDouble(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]), StartMechanism.valueOf(info[11])));
				} else if(info[0].equals("Truck")) {
					inventory.add(new Truck(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]), VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), 
							Double.parseDouble(info[7]), Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]), StartMechanism.valueOf(info[11])));
				}
			}
			return true;
			
		  // Thrown if file directory is incorrect
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return false;
		}
		
		
	}


	public ArrayList<Vehicle> getInventory() {
		return inventory;
	}


	public void setInventory(ArrayList<Vehicle> inventory) {
		this.inventory = inventory;
	}
	
	

}
