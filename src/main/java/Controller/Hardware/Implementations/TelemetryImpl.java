package Controller.Hardware.Implementations;

import javax.swing.JTextArea;

import Controller.Hardware.Telemetry;

/**
 * Created by gregory.ling on 12/14/17.
 */

public class TelemetryImpl extends JTextArea implements Telemetry {
    String telemetryString = "";
    public String displayedString = "";

    public TelemetryImpl() {
        super();
        setEditable(false);
    }

    public void addLine(String line) {
        telemetryString += line + "\n";
    }

    public void addData(String name, Object data) {
        telemetryString += name + ": " + data.toString() + "\n";
    }

    public void update() {
        setText(telemetryString);
        displayedString = telemetryString;
        telemetryString = "";
    }
}
