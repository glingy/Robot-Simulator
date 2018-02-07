package LessonExampleSolutions;

import Controller.Hardware.DcMotor;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L2 extends OpMode {

    DcMotor mainMotor;

    public L2() {
        super();
        LESSON = 2; // Set LESSON to one to check for correctness
    }

    @Override
    public void init() {
        mainMotor = hardwareMap.dcMotor.get("Main Motor");

        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    @Override
    public void start() {
        //mainMotor.setPower(0.5); //Unnecessary in this lesson
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            mainMotor.setPower(1);
        } else {
            mainMotor.setPower(-1);
        }
    }

    @Override
    public void stop() {

    }
}
