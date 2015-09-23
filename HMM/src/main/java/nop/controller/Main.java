package nop.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;

import nop.view.ui.DateTextField;
import nop.view.ui.MenuView;

public class Main extends JFrame {

	private static JPanel currentPanel;
	private static Main mainFrame;
	private static Controller controller;
	private static final int HEIGHT = 600;
	private static final int WIDTH = 700;
	static MenuView menuView;

	public Main() {
		controller = new Controller();
		controller.loadData();
		currentPanel = new JPanel();

		setTitle("HMM 2015");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		// menuView.setPreferredSize(new Dimension(50,30));
		// menuView.setBounds(0,0,50,30);
		// currentPanel.setBounds(30,0,100,100);
		// currentPanel.setSize(new Dimension(100,100));
		// currentPanel.setPreferredSize(new Dimension(100,100));

		// menuView.setBorder(new LineBorder(Color.black));
		// currentPanel.setBorder(new LineBorder(Color.RED));

	}

	public void jbInit() {
		DateTextField txtMonth = new DateTextField();
		txtMonth.setPreferredSize(new Dimension(100, 30));
		currentPanel.add(txtMonth);
		menuView = new MenuView(mainFrame);
		this.setLayout(new GridBagLayout());
		this.add(menuView, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
		add(currentPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,
				new Insets(0, 2, 0, 0), 0, 0));
	}

	public Controller getController() {
		return this.controller;
	}

	public static void changePanel(JPanel newPanel) {
		mainFrame.remove(menuView);
		mainFrame.remove(currentPanel);
		currentPanel = newPanel;
		mainFrame.add(menuView, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
		mainFrame.add(currentPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,
				new Insets(0, 2, 0, 0), 0, 0));
		mainFrame.validate();
		mainFrame.repaint();
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
		mainFrame.jbInit();
	}
}
