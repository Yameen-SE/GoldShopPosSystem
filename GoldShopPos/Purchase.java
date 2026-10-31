import java.util.Date;

public class Purchase {

    private int purchaseId;
    private int itemId;
    private Date purchaseDate;
    private String supplierName;
    private int quantity;
    private double cost;

    public Purchase() {
    }

    public Purchase(int purchaseId, int itemId, Date purchaseDate,
                    String supplierName, int quantity, double cost) {
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.purchaseDate = purchaseDate;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
