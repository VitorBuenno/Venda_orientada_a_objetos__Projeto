package At1;

/**
 * Padrão: Factory Method
 * Problema: Caso a loja ganhe novos papeis, a interface teria que ser alterada manualmente.
 * 
 * Solução: Uma classe assume a responsabilidade de instanciar os objetos (Factiory).
 * Quem chama a fábrica recebe o tipo mais genérico (Pessoa) por polimorfismo
 * 
 * Benefício: A tela interage de forma genérica. Adicionar novos tipos altera apenas a fábrica em um único lugar, 
 * sem tocar nas interfaces gráficas
 * 
 * Custo: Além de aumentar uma classe, deixa o código mais dificil de ser lido, já que as classes não são chamadas diretamente
 */
public class FactoryPessoa {
    
    public static Pessoa criar(String tipo, String nome, int moedas, int camisetas) {
        Pessoa p;
        if (tipo.equalsIgnoreCase("Cliente")) {
            p = new cliente(moedas, camisetas);
        } else if (tipo.equalsIgnoreCase("Vendedor")) {
            p = new clt(moedas, camisetas);
        } else {
            throw new IllegalArgumentException("Tipo de pessoa desconhecido pela fábrica.");
        }
        p.setNome(nome);
        return p;
    }
}