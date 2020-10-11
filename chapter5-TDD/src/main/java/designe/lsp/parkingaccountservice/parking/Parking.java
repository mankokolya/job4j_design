package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public interface Parking {
    void park(Transport transport, int parkingPlace);
    void parkOverSize(Transport transport, int startingParkingPlace);
    int allocateSpace(Transport transport);
    List<Transport> getParkingSchema();

}
