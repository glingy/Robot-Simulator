package Teamcode;

import Controller.Hardware.GamepadKeyBindings;

/**
 * Created by gregory.ling on 12/15/17.
 */

public final class SettingsManager {
    public GamepadKeyBindings Gamepad1 = new GamepadKeyBindings();
    public GamepadKeyBindings Gamepad2 = new GamepadKeyBindings();

    public SettingsManager() {
        Gamepad1.a = 'a';
        Gamepad1.b = 'b';
        Gamepad1.x = 'x';
        Gamepad1.y = 'y';

        Gamepad2.a = '3';
        Gamepad2.b = '4';
        Gamepad2.x = '5';
        Gamepad2.y = '6';
    }
}
