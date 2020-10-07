package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public class TruckParking extends ParkingModel {

    public TruckParking(int size) {
        super(size);
    }

    @Override
    public boolean accept(Transport transport) {

        return transport.getSize() == 4;
    }

    @Override
    public int hasFreeSpace(Transport transport) {
        List<Transport> parkingInfo = info();
        for (int i = 0; i < parkingInfo.size(); i++) {
            if (parkingInfo.get(i) == null) {
                return i;
            }
        }
      return -1;
    }
}
