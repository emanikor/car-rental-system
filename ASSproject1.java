package com.mycompany.assproject1;

import java.util.List;
import java.util.ArrayList;

// Class to represent a car in the rental agency
class Car {
    private String licensePlate;
    private String model;
    private boolean isRented;

    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        this.isRented = true;
    }

    public void returnCar() {
        this.isRented = false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", isRented=" + isRented +
                '}';
    }
}
 /**
     * Add a customer to the rental service.
     * @param client The client to be added.
     */

// Class to represent a customer
class Customer {
    private String name;
    private String driverLicenseNumber;

    public Customer(String name, String driverLicenseNumber) {
        this.name = name;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                '}';
    }
}
 /**
     * Constructor to initialize the rental agency.
     */

// Class to manage the rental agency's operations
class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
     /**
     * Find an available vehicle of a specific model.
     * @param model The model of the car to find.
     * @return The available car or null if none found.
     */

    public Car findAvailableCar(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model) && !car.isRented()) {
                return car;
            }
        }
        return null;
    }

     /**
     * Rent a vehicle to a client.
     * @param client The client renting the vehicle.
     * @param model The model of the vehicle to be rented.
     * @return True if the vehicle was successfully rented, false otherwise.
     */
    public boolean rentCar(Customer customer, String model) {
        Car car = findAvailableCar(model);
        if (car != null) {
            car.rent();
            System.out.println("Car rented: " + car);
            return true;
        } else {
            System.out.println("No available car of model: " + model);
            return false;
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        System.out.println("Car returned: " + car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "RentalAgency{" +
                "cars=" + cars +
                ", customers=" + customers +
                '}';
    }
}

// Main class to run the application
public class ASSproject1 {
    public static void main(String[] args) {
        
         // Creating an instance of the rental service
        RentalAgency rentalAgency = new RentalAgency();

        // Adding cars to the rental agency
        rentalAgency.addCar(new Car("ABC123", "Toyota Camry"));
        rentalAgency.addCar(new Car("XYZ789", "Honda Civic"));
        rentalAgency.addCar(new Car("LMN456", "Ford Mustang"));

        // Adding customers to the rental agency
        rentalAgency.addCustomer(new Customer("conny emanikor", "D1234567"));
        rentalAgency.addCustomer(new Customer("Jane Smith", "D7654321"));

        // Renting a car
        Customer customer1 = rentalAgency.getCustomers().get(0);
        rentalAgency.rentCar(customer1, "Toyota Camry");

        // Returning a car
        Car rentedCar = rentalAgency.getCars().get(0);
        rentalAgency.returnCar(rentedCar);

        // Print rental agency state
        System.out.println(rentalAgency);
    }
}
