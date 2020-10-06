package designe.lsp.parking_account_service.parking;

import designe.lsp.parking_account_service.transport.ITransport;

public interface IParking {
    boolean park(ITransport car);
    int find(ITransport car);

}
