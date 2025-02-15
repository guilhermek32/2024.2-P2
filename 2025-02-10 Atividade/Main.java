public class Main {
    public static void main(String[] args) {
        Product chocolate = new Product("chocolate", 7.00);
        Product leite = new Product("leite", 12.50);
        Product pao = new Product("pão", 3.00);
        Product arroz = new Product("arroz", 20.00);

        ShoppingCart cart = new ShoppingCart(123);
        cart.addProduct(chocolate);
        cart.addProduct(leite);
        cart.addProduct(pao);
        cart.addProduct(arroz);

        System.out.println("Conteúdo do carrinho:");
        System.out.println(cart.getContents());
        System.out.println("Total de Itens: " + cart.getItemCount());
        System.out.printf("Preço Total: R$%.2f%n", cart.getTotalPrice());
    }
}