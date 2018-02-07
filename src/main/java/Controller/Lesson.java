package Controller;

import java.util.HashMap;
import java.util.Map;

import Controller.Hardware.Gamepad;
import Controller.Hardware.Implementations.TelemetryImpl;
import Controller.Hardware.Telemetry;
import Controller.HardwareMap;
import Controller.MainGUI;

/**
 * Created by gregory.ling on 2/4/18.
 */

public abstract class Lesson {
    protected Map<String, HardwareDevice> devices = MainGUI.devices;
    protected TelemetryImpl telemetry = MainGUI.telemetry;
    protected Gamepad gamepad1 = MainGUI.gamepad1;
    protected Gamepad gamepad2 = MainGUI.gamepad2;

    public Lesson() {
    }

    protected void reset(OpMode code) {
        code.stop();
        devices.clear();

    }

    abstract public boolean test(OpMode code);
}
