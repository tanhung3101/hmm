package nop.view.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import layout.TableLayout;
import nop.controller.Controller;
import nop.dto.Bill;

public class EditTemplateBillView extends JDialog implements KeyListener{
	
	Controller controller;	
	Bill bill;
	JLabel lblName=new JLabel("Name:");
    JTextField txtName=new JTextField("");
    JLabel lblPhonetic=new JLabel("Phonetic:");
    JTextField txtPhonetic=new JTextField("");
    JLabel lblDesc=new JLabel("Desc:");
    JTextField txtDesc=new JTextField("");
    JButton btnEnter=new JButton("Enter");
    JButton btnCancel=new JButton("Cancel");
     
    JLabel lblHeader=new JLabel("Edit Template Bill");
    
    JPanel tableViewPanel=new JPanel();
     
    private Font fontForValues;
 
    private Font fontForDesc;
 
    private Color colorForButton;
 
    private Color backgroundForWords;
 
    private Color backgroundForMain;
 
    private Color colorWords;
    JLabel lblErrorMessage=new JLabel();
    String errorMess=new String();
		
	public EditTemplateBillView(Controller controller,Bill bill){
		try{
			this.controller=controller;
			this.bill=bill;
			jBInit();
			 applyFormat();
		        setFormat();
		        validate();
		        registerListener();
		}catch(Exception e){
			System.out.println(e);
		}
	
	}
	 public void close() {
		 this.dispose();
	  }
	
	private void registerListener() {
		   btnCancel.addActionListener(new ActionListener() {
	             
	            public void actionPerformed(ActionEvent arg0) {
	                // TODO Auto-generated method stub
	                close();
	                 
	            }
	        });
	        btnEnter.addActionListener(new ActionListener() {
	             
	            public void actionPerformed(ActionEvent arg0) {
	                // TODO Auto-generated method stub
	                 	
	            }
	        });
	         
	        txtName.addKeyListener(this);
	        txtPhonetic.addKeyListener(this);
	        txtDesc.addKeyListener(this);
	}
	 public void setStatusButton(boolean status){
	        btnEnter.setEnabled(status);
	    }
	private void setFormat() {
		   btnEnter.setBackground(colorForButton);
	        btnCancel.setBackground(colorForButton);
	        btnEnter.setForeground(Color.white);
	        btnCancel.setForeground(Color.white);
	        lblErrorMessage.setForeground((Color)Color.decode("#fd0a0a"));
	        this.setBackground(backgroundForMain);
	}
	  public void validate(){
	        if((txtName.getText().length()==0)){
	            errorMess="Please enter required fields";
	            setStatusButton(false);
	        }else{
	            errorMess="";
	            setStatusButton(true);
	        }
	            lblErrorMessage.setText(errorMess);
	    }

	private void applyFormat() {
		 fontForValues =new Font("Arial", Font.BOLD,12);
	        fontForDesc =new Font("Arial", Font.PLAIN,12);
	         
	        colorForButton=Color.decode("#0c64e8");
	         
	        backgroundForWords=Color.decode("#323232");
	        backgroundForMain=Color.decode("#0ce890");
	        colorWords=Color.BLACK;
	}

	public void jBInit(){
		  double size[][]={{0.2,20,0.3},//cols
	        		{0.25,10,0.25,20,0.25,20,0.25}//rows
	        };
	        JPanel inputPanel=new JPanel(new TableLayout(size));
	        inputPanel.setPreferredSize(new Dimension(500, 170));
	        inputPanel.setOpaque(false);
	        inputPanel.add(lblHeader,"0 0 2 0");
	        inputPanel.add(lblName,"0 2 0 0");
	        inputPanel.add(txtName,"2 2 1 1");
	        inputPanel.add(lblErrorMessage,"0 4 2 0");
	        inputPanel.add(btnEnter,"0 6");
	        inputPanel.add(btnCancel,"2 6");
	        
	        
	        this.setLayout(new GridBagLayout());
//	        this.add(inputPanel,new GridBagConstraints(0, 0, 0,1, 0, 0,
//					GridBagConstraints.PAGE_START,
//					GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 1));
	        this.add(inputPanel);
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
