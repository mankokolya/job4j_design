package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ParkingModel implements Parking{
    private List<Transport> parking;

    public ParkingModel(int size) {
        this.parking = new ArrayList<>(Collections.nCopies(size, null));
    }

    @Override
    public int park(Transport transport) {
        int parkingIndex = hasFreeSpace(transport);
        if (parkingIndex > -1) {
            for (int i = parkingIndex; i < parkingIndex + transport.getSize(); i++) {
                parking.add(i, transport);
            }
            return parkingIndex;
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

    public List<Transport> info() {
        return Collections.unmodifiableList(parking);
    }
}
