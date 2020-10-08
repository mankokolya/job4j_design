package designe.lsp.parkingaccountservice.businness;

import designe.lsp.parkingaccountservice.parking.Parking;
import designe.lsp.parkingaccountservice.transport.Transport;

import java.util.Arrays;
import java.util.List;

public class KievParking implements ParkingBusiness {

    private final List<Parking> parking;

    public KievParking(Parking... args) {
        this.parking = Arrays.asList(args.clone());
    }

    @Override
    public int setParkingLot(Transport transport) {
        return parking.stream()
                .filter(parking1 -> parking1.accept(transport))
                .map(parking1 -> parking1.park(transport))
                .findFirst().get();
    }
}
