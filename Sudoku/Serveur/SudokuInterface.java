import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SudokuInterface extends Remote {
    String[] getPuzzle() throws RemoteException;
    String[] getSolution() throws RemoteException;

    boolean validateMove(int row, int col, String value) throws RemoteException;
    void callMeBack(int time, String param, ICallback callback) throws RemoteException;
    boolean connectClient() throws RemoteException;
    void disconnectClient() throws RemoteException;

}
