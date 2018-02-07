package LessonExampleSolutions;

import Controller.Hardware.DcMotor;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L1 extends OpMode {

    DcMotor mainMotor;

    public L1() {
        super();
        LESSON = 1; // Set LESSON to one to check for correctness
    }

    @Override
    public void init() {
        mainMotor = hardwareMap.dcMotor.get("Main Motor");

        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    @Override
    public void start() {
        mainMotor.setPower(0.5);
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }
}
