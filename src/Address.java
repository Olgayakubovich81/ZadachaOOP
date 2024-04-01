import java.util.Objects;

public class Address {
    private City city;
    private int houseNumber;

    public Address(City city, int houseNumber) {
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return houseNumber == address.houseNumber && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
