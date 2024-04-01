import java.time.LocalDate;
import java.util.HashMap;

public class DebtService {

    public boolean isDebtorByCard(ClientType type, HashMap<LocalDate, Integer> paidMoney) {
        if (type == ClientType.VIP && paidMoney.containsKey(LocalDate.now().minusDays(90))) {
            return true;
        } else if (type == ClientType.STANDARD && paidMoney.containsKey(LocalDate.now().minusDays(30))) {
            return true;
        }
        return false;
    }

    public boolean cancelDebts(Client client, HashMap<LocalDate, Integer> paidMoney) {
        LocalDate today = LocalDate.now();
        Integer currentPaymentAmount = paidMoney.get(today);
        Integer previousPaymentAmount = paidMoney.get(today.minusDays(1));
        if (client.isActive() && currentPaymentAmount > 2 * previousPaymentAmount) {
            return true;
        }
        return false;
    }
}


