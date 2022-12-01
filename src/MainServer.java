import processing.core.PApplet;


abstract class MainServer {

    public static void main(String[] args) {

        var pt = Pong.newServer(8080);
        PApplet.runSketch(new String[]{"Pong"}, pt);
        new Ball(100, 100, 30);


    }
}
