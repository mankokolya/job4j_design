package designe.lsp.parkingaccountservice.business;

import designe.lsp.parkingaccountservice.parking.CarParking;
import designe.lsp.parkingaccountservice.businness.KievParking;
import designe.lsp.parkingaccountservice.parking.Parking;
import designe.lsp.parkingaccountservice.parking.TruckParking;
import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.Transport;
import org.junit.Test;

public class KyivParkingTest {

    @Test
    public void createKyivParking() {
        Parking carParking = new CarParking(5);
        Parking truckParking = new TruckParking(2);
        Transport car = new Car("DS5478ER", "B");
        KievParking kyivParking = new KievParking(carParking, truckParking);
        kyivParking.setParkingLot(car);
    }

}