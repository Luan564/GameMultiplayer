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
    Ship ship;
    
    public static void main(String args[]){
        Board b = new Board();
        
    }

    public Board(){
        ship = new Ship(200,200);
       
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

        
        window.add(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Draw nave
        ArrayList<Point>points = new ArrayList<Point>();
        points.add(new Point (10,0));
        points.add(new Point (-15,-10));
        points.add(new Point (-15,10));
        

        Polygon nave = new Polygon();
    

        for(int i = 0 ; i < points.size() ; i++){ 
        //System.out.println(ship.getAngle());
        points.get(i).rotate(ship.getAngle()*Math.PI/180);
                   
        }

        for(int i = 0 ; i < points.size() ; i++){
            System.out.println("Ship.getX()"+ship.getX());
            System.out.println("Ship.getY()"+ship.getY());
            nave.addPoint(ship.getX()+(int)points.get(i).getX(), ship.getY()+(int)points.get(i).getY());
           
        }
        g.setColor(Color.GREEN);
        g.fillPolygon(nave);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       

        //Change Dir
        double yDir = ship.getY();
        double xDir = ship.getX();
        double angle = ship.getAngle();
        switch(ship.getDir()){
            case Ship.UP:
            xDir+=(Math.cos((angle)));
            System.out.println(xDir);
            yDir+=(Math.sin((angle)));
            System.out.println(yDir);
            break;



            case Ship.DOWN:
            yDir+=4;
            break;
            case Ship.LEFT:
            xDir-=4;
            break;
            case Ship.RIGHT:
            xDir+=4;
            break;
            case Ship.ROTATE_LEFT:
            angle-=7;
            break;
            case Ship.ROTATE_RIGHT:
            angle+=7;
            break;
        }
        ship.setY((int)yDir);
        ship.setX((int)xDir);
        ship.setAngle(angle);

                
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Detected the Keyboard
        int codeKey = e.getKeyCode();
        switch(codeKey){
            case KeyEvent.VK_W:
            ship.setDir(Ship.UP);
            break;
            case KeyEvent.VK_S:
            ship.setDir(Ship.DOWN);
            break;
            case KeyEvent.VK_A:
            ship.setDir(Ship.LEFT);
            break;
            case KeyEvent.VK_D:
            ship.setDir(Ship.RIGHT);
            break;
            case KeyEvent.VK_J:
            ship.setDir(Ship.ROTATE_LEFT);
            break;
            case KeyEvent.VK_L:
            ship.setDir(Ship.ROTATE_RIGHT);
            break;
        }        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
    }
}