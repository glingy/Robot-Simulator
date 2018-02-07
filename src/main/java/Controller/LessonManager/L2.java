package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Lesson;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L2 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        if (devices.containsKey("Main Motor") && devices.get("Main Motor") instanceof DcMotor) {
            System.out.println("Stage 1 Passed: You initiailized a valid motor.");
            gamepad1.x = false;
            code.loop();
            if (((DcMotor) devices.get("Main Motor")).getPower() < 0) {
                System.out.println("Stage 2 Passed: Your motor runs backwards when gamepad1.x is not pressed.");
                gamepad1.x = true;
                code.loop();
                if (((DcMotor) devices.get("Main Motor")).getPower() > 0) {
                    System.out.println("Stage 3 Passed: Your motor runs forwards when gamepad1.x is pressed.");
                    gamepad1.x = false;
                    return true;
                }
            }
        }

        return false;
    }
}
