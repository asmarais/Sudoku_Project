import java.rmi.*;

public class Servant extends Thread {
    private int time;
    private String param;
    private ICallback callback;

    public Servant(int time, String param, ICallback callback) {
        this.time = time;
        this.param = param;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            // Sleep for the specified amount of time
            Thread.sleep(1000 * time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Execute the callback method on the client
        try {
            callback.doCallback(param);
        } catch (RemoteException e) {
            System.err.println("Callback failed: " + e);
        }

        // Clean up
        callback = null;
        System.gc();
    }
}
