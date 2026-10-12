package At1;

import java.util.ArrayList;

public class At1 {
    
    public static void main(String[] args) {

        //Declarando o vendedor e comprador como Pessoa
        Pessoa comprador = new cliente(10, 0);
        comprador.setNome("Cleber");

        Pessoa vendedor = new clt(5, 5);
        vendedor.setNome("Claudio");
        ((clt)vendedor).setPreco(3);

        ArrayList<Pessoa> comerciantes = new ArrayList<>();
        comerciantes.add(comprador);
        comerciantes.add(vendedor);



        //Momento da compra de uma camiseta
        ((clt)vendedor).vender((cliente)comprador, 2);

        //chama a função nota, diferente para cada um dos dois pelo override na herança, 
        //mas pelo mesmo array pelo polimorfismo
        for (Pessoa c : comerciantes) {
            System.out.println(c.nota());
        }

    }

}
