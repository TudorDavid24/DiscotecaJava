import java.util.Random;

public class Persona extends Thread {

    String nome;
    Boolean tipoBiglietto;
    Boolean sesso;
    long tMedioDisco;
    int Soldi;
    Random r = new Random();
    public Boolean inDiscoteca;

    public Persona(String nome, int soldi) {
        this.nome = nome;
        this.tipoBiglietto = r.nextBoolean();
        this.sesso = r.nextBoolean();
        this.tMedioDisco = 0;
        Soldi = r.nextInt(100);
    }


    @Override
    public void run() {
            EntraInCoda();
        while(inDiscoteca){
            ScegliCosaFare();
        }
    }

    private void EntraInCoda(){
        if (tipoBiglietto==true) {
            //Biglietto fila in loco
            Singleton.getInstance().codaOffilne.add(this);
        }
        else{
            //Biglietto fila online
            Singleton.getInstance().codaOnline.add(this);
        }
    }

    private void ScegliCosaFare(){
        int numeroCasuale = r.nextInt(100);
        if (numeroCasuale<=80) {
            //Continua a ballare
            return;
        }
        else if (numeroCasuale>80 && numeroCasuale<=95) {
            //Vai a prendere un drink
            Singleton.getInstance().codaBar.add(this);
        }
        else{
            //Esci dalla discoteca
            Singleton.getInstance().spazioDiscoteca.remove(this);
        }
    }


}
