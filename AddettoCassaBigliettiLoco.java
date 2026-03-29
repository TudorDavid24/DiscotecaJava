import java.util.Random;

public class AddettoCassaBigliettiLoco extends Thread{

    Random r = new Random();

    @Override
    public void run() {
        while (true){
            if (Singleton.getInstance().codaOffilne.isEmpty() == false) {
                try {sleep(r.nextLong(20, 30));} catch (Exception e) {}
                Persona personaServita = Singleton.getInstance().codaOffilne.peek();
                if(personaServita.sesso == true){
                    //La persona è un uomo
                    if (personaServita.Soldi>=20) {
                        personaServita.Soldi-=20;
                        Singleton.getInstance().codaOffilne.remove(personaServita);
                        Singleton.getInstance().codaGuardaroba.add(personaServita);
                    }
                    else{
                        Singleton.getInstance().codaOffilne.remove(personaServita);
                    }
                }
                else{
                    //La persona è una donna
                    if (personaServita.Soldi>=15) {
                        personaServita.Soldi-=15;
                        Singleton.getInstance().codaOffilne.remove(personaServita);
                        Singleton.getInstance().codaGuardaroba.add(personaServita);
                    }
                    else{
                        Singleton.getInstance().codaOffilne.remove(personaServita);
                    }
                }
            }
        }
    }
}