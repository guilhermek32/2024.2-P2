package a2025_02_17_Atividade1;
import java.util.ArrayList;


public class ShoppingCart {
    private ArrayList<Product> productList;
    private int customerID;

    public ShoppingCart(int customerID) {
        this.customerID = customerID;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public String getContents() {
        String contents = "";
        for (Product product : productList) {
            contents += product.getBrand() + " ";
        }
        return contents;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemCount() {
        return productList.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }
}