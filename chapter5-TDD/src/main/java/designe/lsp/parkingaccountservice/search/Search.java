package designe.lsp.parkingaccountservice.search;

import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public interface Search {
    int find(Transport car, List<Transport> transports);
    int findFreeSpace(int parkingSize, List<Transport> transports);
    int findFreeSpaceForOversize(int parkingSize, List<Transport> transports);
}
