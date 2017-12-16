package gui;

/**
 * Created by gregory.ling on 12/14/17.
 */

public interface DcMotor {
    void setPower(double power);
    void setDirection(DcMotorImpl.Direction direction);
    void setTargetPosition(int position);
    int getCurrentPosition();
    void setMode(DcMotorImpl.RunMode mode);
    RunMode getMode();
    void resetDeviceConfigurationForOpMode();
    void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior);
    ZeroPowerBehavior getZeroPowerBehavoir();

    enum ZeroPowerBehavior {
        UNKNOWN,
        BRAKE,
        FLOAT
    }

    enum RunMode {
        RUN_WITHOUT_ENCODER,
        RUN_USING_ENCODER,
        RUN_TO_POSITION,
        STOP_AND_RESET_ENCODER
    }

    enum Direction {
        FORWARD,
        REVERSE;

        int value() {
            return this == FORWARD? 1 : -1;
        }
    }



}
