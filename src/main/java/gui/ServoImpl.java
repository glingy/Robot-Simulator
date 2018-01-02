package gui;

/**
 * Created by gregory.ling on 1/2/18.
 */

public class ServoImpl extends HardwareDevice implements Servo {
    Direction direction = Direction.FORWARD;
    double position = 0.0;
    double maxPos = 1.0;
    double minPos = 0.0;

    final int DIRECTION = 0;
    final int POSITION = 1;

    public ServoImpl(String name) {
        super("Servo", name, 2, 0);
        labels[DIRECTION].setText(String.format("Direction: %s", (direction == Direction.FORWARD ? "Forward" : "Reverse")));
        labels[POSITION].setText(String.format("Position: %.3f", position));
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        labels[DIRECTION].setText(String.format("Direction: %s", (direction == Direction.FORWARD ? "Forward" : "Reverse")));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPosition(double position) {
        position = Math.min(Math.max(position, -1), 1);
        this.position = position * (maxPos - minPos) + minPos;
        labels[POSITION].setText(String.format("Position: %.3f", position));
    }

    public double getPosition() {
        return position;
    }

    public void scaleRange(double min, double max) {
        if (max > min) {
            minPos = min;
            maxPos = max;
        }
    }

    public void update() {}
}
