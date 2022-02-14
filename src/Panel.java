import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;


public class Panel extends JPanel{
    private double maxBranch = 10;
    private int rotation =45;
    private int strokeWeight = (int)maxBranch;

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
        int branchNo=0;

        g2d.setStroke(new BasicStroke(strokeWeight));
        g2d.setColor(Color.black);
        Line2D line = new Line2D.Double(LP.getsize()/2,LP.getsize(),LP.getsize()/2,LP.getsize()-length);
        g2d.draw(line);
        drawBranchLeft(g2d, branchNo+1, line.getX2(), line.getY2());
        drawBranchRight(g2d, branchNo+1, line.getX2(), line.getY2());
    }

    public void drawBranchLeft(Graphics2D g2d,int branchNo,double x, double y){
        g2d.setStroke(new BasicStroke(strokeWeight-branchNo));
        Line2D line = new Line2D.Double(x,y,x+(Math.sin(Math.toRadians(rotation*branchNo))*((maxBranch-branchNo)/maxBranch*length)),y-(Math.cos(Math.toRadians(rotation*branchNo))*((maxBranch-branchNo)/maxBranch*length)));
        g2d.draw(line);
        if((maxBranch-branchNo)>0){
            drawBranchLeft(g2d, branchNo+1, line.getX2(), line.getY2());
            drawBranchRight(g2d, branchNo+1, line.getX2(), line.getY2());
        }
    }

    public void drawBranchRight(Graphics2D g2d,int branchNo,double x, double y){
        g2d.setStroke(new BasicStroke(strokeWeight-branchNo));
        Line2D line = new Line2D.Double(x,y,x+(Math.sin(Math.toRadians(-rotation*branchNo))*((maxBranch-branchNo)/maxBranch*length)),y-(Math.cos(Math.toRadians(rotation*branchNo))*((maxBranch-branchNo)/maxBranch*length)));
        g2d.draw(line);
        if((maxBranch-branchNo)>0){
            drawBranchLeft(g2d, branchNo+1, line.getX2(), line.getY2());
            drawBranchRight(g2d, branchNo+1, line.getX2(), line.getY2());
        }
    }

    public int getrotation(){
        return rotation;
    }

    public void setrotation(int value){
        rotation = value;
    }
}
