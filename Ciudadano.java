package PuebloDormido;
import java.util.ArrayList;

public abstract class Ciudadano implements Batalla {
    private static int poblacion = 0;
    private String nombre;

    public Ciudadano(String nombre) {
        this.nombre = nombre;
        poblacion++;
    }

    public static int getPoblacion() {
        return poblacion;
    }

    public static void setPoblacion(int numero) {
        poblacion = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Nombre del ciudadano: " + nombre;
    }

    public static void censar(ArrayList<Ciudadano> ciudadanos) {
        System.out.println("\n--- CENSO DE CIUDADANOS ---");
        for (Ciudadano ciudadano : ciudadanos) {
            System.out.println(ciudadano);
        }
        System.out.println("-------------------------");
        poblacionesTotales();
    }

    public static void poblacionesTotales() {
        System.out.println("\n--- POBLACIONES TOTALES ---");
        System.out.println("Total de ciudadanos: " + Ciudadano.getPoblacion());
        System.out.println("Total de humanos: " + Humano.getPoblacion());
        System.out.println("Total de lobos: " + Lobo.getPoblacion());
        System.out.println("Total de vampiros: " + Vampiro.getPoblacion());
        System.out.println("--------------------------");
    }

    public abstract void morir(ArrayList<Ciudadano> ciudadanos);
    public abstract Vulnerable getVulnerable();
}




