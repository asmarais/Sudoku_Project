import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;
import java.rmi.Remote;

public class SudokuServer {
    public static void main(String[] args) {
        try {
            if (System.getSecurityManager() == null)
                System.setSecurityManager(new RMISecurityManager());

            //FabSudokuImpl fabrique = new FabSudokuImpl();
            Properties p= System.getProperties();
            String url=p.getProperty("java.rmi.server.codebase");
            Class ClasseServeur = RMIClassLoader.loadClass(url,
            "FabSudokuImpl");

            Registry registry = LocateRegistry.createRegistry(2000);
            //registry.rebind("FabSudoku", fabrique);
            registry.rebind("FabSudoku",(Remote)ClasseServeur.newInstance());
            System.out.println("Sudoku Server with Fabrique is running...");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
