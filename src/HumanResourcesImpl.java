import java.time.LocalDate;
import java.time.Period;

public class HumanResourcesImpl implements HumanResources {

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