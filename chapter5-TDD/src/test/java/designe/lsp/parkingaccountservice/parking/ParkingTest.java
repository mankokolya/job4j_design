package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.ITransport;
import designe.lsp.parkingaccountservice.transport.Truck;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTest {

    @Test
    public void createNewCarParking() {
        IParking parking = new CarParking(10);
    }

    @Test
    public void parkCar() {
        IParking parking = new CarParking(10);
        ITransport car = new Car("DF2542DC");
        assertTrue(parking.park(car));
        assertTrue(parking.find(car) > -1);
    }

    @Test
    public void parkCarWhenFullCarParking() {
        IParking parking = new CarParking(1);
        ITransport car1 = new Car("DF2542DC");
        ITransport car2 = new Car("DF2542DC");
        parking.park(car1);
        assertFalse(parking.park(car2));
    }

    @Test
    public void parkTruck() {
        IParking parking = new TruckParking(2);
        ITransport truck1 = new Truck("DF5487RE");
        assertTrue(parking.park(truck1));
        assertTrue(parking.find(truck1) > -1);
    }

    @Test
    public void parkCarWhenFullTruckParking() {
        IParking parking = new TruckParking(1);
        ITransport truck1 = new Truck("DF5487RE");
        ITransport truck2 = new Truck("DF5458RE");
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }


}