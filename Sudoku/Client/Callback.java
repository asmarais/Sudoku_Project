import java.rmi.*;
import java.rmi.server.*;

public class Callback extends UnicastRemoteObject implements ICallback {
    public Callback() throws RemoteException {
        super();
    }

    @Override
    public void doCallback(String message) throws RemoteException {
        // Print the message from the server
        System.out.println("Callback received: " + message);
    }
}
