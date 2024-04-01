import java.time.LocalDate;
import java.util.Objects;

public class StandartClient extends Client{

    boolean wasOnceInactive;

    public StandartClient(String name, String surname, LocalDate birthDate, Address address, boolean wasOnceInactive) {
        super(name, surname, birthDate, address);
        this.wasOnceInactive = wasOnceInactive;
    }


    public boolean isWasOnceInactive() {
        return wasOnceInactive;
    }

    public void setWasOnceInactive(boolean wasOnceInactive) {
        this.wasOnceInactive = wasOnceInactive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandartClient that)) return false;
        if (!super.equals(o)) return false;
        return wasOnceInactive == that.wasOnceInactive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wasOnceInactive);
    }

    @Override
    public String toString() {
        return "StandartClient{" +
                "wasOnceInactive=" + wasOnceInactive +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", needMedicalInsurance=" + needMedicalInsurance +
                '}';
    }

    @Override
    int calculateClientPresent() {
        if (isWasOnceInactive()) {
            return 50;
        } else {
            return 100;
        }
    }
}













