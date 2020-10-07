package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

public class CarParking extends ParkingModel {

    public CarParking(int size) {
        super(size);
    }

    @Override
    public boolean accept(Transport transport) {
        return transport.getCategory().equals("B") || transport.getCategory().equals("C");
     }

    @Override
    public int hasFreeSpace(Transport transport) {
        return 0;
    }


}
