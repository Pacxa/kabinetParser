import java.util.List;

/**
 * Created by PC on 19.08.2020.
 */

enum typePos{
    COUNTABLE,
    SCALABLE,
    SHOES,
    CLOTHES,
    SERVICES,
    TOBACCO,
    ALCOHOL
}

enum tax{
    NDS_NO_TAX,
    NDS_0,
    NDS_10,
    NDS_20,
    NDS_10_CALCULATED,
    NDS_20_CALCULATED
}

public class positions {
    private String id;
    private String name;
    private typePos type;
    private String quantity;
    private String price;
    private String amount;
    private List<String> discounts;
    private String discount;
    private String barcode;
    private String exciseBarcode;
    private String vendorCode;
    private tax tax;
    private String departmentId;

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public typePos getType() {
        return type;
    }

    public void setType(typePos type) {
        this.type = type;
    }

    public String getQuantity() {
        return  quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<String> getDiscounts() { return discounts;}

    public void setDiscounts(List<String> discounts) {
        this.discounts = discounts;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExciseBarcode() {
        return exciseBarcode;
    }

    public void setExciseBarcode(String exciseBarcode) {
        this.exciseBarcode = exciseBarcode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public tax getTax() {
        return tax;
    }

    public void setTax(tax tax) {
        this.tax = tax;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
