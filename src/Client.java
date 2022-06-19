import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Thread{
    private Client() {}

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client c = new Client();
        Registry reg = LocateRegistry.getRegistry("localhost",8000);
        Hello h = (Hello) reg.lookup("server");
        String hello=h.messaggio();
        int risultato = h.somma(2,3);
        System.out.println(hello+" la somma è : "+risultato);
    }
}
