package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Lesson;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L4 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        if (devices.containsKey("Main Motor") && devices.get("Main Motor") instanceof DcMotor && devices.containsKey("Other Motor") && devices.get("Other Motor") instanceof DcMotor) {
            System.out.println("Stage 1 Passed: You initialized valid motors.");
            gamepad1.a = false;
            gamepad1.b = false;
            code.loop();
            if (((DcMotor) devices.get("Main Motor")).getPower() == 0 && ((DcMotor) devices.get("Other Motor")).getPower() == 0) {
                System.out.println("Stage 2 Passed: Your motor are stopped when no buttons are pressed.");
                gamepad1.a = true;
                code.loop();
                if (((DcMotor) devices.get("Main Motor")).getPower() > 0 && ((DcMotor) devices.get("Other Motor")).getPower() == 0) {
                    System.out.println("Stage 3 Passed: Your main motor runs forwards when gamepad1.a is pressed.");
                    gamepad1.b = true;
                    gamepad1.a = false;
                    code.loop();
                    if (((DcMotor) devices.get("Other Motor")).getPower() > 0 && ((DcMotor) devices.get("Main Motor")).getPower() == 0) {
                        System.out.println("Stage 4 Passed: Your other motor runs forwards when gamepad1.b is pressed.");
                        gamepad1.b = false;
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
