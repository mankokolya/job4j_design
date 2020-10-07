package designe.lsp.parkingaccountservice.business;

import designe.lsp.parkingaccountservice.parking.CarParking;
import designe.lsp.parkingaccountservice.parking.IParking;
import designe.lsp.parkingaccountservice.parking.TruckParking;
import designe.lsp.parkingaccountservice.transport.Car;
import designe.lsp.parkingaccountservice.transport.ITransport;
import org.junit.Test;

public class KyivParkingTest {

    @Test
    public void createKyivParking() {
        IParking carParking = new CarParking(5);
        IParking truckParking = new TruckParking(2);
        ITransport car = new Car("DS5478ER");
        ParkingBusiness kyivParking = new KyivParking(carParking, truckParking);
        kyivParking.parkTransport(car);
    }

}