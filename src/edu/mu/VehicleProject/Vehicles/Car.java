package edu.mu.VehicleProject.Vehicles;

import java.time.Year;

import edu.mu.VehicleProject.enums.FuelType;
import edu.mu.VehicleProject.enums.StartMechanism;
import edu.mu.VehicleProject.enums.VehicleColor;

public class Car extends Vehicle{


	public Car(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * this.mass * (Year.now().getValue() - this.modelYear) * this.cylinders * 0.0005;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = this.cylinders * this.gasTankCapacity * fuelPrice / distance * 0.003;
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		System.out.println("They vehicle started by " + this.startType);
		
	}
	
	
	
	

}
