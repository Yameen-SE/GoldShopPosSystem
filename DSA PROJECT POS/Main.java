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

                        for (int i = 0; i < name.length(); i++) {

                            char ch = name.charAt(i);

                            if (!Character.isLetter(ch) && ch != ' ') {
                                throw new IllegalArgumentException("Name cannot contain numbers or symbols.");
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
                     for (int i = 0; i < name.length(); i++) {

                        char ch = name.charAt(i);

                        if (!Character.isLetter(ch) && ch != ' ') {
                            throw new IllegalArgumentException("Name cannot contain numbers or symbols.");
                         }
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
