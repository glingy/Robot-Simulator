package Controller;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

/**
 * Created by gregory.ling on 12/16/17.
 */

public class Slider {
    public JSlider slider;
    public JLabel label;

    public Slider(HardwareDevice changeListener) {
        slider = new JSlider();
        label = new JLabel();
        slider = new JSlider();
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        if (changeListener instanceof ChangeListener)
            slider.addChangeListener((ChangeListener) changeListener);
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
