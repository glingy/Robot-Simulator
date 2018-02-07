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
        telemetryString += (telemetryString.length() > 0 ? "\n" : "") + line;
    }

    public void addData(String name, Object data) {
        telemetryString += (telemetryString.length() > 0 ? "\n" : "") + name + ": " + data.toString();
    }

    public void update() {
        setText(telemetryString);
        displayedString = telemetryString;
        telemetryString = "";
    }
}
