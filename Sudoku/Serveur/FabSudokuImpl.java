import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class FabSudokuImpl extends UnicastRemoteObject implements FabSudokuInterface {

    public FabSudokuImpl() throws RemoteException {
        super();
    }

    @Override
    public SudokuInterface createSudokuGame() throws RemoteException {
        return new SudokuImpl();
    }
}
