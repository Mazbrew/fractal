import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class Panel extends JPanel{
    private int size;
    private int branchSize;
    private int rotation =45;

    public Panel(int size){
        super();
        this.size= size;
        this.setBounds(0,0,size,size);
        this.add(new Slider(this));
    }

    public void paint(Graphics g){
        g.setColor(new Color(214,214,214));
        g.fillRect(0, 0, size, size);
        drawTree(g);
        paintComponent(g);
    }


    public void drawTree(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.black);
        Line2D line = new Line2D.Double(size/2,size,size/2,size-100);
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rotation), line.getX1(), line.getY1());

        g2d.draw(at.createTransformedShape(line));
    }

    public int getrotation(){
        return rotation;
    }

    public void setrotation(int value){
        rotation = value;
    }
}
