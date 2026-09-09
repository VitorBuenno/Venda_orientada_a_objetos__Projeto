package At1;

public class Clt{
    private String nome;
    private int moedas;
    private int camisetas;
    private int preco;

    public Clt (int moedas, int camisetas){
        this.moedas = moedas;
        this.camisetas = camisetas;
    }

    public String getNome(){
        return nome;
    }

    public int getMoedas(){
        return moedas;
    }

    public int getPreco(){
        return preco;
    }

    public int getCamisetas(){
        return camisetas;
    }

    public void setNome (String n){
        nome = n;
    }

    public void setPreco (int p){
        preco = p;
    }

    public void setMoedas(int qtd){
        if (moedas<15 && moedas>0 ){
            moedas = moedas + (preco * qtd);
        } else {
            System.out.println("Alteracao invalida");
        }
    }

    public void setCamisetas(int c){
        if (c<6 && c>0 ){   
            camisetas = camisetas - c;
        } else {
            System.out.println("Alteracao invalida");
        }
    }

    void vender(Cliente alvo, int qtd){
        
        if (alvo.getMoedas() >= preco*qtd && camisetas >= qtd){
            alvo.comprar(preco, qtd);
            setMoedas(qtd);
            setCamisetas(qtd);
            System.out.println(getNome() + " vendeu " + qtd + " camiseta(s) para " + alvo.getNome() + "\n");
        } else {
            System.out.println ("nao foi possivel comprar");
        }
    }

    

}