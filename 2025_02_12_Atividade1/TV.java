package a2025_02_17_Atividade1;

public class TV extends Product {
    private int inches;

    public TV(String brand, double price, int inches) {
        super(brand, price);
        this.inches = inches;
    }

    public int getInches() {
        return inches;
    }
}