import java.rmi.*;

public interface ICallback extends Remote {
    void doCallback(String message) throws RemoteException;
}