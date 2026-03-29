import java.util.Random;

public class Persona extends Thread {

    String nome;
    Boolean tipoBiglietto;
    long tMedioDisco;
    int Soldi;
    Random r = new Random();

    public Persona(String nome, int soldi) {
        this.nome = nome;
        this.tipoBiglietto = r.nextBoolean();
        this.tMedioDisco = 0;
        Soldi = r.nextInt(100);
    }


    @Override
    public void run() {
        while (true) {
            
        }
    }
}
