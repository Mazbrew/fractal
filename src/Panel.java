import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;
import java.text.BreakIterator;
import java.awt.geom.AffineTransform;


public class Panel extends JPanel{
    private int rotation =45;

    private LayeredPanel LP;

    private int length =100;

    public Panel(LayeredPanel LP){
        super();
        this.LP = LP;
        this.setBounds(0,0,LP.getsize(),LP.getsize());
    }

    public void paint(Graphics g){
        g.setColor(new Color(214,214,214));
        g.fillRect(0, 0, LP.getsize(), LP.getsize());
        drawTree(g);
        
    }

    public void drawTree(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int branchsize=1;

        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.black);
        Line2D line = new Line2D.Double(LP.getsize()/2,LP.getsize(),LP.getsize()/2,LP.getsize()-length);
        g2d.draw(line);
    }

    public void drawBranch(Graphics2D g2d,int branchsize,double x, double y){
        Line2D line = new Line2D.Double(x,y,x,y-100);
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rotation*branchsize), line.getX1(), line.getY1());

        g2d.draw(at.createTransformedShape(line));

    }

    public int getrotation(){
        return rotation;
    }

    public void setrotation(int value){
        rotation = value;
    }
}
