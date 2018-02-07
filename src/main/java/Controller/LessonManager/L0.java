package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Lesson;
import Controller.MainGUI;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L0 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        return telemetry.displayedString.equals("Yay FTC!");
    }
}
