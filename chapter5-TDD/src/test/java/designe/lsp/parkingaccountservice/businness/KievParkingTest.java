//package designe.lsp.parkingaccountservice.businness;
//
//import designe.lsp.parkingaccountservice.parking.ParkingBusiness;
//import designe.lsp.parkingaccountservice.parking.Parking;
//import designe.lsp.parkingaccountservice.parking.TruckParking;
//import designe.lsp.parkingaccountservice.transport.Car;
//import designe.lsp.parkingaccountservice.transport.Transport;
//import designe.lsp.parkingaccountservice.transport.Truck;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class KievParkingTest {
//
//    @Test
//    public void setParkingForCar() {
//        Parking parking = new ParkingBusiness(1);
//        Transport car1 = new Car("DF2542DC");
//        designe.lsp.parkingaccountservice.businness.ParkingBusiness business = new KievParking(parking);
//        assertEquals(0, business.setParkingLot(car1));
//    }
//
//    @Test
//    public void setParkingForTruck() {
//        Parking parking = new TruckParking(1);
//        Transport truck1 = new Truck("DF5487RE", 4);
//        designe.lsp.parkingaccountservice.businness.ParkingBusiness business = new KievParking(parking);
//        assertEquals(0, business.setParkingLot(truck1));
//    }
//
//    @Test
//    public void parkTruckInCarParking() {
//        Parking parking = new ParkingBusiness(8);
//        Transport car1 = new Car("DF2542DC");
//        Transport truck1 = new Truck("DF5487RE", 4);
//        designe.lsp.parkingaccountservice.businness.ParkingBusiness business = new KievParking(parking);
//        business.setParkingLot(car1);
//        assertEquals(1, business.setParkingLot(truck1));
//    }
//}