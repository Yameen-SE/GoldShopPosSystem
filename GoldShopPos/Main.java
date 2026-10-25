import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static CategoryDAO categoryDAO = new CategoryDAO();
    static CustomerDAO customerDAO = new CustomerDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Gold Shop Management System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Category");
            System.out.println("3. View Categories");
            System.out.println("4. Update Category");
            System.out.println("5. Delete Category");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1: addCustomer();   break;
                case 2: addCategory();   break;
                case 3: viewCategories(); break;
                case 4: updateCategory(); break;
                case 5: deleteCategory(); break;
                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine().trim();
        System.out.print("Enter Address: ");
        String address = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        Customer customer = new Customer(name, phone, address);
        int id = customerDAO.addCustomer(customer);

        System.out.println(id > 0
                ? "Customer saved! ID: " + id
                : "Customer could not be saved.");
    }

    static void addCategory() {
        System.out.print("Enter Category Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        int id = categoryDAO.addCategory(new Category(name));

        System.out.println(id > 0
                ? "Category saved! ID: " + id
                : "Category could not be saved.");
    }

    static void viewCategories() {
        List<Category> list = categoryDAO.getAllCategories();

        if (list.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }

        System.out.println("\nID\tName");
        System.out.println("----------------");
        for (Category c : list) {
            System.out.println(c.getCategoryId() + "\t" + c.getCategoryName());
        }
    }

    static void updateCategory() {
        System.out.print("Enter Category ID to update: ");
        int id = readInt();
        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        boolean ok = categoryDAO.updateCategory(new Category(id, name));
        System.out.println(ok ? "Category updated." : "Update failed (ID not found?).");
    }

    static void deleteCategory() {
        System.out.print("Enter Category ID to delete: ");
        int id = readInt();

        boolean ok = categoryDAO.deleteCategory(id);
        System.out.println(ok ? "Category deleted." : "Delete failed (ID not found or in use).");
    }

    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
