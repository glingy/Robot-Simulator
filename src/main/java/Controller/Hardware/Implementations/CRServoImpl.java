package Controller.Hardware.Implementations;

import Controller.Hardware.CRServo;
import Controller.HardwareDevice;

/**
 * Created by gregory.ling on 1/2/18.
 */

public class CRServoImpl extends HardwareDevice implements CRServo {
    Direction direction = Direction.FORWARD;
    double power = 0.0;
    double position = 0;
    final double MAX_SPEED = 1;

    final int DIRECTION = 0;
    final int POWER = 1;
    final int POSITION = 2;


    public CRServoImpl(String name) {
        super("Servo", name, 3, 0);
        labels[DIRECTION].setText(String.format("Direction: %s", (direction == Direction.FORWARD ? "Forward" : "Reverse")));
        labels[POWER].setText(String.format("Power: %.1f", power));
        labels[POSITION].setText(String.format("Position: %.1f?", position));
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        labels[DIRECTION].setText("Direction: " + (direction == Direction.FORWARD ? "Forward" : "Reverse"));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPower(double power) {
        power = Math.abs(Math.min(Math.max(power, -1), 1));
        this.power = power;
        labels[POWER].setText(String.format("Power: %.1f%%", (power * 100)));
    }

    public double getPower() {
        return power;
    }

    public void update() {
        position += power * MAX_SPEED * (direction == Direction.FORWARD? 1 : -1);
        labels[POSITION].setText(String.format("Position: %.0f?", position));
    }
}
