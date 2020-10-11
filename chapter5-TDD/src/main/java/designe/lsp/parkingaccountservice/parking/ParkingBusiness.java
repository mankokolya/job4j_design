package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.accept.Accept;
import designe.lsp.parkingaccountservice.search.Search;
import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public class ParkingBusiness extends ParkingModel implements Accept {
    private final Search searcher;

    public ParkingBusiness(List<Transport> transports, Search searcher) {
        super(transports);
        this.searcher = searcher;
    }

    @Override
    public boolean accept(Transport transport) {
        return transport.getSize() == 1 || transport.getSize() == 4;
    }

    @Override
    public int allocateSpace(Transport transport) {
        int parkedIndex = -1;
        if (accept(transport)) {
            int initialIndex = searcher.findFreeSpace(transport.getSize(), super.getParkingSchema());
            if (initialIndex > -1) {
                super.park(transport, initialIndex);
                parkedIndex = initialIndex;
            } else {
                if (transport.getSize() == 4) {
                    parkedIndex = parkTruckWhenNoPlaceForTrucksLeft(transport);
                }
            }
        }
        return parkedIndex;
    }

    private int parkTruckWhenNoPlaceForTrucksLeft(Transport transport) {
        int initialIndex = searcher.findFreeSpaceForOversize(transport.getSize(), super.getParkingSchema());
        if (initialIndex > -1) {
            super.parkOverSize(transport, initialIndex);
        }
        return initialIndex;
    }
}
