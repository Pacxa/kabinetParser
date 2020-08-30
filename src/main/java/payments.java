/**
 * Created by PC on 19.08.2020.
 */

enum typeP{
    CASH,
    CASHLESS,
    PREPAID,
    CREID,
    CONSIDERATION
}

public class payments {
    private typeP type;
    private String amount;

    public typeP getType() {
        return type;
    }

    public void setType(typeP type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
