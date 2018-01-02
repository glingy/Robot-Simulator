package teamcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gui.Gamepad;
import gui.GamepadKeyBindings;

/**
 * Created by gregory.ling on 12/15/17.
 */

public class SettingsManager {
    public GamepadKeyBindings Gamepad1 = new GamepadKeyBindings();

    public SettingsManager() {
        Gamepad1.a = 'a';
        Gamepad1.b = 'b';
        Gamepad1.x = 'x';
        Gamepad1.y = 'y';
    }
}
