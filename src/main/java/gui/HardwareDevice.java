package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;

/**
 * Created by gregory.ling on 12/15/17.
 */

public abstract class HardwareDevice extends JPanel {
    public static Map<String, HardwareDevice> devices = new HashMap<>();

    private int index;
    protected JLabel labels[];
    protected JSlider sliders[];
    public HardwareDevice(String deviceName, String instanceName, int labelCount, int sliderCount) {
        labels = new JLabel[labelCount];
        sliders = new JSlider[sliderCount];

        index = devices.size();
        setBorder(new TitledBorder(String.format("%s %d (%s):", deviceName, index, instanceName)));
        setLayout(new GridLayout(labelCount + sliderCount, 1));

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(labels[i]);
        }

        for (int i = 0; i < sliders.length; i++) {
            sliders[i] = new JSlider();
            sliders[i].setMinimum(0);
            sliders[i].setMaximum(100);
            if (this instanceof ChangeListener)
                sliders[i].addChangeListener((ChangeListener) this);
            add(sliders[i]);
        }


        System.out.println(MainGUI.ifacesLayout.getColumns());
        System.out.println(MainGUI.ifacesLayout.getRows());
        System.out.println(MainGUI.mainGUI.getWidth());
        System.out.println(MainGUI.mainGUI.getHeight());
        System.out.println(MainGUI.ifaces.getComponentCount());

        if (MainGUI.ifacesLayout.getColumns() == 0) {
            System.out.println("Column Zero");
            MainGUI.ifacesLayout.setColumns(1);
        } else if (MainGUI.ifacesLayout.getRows() == 0){
            System.out.println("Row Zero");
            MainGUI.ifacesLayout.setRows(1);
        } else if (MainGUI.ifacesLayout.getColumns() * MainGUI.ifacesLayout.getRows() > MainGUI.ifaces.getComponentCount()) {
        } else if (MainGUI.mainGUI.getHeight() - 100 >= ((MainGUI.ifacesLayout.getRows() + 1) * 200)){
            System.out.println("Row increase");
            MainGUI.ifacesLayout.setRows(MainGUI.ifacesLayout.getRows() + 1);
        } else if ((MainGUI.mainGUI.getWidth() >= (MainGUI.ifacesLayout.getColumns() + 1) * 200) || (2 * (MainGUI.mainGUI.getHeight() - 100) >= (MainGUI.mainGUI.getWidth()))) {
            System.out.println("Column increase");
            MainGUI.ifacesLayout.setColumns(MainGUI.ifacesLayout.getColumns() + 1);
        } else {
            System.out.println("Row increase two");
            MainGUI.ifacesLayout.setRows(MainGUI.ifacesLayout.getRows() + 1);
        }

        MainGUI.ifaces.add(this);
        MainGUI.devices.put(instanceName, this);
        MainGUI.mainGUI.setMinimumSize(new Dimension(MainGUI.ifacesLayout.getColumns() * 200, (MainGUI.ifacesLayout.getRows() * 200) + 100));

        System.out.println(MainGUI.ifacesLayout.getColumns());
        System.out.println(MainGUI.ifacesLayout.getRows());
        System.out.println(MainGUI.mainGUI.getWidth());
        System.out.println(MainGUI.mainGUI.getHeight());
        System.out.println(MainGUI.ifaces.getComponentCount());
        System.out.println("------------");
    }

    abstract void update();
}
