
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;


public class ClientServerThread extends Thread {

    private ServerSocket serverSocket;

    private Socket socket;

    private Pong pong;

    private ObjectOutputStream oos;

    private ClientServerThread(Pong pt) {
        this.pong = pt;
    }

    // Constructor für den Server Thread
    public static ClientServerThread newServer(int port, Pong pong) {

        var cst = new ClientServerThread(pong);
        try {
            cst.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cst;
    }

    public static ClientServerThread newClient(String ip, int port, Pong pong) {
        var cst = new ClientServerThread(pong);
        try {
            cst.socket = new Socket(ip, port);
            cst.oos = new ObjectOutputStream(cst.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cst;
    }

    public boolean isConnected(){return socket != null && socket.isConnected();}


}
