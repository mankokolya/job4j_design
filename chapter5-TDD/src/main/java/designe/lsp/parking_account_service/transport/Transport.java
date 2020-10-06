package designe.lsp.parking_account_service.transport;

import java.util.Objects;

public abstract class Transport implements ITransport {
    private final String registrationNumber;

    protected Transport(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport vehicle = (Transport) o;
        return registrationNumber.equals(vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
