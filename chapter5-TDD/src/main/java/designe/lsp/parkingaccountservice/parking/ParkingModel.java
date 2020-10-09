package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.Collections;
import java.util.List;

public abstract class ParkingModel implements Parking {
    private List<Transport> transports;

    public ParkingModel(List<Transport> transports) {
        this.transports = transports;
    }

    @Override
    public int park(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            transports.set(parkingIndex, transport);
        }
        return parkingIndex;
    }

    @Override
    public int parkOverSize(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            int lastOccupiedIndex = parkingIndex + transport.getSize();
            for (int i = parkingIndex; i < lastOccupiedIndex; i++) {
                transports.set(i, transport);
            }
        }
        return parkingIndex;
    }

    @Override
    public int find(Transport transport) {
        return this.transports.indexOf(transport);
    }

    @Override
    public int hasFreeSpace(Transport transport) {
        List<Transport> parkingInfo = info();
        for (int i = 0; i < parkingInfo.size(); i++) {
            if (parkingInfo.get(i).getRegistrationNumber() == null) {
                return i;
            }
        }
        return -1;
    }

    public List<Transport> info() {
        return Collections.unmodifiableList(transports);
    }
}
