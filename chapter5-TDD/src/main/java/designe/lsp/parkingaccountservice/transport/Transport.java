package designe.lsp.parkingaccountservice.transport;

import java.util.Objects;

public abstract class Transport {

    private String registrationNumber = "";
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

    public int getSize() {
        return parkingSize;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transport transport = (Transport) o;
        return parkingSize == transport.parkingSize
                && registrationNumber.equals(transport.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, parkingSize);
    }
}
