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
	private double calculateMaintenaceCost;
	private double calculateFuelEfficiency;
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
	
	
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
//	This will display the information, including maintenance cost, fuel efficiency, and how 
//	the vehicle starts, of all the cars present in the vehicleList.
//	If the vehicle is not found, then print an appropriate error message.
	public void displayAllCarInformation() {
		System.out.println("\u001B[31m"+"The following are all Cars:"+"\u001B[0m");
		for(Vehicle car : inventory) {
			if(car instanceof Car) {
				System.out.println("\nCar Brand : " + car.getBrand()+"\nMaintenance Cost : " +car.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "+car.calculateFuelEfficiency(distance, fuelPrice));
				car.startEngine(); 
			}
		}
	}
	public void displayAllTruckInformation() {
		System.out.println("\u001B[31m"+"\n\nThe following are all Trucks:"+"\u001B[0m");
		for(Vehicle Truck : inventory) {
			if(Truck instanceof Truck) {
				System.out.println("\nTruck Brand : " + Truck.getBrand()+"\nMaintenance Cost : " +Truck.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "+Truck.calculateFuelEfficiency(distance, fuelPrice));
				Truck.startEngine(); 
			}
		}
	}

	public void displayAllSUVInformation() {
		System.out.println("\u001B[31m"+"\n\nThe following are all SUVS:"+"\u001B[0m");
		for(Vehicle SUV : inventory) {
			if(SUV instanceof SUV) {
				System.out.println("\nSUV Brand : " + SUV.getBrand()+"\nMaintenance Cost : " +SUV.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "+SUV.calculateFuelEfficiency(distance, fuelPrice));
				SUV.startEngine(); 
			}
		}
	}

	public void displayAllMotorBikeInformation() {
		System.out.println("\u001B[31m"+"\n\nThe following are all MotorBikes:"+"\u001B[0m");
		for(Vehicle MotorBike : inventory) {
			if(MotorBike instanceof MotorBike) {
				System.out.println("\nMotorbike Brand : " + MotorBike.getBrand()+"\nMaintenance Cost : " +MotorBike.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "+MotorBike.calculateFuelEfficiency(distance, fuelPrice));
				MotorBike.startEngine(); 
			}
		}
	}
	
	public void displayVehicleInformation(Vehicle v) {
		if(inventory.contains(v)) {
			if (v instanceof Car) {
	            Car car = (Car) v;
	            System.out.println("\nCar Brand: " + car.getBrand());
	            System.out.println("Maintenance Cost: " + car.calculateMaintenaceCost(distance));
	            System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency(distance, fuelPrice));
	            car.startEngine();
	        } else if (v instanceof Truck) {
	            Truck truck = (Truck) v;
	            System.out.println("\nTruck Brand: " + truck.getBrand());
	            System.out.println("Maintenance Cost: " + truck.calculateMaintenaceCost(distance));
	            System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency(distance, fuelPrice));
	            truck.startEngine();
	        } else if (v instanceof SUV) {
	            SUV suv = (SUV) v;
	            System.out.println("\nSUV Brand: " + suv.getBrand());
	            System.out.println("Maintenance Cost: " + suv.calculateMaintenaceCost(distance));
	            System.out.println("Fuel Efficiency: " + suv.calculateFuelEfficiency(distance, fuelPrice));
	            suv.startEngine();
	        } else if (v instanceof MotorBike) {
	            MotorBike motorBike = (MotorBike) v;
	            System.out.println("\nMotorBike Brand: " + motorBike.getBrand());
	            System.out.println("Maintenance Cost: " + motorBike.calculateMaintenaceCost(distance));
	            System.out.println("Fuel Efficiency: " + motorBike.calculateFuelEfficiency(distance, fuelPrice));
	            motorBike.startEngine();
	        } else {
	        	System.out.println("\nUnknown vehicle type.");
	        }
		} else {
			System.out.println("\nError: Vehicle not found in inventory");
		}
		
	}


	public ArrayList<Vehicle> getInventory() {
		return inventory;
	}


	public void setInventory(ArrayList<Vehicle> inventory) {
		this.inventory = inventory;
	}
	
	

}
