import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee implements HumanResources {
    final String name;
    final String surname;
    private Address homeAddress;
    private LocalDate birthDate;

    public Employee(String name, String surname, Address homeAddress, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.homeAddress = homeAddress;
        this.birthDate = birthDate;

    }
        public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(homeAddress, employee.homeAddress) && Objects.equals(birthDate, employee.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, homeAddress, birthDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", homeAddress=" + homeAddress +
                ", birthDate=" + birthDate +
                '}';
    }


    @Override
    public boolean needMedicalInsurance(Employee employee) {
        LocalDate birthDate = employee.getBirthDate();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        if (age > 35) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean needMedicalInsurance(Client client) {
        return false;
    }


}
