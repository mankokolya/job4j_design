package designe.lsp.parking_account_service.business;

import designe.lsp.parking_account_service.transport.ITransport;


public interface ParkingBusiness {
    boolean parkTransport(ITransport park);
}
