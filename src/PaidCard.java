import java.time.LocalDate;
import java.util.HashMap;

public class PaidCard {
    static HashMap<LocalDate, Integer> paidMoney= new HashMap<>();
    private static ClientType type;

    public static HashMap<LocalDate, Integer> getPaidMoney() {
        return paidMoney;
    }

    public static void setPaidMoney(HashMap<LocalDate, Integer> paidMoney) {
        PaidCard.paidMoney = paidMoney;
    }

    public static ClientType getType() {
        return type;
    }

    public static void setType(ClientType type) {
        PaidCard.type = type;
    }

    static void payMoney (ClientType type, int amount) {
         if (type== ClientType.VIP && amount==1000) {
             paidMoney.put(LocalDate.now(), amount);
        } else if (type == ClientType.STANDARD&& amount==500) {
             paidMoney.put(LocalDate.now(),amount);
         }


        }
    }







