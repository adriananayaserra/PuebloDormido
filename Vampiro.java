package PuebloDormido;
import java.util.ArrayList;


public final class Vampiro extends Ciudadano {

    private static int totalVampiros = 0;
    private static int ultimoVampiro = 0;
    private final Vulnerable VULNERABLE = Vulnerable.LOBO;

    public Vampiro() {
        super("VAMPIRO" + ++ultimoVampiro);
        totalVampiros++;
    }

    public static int getPoblacion() {
        return totalVampiros;
    }

    public static void setPoblacion(int numero) {
        totalVampiros = numero;
    }

    public Ciudadano combate(Ciudadano oponente) {
        System.out.println(this.getNombre() + " lucha contra " + oponente.getNombre());

        if (oponente.getVulnerable() == Vulnerable.VAMPIRO) {
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

    public void morir(ArrayList<Ciudadano> ciudadanos) {
        System.out.println(this.getNombre() + " ha muerto.");
        ciudadanos.remove(this);
        totalVampiros--;
        Ciudadano.setPoblacion(Ciudadano.getPoblacion() - 1);
    }

    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    public String toString() {
        return super.toString() + " [Vampiro, Vulnerable a: " + VULNERABLE + "]";
    }
}
