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
        Point p=new Point (3,2);
        p.rotate(Math.PI/2);
        
       
        ArrayList<Point>points = new ArrayList<Point>();
        points.add(new Point (50,50));
        points.add(new Point (35,80));
        points.add(new Point (65,80));

        Polygon nave = new Polygon();
        int i;

        for(i = 0 ; i < points.size() ; i++){ 
            points.get(i).rotate(ship.getAngle()*Math.PI/180);
            //System.out.print(i+":" +points.get(i).getX());
            //System.out.print(","+ points.get(i).getY()); 
        }
        for(i = 0 ; i < points.size() ; i++){
            nave.addPoint((int)points.get(i).getX(), ship.getY()+(int)points.get(i).getY());
           
        }
        g.setColor(Color.GREEN);
        g.fillPolygon(nave);

       

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Change Dir
        int yDir = ship.getY();
        double angle = ship.getAngle();
        switch(ship.getDir()){
            case Ship.UP:
            yDir--;
            break;
            case Ship.DOWN:
            yDir++;
            break;
            case Ship.LEFT:
            angle--;
            break;
            case Ship.RIGHT:
            angle++;
            break;
        }
        ship.setY(yDir);
        ship.setAngle(angle);

                
        repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
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
        }        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}