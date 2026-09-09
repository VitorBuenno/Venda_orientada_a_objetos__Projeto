package At1;

public class Cliente{
    private String nome;
    private int moedas;
    private int camisetas;

    public Cliente (int moedas, int camisetas){
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

    public void setMoedas(int p, int qtd){
        if ((p*qtd) <= moedas){
            moedas = moedas - (p*qtd);
        } else {
            System.out.println("Alteracao invalida");
        }
    }

    public void setCamisetas(int qtd){
        if (qtd>=0 && qtd<11 ){   
            camisetas = camisetas + qtd;
        } else {
            System.out.println("Alteracao invalida");
        }
    }

    void comprar (int preco, int qtd){
        setCamisetas(qtd);
        setMoedas(preco, qtd);
    }

}

