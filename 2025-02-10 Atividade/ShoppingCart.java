import java.util.ArrayList;

public class ShoppingCart {
    private int customerID;
    private ArrayList<Product> productList;

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
        StringBuilder contents = new StringBuilder();
        for (Product p : productList) {
            contents.append(p.getName()).append(" - R$").append(String.format("%.2f", p.getPrice())).append("\n");
        }
        return contents.toString();
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemCount() {
        return productList.size();
    }

    public double getTotalPrice() {
        double total = 0.00;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }
}