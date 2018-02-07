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

@TeleOp(name="Hello", group="Testing")
public class CombinedExample extends OpMode {
    private DcMotor m;
    private DcMotor m2;
    private DcMotor m3;
    private DcMotor m4;
    private DcMotor m5;
    private LightSensor l1;
    private Servo s1;
    private CRServo s2;


    public CombinedExample() {
        super();
        LESSON = 1;
    }

    @Override
    public void init() {
        m = hardwareMap.dcMotor.get("Hello");
        m2 = hardwareMap.dcMotor.get("Test");
        m3 = hardwareMap.dcMotor.get("Look");
        m4 = hardwareMap.dcMotor.get("Helloo");
        l1 = hardwareMap.lightSensor.get("SensorTest");
        s1 = hardwareMap.servo.get("Servo!");
        s2 = hardwareMap.crservo.get("CRServo!");
        m5 = hardwareMap.dcMotor.get("RunME");

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
        s1.setPosition(0);
        s2.setPower(0);
    }

    @Override
    public void loop() {
        m5.setPower(1);
        if (m.getCurrentPosition() > 100) {
            m.setDirection(DcMotor.Direction.REVERSE);
        } else if (m.getCurrentPosition() < -100){
            m.setDirection(DcMotor.Direction.FORWARD);
        }
        telemetry.addData("Motor 1 Position", m.getCurrentPosition());

        m4.setPower(gamepad1.a ? 1 : -1);
        m3.setPower(l1.getLightDetected());
        s1.setPosition(l1.getLightDetected());
        s2.setPower(l1.getLightDetected());

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
