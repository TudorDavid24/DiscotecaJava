import java.util.Random;

public class AddetoGuardaroba extends Thread{
    Random r = new Random();

    @Override
    public void run() {
        while (true) {
            if (Singleton.getInstance().codaGuardaroba.isEmpty() == false) {
                int numeroCasuale = r.nextInt(100);
                if (numeroCasuale<=20) {
                    Singleton.getInstance().codaGuardaroba.remove();
                }
                else{
                    Persona personaServita = Singleton.getInstance().codaGuardaroba.peek();
                    if (personaServita.Soldi>=5) {
                        personaServita.Soldi-=5;
                        Singleton.getInstance().codaGuardaroba.remove(personaServita);
                        Singleton.getInstance().spazioDiscoteca.add(personaServita);
                    }
                    else{
                        Singleton.getInstance().codaGuardaroba.remove(personaServita);
                        Singleton.getInstance().spazioDiscoteca.add(personaServita);
                    }
                    
                }
            }
        }
    }
}
