package Controller.Hardware.Implementations;

import Controller.Hardware.DcMotor;
import Controller.HardwareDevice;

/**
 * Created by gregory.ling on 12/13/17.
 */

public class DcMotorImpl extends HardwareDevice implements DcMotor {
    public static final int POWER = 0;
    public static final int POSITION = 1;
    public static final int TARGET_POSITION = 2;

    public double speed = 0;
    public double pos = 0;
    public int targPos = 0;
    public Direction direction = Direction.FORWARD;
    public RunMode mode = RunMode.RUN_USING_ENCODER; // I don't know default mode...
    public ZeroPowerBehavior zeroPowerBehavior = ZeroPowerBehavior.FLOAT;

    public DcMotorImpl(String name) {
        super("DcMotor", name, 3, 0);

        labels[POWER].setText(String.format("Power: %.1f%%", speed * 100));
        labels[POSITION].setText(String.format("Current Position: %.0f", pos));
        labels[TARGET_POSITION].setText(String.format("Target Position: %d", targPos));
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
        labels[POSITION].setText(String.format("Current Position: %.0f", pos));
    }

    public void setPower(double power) {
        speed = Math.min(Math.max(power, -1), 1);
        labels[POWER].setText(String.format("Power: %.1f%%", speed * 100));
    }

    public void setTargetPosition(int position) {
        targPos = position;
        labels[TARGET_POSITION].setText(String.format("Target Position: %d", targPos));
    }

    public int getCurrentPosition() {
        return (int)pos;
    }

    public void setMode(RunMode mode) {
        this.mode = mode;
    }

    public RunMode getMode() {
        return mode;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void resetDeviceConfigurationForOpMode() {
        setDirection(Direction.FORWARD);
    }

    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        this.zeroPowerBehavior = zeroPowerBehavior;
    }

    public ZeroPowerBehavior getZeroPowerBehavior() {
        return zeroPowerBehavior;
    }

    public double getPower() {
        return this.speed;
    }
}
