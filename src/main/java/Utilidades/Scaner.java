package Utilidades;
import java.util.Scanner;

public class Scaner {
    static final Scanner scanner = new Scanner(System.in);

    public static String ingresarString() {
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println(ingresarString());
    }
}
