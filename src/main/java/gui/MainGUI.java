package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import teamcode.Run;
import teamcode.SettingsManager;

public class MainGUI extends JFrame {
    static GridBagLayout ifacesLayout = new GridBagLayout();
    static JPanel ifaces;
    static TelemetryImpl telemetry;
    static SettingsManager settings = new SettingsManager();
    static GamepadController gamepad1 = new GamepadController(settings.Gamepad1);
    static Map<String, HardwareDevice> devices = new HashMap<>();
    Timer timer;
    TimerTask timerTask;
    Boolean running = false;
    public static MainGUI mainGUI;

    public MainGUI() {
        mainGUI = this;
        Container cp = getContentPane();

        ifaces = new JPanel();
        ifaces.setLayout(ifacesLayout);

        telemetry = new TelemetryImpl();

        JScrollPane teleScroll = new JScrollPane(telemetry);
        teleScroll.setAutoscrolls(true);

        // Content-pane sets layout
        GroupLayout layout = new GroupLayout(cp);
        cp.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup().addComponent(ifaces, GroupLayout.Alignment.CENTER).addComponent(teleScroll, GroupLayout.Alignment.CENTER)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup().addGroup(
                        layout.createSequentialGroup().addComponent(ifaces, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(teleScroll, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                )
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("FTC Java Simulator"); // "super" JFrame sets title
        setSize(600, 400);         // "super" JFrame sets initial size
        setVisible(true);

        OpMode code = new Run();
        code.init();
        code.start();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (running) {
                    code.loop();
                    for (HardwareDevice d: devices.values()) d.update();
                }
            }
        };

        timer.schedule(timerTask, 0, 50);
        running = true;
        addWindowStateListener((windowEvent) -> {
            if (windowEvent.getNewState() == WindowEvent.WINDOW_CLOSING) {
                timer.cancel();
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(gamepad1);
    }

    public static void resize() {
        System.out.println("Resizing");
        int count = devices.size();
        int width = (int)Math.sqrt(count - 1) + 1;
        int height = (count - 1)/width + 1;
        int x = 0;
        int y = 0;
        for (HardwareDevice d : devices.values()) {
            GridBagConstraints c = ifacesLayout.getConstraints(d);
            if (x == width) {
                x = 0;
                y++;
            }
            System.out.println(x);
            c.gridx = x;
            c.gridy = y;
            ifacesLayout.setConstraints(d, c);
            x++;
        }
        ifaces.setMinimumSize(new Dimension(width * 200, height * 200));
        mainGUI.setMinimumSize(new Dimension(width * 200, height * 200 + 125));
    }




    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(() -> {new MainGUI();});
    }
}