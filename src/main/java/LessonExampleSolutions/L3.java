package LessonExampleSolutions;

import Controller.Hardware.DcMotor;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L3 extends OpMode {

    DcMotor mainMotor;

    public L3() {
        super();
        LESSON = 3; // Set LESSON to one to check for correctness
    }

    @Override
    public void init() {
        mainMotor = hardwareMap.dcMotor.get("Main Motor");

        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    @Override
    public void start() {
        mainMotor.setPower(1);
    }

    @Override
    public void loop() {
        if (mainMotor.getCurrentPosition() > 100) {
            mainMotor.setPower(-1);
        } else if (mainMotor.getCurrentPosition() < -100) {
            mainMotor.setPower(1);
        }
    }

    @Override
    public void stop() {

    }
}
