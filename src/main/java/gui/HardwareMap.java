package gui;

/**
 * Created by gregory.ling on 12/14/17.
 */

public class HardwareMap {
    public class DcMotorC {
        public DcMotor get(String name) {
            if (MainGUI.devices.containsKey(name) && MainGUI.devices.get(name) instanceof DcMotor)
                return (DcMotor) MainGUI.devices.get(name);
            return new DcMotorImpl(name);
        }
    }

    public class LightSensorC {
        public LightSensor get(String name) {
            if (MainGUI.devices.containsKey(name) && MainGUI.devices.get(name) instanceof LightSensor)
                return (LightSensor) MainGUI.devices.get(name);
            return new LightSensorImpl(name);
        }
    }

    public class ServoC {
        public Servo get(String name) {
            if (MainGUI.devices.containsKey(name) && MainGUI.devices.get(name) instanceof Servo)
                return (Servo) MainGUI.devices.get(name);
            return new ServoImpl(name);
        }
    }

    public class CRServoC {
        public CRServo get(String name) {
            if (MainGUI.devices.containsKey(name) && MainGUI.devices.get(name) instanceof CRServo)
                return (CRServo) MainGUI.devices.get(name);
            return new CRServoImpl(name);
        }
    }

    public LightSensorC lightSensor = new LightSensorC();
    public DcMotorC dcMotor = new DcMotorC();
    public ServoC servo = new ServoC();
    public CRServoC crservo = new CRServoC();
}
