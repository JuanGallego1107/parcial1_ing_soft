import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class representing a product
class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Class representing the inventory
class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Method to add a new product to the inventory
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Method to update the quantity of a product in the inventory
    public void updateQuantity(int productId, int newQuantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
        } else {
            System.out.println("Product with ID " + productId + " does not exist in the inventory.");
        }
    }

    // Method to remove a product from the inventory
    public void removeProduct(int productId) {
        products.remove(productId);
    }

    // Method to generate a report on the state of the inventory
    public void generateReport() {
        System.out.println("Inventory:");
        for (Product product : products.values()) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }
}

public class Ejercicio3_imperativa {
    public static void main(String[] args) {
        // Create an inventory
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // Menu of options
        int option;
        do {
            System.out.println("\n=== Inventory Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. Generate Inventory Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter the product quantity: ");
                    int productQuantity = scanner.nextInt();
                    inventory.addProduct(new Product(productId, productName, productQuantity));
                    System.out.println("Product added to the inventory.");
                    break;
                case 2:
                    System.out.print("Enter the ID of the product to update: ");
                    int productIdToUpdate = scanner.nextInt();
                    System.out.print("Enter the new quantity of the product: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(productIdToUpdate, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter the ID of the product to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    inventory.removeProduct(productIdToRemove);
                    break;
                case 4:
                    inventory.generateReport();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (option != 5);

        scanner.close();
    }
}
