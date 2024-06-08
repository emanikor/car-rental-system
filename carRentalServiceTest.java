package com.mycompany.assproject1;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class test22 {

    private RentalAgency rentalAgency;

    @Before
    public void setUp() {
        rentalAgency = new RentalAgency();
        rentalAgency.addCar(new Car("ABC123", "Toyota Camry"));
        rentalAgency.addCar(new Car("XYZ789", "Honda Civic"));
        rentalAgency.addCustomer(new Customer("conny emanikor", "D1234567"));
    }

    @Test
    public void testAddCar() {
        Car car = new Car("LMN456", "Ford Mustang");
        rentalAgency.addCar(car);
        assertEquals("Car should be added to the list", 3, rentalAgency.getCars().size());
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("Jane Smith", "D7654321");
        rentalAgency.addCustomer(customer);
        assertEquals("Customer should be added to the list", 2, rentalAgency.getCustomers().size());
    }

    @Test
    public void testRentCar() {
        Customer customer = rentalAgency.getCustomers().get(0);
        boolean result = rentalAgency.rentCar(customer, "Toyota Camry");
        assertTrue("Car should be rented successfully", result);
        assertTrue("Car's rented status should be true", rentalAgency.getCars().get(0).isRented());
    }

    @Test
    public void testReturnCar() {
        // Rent a car first
        Customer customer = rentalAgency.getCustomers().get(0);
        rentalAgency.rentCar(customer, "Toyota Camry");

        // Then return it
        Car car = rentalAgency.getCars().get(0);
        rentalAgency.returnCar(car);
        assertFalse("Car's rented status should be false", car.isRented());
    }
}
