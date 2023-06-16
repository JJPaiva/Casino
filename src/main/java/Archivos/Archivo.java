package Archivos;

import java.io.File;

public class Archivo {
    public static void main(String[] args) {

        File DatosCasino = new File("Archivos\\Datos.csv");

        if(DatosCasino.exists()){
            System.out.println("Nombre del archivo: "+ DatosCasino.getName());
            System.out.println("Ruta: "+ DatosCasino.getPath());
            System.out.println("Ruta absoluta:"+ DatosCasino.getAbsolutePath());
            System.out.println("Se puede escribir: "+DatosCasino.canRead());
            System.out.println("Se puede leer: "+DatosCasino.canWrite());
            System.out.println("Tamaño: "+DatosCasino.length());
        }
    }



}
