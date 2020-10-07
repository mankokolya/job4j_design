package designe.lsp.parkingaccountservice.business;

import designe.lsp.parkingaccountservice.parking.CarParking;
import designe.lsp.parkingaccountservice.businness.KievParking;
import designe.lsp.parkingaccountservice.parking.Parking;
import designe.lsp.parkingaccountservice.parking.TruckParking;
import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.Transport;
import designe.lsp.parkingaccountservice.transport.Truck;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KyivParkingTest {

    @Test
    public void createKyivParking() {
        Parking carParking = new CarParking(2);
        Parking truckParking = new TruckParking(2);
        Transport truck = new Truck("DS5478ER", 4);
        KievParking kyivParking = new KievParking(carParking, truckParking);
        int parkingIndex = kyivParking.setParkingLot(truck);
        assertTrue(parkingIndex > -1);
    }

}