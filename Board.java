import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.plaf.DimensionUIResource;


public class Board extends JPanel implements ActionListener, KeyListener{
    public static final int UP =0, DOWN = 1, LEFT = 2, RIGHT = 3, ROTATE_RIGHT = 4, ROTATE_LEFT = 5, SHOOT = 6; 
    ArrayList<Point>points=new ArrayList<>();
    Point p2;
    boolean shoot;
    int dir;
    double angle2;
    
    

    
    public static void main(String args[]){
        Board b = new Board();
        
    }

    public Board(){
        double angle=Math.PI/2;
        Point p=new Point(0,0);
        
        Timer t = new Timer(80, this);{
        t.start();
        }
        setPreferredSize(new DimensionUIResource(Config.SIZE_WIN_W, Config.SIZE_WIN_H));
        setBackground(Color.GRAY);
        JFrame window = new JFrame("Multiplayer");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
        window.setSize(Config.SIZE_WIN_W, Config.SIZE_WIN_H);      
        window.add(this);   
        window.addKeyListener(this);                  
        window.pack();                                
        window.setResizable(false);          
        window.setLocationRelativeTo(null);         
        window.setVisible(true);  
        
        Bullet bala = new Bullet(angle, new Point(Config.X_SHIP, Config.Y_SHIP));
        ShipData navecita = new ShipData(Config.X_SHIP, Config.Y_SHIP, Config.COLOR_SHIP, Config.ANGLE);

       p2 = p;
       angle2=angle;
       for (int i=0; i<500; i++){
        
        if(bala.getEnable() == shoot){
            bala.setAngle(angle);
            bala.setPos(p2);
            bala.updateLocation();
        }

        navecita.setAngle(angle);
        navecita.setP(p);
        navecita.print();
        this.setPoints(navecita.getPointsTranlate());
        angle=+angle2; 
        p.setX(p2.getX());
        p.setY(p2.getY());
            try{

                Thread.sleep(100);

            }catch (InterruptedException e) {

            

            }  
        //System.out.println("x"+p.getX());
        //System.out.println("ShipData.x"+navecita.getP().getX());
        //System.out.println("y"+p.getY());
        //System.out.println("ShipData.y"+navecita.getP().getY());
        //System.out.println(i); 
        i=0; 
        
        }

        
        window.add(this);
    }
    
   
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        Polygon nave = new Polygon();
        for(int i = 0 ; i < points.size() ; i++){
             nave.addPoint((int)Math.round(points.get(i).getX()),(int)Math.round(points.get(i).getY()));
             repaint();
             
           
        }
        g.fillPolygon(nave);
        
    }
    public void setPoints(ArrayList<Point>points){
        this.points=points;
    }
    public int getDir() {
        return dir;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        

        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        double xP = p2.getX();
        double yP = p2.getY();
        double angle = angle2;
        boolean shootAct = false;
        switch(dir){
            case UP:
            yP = yP-4;
            break;
            case DOWN:
            yP = yP+4;
            break;
            case RIGHT:
            xP = xP-4;
            break;
            case LEFT:
            xP = xP+4;
            break;
            case ROTATE_LEFT:
            angle=angle-0.1;
            break;
            case ROTATE_RIGHT:
            angle=angle+0.1;
            break;
            case SHOOT:
            shootAct = true;
            break;

        }
        p2.setX(xP);
        p2.setY(yP);
        angle2 = angle;
        shoot = shootAct;


        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Detected the Keyboard
        int codeKey = e.getKeyCode();
        switch(codeKey){
            case KeyEvent.VK_W:
            dir = UP;
            break;
            case KeyEvent.VK_S:
            dir = DOWN;
            break;
            case KeyEvent.VK_A:
            dir = RIGHT;
            break;
            case KeyEvent.VK_D:
            dir = LEFT;
            break;
            case KeyEvent.VK_J:
            dir = ROTATE_LEFT;
            break;
            case KeyEvent.VK_L:
            dir = ROTATE_RIGHT;
            break;
            case KeyEvent.VK_SPACE:
            dir = SHOOT;
            break;
        }        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
    }
}