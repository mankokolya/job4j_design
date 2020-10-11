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
    public void park(Transport transport, int parkingPlace) {
        transports.set(parkingPlace, transport);
    }

    @Override
    public void parkOverSize(Transport transport, int parkingPlaceStartingIndex) {
        int lastOccupiedPlace = parkingPlaceStartingIndex + transport.getSize();
        for (int i = parkingPlaceStartingIndex; i < lastOccupiedPlace; i++) {
            transports.set(i, transport);
        }
    }

    @Override
    public List<Transport> getParkingSchema() {
        return Collections.unmodifiableList(transports);
    }
}
