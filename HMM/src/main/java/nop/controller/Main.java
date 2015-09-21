package nop.controller;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main extends JFrame {

    private static JPanel currentPanel;
    private static Main mainFrame;

    public Main() {

        currentPanel = new JPanel();
        setTitle("HMM 2015");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(currentPanel);
    }

    public static void changePanel(JPanel newPanel) {

        mainFrame.remove(currentPanel);
        currentPanel = newPanel;
        mainFrame.add(currentPanel);
        mainFrame.validate();
        System.gc();
    }

    public static Main getMainFrame() {
        return mainFrame;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        try {
            for (LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Cannot load the Nimbus theme!!!");
        }
        mainFrame = new Main();
    }
}
