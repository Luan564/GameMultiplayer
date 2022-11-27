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
        ship = new Ship(1,1);
       
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
        points = ship.getPoints();
        Polygon nave = new Polygon();
    

        for(int i = 0 ; i < points.size() ; i++){ 
        System.out.println(ship.getAngle());
        points.get(i).rotate(Math.toRadians(ship.getAngle()));
        ship.setAngle(0);
                   
        }

        for(int i = 0 ; i < points.size() ; i++){
            nave.addPoint(ship.getX()+(int)points.get(i).getX(), ship.getY()+(int)points.get(i).getY());
           
        }
        g.setColor(Color.GREEN);
        g.fillPolygon(nave);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Point>points = new ArrayList<Point>();
        points = ship.getPoints();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Change Dir
        ArrayList<Point>points = new ArrayList<Point>();
        points = ship.getPoints();
        Point pHead = points.get(Config.HEAD);
        Point pLeft = points.get(Config.P_LEFT);
        Point pRight = points.get(Config.P_RIGHT);

        int yDir = ship.getY();
        int xDir = ship.getX();
        double angle = ship.getAngle();
        switch(ship.getDir()){
            case Ship.UP:
            yDir-=4;
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
            angle--;
            break;
            case Ship.ROTATE_RIGHT:
            angle++;
            break;
        }
        ship.setY(yDir);
        ship.setX(xDir);
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