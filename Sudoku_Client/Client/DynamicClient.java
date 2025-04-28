import java.rmi.server.RMIClassLoader;
import java.util.Properties;
import java.lang.reflect.Constructor;
import java.rmi.RMISecurityManager;


public class DynamicClient {

    public static void main(String[] args) {
        // Set the security manager (optional, depending on your environment)
        System.setSecurityManager(new RMISecurityManager());

        try {
            // Get the RMI codebase URL from system properties
            Properties p = System.getProperties();
            String url = p.getProperty("java.rmi.server.codebase");

            // Dynamically load the class (SudokuClient) from the specified URL
            Class<?> classeClient = RMIClassLoader.loadClass(url, "SudokuClient");

            // Get the constructor of SudokuClient (ensure it doesn't require parameters)
            Constructor<?> constructor = classeClient.getConstructor();

            // Create an instance of SudokuClient using the constructor
            Object clientInstance = constructor.newInstance();

            System.out.println("Client class loaded and instance created: " + classeClient.getName());

        } catch (Exception e) {
            // Handle exceptions appropriately
            System.out.println("Error: " + e.toString());
        }
    }
}
