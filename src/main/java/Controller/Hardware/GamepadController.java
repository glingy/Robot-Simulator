package Controller.Hardware;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 * Created by gregory.ling on 12/15/17.
 */

public class GamepadController extends Gamepad implements KeyEventDispatcher {
    private GamepadKeyBindings keyBindings;

    public GamepadController(GamepadKeyBindings keyBindings) {
        this.keyBindings = keyBindings;
    }

    private void keyStateChange(KeyEvent keyEvent, boolean state) {
        if (keyEvent.getKeyChar() == keyBindings.a) {
            a = state;
        } else if (keyEvent.getKeyChar() == keyBindings.b) {
            b = state;
        } else if (keyEvent.getKeyChar() == keyBindings.x) {
            x = state;
        } else if (keyEvent.getKeyChar() == keyBindings.y) {
            y = state;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
            keyStateChange(keyEvent, true);
        } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
            keyStateChange(keyEvent, false);
        }
        return false;
    }
}
