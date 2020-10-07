package designe.lsp.parkingaccountservice.parking;

import designe.lsp.parkingaccountservice.transport.ITransport;

public interface IParking {
    boolean park(ITransport car);
    int find(ITransport car);

}
