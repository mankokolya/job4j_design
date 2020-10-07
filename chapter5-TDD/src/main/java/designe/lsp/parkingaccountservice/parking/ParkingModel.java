package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ParkingModel {
    private List<Transport> parking;

    public ParkingModel(int size) {
        this.parking = new ArrayList<>(size);
    }

    public int park(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            parking.add(parkingIndex, transport);
            return parkingIndex;
        }
        return -1;
    }

    public int find(Transport transport) {
        for (int i = 0; i < parking.size(); i++) {
            if (transport.equals(parking.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public List<Transport> info() {
        return Collections.unmodifiableList(parking);
    }

    public abstract boolean accept(Transport transport);

    public abstract int hasFreeSpace(Transport transport);

}
