package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ParkingModel implements Parking {
    private List<Transport> parking;

    public ParkingModel(int size) {
        this.parking = new ArrayList<>(Collections.nCopies(size, null));
    }

    @Override
    public int park(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            parking.set(parkingIndex, transport);
        }
        return parkingIndex;
    }

    @Override
    public int parkOverSize(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            int lastOccupiedIndex = parkingIndex + transport.getSize();
            for (int i = parkingIndex; i < lastOccupiedIndex; i++) {
                parking.set(i, transport);
            }
        }
        return parkingIndex;
    }

    @Override
    public int find(Transport transport) {
        for (int i = 0; i < parking.size(); i++) {
            if (transport.equals(parking.get(i))) {
                return i;
            }
        }
        return -1;
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

    public List<Transport> info() {
        return Collections.unmodifiableList(parking);
    }
}
