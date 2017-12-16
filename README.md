# RobotSimulator
A simulator for the FTC Robot Controller written in Java.

The goal of this project is to allow for some off-bot theoretical testing and langauge learining. This will simulate motors running and the gamepad presses to show what your code will do. There are almost no physics and the motor speeds are arbitrary at the moment, but it allows for the testing of ideas and for someone to teach the language. 

## Currently Supports:
 * DcMotor (Primitively, and with no physics or zeroPowerBehavior, but movement is shown)
 * Telemetry (Shows telemetry output to main window)
 * Gamepad (With modifiable keybinds in the SettingsManager class)
 * OpModes (But only in the class Run in the package teamcode currently: support for unknown opModes to be added later)
 * Primitive Sensors coming soon... (whenever I get around to it)
