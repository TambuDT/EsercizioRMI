import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Hello{
    private int numero=0;

    protected Server() throws RemoteException {
        super();
    }
    @Override
    public String messaggio() throws RemoteException {
        return "Cazzo Funziona";
    }
    public int somma(int uno, int due) throws RemoteException{
        return uno+due;
    }

    public synchronized int add(int numero) throws RemoteException{
        int temp=this.numero;
        int ris= temp+numero;
        this.numero=ris;
        System.out.println(this.numero);
        return ris;
    }

    public static void main(String args[]) throws RemoteException {
       Registry reg = LocateRegistry.createRegistry(8000);
       reg.rebind("server",new Server());
       System.out.println("Server ready");
    }
}
