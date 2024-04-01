import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Client implements HumanResources {
    final String name;
    final String surname;
    final LocalDate birthDate;
    static boolean active;
    private Address address;
    private PaidCard paidCard;
    boolean needMedicalInsurance;

    public Client(String name, String surname, LocalDate birthDate, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaidCard getPaidCard() {
        return paidCard;
    }

    public void setPaidCard(PaidCard paidCard) {
        this.paidCard = paidCard;
    }

    public boolean isNeedMedicalInsurance() {
        return needMedicalInsurance;
    }

    public void setNeedMedicalInsurance(boolean needMedicalInsurance) {
        this.needMedicalInsurance = needMedicalInsurance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return active == client.active && needMedicalInsurance == client.needMedicalInsurance && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(birthDate, client.birthDate) && Objects.equals(address, client.address) && Objects.equals(paidCard, client.paidCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, active, address, paidCard, needMedicalInsurance);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", address=" + address +
                ", paidCard=" + paidCard +
                ", needMedicalInsurance=" + needMedicalInsurance +
                '}';
    }

    int calculateClientPresent() {
        return 0;
    }


    @Override
    public boolean needMedicalInsurance(Employee employee) {
        return false;
    }

    @Override
    public boolean needMedicalInsurance(Client client) {
        LocalDate birthDate = client.getBirthDate();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        if (age > 55 && client.getAddress().equals(City.BERLIN) && client.isActive()) {
            return true;
        } else {
            return false;
        }
    }
}

