import processing.core.PApplet;


abstract class MainClient {
    public static void main(String[] args){




        var pt = Pong.newClient("localhost", 8080);
        PApplet.runSketch(new String[]{"Pong"}, pt);
    }

}
