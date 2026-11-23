public class Inventory {

    int InventoryID;
    int ItemID;
    int StockLeft;

     public Inventory(int InventoryID, int ItemID, int StockLeft) {
        this.InventoryID = InventoryID;
        this.ItemID = ItemID;
        this.StockLeft = StockLeft;
    } 

     public void displayInventory() {
        System.out.println("Inventory ID: " + InventoryID);
        System.out.println("Item ID: " + ItemID);
        System.out.println("Stock Left: " + StockLeft);
    }
    
}
