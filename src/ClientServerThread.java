
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

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }
    @Override
    public void run() {

        try {

            if (socket == null) {
                socket = serverSocket.accept();
                oos = new ObjectOutputStream(socket.getOutputStream());
            }
            var ois = new ObjectInputStream((socket.getInputStream()));
            while (true) {
                Object obj = ois.readObject();
                // TODO CHECKEN OB DIE IFABFRAGE RECHTENS IST
                if (obj instanceof Pong) {
                    // Hier wird dann glaube ich Position von Ball und Schläger hin und her geschoben

                } else if (obj instanceof String) {

                    switch ((String) obj) {
                        // case "Trade" -> {poketrade.trade();}
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}




