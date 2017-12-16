package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Created by gregory.ling on 12/13/17.
 */

public class DcMotorImpl extends JPanel implements DcMotor {
    public static Map<String, DcMotorImpl> motors = new HashMap<>();
    private int index = 0;
    private JLabel speedL = new JLabel();
    private JLabel posL = new JLabel();
    private JLabel targPosL = new JLabel();

    private double speed = 0;
    private double pos = 0;
    private int targPos = 0;
    private Direction direction = Direction.FORWARD;
    private RunMode mode = RunMode.RUN_WITHOUT_ENCODER; // Unknown in reality

    public DcMotorImpl(String name) {
        super();
        index = motors.size();
        motors.put(name, this);
        setBorder(new TitledBorder("DcMotor " + index + " (" + name + "):"));
        setLayout(new GridLayout(3, 1));
        speedL.setText("Speed: 0%");
        posL.setText("Current Position: 0");
        targPosL.setText("Target Position: 0");

        speedL.setHorizontalAlignment(SwingConstants.CENTER);
        posL.setHorizontalAlignment(SwingConstants.CENTER);
        targPosL.setHorizontalAlignment(SwingConstants.CENTER);

        add(speedL);
        add(posL);
        add(targPosL);

        System.out.println(MainGUI.ifacesLayout.getColumns());
        System.out.println(MainGUI.ifacesLayout.getRows());
        System.out.println(MainGUI.mainGUI.getWidth());
        System.out.println(MainGUI.mainGUI.getHeight());
        System.out.println(motors.size());

        if (MainGUI.ifacesLayout.getColumns() == 0) {
            System.out.println("Column Zero");
            MainGUI.ifacesLayout.setColumns(1);
        } else if (MainGUI.ifacesLayout.getRows() == 0){
            System.out.println("Row Zero");
            MainGUI.ifacesLayout.setRows(1);
        } else if (MainGUI.ifacesLayout.getColumns() * MainGUI.ifacesLayout.getRows() >= motors.size()) {
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
        MainGUI.mainGUI.setMinimumSize(new Dimension(MainGUI.ifacesLayout.getColumns() * 200, (MainGUI.ifacesLayout.getRows() * 200) + 100));
        System.out.println(MainGUI.ifacesLayout.getColumns());
        System.out.println(MainGUI.ifacesLayout.getRows());
        System.out.println(MainGUI.mainGUI.getWidth());
        System.out.println(MainGUI.mainGUI.getHeight());
        System.out.println(motors.size());
        System.out.println("------------");
    }
    public void update() {
        if (mode == RunMode.RUN_WITHOUT_ENCODER || mode == RunMode.RUN_USING_ENCODER) {
            pos += speed * direction.value();
        } else if (mode == RunMode.STOP_AND_RESET_ENCODER) {
            pos = 0;
        } else if (mode == RunMode.RUN_TO_POSITION){
            pos += Math.min(Math.max((targPos - pos)/10d, -1), 1) * Math.abs(speed);
            if (Math.abs(pos - targPos) < 0.1) {
                pos = targPos;
            }
        }
        posL.setText("Current Position: " + (int)pos + "");
    }

    public void setPower(double power) {
        speed = Math.min(Math.max(power, -1), 1);
        speedL.setText("Speed: " + speed * 100 + "%");
    }

    public void setTargetPosition(int position) {
        targPos = position;
        targPosL.setText("Target Position: " + targPos + "");
    }

    public int getCurrentPosition() {
        return (int)pos;
    }

    public void setMode(RunMode mode) {
        this.mode = mode;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void resetDeviceConfigurationForOpMode() {
        setDirection(Direction.FORWARD);
    }

    public static void loop() {
        for (DcMotorImpl m : motors.values()) {
            m.update();
        }
    }
}
