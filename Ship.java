import java.awt.Color;
import java.util.ArrayList;

public class Ship {
    //Atributos
    private Color color;
    private double angle = 0;
    private int x, y;
    public static final int UP =0, DOWN = 1, LEFT = 2, RIGHT = 3, ROTATE_RIGHT = 4, ROTATE_LEFT = 5; 
    private int dir;
    private ArrayList<Point>points = new ArrayList<Point>();
    

    

    public Ship(int x, int y){
        points.add(new Point (0,-10));
        points.add(new Point (-10,15));
        points.add(new Point (10,15));
        this.x=x;
        this.y=y;
        color = Color.BLACK;
    }


    public ArrayList<Point> getPoints() {
        return points;
    }
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
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
