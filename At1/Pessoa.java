package At1;


public class Pessoa {

    //Protected para poder ser acessado por filhos
    protected String nome;
    protected int moedas;
    protected int camisetas;

    public Pessoa (int moedas, int camisetas){
        this.moedas = moedas;
        this.camisetas = camisetas;
    }

    public String getNome(){
        return nome;
    }

    public int getMoedas(){
        return moedas;
    }

    public int getCamisetas(){
        return camisetas;
    }

    public void setNome (String n){
        nome = n;
    }

    //Metodo padrão para subtrair moedas
    public void subMoedas(int p, int qtd){
        if ((p*qtd) <= moedas){
            moedas = moedas - (p*qtd);
        } else {
            // Substituição de um antigo print para a interface
            throw new IllegalArgumentException("Erro: Sem moedas");
        }
    }

    //Metodo padrão para acrescentar camisetas
    public void addCamisetas(int qtd){
        if (qtd>=0 && qtd<11 ){   
            camisetas = camisetas + qtd;
        } else {
            throw new IllegalArgumentException("Erro: Quantidade invalida de camisetas");
        }
    }
    //Metodo padrão para diminuir camisetas
    public void subCamisetas(int c){
        if (c<6 && c>0 ){   
            camisetas = camisetas - c;
        } else {
            throw new IllegalArgumentException("Erro: Quantidade invalida de camisetas");
        }
    }

    void comprar (int preco, int qtd){
        addCamisetas(qtd);
        subMoedas(preco, qtd);
    }

    //Metodo padrão para saída de informações
    public String nota(){
        return nome + " possui " + camisetas + " camisetas " +
        " e " + moedas + " moedas";
    }

}

class clt extends Pessoa {
    
    protected int preco;

    //Inicialização da subclasse com um preço padrão para caso não seja declarado
    public clt(int moedas, int camisetas){
        super(moedas, camisetas);
        this.preco = 3;
    }

    //Funções unicas dessa classe, já que envolvem a variavel unica "Preço"
    public int getPreco(){
        return preco;
    }

    public void setPreco (int p){
        preco = p;
    }

    public void addMoedas(int qtd){
        if (moedas<15 && moedas>=0 ){
            moedas = moedas + (preco * qtd);
        } else {
            throw new IllegalArgumentException("Erro: Mais moedas que o permitido");
        }
    }

    void vender(cliente alvo, int qtd){
        
        if (alvo.getMoedas() >= preco*qtd && camisetas >= qtd){
            alvo.comprar(preco, qtd);
            addMoedas(qtd);
            subCamisetas(qtd);
        } else {
            throw new IllegalArgumentException("Erro: O cliente não possui saldo ou o vendedor não possui estoque");
        }
    }

    //Override da função já existente, chamando ela mesma e acrescentando a nova informação de classe
    @Override 
    public String nota(){
        return super.nota() + ". Atualmente suas camisetas possuem o valor de " + preco + " Moedas ";
    }
}

class cliente extends Pessoa{

    public cliente(int moedas, int camisetas){
        super(moedas, camisetas);
    }

}