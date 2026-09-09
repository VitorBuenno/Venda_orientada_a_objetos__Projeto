package At1;

public class At1 {
    
    public static void main(String[] args) {

        Cliente comprador = new Cliente(10, 0);
        comprador.setNome("Cleber");

        Clt vendedor = new Clt(5, 5);
        vendedor.setNome("Claudio");
        vendedor.setPreco(3);

        //Momento da compra de uma camiseta
        vendedor.vender(comprador, 2);

        System.out.println("Agora " + vendedor.getNome() + " possui " + vendedor.getMoedas() + " moedas e " + 
            vendedor.getCamisetas() + " camisetas\n");

        System.out.println("Agora " + comprador.getNome() + " possui " + comprador.getMoedas() + " moedas e " + 
            comprador.getCamisetas() + " camisetas\n");
    }

}
