import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ChangeListener{
    private Panel panel;
    public Slider(Panel panel){
        super(0,180);
        this.panel=panel;
        this.setValue(panel.getrotation());
        this.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        panel.setrotation(this.getValue());
        panel.repaint();
    }
}
