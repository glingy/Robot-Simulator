package LessonExampleSolutions;

import Controller.Hardware.DcMotor;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L4 extends OpMode {

    DcMotor mainMotor;
    DcMotor otherMotor;

    public L4() {
        super();
        LESSON = 4; // Set LESSON to one to check for correctness
    }

    @Override
    public void init() {
        mainMotor = hardwareMap.dcMotor.get("Main Motor");
        otherMotor = hardwareMap.dcMotor.get("Other Motor");

        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            mainMotor.setPower(1);
        } else {
            mainMotor.setPower(0);
        }
        if (gamepad1.b) {
            otherMotor.setPower(1);
        } else {
            otherMotor.setPower(0);
        }
    }

    @Override
    public void stop() {

    }
}
