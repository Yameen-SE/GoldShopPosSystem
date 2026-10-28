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
}