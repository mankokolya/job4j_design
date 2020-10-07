package designe.lsp.parkingaccountservice.transport;

import java.util.Objects;

public abstract class Transport {
    private final String registrationNumber;
    private String category;

    protected Transport(String registrationNumber, String category) {
        this.registrationNumber = registrationNumber;
        this.category = category;
    }

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


    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    public String getCategory() {
        return category;
    }
}
