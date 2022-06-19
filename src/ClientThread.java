import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientThread extends Thread {
    private int ThreadId;
    public ClientThread(int ThreadId){
        this.ThreadId=ThreadId;
    }

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        while(true){
            sleep(2000);
            ClientThread miothread = new ClientThread(i);
            miothread.start();
            i++;
        }
    }
        public void run() {
        Registry reg = null;
        try {
            reg = LocateRegistry.getRegistry("localhost",8000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Hello h = null;
        try {
            h = (Hello) reg.lookup("server");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Sono il thread numero: "+ThreadId+" e faccio la somma tra: "+ThreadId+" "+ThreadId);
        int risultato= 0;
        try {
            risultato = h.somma(ThreadId,ThreadId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println(" la somma è : "+risultato);
        }

    }


