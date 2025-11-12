import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Product> products;

    public InventoryManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int productID) {
        return products.removeIf(p -> p.getProductID() == productID);
    }

    public Product searchProductByID(int productID) {
        for (Product p : products) {
            if (p.getProductID() == productID) {
                return p;
            }
        }
        return null;
    }

    public boolean updateProduct(int productID, String name, double price, int quantity, String category) {
        Product product = searchProductByID(productID);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCategory(category);
            return true;
        }
        return false;
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product product : products) {
            product.displayProduct();
            System.out.println("----------------");
        }
    }
}
