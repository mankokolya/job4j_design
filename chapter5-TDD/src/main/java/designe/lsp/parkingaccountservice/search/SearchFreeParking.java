package designe.lsp.parkingaccountservice.search;


import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.List;

public class SearchFreeParking implements Search {

    @Override
    public int find(Transport transport, List<Transport> transports) {
        return transports.indexOf(transport);
    }

    @Override
    public int findFreeSpace(int parkingSize, List<Transport> transports) {
        for (int i = 0; i < transports.size(); i++) {
            Transport parkedTransport = transports.get(i);
            if (parkedTransport.getSize() == parkingSize
                    && parkedTransport.getRegistrationNumber().isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int findFreeSpaceForOversize(int parkingSize, List<Transport> transports) {
        int defaultParkingSize = 1;
        int startPosition = -1;
        for (int i = 0; i + parkingSize <= transports.size(); i++) {
            if (findFreeSpaceEqualParkingSize(parkingSize, defaultParkingSize, i, transports)) {
                startPosition = i;
                break;
            }
        }
        return startPosition;
    }

    private boolean findFreeSpaceEqualParkingSize(int parkingSize, int defaultParkingSize, int i, List<Transport> transports) {
        int countFreeConsecutiveSpace = 0;
        for (int j = i; j < i + parkingSize; j++) {
            if (transports.get(j).getSize() == defaultParkingSize
                    && transports.get(i).getRegistrationNumber().isEmpty()) {
                countFreeConsecutiveSpace++;
            } else {
                break;
            }
        }
        return countFreeConsecutiveSpace == parkingSize;
    }
}
