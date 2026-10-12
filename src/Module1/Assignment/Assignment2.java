package Module1.Assignment;

import java.util.*;

abstract class Product {
    private final int id;
    private final String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        if (id <= 0 || name == null || name.trim().isEmpty()
                || price < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product details.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void update(double price, int quantity) {
        if (price < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid price or quantity.");
        }
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Category: %s | Name: %s | Price: Rs. %.2f | Quantity: %d | Total: Rs. %.2f",
                id, getCategory(), name, price, quantity, getTotal()
        );
    }
}

class ClothesProduct extends Product {
    public ClothesProduct(int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getCategory() {
        return "Clothes";
    }
}

class ElectronicProduct extends Product {
    public ElectronicProduct(int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

class ToysProduct extends Product {
    public ToysProduct(int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getCategory() {
        return "Toys";
    }
}

class ShoppingCart {
    private final Map<Integer, Product> products = new TreeMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            System.out.println("Product ID already exists.");
            return;
        }
        products.put(product.getId(), product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(int id) {
        if (products.remove(id) == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Product removed successfully.");
        }
    }

    public void updateProduct(int id, double price, int quantity) {
        Product product = products.get(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        try {
            product.update(price, quantity);
            System.out.println("Product updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }

        double grandTotal = 0;

        System.out.println("\n========== SHOPPING CART ==========");

        for (Product product : products.values()) {
            System.out.println(product);
            grandTotal += product.getTotal();
        }

        System.out.printf("Grand Total: Rs. %.2f%n", grandTotal);
        System.out.println("===================================");
    }
}

public class Assignment2 {
    private static final Scanner sc = new Scanner(System.in);
    private static final ShoppingCart cart = new ShoppingCart();

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Invalid numeric input is handled below.
            }
            System.out.println("Please enter a valid number.");
        }
    }

    private static String readName() {
        while (true) {
            System.out.print("Enter product name: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Product name cannot be empty.");
        }
    }

    private static void addProduct() {
        System.out.println("\n1. Clothes");
        System.out.println("2. Electronics");
        System.out.println("3. Toys");

        int category = readInt("Select category: ");
        if (category < 1 || category > 3) {
            System.out.println("Invalid category.");
            return;
        }

        int id = readInt("Enter product ID: ");
        String name = readName();
        double price = readDouble("Enter price: ");
        int quantity = readInt("Enter quantity: ");

        try {
            Product product;

            switch (category) {
                case 1:
                    product = new ClothesProduct(id, name, price, quantity);
                    break;
                case 2:
                    product = new ElectronicProduct(id, name, price, quantity);
                    break;
                default:
                    product = new ToysProduct(id, name, price, quantity);
            }

            cart.addProduct(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== SHOPPING CART MENU ======");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Show Cart");
            System.out.println("5. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    cart.removeProduct(readInt("Enter product ID to remove: "));
                    break;
                case 3:
                    int id = readInt("Enter product ID to update: ");
                    double price = readDouble("Enter new price: ");
                    int quantity = readInt("Enter new quantity: ");
                    cart.updateProduct(id, price, quantity);
                    break;
                case 4:
                    cart.showCart();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}