package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public class CarParking extends ParkingModel {

    public CarParking(int size) {
        super(size);
    }

    @Override
    public boolean accept(Transport transport) {
        return transport.getSize() == 1 || transport.getSize() == 4;
    }

    @Override
    public int hasFreeSpace(Transport transport) {
        int index = super.hasFreeSpace(transport);
        if (transport.getSize() == 4) {
            index = spaceForTruck(super.info(), transport.getSize(), index);
        }
        return index;
    }

    @Override
    public int park(Transport transport) {
        return transport.getSize() == 1 ? super.park(transport) : super.parkOverSize(transport);
    }

    private int spaceForTruck(List<Transport> parkingInfo,  int size, int startPosition) {
        int index = startPosition;
        for (int i = startPosition + 1; i < startPosition + size; i++) {
            if (parkingInfo.get(i) != null) {
                index = -1;
                break;
            }
        }
        return index;
    }
}
