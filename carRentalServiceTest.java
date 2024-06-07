package com.mycompany.ASSproject1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ASSproject1{

    @Test
    public void testAddCar() {
        RentalAgency rentalAgency = new RentalAgency();
        Car car = new Car("ABC123", "Toyota Camry");
        rentalAgency.addCar(car);
        assertEquals(1, rentalAgency.getCars().size());
        assertEquals("Toyota Camry", rentalAgency.getCars().get(0).getModel());
    }

    @Test
    public void testAddCustomer() {
        RentalAgency rentalAgency = new RentalAgency();
        Customer customer = new Customer("conny emanikor", "D1234567");
        rentalAgency.addCustomer(customer);
        assertEquals(1, rentalAgency.getCustomers().size());
        assertEquals("conny emanikor", rentalAgency.getCustomers().get(0).getName());
    }

    @Test
    public void testRentCar() {
        RentalAgency rentalAgency = new RentalAgency();
        Car car = new Car("ABC123", "Toyota Camry");
        rentalAgency.addCar(car);
        Customer customer = new Customer("conny emanikor", "D1234567");
        rentalAgency.addCustomer(customer);
        boolean result = rentalAgency.rentCar(customer.getId(), car.getId());
        assertTrue(result);
        assertTrue(car.isRented());
    }

    @Test
    public void testReturnCar() {
        RentalAgency rentalAgency = new RentalAgency();
        Car car = new Car("ABC123", "Toyota Camry");
        rentalAgency.addCar(car);
        car.setRented(true); // Assuming there is a method to set the car as rented
        rentalAgency.returnCar(car.getId()); // Assuming there is a method to return the car by ID
        assertFalse(car.isRented());
    }
}
