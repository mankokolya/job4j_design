package designe.lsp.parkingaccountservice.business;

import designe.lsp.parkingaccountservice.transport.ITransport;


public interface ParkingBusiness {
    boolean parkTransport(ITransport park);
}
