public class Category {

    int CategoryID;
    String CategoryName;
    
 public Category(int CategoryID, String CategoryName) {

        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
    }
    
 public void displayCategory() {

        System.out.println("Category ID: " + CategoryID);
        System.out.println("Category Name: " + CategoryName);
    }
}
