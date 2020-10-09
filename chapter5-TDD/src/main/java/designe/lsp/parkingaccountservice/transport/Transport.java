package designe.lsp.parkingaccountservice.transport;

import java.util.Objects;

public abstract class Transport {
    private String registrationNumber = null;
    private int parkingSize = 1;

    protected Transport(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    protected Transport(String registrationNumber, int parkingSize) {
        this.registrationNumber = registrationNumber;
        this.parkingSize = parkingSize;
    }
    protected Transport() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transport vehicle = (Transport) o;
        return registrationNumber.equals(vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    public int getSize() {
        return parkingSize;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
