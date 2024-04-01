import java.time.LocalDate;
import java.util.Objects;

public class VipClient extends Client {
    private boolean satisfied;

    public VipClient(String name, String surname, LocalDate birthDate, Address address, boolean satisfied) {
        super(name, surname, birthDate, address);
        this.satisfied = satisfied;
    }

        public boolean isSatisfied() {
        return satisfied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VipClient vipClient)) return false;
        if (!super.equals(o)) return false;
        return satisfied == vipClient.satisfied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), satisfied);
    }

    @Override
    public String toString() {
        return "VipClient{" +
                "satisfied=" + satisfied +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", needMedicalInsurance=" + needMedicalInsurance +
                '}';
    }


    @Override
    int calculateClientPresent() {
        if (!isSatisfied()) {
            return 200;
        } else {
            return 100;
        }
    }
}







