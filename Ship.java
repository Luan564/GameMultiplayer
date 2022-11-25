import java.awt.Color;

public class Ship {
    //Atributos
    private Color color;
    private double angle = 0;
    private int speed, x, y;
    public static final int UP =0, DOWN = 1, LEFT = 2, RIGHT = 3; 
    private int dir;
    

    

    public Ship(int x, int y){
        this.x=x;
        this.y=y;
        color = Color.BLACK;
        speed = 0;


    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getDir() {
        return dir;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }

}
