package designe.lsp.parking_account_service.parking;

import designe.lsp.parking_account_service.transport.ITransport;

public class CarParking implements IParking {
    private ITransport[] carParking;
    private int nexFreeSpot = 0;

    public CarParking(int carParkingSize) {
        this.carParking = new ITransport[carParkingSize];
    }

    @Override
    public boolean park(ITransport car) {
        if (nexFreeSpot < carParking.length) {
            carParking[nexFreeSpot++] = car;
            return true;
        }
        return false;
    }

    @Override
    public int find(ITransport car) {
        for (int i = 0; i < carParking.length; i++) {
            if (car.equals(carParking[i])) {
                return i;
            }
        }
        return -1;
    }
}
