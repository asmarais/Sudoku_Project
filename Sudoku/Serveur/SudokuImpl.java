import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

public class SudokuImpl extends UnicastRemoteObject implements SudokuInterface {
    private static final int MAX_CLIENTS = 10; 
    private static Semaphore semaphore;
    // Sudoku puzzle and solution
    String[] puzzle = {
        "-8------5", "2-------9", "-----7-1-", 
        "-5------4", "--3----9-", "--6-----7", 
        "9-------2", "67-83----", "8----5---"
    };

    private final String[] solution = {
        "387491625", "241568379", "569327418", 
        "758619234", "123784596", "496253187", 
        "934176852", "675832941", "812945763"
    };

    public SudokuImpl() throws RemoteException {
        super();
        if (semaphore == null) {
            semaphore = new Semaphore(MAX_CLIENTS);
        }
    }

    public String[] getPuzzle() throws RemoteException {
        return puzzle;
    }

    public String[] getSolution() throws RemoteException {
        return solution;
    }

    public boolean validateMove(int row, int col, String value) throws RemoteException {
        return String.valueOf(solution[row].charAt(col)).equals(value);
    }

    @Override
    public void callMeBack(int time, String param, ICallback callback) throws RemoteException {

        Servant servant = new Servant(time, param, callback);
        servant.start();
    }

    // Method to handle client connections and ensure we do not exceed the max client limit
    public boolean connectClient() throws RemoteException {
        try {

            if (semaphore.tryAcquire()) {
                // Client connected successfully
                return true; 
            } else {
                // Server is at full capacity
                return false; 
            }
        } catch (Exception e) {
            throw new RemoteException("Error while acquiring semaphore", e);
        }
    }

    // Method to release a client connection after they disconnect
    public void disconnectClient() throws RemoteException {
        semaphore.release();
    }
}
