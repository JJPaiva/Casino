package BlackJack;

public class Carta{
    private String cara;
    private int valor;
    private  Pinta pinta;



    public Carta(String cara, int valor, Pinta pinta){
        this.cara = cara;
        this.valor = valor;
        this.pinta = pinta;
    }
    public String getCara(){
        return cara;
    }

    public int getValor(){
        return valor;
    }

    public Pinta getPinta(){
        return pinta;
    }

}
