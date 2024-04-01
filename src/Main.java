import java.time.LocalDate;

//        Создать вип клиент
//        Создать 2 стандартных
//        Посчитать сумму подарка для стандартног клиента
//        Посчитать сумму подарка для  вип клиента
//        Вип клиент оплатил 01 января  2024 1000
//        Вип клиент оплатил 15 марта 2024 1000
//        Стандартный  клиент оплатил 15 декабря  2022 500
//        Стандартный  клиент оплатил 19 декабря  2022 500
//        Должник ли вип клиент?
//        Должник ли стандартный клиент?
//        Может ли списать долги аип клиенту?
//        Может ли списать долги стандартному клиенту?
//        Создать сотрудника
//        Нужна ли страховка сотруднику?
//        Нужна ли страховка вип клиенту?
//        Нужна ли страховка стандартному клиенту?
public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(City.LONDON, 10);
        Address address2 = new Address(City.BERLIN, 22);
        Address address3 = new Address(City.BERLIN, 14);
        VipClient vipClient= new VipClient ("Gleb", "Ivanov", LocalDate.of(1981,12,22),address1,false);
        StandartClient standartClient= new StandartClient("Oleg", "Petrov", LocalDate.of(1956,3, 12),address2,false);
        StandartClient standartClient2= new StandartClient ("Valentin", "Semenov", LocalDate.of(1950,6,12),address3, true);
        System.out.println(vipClient.toString() + ", " + address1.toString());
        System.out.println(standartClient.toString() + ", " + address2.toString());
        System.out.println(standartClient2.toString() + ", " + address3.toString());
        int presentAmount = standartClient.calculateClientPresent();
        System.out.println("Подарок для стандартного клиента: " + presentAmount);
        int presentAmount1 = standartClient2.calculateClientPresent();
        System.out.println("Подарок для стандартного клиента2: " + presentAmount);
        int presentAmount3 = vipClient.calculateClientPresent();
        System.out.println("Подарок для випклиента: " + presentAmount);
        PaidCard.paidMoney.put(LocalDate.of(2024, 1, 1), 1000);
        PaidCard.paidMoney.put(LocalDate.of(2024, 3, 15), 1000);
        PaidCard.paidMoney.put(LocalDate.of(2022, 12, 15), 500);
        PaidCard.paidMoney.put(LocalDate.of(2022, 12, 19), 500);
        DebtService debtService = new DebtService();
        boolean isVipDebtor = debtService.isDebtorByCard(ClientType.VIP, PaidCard.getPaidMoney());
        System.out.println(vipClient+ " должник " +isVipDebtor);
        boolean isStandardDebtor = debtService.isDebtorByCard(ClientType.STANDARD, PaidCard.getPaidMoney());
        System.out.println(standartClient+ " должник " +isStandardDebtor);
        System.out.println(standartClient2+ " должник " +isStandardDebtor);
        boolean cancelDebtForVIP = debtService.cancelDebts(vipClient, PaidCard.getPaidMoney());
        System.out.println(vipClient+ " списание долгов " +cancelDebtForVIP);
        boolean cancelDebtForStandard = debtService.cancelDebts(standartClient, PaidCard.getPaidMoney());
        System.out.println(standartClient+ " списание долгов " +isVipDebtor);
        System.out.println(standartClient2+ " списание долгов " +isVipDebtor);
        Address address4 = new Address(City.LONDON, 5);
        Employee employee= new Employee("Петр", "Иванов",address4, LocalDate.of(2000, 1,1));
        System.out.println(employee.toString() + ", " + address1.toString());
        HumanResources hr = new HumanResourcesImpl();
        boolean isEmployeeInsured = hr.needMedicalInsurance(employee);
        System.out.println("Нужна ли медицинская страховка для работника? " + isEmployeeInsured);
        boolean isVipClientInsured = hr.needMedicalInsurance(vipClient);
        System.out.println("Нужна ли медицинская страховка для випклиента? " + isVipClientInsured);
        boolean isStandardClientInsured = hr.needMedicalInsurance(standartClient);
        System.out.println("Нужна ли медицинская страховка для клиента1 " + isStandardClientInsured);
        System.out.println("Нужна ли медицинская страховка для клиента2 " + isStandardClientInsured);

    }
        }







