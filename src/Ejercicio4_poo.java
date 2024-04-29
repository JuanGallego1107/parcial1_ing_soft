import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa un Shopproducto
class ShopProduct {
    private int id;
    private String name;
    private double price;

    public ShopProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Clase que representa un carrito de compras
class ShoppingCart {
    private List<ShopProduct> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    // Método para agregar un Shopproducto al carrito
    public void addShopProduct(ShopProduct Shopproduct) {
        products.add(Shopproduct);
    }

    // Método para calcular el total de la compra
    public double calculateTotal() {
        double total = 0;
        for (ShopProduct Shopproduct : products) {
            total += Shopproduct.getPrice();
        }
        return total;
    }

    // Método para ver los Shopproductos en el carrito
    public void viewCart() {
        System.out.println("\n=== Shopping Cart ===");
        if (products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (ShopProduct Shopproduct : products) {
                System.out.println("ID: " + Shopproduct.getId() + ", Name: " + Shopproduct.getName() + ", Price: $" + Shopproduct.getPrice());
            }
            System.out.println("Total: $" + calculateTotal());
        }
    }

    // Método para realizar el pago
    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty. Cannot proceed to checkout.");
        } else {
            System.out.println("Checkout successful. Total amount charged: $" + calculateTotal());
            products.clear(); // Vaciar el carrito después de realizar el pago
        }
    }
}

// Clase principal que representa la tienda en línea
public class Ejercicio4_poo {
    public static void main(String[] args) {
        // Crear algunos Shopproductos
        ShopProduct Shopproduct1 = new ShopProduct(1, "Laptop", 999.99);
        ShopProduct Shopproduct2 = new ShopProduct(2, "Smartphone", 599.99);
        ShopProduct Shopproduct3 = new ShopProduct(3, "Tablet", 299.99);

        // Crear un carrito de compras
        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        int option;
        do {
            System.out.println("\n=== Online Store Menu ===");
            System.out.println("1. Add ShopProduct to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Agregar Shopproducto al carrito
                    addShopProductToCart(cart, Shopproduct1); // Aquí puedes pasar cualquier Shopproducto que desees agregar al carrito
                    break;
                case 2:
                    // Ver el contenido del carrito
                    cart.viewCart();
                    break;
                case 3:
                    // Realizar el pago
                    cart.checkout();
                    break;
                case 4:
                    System.out.println("Exiting the Online Store...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (option != 4);

        scanner.close();
    }

    // Método para agregar un Shopproducto al carrito
    private static void addShopProductToCart(ShoppingCart cart, ShopProduct Shopproduct) {
        cart.addShopProduct(Shopproduct);
        System.out.println(Shopproduct.getName() + " added to cart.");
    }
}
