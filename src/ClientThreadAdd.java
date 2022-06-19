import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientThreadAdd extends Thread {
    private String ThreadId="";
    public ClientThreadAdd(String ThreadId){
        this.ThreadId=ThreadId;
    }

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        while(true){
            sleep(2000);
            ClientThreadAdd mioThread1 = new ClientThreadAdd("istanza di mioThread1 numero  "+i);
            mioThread1.start();
            ClientThreadAdd mioThread2 = new ClientThreadAdd("istanza di mioThread2 numero  "+i);
            mioThread2.start();
            ClientThreadAdd mioThread3 = new ClientThreadAdd("istanza di mioThread3 numero  "+i);
            mioThread3.start();
            ClientThreadAdd mioThread4 = new ClientThreadAdd("istanza di mioThread4 numero  "+i);
            mioThread4.start();
            ClientThreadAdd mioThread5 = new ClientThreadAdd("istanza di mioThread5 numero  "+i);
            mioThread5.start();
            ClientThreadAdd mioThread6 = new ClientThreadAdd("istanza di mioThread6 numero  "+i);
            mioThread6.start();
            ClientThreadAdd mioThread7 = new ClientThreadAdd("istanza di mioThread7 numero  "+i);
            mioThread7.start();
            ClientThreadAdd mioThread8 = new ClientThreadAdd("istanza di mioThread8 numero  "+i);
            mioThread8.start();
            ClientThreadAdd mioThread9 = new ClientThreadAdd("istanza di mioThread9 numero  "+i);
            mioThread9.start();
            ClientThreadAdd mioThread10 = new ClientThreadAdd("istanza di mioThread10 numero "+i);
            mioThread10.start();
            i++;
        }
    }
    public void run(){
        Registry reg = null;
        try {
            reg = LocateRegistry.getRegistry("localhost",8000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Hello h= null;
        try {
            h = (Hello) reg.lookup("server");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        int numero= 0;
        try {
            numero = h.add(1);
            System.out.println(ThreadId+" e sto sommando 1 alla variabile sul server -> "+numero);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
