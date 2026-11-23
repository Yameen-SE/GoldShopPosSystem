import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Customer[] C = new Customer[15];
        Category[] A = new Category[15];

        int U = -1;
        int V = -1;

        int customerID = 0;
        int categoryID = 0;

        while (true) {

            try {

                System.out.println("===== GOLD SHOP POS SYSTEM =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Display Customers");
                System.out.println("3. Add Category");
                System.out.println("4. Display Categories");
                System.out.println("5. Exit");

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
