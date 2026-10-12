package At1;

/**
 * Padrão: Singleton
 * Problema: A tela de vendas precisa de um vendedor fixo com seu estoque e moedas.
 * Se cada interação der um new CLT, a loja vai perder todo o histórico e ter dados que divergem
 * 
 * Solução: Uma classe com construtor privado e um método getInstance() que retorna sempre a mesma e única instância do objeto
 * 
 * Benefício: A existencia de um unico vendedor é garantida pela classe e fornece um acesso global para qualquer tela do sistema
 * Custo: É um acesso global, o que acopla dependências e dificulta testes, já que o estado sobrevive a múltiplas execuções
 */
public class LojaSingleton {
    private static LojaSingleton instancia;
    private clt vendedorAtual;

    private LojaSingleton() {
        // Inicializa o vendedor padrao
        vendedorAtual = new clt(5, 5);
        vendedorAtual.setNome("Claudio");
        vendedorAtual.setPreco(3);
    }

    public static LojaSingleton getInstance() {
        if (instancia == null) {
            instancia = new LojaSingleton();
        }
        return instancia;
    }

    public clt getVendedor() {
        return vendedorAtual;
    }
}