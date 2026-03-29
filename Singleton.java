import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public Queue<Persona> codaOffilne = new ArrayBlockingQueue<>(50);
    public Queue<Persona> codaOnline = new ArrayBlockingQueue<>(20);
    public Queue<Persona> codaGuardaroba = new ArrayBlockingQueue<>(10);
    public Queue<Persona> codaBar = new ArrayBlockingQueue<>(10);
    public Queue<Persona> codaBagno = new ArrayBlockingQueue<>(5);
    public CopyOnWriteArrayList<Persona> spazioDiscoteca = new CopyOnWriteArrayList<>();



}
