import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ChangeListener{
    private LayeredPanel LP;
    public Slider(LayeredPanel LP){
        super(0,360);
        this.LP=LP;
        this.setValue(LP.getPanel().getrotation());
        this.setSize(300,25);
        this.setLocation(LP.getsize()/2-this.getSize().width/2,0);
        this.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        LP.getPanel().setrotation(this.getValue());
        LP.repaint();
    }
}
