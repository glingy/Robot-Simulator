package Controller.LessonManager;


import Controller.Hardware.DcMotor;
import Controller.Hardware.Implementations.DcMotorImpl;
import Controller.Lesson;
import Controller.OpMode;

/**
 * Created by gregory.ling on 2/4/18.
 */

public class L3 extends Lesson {

    @Override
    public boolean test(OpMode code) {
        if (devices.containsKey("Main Motor") && devices.get("Main Motor") instanceof DcMotor) {
            System.out.println("Stage 1 Passed: You initiailized a valid motor.");
            code.loop();
            if (((DcMotor) devices.get("Main Motor")).getPower() > 0) {
                System.out.println("Stage 2 Passed: Your motor runs forwards at first.");
                ((DcMotorImpl) devices.get("Main Motor")).pos = 101;
                code.loop();
                if (((DcMotor) devices.get("Main Motor")).getPower() < 0) {
                    System.out.println("Stage 3 Passed: Your motor runs backwards after the motor passes 100.");
                    ((DcMotorImpl) devices.get("Main Motor")).pos = 0;
                    code.loop();
                    if (((DcMotor) devices.get("Main Motor")).getPower() < 0) {
                        System.out.println("Stage 4 Passed: Your motor continues to run backwards towards -100.");
                        ((DcMotorImpl) devices.get("Main Motor")).pos = -101;
                        code.loop();
                        if (((DcMotor) devices.get("Main Motor")).getPower() > 0) {
                            System.out.println("Stage 5 Passed: Your motor runs forwards agian after passing -100.");
                            ((DcMotorImpl) devices.get("Main Motor")).pos = 0;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
