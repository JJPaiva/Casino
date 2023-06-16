package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Juego {

    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Carta> mano1 = new ArrayList<>();
    static ArrayList<Carta> mano2 = new ArrayList<>();

    public static void revolverMazo() {
        Mazo.crearMazo();
        Collections.shuffle(Mazo.mazo);
    }

    public static void repartirCartasMano1(){
        for(int i=0;i<3;i++){
            mano1.add(Mazo.mazo.get(0));
            Mazo.mazo.remove(0);
        }
    }

    public static void repartirCartasMano2(){
        for(int i=0;i<3;i++){
            mano2.add(Mazo.mazo.get(0));
            Mazo.mazo.remove(0);
        }
    }

    public static void repartirCartas() {
        repartirCartasMano1();
        repartirCartasMano2();
    }

    public static void mostrarMano1() {
        for (Carta carta : mano1) {
            System.out.println("Carta: " + carta.getCara() + " de " + carta.getPinta());
        }
    }

    public static void mostrarMano2() {
        for (Carta carta : mano2) {
            System.out.println("Carta: " + carta.getCara() + " de " + carta.getPinta());
        }
    }

    public static void mostrarManos() {
        System.out.println("Mano Jugador:\n");
        mostrarMano1();
        System.out.println("**Total: "+sumaMano1()+" puntos**\n");
        System.out.println("Mano COM:\n");
        mostrarMano2();
        System.out.println("**Total: "+sumaMano2()+" puntos**\n");
    }

    public static void limpiarManos() {mano1.clear(); mano2.clear();}

    public static int sumaMano1() {
        int total=0;
        for (Carta carta : mano1) {
            total = total + carta.getValor();
        }
        return total;
    }

    public static int sumaMano2() {
        int total=0;
        for(Carta carta:mano2){
            total = total + carta.getValor();
        }
        return total;
    }


    public static int compararManos() {
        if(sumaMano1()>sumaMano2() && sumaMano2()<22 && sumaMano1()<22) {return 1;}
        else if(sumaMano1()<22 && sumaMano2()>21) {return 1;}
        else if(sumaMano2()>sumaMano1() && sumaMano1()<22 && sumaMano2()<22) {return 2;}
        else if(sumaMano2()<22 && sumaMano1()>21) {return 2;}
        else if(sumaMano2()==sumaMano1() && sumaMano2()<22 && sumaMano1()<22){return 3;}
        else return 4;
    }

    public static boolean mazoMenos6() {
        if(Mazo.mazo.size()<6){System.out.println("Se acabaron las cartas del mazo\n"); return false;}
        return true;
    }

    public static boolean seguirJugando(){
        System.out.println("Desea jugar otra ronda? \n1.-Si\n2.-No\n");
        int respuesta = scanner.nextInt();
        return respuesta != 2;
    }

    public static boolean romperCiclo(){return seguirJugando() && mazoMenos6();}

    public static int[] Jugar() {
        int cont1=0;
        int cont2=0;
        boolean aux = true;
        while (aux){
            repartirCartas();
            mostrarManos();
            switch (compararManos()) {
                case 1 -> {
                    System.out.println("[Jugador Gana la ronda]\n");
                    cont1 += 1;
                    break;
                }
                case 2 -> {
                    System.out.println("[COM Gana la ronda]\n");
                    cont2 += 1;
                    break;
                }
                case 3 -> {
                    System.out.println("[Jugador y COM empatan]\n[1 punto para cada uno]\n");
                    cont1 += 1;
                    cont2 += 1;
                    break;
                }
                case 4 -> {
                    System.out.println("[Ambos pierden la ronda]\n[Ninguno obtiene el punto]\n");
                    break;
                }
            }
            limpiarManos();
            aux=romperCiclo();
        }
        return new int[] {cont1,cont2};
    }

    public static void ganador(int[] valor) {
        System.out.println("Puntos Jugador: "+ valor[0] +"\nPuntos COM: "+ valor[1]);
        if(valor[0]> valor[1]){
            System.out.println("Jugador Gana!!!");
        } else if (valor[1]> valor[0]){
            System.out.println("COM Gana!!!");
        }else System.out.println("Empate");
    }

    public static void playBlackJack() {revolverMazo(); ganador(Jugar()); }
}
