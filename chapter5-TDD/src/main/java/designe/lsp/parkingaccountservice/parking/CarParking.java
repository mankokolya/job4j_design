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
        List<Transport> parkingInfo = info();
        int index = -1;
        if (transport.getSize() == 1) {
            index = spaceForCar(parkingInfo);
        } else if (transport.getSize() == 4) {
            int startPosition = spaceForCar(parkingInfo);
            index = spaceForTruck(parkingInfo, transport.getSize(), startPosition);
        }
        return index;
    }

    private int spaceForTruck(List<Transport> parkingInfo,  int size, int startPosition) {
        int index = startPosition;
        for (int i = startPosition + 1; i < startPosition + size; i++) {
            if (parkingInfo.get(i) != null) {
                index = -1;
            }
        }
        return index;
    }

    private int spaceForCar(List<Transport> transports) {
        int index = -1;
        for (int i = 0; i < transports.size(); i++) {
            if (transports.get(i) == null) {
                index = i;
                break;
            }
        }
        return  index;
    }
}
