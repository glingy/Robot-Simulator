# RobotSimulator
A simulator for the FTC Robot Controller written in Java.

The goal of this project is to allow for some off-bot theoretical testing and langauge learining. This will simulate motors running and the gamepad presses to show what your code will do. There are almost no physics and the motor speeds are arbitrary at the moment, but it allows for the testing of ideas and for someone to teach the language. 

## Currently Supports:
 * DcMotor (Primitively, and with no physics or zeroPowerBehavior, but movement is shown)
 * Telemetry (Shows telemetry output to main window)
 * Gamepad (With modifiable keybinds in the SettingsManager class)
 * OpModes (But only in the class Run in the package Teamcode currently: support for unknown opModes to be added later)
 * Light Sensor (With random maximum light because I don't know what the real max is)
 * Servo
 * CRServo
 * Addition of custom hardware devices
 
## Setup:
 * Open as Android Studio project and modify the Teamcode.Run class.
 * Click Run (It will call the configuration MainGUI, that's the right one)
 * Look at the window that appears and ignore the console debug output.

## Creating Custom HardwareDevices:
 * Extend class HardwareDevice (with the existing naming convention) and implement the update() function as public.
 * Call super in constructor with the specifications for your sensor
 * Add your sensor to the main device list (MainGUI.devices.put(*name*, *device*)) to add to the update loop
 * Make an interface (with the existing naming convention) that is the same name as the FTC one (if there is a corresponding device)
 * In the hardwareMap class, duplicate an existing class and rename the classes to what you have named yours.
 * The new hardware device should be good to go. Use in an opMode as shown in the example to create an instance of the device.

## TODO:
 * Reorganize so the Controller package isn't so cluttered and rename that package as well
 * Implement gamepad joystick
