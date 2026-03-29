import java.util.Random;

public class Barman extends Thread {
    
    Random r = new Random();
    @Override
    public void run() {
        while (true) {
            if (Singleton.getInstance().codaBar.isEmpty() == false) {
                try {
                    sleep(r.nextLong(20, 80));  
                } catch (Exception e) {}
                Persona personaServita = Singleton.getInstance().codaBar.peek();
                if(personaServita.Soldi<10){
                    Singleton.getInstance().codaBar.remove(personaServita);
                }
                else{
                    personaServita.Soldi-=10;
                    Singleton.getInstance().codaBar.remove(personaServita);
                }
            }
        }
    }
}
