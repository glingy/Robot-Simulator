package Controller.Hardware;

/**
 * Created by gregory.ling on 12/14/17.
 */

public interface Telemetry {
    void addLine(String line);
    void addData(String name, Object data);
    void update();
}
