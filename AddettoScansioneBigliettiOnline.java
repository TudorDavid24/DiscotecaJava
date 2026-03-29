import java.util.Random;

public class AddettoScansioneBigliettiOnline extends Thread {
    Random r = new Random();

    @Override
    public void run() {
        while (true) {
            if (Singleton.getInstance().codaOnline.isEmpty() == false) {
                try {
                    sleep(r.nextLong(10, 15));
                } catch (Exception e) {
                }
                Persona personaServita = Singleton.getInstance().codaOnline.peek();
                if (personaServita.Soldi >= 10) {
                    personaServita.Soldi -= 10;
                    Singleton.getInstance().codaOnline.remove(personaServita);
                    Singleton.getInstance().codaGuardaroba.add(personaServita);
                } else {
                    Singleton.getInstance().codaOnline.remove(personaServita);
                }
            }
        }
    }
}
