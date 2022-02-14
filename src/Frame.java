import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(Panel panel){
        super();
        this.add(panel);
        this.getContentPane().setPreferredSize(new Dimension(panel.getSize().width,panel.getSize().height));
        this.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-panel.getSize().width/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-panel.getSize().height/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(false);
        this.setTitle("Fractal");
        this.pack();
        
        this.setVisible(true);
    }
}
