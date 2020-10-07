package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.Transport;
import designe.lsp.parkingaccountservice.transport.Truck;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void createNewCarParking() {
        Parking parking = new CarParking(10);
    }

    @Test
    public void parkCar() {
        Parking parking = new CarParking(10);
        Transport car = new Car("DF2542DC");
        assertTrue(parking.park(car) > -1);
        assertTrue(parking.find(car) > -1);
    }

    @Test
    public void parkCarWhenFullCarParking() {
        Parking parking = new CarParking(1);
        Transport car1 = new Car("DF2542DC");
        Transport car2 = new Car("DF2542DC");
        parking.park(car1);
        assertEquals(parking.park(car2), -1);
    }

    @Test
    public void parkTruck() {
        Parking parking = new TruckParking(2);
        Transport truck1 = new Truck("DF5487RE", 4);
        assertTrue(parking.park(truck1) > -1);
        assertTrue(parking.find(truck1) > -1);
    }

    @Test
    public void parkCarWhenFullTruckParking() {
        Parking parking = new TruckParking(1);
        Transport truck1 = new Truck("DF5487RE", 4);
        Transport truck2 = new Truck("DF5458RE", 4);
        parking.park(truck1, parking);
        assertEquals(parking.park(truck2), -1);
    }
}