import processing.core.PApplet;

public class Pong extends PApplet{

    private ClientServerThread thread;



    // Create Server
    public static Pong newServer(int port){
        var pt = new Pong();
        pt.thread = ClientServerThread.newServer(port, pt);
        pt.thread.start();
        return pt;
    }

    public static Pong newClient(String ip, int port){
        var pt = new Pong();
        pt.thread = ClientServerThread.newClient(ip, port, pt);
        pt.thread.start();
        return pt;
    }


    @Override
    public void settings(){
        setSize(720, 720);
    }
    @Override
    public void setup(){}

    @Override
    public void draw(){}
}