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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import layout.TableLayout;
import nop.controller.Controller;
import nop.controller.Utility;
import nop.dto.Bill;
 
 
public class TemplateBillView extends JPanel implements KeyListener{
    ArrayList<Bill> lstBills =new ArrayList<Bill>();
     
    JLabel lblName=new JLabel("Name:");
    JTextField txtName=new JTextField("");
    JLabel lblPhonetic=new JLabel("Phonetic:");
    JTextField txtPhonetic=new JTextField("");
    JLabel lblDesc=new JLabel("Desc:");
    JTextField txtDesc=new JTextField("");
    JButton btnEnter=new JButton("Enter");
    JButton btnCancel=new JButton("Cancel");
     
    JLabel lblHeader=new JLabel("Create Template Bill");
    
    JPanel tableViewPanel=new JPanel();
     
    Controller controller;
 
    private Font fontForValues;
 
    private Font fontForDesc;
 
    private Color colorForButton;
 
    private Color backgroundForWords;
 
    private Color backgroundForMain;
 
    private Color colorWords;
    JLabel lblErrorMessage=new JLabel();
    String errorMess=new String();
    TemplateBillReportView tableReportView;
     
    public TemplateBillView(Controller controller) {
        this.controller=controller;
        tableReportView=new TemplateBillReportView(this.controller);
        jbInit();
        applyFormat();
        setFormat();
        validate();
        registerListener();
    }
    public void registerListener() {
        btnCancel.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                close();
                 
            }
        });
        btnEnter.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
//                model.addBillToListAll(getDTOFromGUI());
                 controller.addObjectToTemplateList(getDTOFromGUI());
                 tableReportView.refreshTable();
                 
            }
        });
         
        txtName.addKeyListener(this);
        txtPhonetic.addKeyListener(this);
        txtDesc.addKeyListener(this);
         
    }
    public Bill getDTOFromGUI() {
        Bill dto=new Bill(Utility.generateIDForBill(1,controller.getModel().getLstTemplateBills(),null),txtName.getText());
        return dto;
    }
 
    public void close() {
        System.exit(0);
    }
     
    public void jbInit() {
//        this.setLayout(null);
//      this.setSize(300,300);
         
//        int startX=100;
//        int startY=40;
//        int HEIGHT=25;
//        int WIDTH=100;
//        lblHeader.setBounds(new Rectangle(150, 0, 100, 20));
//         
//        lblName.setBounds(startX, startY,WIDTH , HEIGHT);
//        lblPhonetic.setBounds(startX, lblName.getBounds().y +HEIGHT , WIDTH, HEIGHT);
//        lblDesc.setBounds(startX,lblPhonetic.getBounds().y+ HEIGHT , WIDTH, HEIGHT);
//         
//        txtName.setBounds(startX + WIDTH +5, startY, WIDTH, HEIGHT);
//        txtPhonetic.setBounds(startX + WIDTH +5, txtName.getBounds().y+HEIGHT, WIDTH, HEIGHT);
//        txtDesc.setBounds(startX + WIDTH +5, txtPhonetic.getBounds().y+HEIGHT, WIDTH, HEIGHT);
//         
//        lblErrorMessage.setBounds(120,130,300,20);
//         
//        btnEnter.setBounds(100,170 , WIDTH, HEIGHT);
//        btnCancel.setBounds(230, 170, WIDTH, HEIGHT);
//         
//        this.add(lblHeader);
//        this.add(lblName,null);
//        this.add(lblPhonetic,null);
//        this.add(lblDesc,null);
//        this.add(txtName,null);
//        this.add(txtPhonetic,null);
//        this.add(txtDesc,null);
//         
//        this.add(btnCancel,null);
//        this.add(btnEnter,null);
//        this.add(lblErrorMessage,null);
//        btnEnter.setEnabled(false);
//        
//        addTableView();
    
        double size[][]={{0.2,20,0.3},//cols
        		{0.25,10,0.25,20,0.25,20,0.25}//rows
        };
//        this.setLayout(new TableLayout(size));
        JPanel inputPanel=new JPanel(new TableLayout(size));
        inputPanel.setPreferredSize(new Dimension(500, 170));
        inputPanel.setOpaque(false);
        inputPanel.add(lblHeader,"0 0 2 0");
        inputPanel.add(lblName,"0 2 0 0");
        inputPanel.add(txtName,"2 2 1 1");
        inputPanel.add(lblErrorMessage,"0 4 2 0");
        inputPanel.add(btnEnter,"0 6");
        inputPanel.add(btnCancel,"2 6");
        
//        inputPanel.setBorder(new LineBorder(Color.black));
        
        
        this.setLayout(new GridBagLayout());
        this.add(inputPanel,new GridBagConstraints(0, 0, 0,1, 0, 0,
				GridBagConstraints.PAGE_START,
				GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 1));
        this.add(tableReportView,new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
    
    public void addTableView(){
    	tableViewPanel.add(tableReportView);
    	this.add(tableViewPanel);
    	tableViewPanel.setBounds(10,180,300,200);
    	
    }
    public void setFormat(){
        btnEnter.setBackground(colorForButton);
        btnCancel.setBackground(colorForButton);
        btnEnter.setForeground(Color.white);
        btnCancel.setForeground(Color.white);
        lblErrorMessage.setForeground((Color)Color.decode("#fd0a0a"));
        this.setBackground(backgroundForMain);
         
    }
     
    public void applyFormat() {
        fontForValues =new Font("Arial", Font.BOLD,12);
        fontForDesc =new Font("Arial", Font.PLAIN,12);
         
        colorForButton=Color.decode("#0c64e8");
         
        backgroundForWords=Color.decode("#323232");
        backgroundForMain=Color.decode("#0ce890");
        colorWords=Color.BLACK;
         
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
     
    public void setStatusButton(boolean status){
        btnEnter.setEnabled(status);
    }
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
         
    }
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
         
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(txtName)){
            validate();
        }else if(e.getSource().equals(txtPhonetic)){
            validate();
        }else if(e.getSource().equals(txtDesc)){
            validate();
        }
    }
}
