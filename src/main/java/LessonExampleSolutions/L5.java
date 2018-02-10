package LessonExampleSolutions;

import Controller.Hardware.DcMotor;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L5 extends OpMode {

    DcMotor mainMotor;

    public L5() {
        super();
        LESSON = 5; // Set LESSON to one to check for correctness
    }

    @Override
    public void init() {
        mainMotor = hardwareMap.dcMotor.get("Main Motor");
        mainMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    @Override
    public void start() {
        mainMotor.setPower(1);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            mainMotor.setTargetPosition(1000);
        } else if (gamepad1.b){
            mainMotor.setTargetPosition(-100);
        } else {
            mainMotor.setTargetPosition(100);
        }
    }

    @Override
    public void stop() {

    }
}
