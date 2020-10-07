package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.Transport;

public interface Parking {
    int park(Transport car);
    int find(Transport car);
    boolean accept(Transport transport);
}
