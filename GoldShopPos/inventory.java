public class inventory{

    private int inventoryId;
    private int itemId;
    private int stockIn;
    private int stockLeft;

    public inventory() {
    }

    public inventory(int inventoryId, int itemId, int stockIn, int stockLeft) {
        this.inventoryId = inventoryId;
        this.itemId = itemId;
        this.stockIn = stockIn;
        this.stockLeft = stockLeft;
    }
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }
}
