package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.search.Search;
import designe.lsp.parkingaccountservice.search.SearchFreeParking;
import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.Transport;
import designe.lsp.parkingaccountservice.transport.Truck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void createNewCarParking() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(5, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(5, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
    }

    @Test
    public void parkCar() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(5, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(5, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
        Transport car = new Car("DF2542DC");
        assertTrue(parking.allocateSpace(car) > -1);
        assertTrue(searcher.find(car, parking.getParkingSchema()) > -1);
    }

    @Test
    public void parkCarWhenFullCarParking() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(1, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(5, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
        Transport car1 = new Car("DF2542DC");
        Transport car2 = new Car("DF2542DC");
        parking.allocateSpace(car1);
        assertEquals(-1, parking.allocateSpace(car2));
    }

    @Test
    public void parkTruck() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(1, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(5, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
        Transport truck1 = new Truck("DF5487RE", 4);
        assertEquals(1, parking.allocateSpace(truck1));
        assertTrue(searcher.find(truck1, parking.getParkingSchema()) > -1);
    }

    @Test
    public void parkTruckWhenFullTruckParkingThenFalse() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(1, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(1, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
        Transport truck1 = new Truck("DF5487RE", 4);
        Transport truck2 = new Truck("DF5458RE", 4);
        parking.allocateSpace(truck1);
        assertEquals(-1, parking.allocateSpace(truck2));
    }

    @Test
    public void parkTruckIntoCarParking() {
        List<Transport> spaceForCars = new ArrayList<>(Collections.nCopies(5, new Car()));
        List<Transport> spaceForTruck = new ArrayList<>(Collections.nCopies(1, new Truck()));
        List<Transport> parkingSpace = Stream.concat(spaceForCars.stream(), spaceForTruck.stream()).collect(Collectors.toList());
        Search searcher = new SearchFreeParking();
        Parking parking = new ParkingBusiness(parkingSpace, searcher);
        Transport car1 = new Car("DF2542DC");
        Transport truck1 = new Truck("DF5487RE", 4);
        Transport truck2 = new Truck("DF5458RE", 4);
        parking.allocateSpace(car1);
        parking.allocateSpace(truck1);
        assertEquals(1, parking.allocateSpace(truck2));
    }
}