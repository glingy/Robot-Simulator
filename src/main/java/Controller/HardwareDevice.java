package Controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Created by gregory.ling on 12/15/17.
 */

public abstract class HardwareDevice extends JPanel {
    protected JLabel labels[];
    protected Slider sliders[];
    public HardwareDevice(String deviceName, String instanceName, int labelCount, int sliderCount) {
        labels = new JLabel[labelCount];
        sliders = new Slider[sliderCount];
        setBorder(new TitledBorder(String.format("%s (%s):", deviceName, instanceName)));
        GridLayout layout = new GridLayout(labelCount + (2 * sliderCount), 1);
        setLayout(layout);
        setPreferredSize(new Dimension(200, 200));


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.weighty = 0.5;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(labels[i]);
        }

        for (int i = 0; i < sliders.length; i++) {
            sliders[i] = new Slider(this);
            add(sliders[i].label);
            add(sliders[i].slider);
        }

        /*if ((MainGUI.ifaces.getHeight() / 200) * (MainGUI.ifaces.getWidth() / 200) > MainGUI.ifaces.getComponentCount()) {
        } else if (MainGUI.mainGUI.getHeight() - 100 >= ((MainGUI.ifacesLayout.getRows() + 1) * 200)){
            System.out.println("Row increase");
            constraints.gridx =
        } else if ((MainGUI.mainGUI.getWidth() >= (MainGUI.ifacesLayout.getColumns() + 1) * 200) || (2 * (MainGUI.mainGUI.getHeight() - 100) >= (MainGUI.mainGUI.getWidth()))) {
            System.out.println("Column increase");
            MainGUI.ifacesLayout.setColumns(MainGUI.ifacesLayout.getColumns() + 1);
        } else {
            System.out.println("Row increase two");
            MainGUI.ifacesLayout.setRows(MainGUI.ifacesLayout.getRows() + 1);
        }



        MainGUI.mainGUI.setMinimumSize(new Dimension(MainGUI.ifacesLayout.getColumns() * 200, (MainGUI.ifacesLayout.getRows() * 200) + 100));
*/

        MainGUI.ifaces.add(this, constraints);
        MainGUI.devices.put(instanceName, this);
        MainGUI.resize();
    }

    abstract public void update();
}
