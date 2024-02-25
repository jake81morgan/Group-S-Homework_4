package edu.mu.VehicleProject;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.VehicleProject.Vehicles.*;
import edu.mu.VehicleProject.enums.FuelType;
import edu.mu.VehicleProject.enums.StartMechanism;
import edu.mu.VehicleProject.enums.VehicleColor;

public class VehicleManager {

	private static VehicleManager instance = null;
	private static final String vehicleFilePath = "vehicleList.csv";
	private ArrayList<Vehicle> inventory;
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;

	// Initialization of singleton
	private VehicleManager() {
		
	}
	
	public static VehicleManager getInstance() {
		if(instance == null) {
			instance = new VehicleManager();
		}
		return instance;
	}

	// Initializes vehicle stock from file
	public boolean initializeStock() {

		inventory = new ArrayList<Vehicle>();

		try {

			// Initializes the file reader and skips header line
			Scanner scanner = new Scanner(new FileInputStream(vehicleFilePath));
			scanner.nextLine();

			// Reads product info from file
			while (scanner.hasNext()) {

				// Read product info off file
				String[] info;
				info = scanner.nextLine().split(",");

				// Add product to inventory
				if (info[0].equals("Car")) {
					inventory.add(new Car(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]),
							VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), Double.parseDouble(info[7]),
							Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]),
							StartMechanism.valueOf(info[11])));
				} else if (info[0].equals("MotorBike")) {
					inventory.add(new MotorBike(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]),
							VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), Double.parseDouble(info[7]),
							Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]),
							StartMechanism.valueOf(info[11])));
				} else if (info[0].equals("SUV")) {
					inventory.add(new SUV(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]),
							VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), Double.parseDouble(info[7]),
							Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]),
							StartMechanism.valueOf(info[11])));
				} else if (info[0].equals("Truck")) {
					inventory.add(new Truck(info[1], info[2], Long.parseLong(info[3]), Double.parseDouble(info[4]),
							VehicleColor.valueOf(info[5]), FuelType.valueOf(info[6]), Double.parseDouble(info[7]),
							Double.parseDouble(info[8]), Integer.parseInt(info[9]), Double.parseDouble(info[10]),
							StartMechanism.valueOf(info[11])));
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
		System.out.println("\u001B[31m" + "The following are all Cars:" + "\u001B[0m");
		int count = 0;
		for (Vehicle car : inventory) {
			if (car instanceof Car) {
				System.out.println("\nCar Brand : " + car.getBrand() + "\nMaintenance Cost : "
						+ car.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "
						+ car.calculateFuelEfficiency(distance, fuelPrice));
				car.startEngine();
				count++;
			}
		}
		// Print an error message if there is no cars
		if (count == 0) {
			System.out.println("There was not a Car in the list");
		}
	}

	public void displayAllTruckInformation() {
		System.out.println("\u001B[31m" + "\n\nThe following are all Trucks:" + "\u001B[0m");
		int count = 0;
		for (Vehicle Truck : inventory) {
			if (Truck instanceof Truck) {
				System.out.println("\nTruck Brand : " + Truck.getBrand() + "\nMaintenance Cost : "
						+ Truck.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "
						+ Truck.calculateFuelEfficiency(distance, fuelPrice));
				Truck.startEngine();
				count++;
			}
		}
		// Print an error message if there is no Truck
		if (count == 0) {
			System.out.println("There was not a Truck in the list");
		}
	}

	public void displayAllSUVInformation() {
		System.out.println("\u001B[31m" + "\n\nThe following are all SUVS:" + "\u001B[0m");
		int count = 0;
		for (Vehicle SUV : inventory) {
			if (SUV instanceof SUV) {
				System.out.println("\nSUV Brand : " + SUV.getBrand() + "\nMaintenance Cost : "
						+ SUV.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "
						+ SUV.calculateFuelEfficiency(distance, fuelPrice));
				SUV.startEngine();
				count++;
			}
		}
		// Print an error message if there is no SUV
		if (count == 0) {
			System.out.println("There was not a SUV in the list");
		}
	}

	public void displayAllMotorBikeInformation() {
		System.out.println("\u001B[31m" + "\n\nThe following are all MotorBikes:" + "\u001B[0m");
		int count = 0;
		for (Vehicle MotorBike : inventory) {
			if (MotorBike instanceof MotorBike) {
				System.out.println("\nMotorbike Brand : " + MotorBike.getBrand() + "\nMaintenance Cost : "
						+ MotorBike.calculateMaintenaceCost(distance) + " \nFuelEfficiency Cost: "
						+ MotorBike.calculateFuelEfficiency(distance, fuelPrice));
				MotorBike.startEngine();
				count++;
			}
		}
		// Print an error message if there is no Motorbike
		if (count == 0) {
			System.out.println("There was not a Motorbike in the list");
		}
	}

	public void displayVehicleInformation(Vehicle v) {
		if (inventory.contains(v)) {
			System.out.println("\u001B[31m" + "\n\nThe following test vehicle was given with the following information:"
					+ "\u001B[0m");
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

// Removes the given vehicle from the vehicleList
// Returns true if the removal is successful, false otherwise.
	public boolean removeVehicle(Vehicle V) {
		return inventory.remove(V);
	}

//adds  the given vehicle from the vehicleList
//Returns true if the addition is successful, false otherwise.
	public boolean addVehicle(Vehicle V) {
		return inventory.add(V);
	}

//Saves the updated vehicleList back to the CSV file located at vehicleFilePath. Overwrites the existing file with the updated data.
//Returns true if the saving is successful, false otherwise (file does not exist, or file empty).
	public boolean saveVehicleList() {
		try {

			// Initializes writer and creates header of file
			BufferedWriter writer = new BufferedWriter(new FileWriter(vehicleFilePath));
			writer.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType");
			writer.newLine();

			// Adds products to CSV file
			for (Vehicle vehicle : inventory) {
				if (vehicle instanceof Car) {
					writer.write("Car");
				} else if (vehicle instanceof Truck) {
					writer.write("Truck");
				} else if (vehicle instanceof SUV) {
					writer.write("SUV");
				} else if (vehicle instanceof MotorBike) {
					writer.write("MotorBike");
				}
				writer.write("," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + ","
						+ vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType() + ","
						+ vehicle.getMileage() + "," + vehicle.getMass() + "," + vehicle.getCylinders() + ","
						+ vehicle.getGasTankCapacity() + "," + vehicle.getStartType());
				writer.newLine(); // Moves to next line

			}

			// Close the writer
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("File write error.");
			return false;
		}
	}

//Checks if the given vehicle is a specific type of Vehicle subclass.
//If the given vehicle object is the object type, then return true, otherwise return false.
	private boolean isVehicleType(Vehicle v, Class clazz) {
		return clazz.isInstance(v);
	}

//Returns the number of objects in the vehicle list based on the object vehicle type.
//Use the isVehicleType(Vehicle v, Class clazz) method.
	public int getNumberOfVehiclesByType(Class clazz) {
		int count = 0;
		for(Vehicle vehicle : inventory) {
			if(isVehicleType(vehicle, clazz)) {
				count++;
			}	
		}
		return count;
	}

//Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the highest maintenance cost.
//If multiple vehicles have the same maintenance cost, randomly return one of the
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		if (inventory.isEmpty()) {
            return null; // Return null if the list is empty
        }

        Vehicle vehicleWithHighestMaintenanceCost = null;
        double highestMaintenanceCost = Double.MIN_VALUE;

        for (Vehicle vehicle : inventory) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);
            if (maintenanceCost > highestMaintenanceCost) {
                highestMaintenanceCost = maintenanceCost;
                vehicleWithHighestMaintenanceCost = vehicle;
            }
        }

        return vehicleWithHighestMaintenanceCost;
	}

//Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the lowest maintenance cost. 
//If multiple vehicles have the same maintenance cost, randomly return one of the vehicles (Use the
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		if (inventory.isEmpty()) {
            return null; // Return null if the list is empty
        }

        Vehicle vehicleWithLowestMaintenanceCost = null;
        double lowestMaintenanceCost = Double.MAX_VALUE;

        for (Vehicle vehicle : inventory) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);
            if (maintenanceCost < lowestMaintenanceCost) {
                lowestMaintenanceCost = maintenanceCost;
                vehicleWithLowestMaintenanceCost = vehicle;
            }
        }

        return vehicleWithLowestMaintenanceCost;
	}

//Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle with the highest fuel efficiency. 
//If multiple vehicles have the same highest fuel efficiency, return vehicles with the same highest fuel efficiency in an ArrayList.
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
		if (inventory.isEmpty()) {
            return null; // Return null if the list is empty
        }

        ArrayList<Vehicle> vehiclesWithHighestFuelEfficiency = new ArrayList<>();
        double highestFuelEfficiency = Double.MIN_VALUE;

        // Calculate the fuel efficiency for each vehicle
        for (Vehicle vehicle : inventory) {
            double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (fuelEfficiency > highestFuelEfficiency) {
                highestFuelEfficiency = fuelEfficiency;
                vehiclesWithHighestFuelEfficiency.clear();
                vehiclesWithHighestFuelEfficiency.add(vehicle);
            } else if (fuelEfficiency == highestFuelEfficiency) {
                vehiclesWithHighestFuelEfficiency.add(vehicle);
            }
        }

        return vehiclesWithHighestFuelEfficiency;
	}

//Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle with the lowest fuel efficiency. 
//If multiple vehicles have the same lowest fuel efficiency, return vehicles with the same lowest fuel efficiency in an ArrayList.
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
		if (inventory.isEmpty()) {
            return null; // Return null if the list is empty
        }

        ArrayList<Vehicle> vehiclesWithLowestFuelEfficiency = new ArrayList<>();
        double lowestFuelEfficiency = Double.MAX_VALUE;

        // Calculate the fuel efficiency for each vehicle
        for (Vehicle vehicle : inventory) {
            double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (fuelEfficiency < lowestFuelEfficiency) {
                lowestFuelEfficiency = fuelEfficiency;
                vehiclesWithLowestFuelEfficiency.clear();
                vehiclesWithLowestFuelEfficiency.add(vehicle);
            } else if (fuelEfficiency == lowestFuelEfficiency) {
                vehiclesWithLowestFuelEfficiency.add(vehicle);
            }
        }

        return vehiclesWithLowestFuelEfficiency;
	}

//Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list. 
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		int suvCount = getNumberOfVehiclesByType(SUV.class);
        if (suvCount == 0) {
            return -1.0; // Error code indicating no SUVs in the list
        }

        double totalFuelEfficiency = 0.0;
        for (Vehicle vehicle : inventory) {
            if (vehicle instanceof SUV) {
                totalFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
            }
        }
        return totalFuelEfficiency / suvCount;
	}

	public ArrayList<Vehicle> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Vehicle> inventory) {
		this.inventory = inventory;
	}

}
