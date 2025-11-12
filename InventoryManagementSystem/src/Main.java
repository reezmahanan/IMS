import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Add some sample products initially
        inventory.addProduct(new Product(1, "Laptop", 220000.0, 10, "Electronics"));
        inventory.addProduct(new Product(2, "Chair", 1500.0, 20, "Furniture"));
        inventory.addProduct(new Product(3, "Smartphone", 85000.0, 15, "Electronics"));

        do {
            System.out.println("\n=== INVENTORY MANAGEMENT SYSTEM ===");
            System.out.println("1. Display All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Display all products
                    System.out.println("\n--- ALL PRODUCTS IN INVENTORY ---");
                    inventory.displayInventory();
                    break;

                case 2:
                    // Add new product
                    System.out.println("\n--- ADD NEW PRODUCT ---");
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    Product newProduct = new Product(id, name, price, quantity, category);
                    inventory.addProduct(newProduct);
                    System.out.println("✅ Product added successfully!");
                    break;

                case 3:
                    // Search product by ID
                    System.out.println("\n--- SEARCH PRODUCT BY ID ---");
                    System.out.print("Enter Product ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Product foundProduct = inventory.searchProductByID(searchId);
                    if (foundProduct != null) {
                        System.out.println("\n🎯 Product Found:");
                        foundProduct.displayProduct();
                    } else {
                        System.out.println("❌ Product with ID " + searchId + " not found!");
                    }
                    break;

                case 4:
                    // Update product
                    System.out.println("\n--- UPDATE PRODUCT ---");
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    // Check if product exists
                    Product existingProduct = inventory.searchProductByID(updateId);
                    if (existingProduct != null) {
                        System.out.println("Current Product Details:");
                        existingProduct.displayProduct();

                        System.out.print("\nEnter New Product Name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter New Price: ");
                        double newPrice = scanner.nextDouble();

                        System.out.print("Enter New Quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter New Category: ");
                        String newCategory = scanner.nextLine();

                        boolean updated = inventory.updateProduct(updateId, newName, newPrice, newQuantity, newCategory);
                        if (updated) {
                            System.out.println("✅ Product updated successfully!");
                        } else {
                            System.out.println("❌ Failed to update product!");
                        }
                    } else {
                        System.out.println("❌ Product with ID " + updateId + " not found!");
                    }
                    break;

                case 5:
                    // Remove product
                    System.out.println("\n--- REMOVE PRODUCT ---");
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = inventory.removeProduct(removeId);
                    if (removed) {
                        System.out.println("✅ Product removed successfully!");
                    } else {
                        System.out.println("❌ Product with ID " + removeId + " not found!");
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Thank you for using Inventory Management System! 👋");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please enter a number between 1-6.");
            }

            // Add a pause between menu displays
            if (choice != 6) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 6);

        scanner.close();
    }
}