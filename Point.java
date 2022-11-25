
public class Point {
    private double x;
    private double y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    //public Point getPoint(){
    //    Point p = new Point(getX(), getY());
    //    return p;
    //}
    public boolean areTheSame (Point p){
        if(x == p.getX() && y == p.getY()){
            return true;
        }
        else 
        return false;
    } 
    public void rotate(double angle){
        double xP, yP;
        xP = x*Math.cos(angle)-y*Math.sin(angle);
        yP = x*Math.sin(angle)+y*Math.cos(angle);
        x=xP;
        x=yP;
    }
    
    //public void setPoint(Point p){
    //    this = p;
    //}
        
}
