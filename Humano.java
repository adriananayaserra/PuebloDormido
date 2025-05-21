package PuebloDormido;
import java.util.ArrayList;
import java.util.Random;
public final class Humano extends Ciudadano implements CicloVital {

    private static int totalHumanos = 0;
    private static int ultimoHumano = 0;
    private static final Random ALEATORIO = new Random();
    private final Vulnerable VULNERABLE = Vulnerable.VAMPIRO;
    private int vida;

    public Humano() {
        super("HUMANO" + ++ultimoHumano);
        this.vida = ALEATORIO.nextInt(VITALIDAD_MAXIMA) + 1;
        totalHumanos++;
    }

    public static int getPoblacion() {
        return totalHumanos;
    }

    public static void setPoblacion(int numero) {
        totalHumanos = numero;
    }

    public Ciudadano combate(Ciudadano oponente) {
        System.out.println(this.getNombre() + " lucha contra " + oponente.getNombre());

        if (oponente.getVulnerable() == Vulnerable.HUMANO) {
            System.out.println(oponente.getNombre() + " es vulnerable a " + this.getNombre());
            return oponente;
        } else if (this.getVulnerable() == oponente.getVulnerable()) {
            System.out.println("¡Ambos ciudadanos son vulnerables al mismo tipo! Es un empate.");
            return null;
        } else {
            System.out.println(this.getNombre() + " es vulnerable a " + oponente.getNombre());
            return this;
        }
    }

    public void reproducir(ArrayList<Ciudadano> ciudadanos) {
        int hijos = ALEATORIO.nextInt(NATALIDAD_MAXIMA) + 1;
        System.out.println(this.getNombre() + " se reproduce y tiene " + hijos + " hijo(s).");

        for (int i = 0; i < hijos; i++) {
            Humano hijo = new Humano();
            ciudadanos.add(hijo);
            System.out.println("Nace " + hijo.getNombre());
        }
    }

    public void morir(ArrayList<Ciudadano> ciudadanos) {
        System.out.println(this.getNombre() + " ha muerto.");
        ciudadanos.remove(this);
        totalHumanos--;
        Ciudadano.setPoblacion(Ciudadano.getPoblacion() - 1);
    }

    public void envejecer(ArrayList<Ciudadano> ciudadanos) {
        vida--;
        System.out.println(this.getNombre() + " envejece. Vida restante: " + vida);

        if (vida <= 0) {
            System.out.println(this.getNombre() + " ha alcanzado su máxima edad y muere.");
            this.morir(ciudadanos);
        }
    }

    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    public String toString() {
        return super.toString() + " [Humano, Vida: " + vida + ", Vulnerable a: " + VULNERABLE + "]";
    }
}