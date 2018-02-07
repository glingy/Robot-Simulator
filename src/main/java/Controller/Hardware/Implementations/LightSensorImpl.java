package Controller.Hardware.Implementations;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Hardware.LightSensor;
import Controller.HardwareDevice;

/**
 * Created by gregory.ling on 12/16/17.
 */

public class LightSensorImpl extends HardwareDevice implements LightSensor, ChangeListener {
    private double maxLight = Math.random() * 230;
    private double value = 0;
    private boolean led = false;

    public void stateChanged(ChangeEvent changeEvent) {
        sliders[0].label.setText(String.format("Intensity: %d%%", sliders[0].slider.getValue()));
        value = sliders[0].slider.getValue()/100d;
    }

    public LightSensorImpl(String name) {
        super("Light Sensor", name, 1, 1);
        sliders[0].slider.setValue(0);
        sliders[0].label.setText("Intensity: 0%");
        enableLed(true);
    }

    public void update() {}

    public double getLightDetected() {
        return value;
    }

    public double getRawLightDetected() {
        return value * maxLight;
    }

    public double getRawLightDetectedMax() {
        return maxLight;
    }

    public void enableLed(boolean enable) {
        led = enable;
        labels[0].setText(led ? "Light On" : "Light Off");
    }

    public String status() {
        return String.format("LED: %s, Light Percentage: %d%%", led? "ON" : "OFF", (int)(value * 100));
    }
}
