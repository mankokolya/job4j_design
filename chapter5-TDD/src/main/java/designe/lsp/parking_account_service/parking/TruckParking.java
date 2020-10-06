package designe.lsp.parking_account_service.parking;

import designe.lsp.parking_account_service.transport.ITransport;

public class TruckParking implements IParking {
    private ITransport[] truckParking;
    private int nexFreeSpot;

    public TruckParking(int size) {
        this.truckParking = new ITransport[size];
    }

    @Override
    public boolean park(ITransport car) {
        if (nexFreeSpot < truckParking.length) {
            truckParking[nexFreeSpot++] = car;
            return true;
        }
        return false;
    }

    @Override
    public int find(ITransport car) {
        for (int i = 0; i < truckParking.length; i++) {
            if (car.equals(truckParking[i])) {
                return i;
            }
        }
        return -1;
    }
}
