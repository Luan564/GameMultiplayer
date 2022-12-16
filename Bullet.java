public class Bullet{
    private Point pos;
    private double delX, delY;
    private double speed;
    private double angle;
    private boolean enable;
    
    public Bullet(double angle, Point pos){
        enable = true;
        this.angle=angle;
        this.pos=pos;
        speed = Config.SPEED_BULLET;
        delX = speed*Math.cos(angle);
        delY = speed*Math.sin(angle);
    }
    public boolean getEnable(){
        return enable;
    }

    public void updateLocation(){
        pos.setX(pos.getX()+delX);
        pos.setY(pos.getY()+delY);
        if (pos.getX()<0 || pos.getX()>Config.SIZE_WIN_W||
        pos.getY()<0 ||pos.getY()>Config.SIZE_WIN_H){
            enable = false;
        }

    }
    public Point getPos() {
        return pos;
    }
    public double getAngle() {
        return angle;
    }
    public double getDelX() {
        return delX;
    }
    public double getDelY() {
        return delY;
    }
    public double getSpeed() {
        return speed;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public void setDelX(double delX) {
        this.delX = delX;
    }
    public void setDelY(double delY) {
        this.delY = delY;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }



}
