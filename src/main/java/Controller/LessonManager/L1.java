package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Lesson;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L1 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        return (devices.containsKey("Main Motor") && devices.get("Main Motor") instanceof DcMotor && ((DcMotor) devices.get("Main Motor")).getPower() == 0.5);
    }
}
