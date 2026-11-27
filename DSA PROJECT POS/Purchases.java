public class Purchases {

    int PurchaseID;
    int ItemID;
    String PurchaseDate;
    String SupplierName;
    int Quantity;
    double Cost;

    public Purchases(int PurchaseID, int ItemID, String PurchaseDate, String SupplierName, int Quantity, double Cost) {

        this.PurchaseID = PurchaseID;
        this.ItemID = ItemID;
        this.PurchaseDate = PurchaseDate;
        this.SupplierName = SupplierName;
        this.Quantity = Quantity;
        this.Cost = Cost;
    }
}
