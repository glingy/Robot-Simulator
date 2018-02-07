package LessonExampleSolutions;

import Controller.Hardware.CRServo;
import Controller.Hardware.DcMotor;
import Controller.Hardware.LightSensor;
import Controller.Hardware.Servo;
import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Lesson 1", group="Lessons")
public class L0 extends OpMode {

    public L0() {
        super();
        LESSON = 0; // Set LESSON to one to check for correctness
    }

    // is run once on initialization
    @Override
    public void init() {
        telemetry.addLine("Yay FTC!"); // add line to telemetry buffer
        telemetry.update();            // send current telemetry buffer
    }

    //is run once when start button is pressed
    @Override
    public void start() {
        // You could also put the two lines above here.
        // It only changes when the data is sent
    }

    //is run continuously after start button pressed
    @Override
    public void loop() {
        // Probably shouldn't put it here for this exercise becuase this is sent every run and that text only needs to be sent once.
    }

    //is run once when stop button is pressed
    @Override
    public void stop() {
        // But not here.
        // Telemetry here is not able to be read by us before wiped by the driver station closing the program, so telemetry here is futile.
    }
}
