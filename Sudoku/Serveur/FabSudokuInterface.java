import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabSudokuInterface extends Remote {
    SudokuInterface createSudokuGame() throws RemoteException;
}
