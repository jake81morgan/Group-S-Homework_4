package edu.mu.VehicleProject.Vehicles;

import edu.mu.VehicleProject.enums.*;

public abstract class Vehicle {
	
	// Protected attributes
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected FuelType fuelType;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected StartMechanism startType;
	
	// Abstract methods for implementation and overriding
	public abstract double calculateMaintenaceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	public abstract void startEngine();
	
	

	
	

}
