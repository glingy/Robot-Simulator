package gui;

/**
 * Created by gregory.ling on 12/14/17.
 */

public class HardwareMap {
    public class DcMotorC {
        public DcMotor get(String name) {
            if (DcMotorImpl.devices.containsKey(name))
                return (DcMotor) DcMotorImpl.devices.get(name);
            return new DcMotorImpl(name);
        }
    }

    public class LightSensorC {
        public LightSensor get(String name) {
            if (LightSensorImpl.devices.containsKey(name))
                return (LightSensor) LightSensorImpl.devices.get(name);
            return new LightSensorImpl(name);
        }
    }

    public LightSensorC lightSensor = new LightSensorC();
    public DcMotorC dcMotor = new DcMotorC();
}
