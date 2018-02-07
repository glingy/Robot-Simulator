package Teamcode;

import Controller.OpMode;
import Controller.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Running", group="UserCode")
public class Run extends OpMode {

    public Run() {
        super();
        LESSON = 0;  //Uncomment this line to check as lesson 0. Change number to check as a different lesson, or comment out to not check at all.
    }

    // is run once on initialization
    @Override
    public void init() {

    }

    //is run once when start button is pressed
    @Override
    public void start() {
        telemetry.addLine("Yay FTC!");
        telemetry.update();
    }

    //is run continuously after start button pressed
    @Override
    public void loop() {

    }

    //is run once when stop button is pressed
    @Override
    public void stop() {

    }
}
