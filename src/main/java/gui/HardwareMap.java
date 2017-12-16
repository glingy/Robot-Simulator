package gui;

/**
 * Created by gregory.ling on 12/14/17.
 */

public class HardwareMap {
    public class DcMotorC {
        public DcMotorImpl get(String name) {
            if (DcMotorImpl.motors.containsKey(name))
                return DcMotorImpl.motors.get(name);
            return new DcMotorImpl(name);

        }
    }

    public DcMotorC dcMotor = new DcMotorC();
}
