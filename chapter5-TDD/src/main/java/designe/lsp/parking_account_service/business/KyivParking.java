package designe.lsp.parking_account_service.business;

import designe.lsp.parking_account_service.parking.IParking;
import designe.lsp.parking_account_service.transport.ITransport;


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
