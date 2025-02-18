package a2025_02_17_Atividade1;

public class Stove extends Product {
    private int burners;

    public Stove(String brand, double price, int burners) {
        super(brand, price);
        this.burners = burners;
    }

    public int getBurners() {
        return burners;
    }
}