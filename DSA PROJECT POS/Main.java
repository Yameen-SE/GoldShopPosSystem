import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Customer[] C = new Customer[15];
        Category[] A = new Category[15];
        Item[] Ite = new Item[15];
        Inventory[] Inv = new Inventory[15];

        int U = -1;
        int V = -1;
        int W = -1;
        int X = -1;

        int customerID = 0;
        int categoryID = 0;
        int itemID = 0;
        int inventoryID = 0;

        while (true) {

            try {

                System.out.println("===== GOLD SHOP POS SYSTEM =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Display Customers");
                System.out.println("3. Add Category");
                System.out.println("4. Display Categories");
                System.out.println("5. Add Item");
                System.out.println("6. Display Items");
                System.out.println("7. Add Inventory");
                System.out.println("8. Display Inventory");
                System.out.println("9. Exit"); 

                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();
                
                if (choice == 1) {
                
                    if (U == C.length - 1) {

                        System.out.println("Customer Array is Full");

                    }
                    else {

                        System.out.print("Enter Customer Name: ");
                        String name = input.nextLine();

                        if (name.length() < 3) {
                            throw new IllegalArgumentException("Name must contain at least 3 characters.");
                        }

                        if (!name.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("Name cannot contain numbers or symbols.");
                        }

                        System.out.print("Enter Phone Number: ");
                        String phone = input.nextLine();

                        if (phone.length() != 11) {
                            throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
                        }

                        if (!phone.matches("[0-9]{11}")) {
                            throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
                        }

                        System.out.print("Enter Address: ");
                        String address = input.nextLine();

                        U = U + 1;

                        C[U] = new Customer(customerID, name, phone, address);

                        customerID++;

                        System.out.println("Customer Inserted Successfully!");
                    }
                }
                
                else if (choice == 2) {

                    if (U == -1) {

                        System.out.println("No Customers Available");

                    }
                    else {

                        System.out.println("===== CUSTOMER RECORDS =====");

                        for (int i = 0; i <= U; i++) {

                            C[i].displayCustomer();
                            System.out.println("--------------------");
                        }
                    }
                }
                
                else if (choice == 3) {

                    if (V == A.length - 1) {

                        System.out.println("Category Array is Full");
                    }
                    else {
                        System.out.print("Enter Category Name: ");
                        String name = input.nextLine();

                        if (name.length() < 3) {
                            throw new IllegalArgumentException("Name must contain at least 3 characters.");
                        }

                        if (!name.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("Name cannot contain numbers or symbols.");
                        }

                        V = V + 1;

                        A[V] = new Category(categoryID, name);

                        categoryID++;

                        System.out.println("Category Inserted Successfully!");
                    }
                }
                
                else if (choice == 4) {

                    if (V == -1) {

                        System.out.println("No Categories Available");

                    }
                    else {

                        System.out.println("===== CATEGORY RECORDS =====");

                        for (int i = 0; i <= V; i++) {

                            A[i].displayCategory();
                            System.out.println("--------------------");
                        }
                    }
                }

                else if (choice == 5) {

                    if (W == Ite.length - 1) {

                        System.out.println("Item Array is Full");

                    }
                    else if (V == -1) {

                        System.out.println("Please Add a Category First");

                    }
                    else {

                        System.out.print("Enter Item Name: ");
                        String name = input.nextLine();

                        if (name.length() < 3) {
                            throw new IllegalArgumentException("Item Name must contain at least 3 characters.");
                        }

                        if (!name.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("Item Name cannot contain numbers or symbols.");
                        }

                        System.out.println("===== AVAILABLE CATEGORIES =====");

                        for (int i = 0; i <= V; i++) {

                            A[i].displayCategory();
                            System.out.println("--------------------");
                        }

                        System.out.print("Enter Category ID: ");
                        int catID = input.nextInt();
                        input.nextLine();

                        boolean found = false;

                        for (int i = 0; i <= V; i++) {

                            if (A[i].CategoryID == catID) {

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            throw new IllegalArgumentException("Invalid Category ID.");
                        }

                        System.out.print("Enter Gold Purity (22K / 21K / 18K): ");
                        String purity = input.nextLine();

                        if (!purity.matches("(22K|21K|18K)")) {
                            throw new IllegalArgumentException("Invalid Gold Purity.");
                        }

                        System.out.print("Enter Weight in Grams: ");
                        double weight = input.nextDouble();
                        input.nextLine();

                        if (weight <= 0) {
                            throw new IllegalArgumentException("Weight must be greater than zero.");
                        }

                        System.out.print("Enter Price: ");
                        double price = input.nextDouble();
                        input.nextLine();

                        if (price <= 0) {
                            throw new IllegalArgumentException("Price must be greater than zero.");
                        }

                        W = W + 1;

                        Ite[W] = new Item(itemID, name, catID, purity, weight, price);

                        itemID++;

                        System.out.println("Item Inserted Successfully!");
                    }
                }

                else if (choice == 6) {

                    if (W == -1) {

                        System.out.println("No Items Available");

                    }
                    else {

                        System.out.println("===== ITEM RECORDS =====");

                        for (int i = 0; i <= W; i++) {

                            Ite[i].displayItem();
                            System.out.println("--------------------");
                        }
                    }
                }

                else if (choice == 7) {

                    if (X == Inv.length - 1) {

                        System.out.println("Inventory Array is Full");

                    }
                    else if (W == -1) {

                        System.out.println("Please Add an Item First");

                    }
                    else {

                        System.out.println("===== AVAILABLE ITEMS =====");

                        for (int i = 0; i <= W; i++) {

                            Ite[i].displayItem();
                            System.out.println("--------------------");
                        }

                        System.out.print("Enter Item ID: ");
                        int selectedItemID = input.nextInt();
                        input.nextLine();

                        boolean found = false;

                        for (int i = 0; i <= W; i++) {

                            if (Ite[i].ItemID == selectedItemID) {

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            throw new IllegalArgumentException("Invalid Item ID.");
                        }

                        System.out.print("Enter Stock Quantity: ");
                        int stockLeft = input.nextInt();
                        input.nextLine();

                        if (stockLeft <= 0) {
                            throw new IllegalArgumentException("Stock must be greater than zero.");
                        }

                        X = X + 1;

                        Inv[X] = new Inventory(inventoryID, selectedItemID, stockLeft);

                        inventoryID++;

                        System.out.println("Inventory Inserted Successfully!");
                    }
                }

                else if (choice == 8) {

                    if (X == -1) {

                        System.out.println("No Inventory Available");

                    }
                    else {

                        System.out.println("===== INVENTORY RECORDS =====");

                        for (int i = 0; i <= X; i++) {

                            Inv[i].displayInventory();
                            System.out.println("--------------------");
                        }
                    }
                }
                
                else if (choice == 9) {

                    System.out.println("Thank You for Using Gold Shop POS!");
                    break;

                }

                else {

                    System.out.println("Invalid Choice! Try Again.");

                }
            }

            catch (InputMismatchException e) {

                System.out.println("Error: Please enter numbers only for menu choice.");

                input.nextLine();

            }

            catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }
        }

        input.close();
    }
}
