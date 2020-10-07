package designe.lsp.parkingaccountservice.business;

import designe.lsp.parkingaccountservice.parking.IParking;
import designe.lsp.parkingaccountservice.transport.ITransport;


public class KyivParking implements ParkingBusiness {
    private final IParking carParking;
    private final IParking truckParking;

    public KyivParking(IParking carParking, IParking truckParking) {
        this.carParking = carParking;
        this.truckParking = truckParking;
    }

    @Override
    public boolean parkTransport(ITransport transport) {
        return carParking.park(transport);
    }

}
