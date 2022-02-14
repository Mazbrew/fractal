
import javax.swing.JLayeredPane;

public class LayeredPanel extends JLayeredPane{
    private int size;

    private Panel panel;

    public LayeredPanel(int size){
        super();
        this.size= size;
        this.setBounds(0,0,size,size);
        panel = new Panel(this);
        this.add(panel, 1);
        this.add(new Slider(this),0);
    }

    public int getsize(){
        return size;
    }

    public Panel getPanel(){
        return panel;
    }
}
