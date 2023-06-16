package Bulleye;

public class Caballo {
    private String nombre;
    private String color;
    private int numero;

    public Caballo(String nombre,String color, int numero){
        this.nombre=nombre;
        this.color=color;
        this.numero=numero;
    }

    public String getNombre(){
        return this.nombre;
    }
    public String getColor(){
        return this.color;
    }
    public int getNumero(){
        return this.numero;
    }
}
