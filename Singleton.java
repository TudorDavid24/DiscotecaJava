import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Singleton {

    private Singleton(){
    }
    //L'istanza deve essere un attributo static
    private static Singleton istanza = null;

    //L'istanza deve essere accessibile tramite un metodo e NON pubblicamente modificabile
    public static synchronized Singleton getInstance(){
        if(istanza==null)
            istanza = new Singleton();

        return istanza;
    }

    Queue<Persona> codaOffilne = new ArrayBlockingQueue<>(50);
    Queue<Persona> codaOnline = new ArrayBlockingQueue<>(20);
    Queue<Persona> codaGuardaroba = new ArrayBlockingQueue<>(10);
    Queue<Persona> codaBar = new ArrayBlockingQueue<>(10);
    Queue<Persona> codaBagno = new ArrayBlockingQueue<>(5);
    Persona spazioDiscoteca[] = new Persona[400];



}
