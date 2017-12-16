package teamcode;

import gui.DcMotor;
import gui.LightSensor;
import gui.OpMode;
import gui.TeleOp;

/**
 * Created by gregory.ling on 12/14/17.
 */

@TeleOp(name="Hello", group="Testing")
public class Run extends OpMode {
    private DcMotor m;
    private DcMotor m2;
    private DcMotor m3;
    private DcMotor m4;
    private LightSensor l1;

    public Run() {
        super();
    }

    @Override
    public void init() {
        m = hardwareMap.dcMotor.get("Hello");
        m2 = hardwareMap.dcMotor.get("Test");
        m3 = hardwareMap.dcMotor.get("Look");
        m4 = hardwareMap.dcMotor.get("Helloo");
        l1 = hardwareMap.lightSensor.get("SensorTest");

        telemetry.addLine("Hello! Initialized...");

        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void start() {

        m.setPower(1);
        m2.setPower(1);
        m2.setTargetPosition(400);
        m3.setPower(0.5);
        m4.setPower(100);
    }

    @Override
    public void loop() {
        if (m.getCurrentPosition() > 100) {
            m.setDirection(DcMotor.Direction.REVERSE);
        } else if (m.getCurrentPosition() < -100){
            m.setDirection(DcMotor.Direction.FORWARD);
        }
        telemetry.addData("Motor 1 Position", m.getCurrentPosition());

        m4.setPower(gamepad1.a ? 1 : -1);

        telemetry.addData("Gamepad A", gamepad1.a);
        telemetry.addData("Gamepad B", gamepad1.b);
        telemetry.addData("Gamepad X", gamepad1.x);
        telemetry.addData("Gamepad Y", gamepad1.y);
        telemetry.addLine("Light Sensor: " + l1.getLightDetected());
        telemetry.update();
    }

    @Override
    public void stop() {

    }
}
