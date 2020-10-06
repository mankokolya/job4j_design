package designe.lsp.parking_account_service.business;

import designe.lsp.parking_account_service.parking.CarParking;
import designe.lsp.parking_account_service.parking.IParking;
import designe.lsp.parking_account_service.parking.TruckParking;
import designe.lsp.parking_account_service.transport.Car;
import designe.lsp.parking_account_service.transport.ITransport;
import org.junit.Test;

import static org.junit.Assert.*;

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