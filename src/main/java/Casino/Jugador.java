package Casino;

public class Jugador {
    private String nombre;
    private int dinero=50000;


    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Nombre Jugador= " + nombre + '\n' + "Dinero restante= " + dinero;
    }

    public String toCSV(){
        return this.nombre+","+this.dinero;
    }
}
