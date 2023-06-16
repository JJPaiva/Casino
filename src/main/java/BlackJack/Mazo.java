package BlackJack;

import java.util.ArrayList;

public class Mazo {

    static ArrayList<Carta> mazo = new ArrayList<>();
    static ArrayList<Pinta> pintas = new ArrayList<>();
    static ArrayList<String> caras = new ArrayList<>();
    static ArrayList<Integer> valores = new ArrayList<>();

    public Mazo(Carta carta){
        mazo.add(carta);
    }


    public static void agregarPintas() {
        pintas.add(Pinta.PICA);
        pintas.add(Pinta.DIAMANTE);
        pintas.add(Pinta.TREBOL);
        pintas.add(Pinta.CORAZON);

    }

    public static void agregarCaras() {
        caras.add("AS"); caras.add("2"); caras.add("3"); caras.add("4"); caras.add("5");
        caras.add("6"); caras.add("7"); caras.add("8"); caras.add("9"); caras.add("10");
        caras.add("JOTA"); caras.add("QUINA"); caras.add("KAISER");

    }

    public static void agregarValores() {
        valores.add(11); valores.add(2); valores.add(3); valores.add(4); valores.add(5);
        valores.add(6); valores.add(7); valores.add(8); valores.add(9); valores.add(10);
        valores.add(10); valores.add(10); valores.add(10);

    }


    public static void crearCartas() {
        int i;
        int j;
        for (i=0;i< pintas.size();i++){
            for (j=0;j< caras.size() && j<valores.size();j++){
                Carta carta = new Carta(caras.get(j),valores.get(j), pintas.get(i));
                Mazo mazo = new Mazo(carta);
            }
        }
    }

    public static void crearMazo() {
        agregarPintas();
        agregarCaras();
        agregarValores();
        crearCartas();
    }
}
