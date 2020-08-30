import java.util.List;

/**
 * Created by PC on 19.08.2020.
 */

enum type{
    SALE,
    SALE_ANNUL,
    REFUND,
    OUTFLOW,
    OUTFLOW_REFUND
}

public class data {
    String id;
    private type type;
    private String amount;
    private String discount;
    private String deviceId;
    private String shopId;
    private String operationId;
    private String shiftId;
    private String number;
    private String depth;
    private String localDate;
    private String date;
    private List<payments> payments;
    private List <positions> positions;
    private cashier cashier;
    private String checkURL;
    private String fiscalDocumentNumber;
    private String fiscalDocumentSign;
    private String fnNumber;
    private String registryNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<payments> getPayments() {
        return payments;
    }

    public void setPayments(List<payments> payments) {
        this.payments = payments;
    }

    public List<positions> getPositions() {
        return positions;
    }

    public void setPositions(List<positions> positions) {
        this.positions = positions;
    }

    public cashier getCashier() {
        return cashier;
    }

    public void setCashier(cashier cashier) {
        this.cashier = cashier;
    }

    public String getCheckURL() {
        return checkURL;
    }

    public void setCheckURL(String checkURL) {
        this.checkURL = checkURL;
    }

    public String getFiscalDocumentNumber() {
        return fiscalDocumentNumber;
    }

    public void setFiscalDocumentNumber(String fiscalDocumentNumber) {
        this.fiscalDocumentNumber = fiscalDocumentNumber;
    }

    public String getFiscalDocumentSign() {
        return fiscalDocumentSign;
    }

    public void setFiscalDocumentSign(String fiscalDocumentSign) {
        this.fiscalDocumentSign = fiscalDocumentSign;
    }

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }
}
