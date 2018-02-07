package Controller.Hardware;

/**
 * Created by gregory.ling on 12/16/17.
 */

public interface LightSensor {
    double getLightDetected();
    double getRawLightDetected();
    double getRawLightDetectedMax();
    void enableLed(boolean enable);
    String status();
}
