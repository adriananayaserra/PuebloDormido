package PuebloDormido;
import java.util.ArrayList;
import java.util.Random;
public final class Lobo extends Ciudadano implements CicloVital {

    private static int totalLobos = 0;
    private static int ultimoLobo = 0;
    private static final Random ALEATORIO = new Random();
    private final Vulnerable VULNERABLE = Vulnerable.HUMANO;
    private int vida;

    public Lobo() {
        super("LOBO" + ++ultimoLobo);
        this.vida = ALEATORIO.nextInt(VITALIDAD_MAXIMA * 2) + 1;
        totalLobos++;
    }

    public static int getPoblacion() {
        return totalLobos;
    }

    public static void setPoblacion(int numero) {
        totalLobos = numero;
    }

    public Ciudadano combate(Ciudadano oponente) {
        System.out.println(this.getNombre() + " lucha contra " + oponente.getNombre());

        if (oponente.getVulnerable() == Vulnerable.LOBO) {
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
        int cachorros = ALEATORIO.nextInt(NATALIDAD_MAXIMA * 2) + 1;
        System.out.println(this.getNombre() + " se reproduce y tiene " + cachorros + " cachorro(s).");

        for (int i = 0; i < cachorros; i++) {
            Lobo cachorro = new Lobo();
            ciudadanos.add(cachorro);
            System.out.println("Nace " + cachorro.getNombre());
        }
    }

    public void morir(ArrayList<Ciudadano> ciudadanos) {
        System.out.println(this.getNombre() + " ha muerto.");
        ciudadanos.remove(this);
        totalLobos--;
        Ciudadano.setPoblacion(Ciudadano.getPoblacion() - 1);
    }

    public void envejecer(ArrayList<Ciudadano> ciudadanos) {
        vida -= 2; // Los lobos envejecen el doble de rápido
        System.out.println(this.getNombre() + " envejece más rápido. Vida restante: " + vida);

        if (vida <= 0) {
            System.out.println(this.getNombre() + " ha alcanzado su máxima edad y muere.");
            this.morir(ciudadanos);
        }
    }

    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    public String toString() {
        return super.toString() + " [Lobo, Vida: " + vida + ", Vulnerable a: " + VULNERABLE + "]";
    }
}