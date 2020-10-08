package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

public interface Parking {
    int park(Transport transport);
    int parkOverSize(Transport transport);
    int find(Transport car);
    boolean accept(Transport transport);
    int hasFreeSpace(Transport transport);
}
