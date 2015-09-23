package nop.view.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import nop.controller.Main;
import nop.model.Model;

public class MenuView extends JPanel{
	 JMenu fileMenu;
	 JMenuItem settingAction;
	 JMenuItem exitAction;
	 JMenuBar menuBar;
	 Main mainframe;
	public MenuView(Main mainframe){
		this.mainframe=mainframe;
		createPanel();
		registerListner();
	}
	
	
	public void createPanel(){
		//menu panel
        menuBar = new JMenuBar();
        menuBar.setOpaque(false);

        //add item in file menu
        fileMenu = new JMenu("File");
        settingAction = new JMenuItem("Setting");
        exitAction = new JMenuItem("Exit");
        fileMenu.add(settingAction);
        fileMenu.add(exitAction);
        
        menuBar.add(fileMenu);
        this.add(menuBar);
        this.setSize(new Dimension(100,30));
	}
	public JPanel getSettingPanel(){
		return new TemplateBillView(mainframe.getController());
	}
	
	public void registerListner(){
		  exitAction.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {

	                if (getDialogConfirmation("Do you want to quit?") == JOptionPane.YES_OPTION) {
	                    System.exit(0);
	                }
	            }
	        });
		  
		  settingAction.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	               mainframe.changePanel(getSettingPanel());
	            }
	        });
	}
	
	private int getDialogConfirmation(String message) {
        int choose = JOptionPane.showConfirmDialog(null, message, "Information", JOptionPane.YES_NO_OPTION);
        return choose;
    }
}
