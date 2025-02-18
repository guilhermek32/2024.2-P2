import a2025_02_17_Atividade1.*;

public class Main {
    public static void main(String[] args) {
        Stove stove = new Stove("Brastemp", 1500.00, 6);
        TV tv = new TV("Samsung", 5000.00, 55);
        Refrigerator refrigerator = new Refrigerator("Electrolux", 3000.00, 500);

        ShoppingCart cart = new ShoppingCart(111);

        cart.addProduct(stove);
        cart.addProduct(tv);
        cart.addProduct(refrigerator);

        System.out.println();

        System.out.println("Conteúdo do carrinho:");
        System.out.println(cart.getContents());
        System.out.println("Total de Itens: " + cart.getItemCount());
        System.out.println("Preço Total: " + cart.getTotalPrice());
        System.out.println("ID do Cliente: " + cart.getCustomerID());
        System.out.println();
        System.out.println("Preco da Tv " + tv.getBrand() + ": R$" + tv.getPrice() + " Tamanho em Polegadas: " + tv.getInches());
        System.out.println("Preco da Geladeira " + refrigerator.getBrand() + ": R$" + refrigerator.getPrice() + " Tamanho em Litros: " + refrigerator.getSize());
        System.out.println("Preco do Fogão " + stove.getBrand() + ": R$" + stove.getPrice() + " Quantidade de Bocas: " + stove.getBurners());

    }
}