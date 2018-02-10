package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Hardware.Implementations.DcMotorImpl;
import Controller.Lesson;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L5 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        if (devices.containsKey("Main Motor") && devices.get("Main Motor") instanceof DcMotor) {
            System.out.println("Stage 1 Passed: You initialized a valid motor.");
            code.loop();
            if (((DcMotor) devices.get("Main Motor")).getPower() > 0 && ((DcMotor) devices.get("Main Motor")).getTargetPosition() == 100) {
                System.out.println("Stage 2 Passed: Your motor power was set correctly and initial target is 100.");
                gamepad1.a = true;
                gamepad1.b = false;
                code.loop();
                if (((DcMotor) devices.get("Main Motor")).getPower() > 0 && ((DcMotor) devices.get("Main Motor")).getTargetPosition() == 1000) {
                    System.out.println("Stage 3 Passed: You set the target position to 1000 when a is pressed.");
                    gamepad1.a = true;
                    gamepad1.b = true;
                    code.loop();
                    if (((DcMotor) devices.get("Main Motor")).getPower() > 0 && ((DcMotor) devices.get("Main Motor")).getTargetPosition() == 1000) {
                        System.out.println("Stage 4 Passed: You left the target position at 1000 when both are pressed.");
                        gamepad1.a = false;
                        gamepad1.b = true;
                        code.loop();
                        if (((DcMotor) devices.get("Main Motor")).getPower() > 0 && ((DcMotor) devices.get("Main Motor")).getTargetPosition() == -100) {
                            System.out.println("Stage 5 Passed: You set the target position to -100 when only b is pressed.");
                            gamepad1.b = false;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
