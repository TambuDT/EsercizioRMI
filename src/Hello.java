import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String messaggio() throws RemoteException;
    int somma(int uno, int due) throws RemoteException;
    int add(int numero) throws RemoteException;
}
