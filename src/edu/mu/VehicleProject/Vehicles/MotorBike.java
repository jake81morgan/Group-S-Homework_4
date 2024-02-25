package edu.mu.VehicleProject.Vehicles;

import java.time.Year;

import edu.mu.VehicleProject.enums.FuelType;
import edu.mu.VehicleProject.enums.StartMechanism;
import edu.mu.VehicleProject.enums.VehicleColor;

public class MotorBike extends Vehicle {
	// Constructor
	public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}

	// Inherited methods
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * this.mass * (Year.now().getValue() - this.modelYear) * this.cylinders * 0.0002;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = this.cylinders * this.gasTankCapacity * fuelPrice / distance * 0.001;
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		System.out.println("They vehicle started by " + this.startType);
		
	}

	// toString implementation
	@Override
	public String toString() {
		return "MotorBike [brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price
				+ ", color=" + color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass
				+ ", cylinders=" + cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType
				+ "]";
	}

}
