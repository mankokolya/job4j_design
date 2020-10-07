package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

public class TruckParking extends ParkingModel {

    public TruckParking(int size) {
        super(size);
    }

    @Override
    public boolean accept(Transport transport) {
        return transport.getCategory().equals("B");
    }

    @Override
    public int hasFreeSpace(Transport transport) {
//        for (int i = 0; i < ; i++) {
//
//        }
      return 0;
    }
}
