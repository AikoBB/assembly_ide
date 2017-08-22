import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;		//for layout manageres
import java.awt.event.*;	//for action events

import java.net.URL;
import java.util.Hashtable;
import java.io.IOException;
public class UserInterface extends JFrame {
	public JMenuBar menuBar;
	public static JTextField axTextFieldH,axTextFieldL,bxTextFieldH,bxTextFieldL,
	cxTextFieldH, cxTextFieldL, dxTextFieldH, dxTextFieldL,csTextField,ipTextField,
	ssTextField, spTextField,bpTextField,siTextField,diTextField, dsTextField,esTextField,zfTextField,
	cfTextField,sfTextField,dfTextField,pfTextField,ofTextField;
	JTextArea codeArea ;
	
	public UserInterface() {
		super("Assembly Code Simulator");
	    Panel p = new Panel();
	    add(p, BorderLayout.SOUTH);
	    addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);
	      }
	      catch (UnsupportedLookAndFeelException ex1) {
	        System.err.println("Unsupported LookAndFeel");
	      }
	      catch (ClassNotFoundException ex2) {
	        System.err.println("LookAndFeel class not found");
	      }
	      catch (InstantiationException ex3) {
	        System.err.println("Could not load LookAndFeel");
	      }
	      catch (IllegalAccessException ex4) {
	        System.err.println("Cannot use LookAndFeel");
	      }
	    JMenuBar menuBar=new JMenuBar();
	    
	    JMenu newMenu=new JMenu("New    ");//new butonu
	    
	    menuBar.add(newMenu);
	    
	    JMenu saveMenu=new JMenu("Save   ");//save menude
	    menuBar.add(saveMenu);
	    
	    JMenu openMenu=new JMenu("Open   ");//open menude
	    menuBar.add(openMenu);
	    
	    JMenu runMenu=new JMenu("Run  ");//run menude
	    menuBar.add(runMenu);
	    
	    JMenu singleStepMenu=new JMenu("Single Step  ");//single step menu kismi
	    menuBar.add(singleStepMenu);
	    
	    JMenu stepBackMenu=new JMenu("Step Back    ");//step back menu kismi
	    menuBar.add(stepBackMenu);
	    
	    JMenu reloadMenu=new JMenu("Reload  ");//single step menu kismi
	    menuBar.add(reloadMenu);
	    
	    
	    
	    

		
		//Layout the text controls and the labels
	    /***ax register and sp***/
	    JLabel axLabel = new JLabel( "AX",SwingConstants.LEFT);
	    axLabel.setFont(new Font("The New Times", Font.BOLD, 12));
	    axLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     axTextFieldH = new JTextField();
	     axTextFieldL = new JTextField();
	    axTextFieldH.setEditable(false);
	    axTextFieldH.setFont(new Font("Times", Font.PLAIN, 12));
	    axTextFieldH.setText(" 00");
	    axTextFieldL.setEditable(false);
	    axTextFieldL.setFont(new Font("Times", Font.PLAIN, 12));
	    axTextFieldL.setText(" 00");
	    
	    /***bx register ***/
	    JLabel bxLabel = new JLabel( "BX",SwingConstants.LEFT);
	    bxLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    bxLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     bxTextFieldH = new JTextField();
	     bxTextFieldL = new JTextField();
	    bxTextFieldH.setEditable(false);
	    bxTextFieldH.setFont(new Font("Times", Font.PLAIN, 12));
	    bxTextFieldH.setText(" 00");
	    bxTextFieldL.setEditable(false);
	    bxTextFieldL.setFont(new Font("Times", Font.PLAIN, 12));
	    bxTextFieldL.setText(" 00");
	    
	    JPanel bx_ax=new JPanel();
	    bx_ax.add(axLabel);
	    bx_ax.add(axTextFieldH);
	    bx_ax.add(axTextFieldL);
	    bx_ax.add(bxLabel);
	    bx_ax.add(bxTextFieldH);
	    bx_ax.add(bxTextFieldL);
	    /***cx register ***/
	    JLabel cxLabel = new JLabel( "CX",SwingConstants.LEFT);
	    cxLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    cxLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    cxTextFieldH = new JTextField();
	     cxTextFieldL = new JTextField();
	    cxTextFieldH.setEditable(false);
	    cxTextFieldH.setFont(new Font("Times", Font.PLAIN, 12));
	    cxTextFieldH.setText(" 00");
	    cxTextFieldL.setEditable(false);
	    cxTextFieldL.setFont(new Font("Times", Font.PLAIN, 12));
	    cxTextFieldL.setText(" 00");
	    
	    /***dx register ***/
	    JLabel dxLabel = new JLabel( "DX",SwingConstants.LEFT);
	    dxLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    dxLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     dxTextFieldH = new JTextField();
	     dxTextFieldL = new JTextField();
	    dxTextFieldH.setEditable(false);
	    dxTextFieldH.setFont(new Font("Times", Font.PLAIN, 12));
	    dxTextFieldH.setText(" 00");
	    dxTextFieldL.setEditable(false);
	    dxTextFieldL.setFont(new Font("Times", Font.PLAIN, 12));
	    dxTextFieldL.setText(" 00");
	    
	    
	    JPanel cx_dx=new JPanel();
	    cx_dx.add(cxLabel);
	    cx_dx.add(cxTextFieldH);
	    cx_dx.add(cxTextFieldL);
	    cx_dx.add(dxLabel);
	    cx_dx.add(dxTextFieldH);
	    cx_dx.add(dxTextFieldL);
	    /***cs register ***/
	    JLabel csLabel = new JLabel( "CS",SwingConstants.LEFT);
	    csLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    csLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    csTextField = new JTextField();
	    csTextField.setEditable(false);
	    csTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    csTextField.setText(" 0000");
	    
	    /***ip register ***/
	    JLabel ipLabel = new JLabel( "IP",SwingConstants.LEFT);
	    ipLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    ipLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    ipTextField = new JTextField();
	    ipTextField.setEditable(false);
	    ipTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    ipTextField.setText(" 0000");
	    
	    JPanel cs_ip=new JPanel();
	    cs_ip.add(csLabel);
	    cs_ip.add(csTextField);
	    cs_ip.add(ipLabel);
	    cs_ip.add(ipTextField);
	    /***ss register ***/
	    JLabel ssLabel = new JLabel( "SS",SwingConstants.LEFT);
	    ssLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    ssLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    ssTextField = new JTextField();
	    ssTextField.setEditable(false);
	    ssTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    ssTextField.setText(" 0000");
	    
	    /***sp register ***/
	    JLabel spLabel = new JLabel( "SP",SwingConstants.LEFT);
	    spLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    spLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     spTextField = new JTextField();
	    spTextField.setEditable(false);
	    spTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    spTextField.setText(" 0000");
	    
	    JPanel ss_sp=new JPanel();
	    ss_sp.add(ssLabel);
	    ss_sp.add(ssTextField);
	    ss_sp.add(spLabel);
	    ss_sp.add(spTextField);
	    
	    /***bp register ***/
	    JLabel bpLabel = new JLabel( "BP",SwingConstants.LEFT);
	    bpLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    bpLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     bpTextField = new JTextField();
	    bpTextField.setEditable(false);
	    bpTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    bpTextField.setText(" 0000");
	    
	    
	    /***si register ***/
	    JLabel siLabel = new JLabel( "SI",SwingConstants.LEFT);
	    siLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    siLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     siTextField = new JTextField();
	    siTextField.setEditable(false);
	    siTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    siTextField.setText(" 0000");
	    
	    JPanel bp_si=new JPanel();
	    bp_si.add(bpLabel);
	    bp_si.add(bpTextField);
	    bp_si.add(siLabel);
	    bp_si.add(siTextField);
	    
	    /***di register ***/
	    JLabel diLabel = new JLabel( "DI",SwingConstants.LEFT);
	    diLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    diLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    diTextField = new JTextField();
	    diTextField.setEditable(false);
	    diTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    diTextField.setText(" 0000");
	    
	    
	    /***ds register ***/
	    JLabel dsLabel = new JLabel( "DS",SwingConstants.LEFT);
	    dsLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    dsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	     dsTextField = new JTextField();
	    dsTextField.setEditable(false);
	    dsTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    dsTextField.setText(" 0000");
	    
	    JPanel di_ds=new JPanel();
	    di_ds.add(diLabel);
	    di_ds.add(diTextField);
	    di_ds.add(dsLabel);
	    di_ds.add(dsTextField);
	    /***es register ***/
	    JLabel esLabel = new JLabel( "ES",SwingConstants.LEFT);
	    esLabel.setFont(new Font("The New Times", Font.BOLD, 14));
	    esLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    esTextField = new JTextField();
	    esTextField.setEditable(false);
	    esTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    esTextField.setText(" 0000");
	    
	    JPanel es=new JPanel();
	    es.add(esLabel);
	    es.add(esTextField);
	    
		JPanel registersPanel = new JPanel();
		BoxLayout registers = new BoxLayout(registersPanel, BoxLayout.Y_AXIS);
		registersPanel.setLayout(registers);
		registersPanel.setBorder(
			BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Registers"),
					BorderFactory.createEmptyBorder(5,5,5,5)));
		//textControlsPane.add(textFieldLabel);
		/*** registers***/
		registersPanel.add(bx_ax);
		registersPanel.add(cx_dx);
		registersPanel.add(cs_ip);
		registersPanel.add(ss_sp);
		registersPanel.add(bp_si);
		registersPanel.add(di_ds);
		registersPanel.add(es);
		//Create a text area
	    ///****************FLAGS**************************///
		/***cf**/
		JLabel cfLabel = new JLabel( "CF",SwingConstants.LEFT);
	    cfLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    cfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    cfTextField = new JTextField();
	    cfTextField.setEditable(false);
	    cfTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    cfTextField.setText(" 0 ");
	    
	    JPanel cfPanel=new JPanel();
	    cfPanel.add(cfLabel);
	    cfPanel.add(cfTextField);
		/***zf**/
		JLabel zfLabel = new JLabel( "ZF",SwingConstants.LEFT);
	    zfLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    zfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    zfTextField = new JTextField();
	    zfTextField.setEditable(false);
	    zfTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    zfTextField.setText(" 0 ");
	    
	    JPanel zfPanel=new JPanel();
	    zfPanel.add(zfLabel);
	    zfPanel.add(zfTextField);
	    /***sf**/
		JLabel sfLabel = new JLabel( "SF",SwingConstants.LEFT);
	    sfLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    sfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    sfTextField = new JTextField();
	    sfTextField.setEditable(false);
	    sfTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    sfTextField.setText(" 0 ");
	    
	    JPanel sfPanel=new JPanel();
	    sfPanel.add(sfLabel);
	    sfPanel.add(sfTextField);
	    
	    /***of**/
		JLabel ofLabel = new JLabel( "OF",SwingConstants.LEFT);
	    ofLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    ofLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    ofTextField = new JTextField();
	    ofTextField.setEditable(false);
	    ofTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    ofTextField.setText(" 0 ");
	    
	    JPanel ofPanel=new JPanel();
	    ofPanel.add(ofLabel);
	    ofPanel.add(ofTextField);
		JPanel flagPanel=new JPanel();
		/***pf**/
		JLabel pfLabel = new JLabel( "PF",SwingConstants.LEFT);
	    pfLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    pfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    pfTextField = new JTextField();
	    pfTextField.setEditable(false);
	    pfTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    pfTextField.setText(" 0 ");
	    
	    JPanel pfPanel=new JPanel();
	    pfPanel.add(pfLabel);
	    pfPanel.add(pfTextField);
	    /***df**/
		JLabel dfLabel = new JLabel( "DF",SwingConstants.LEFT);
	    dfLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    dfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
	    dfTextField = new JTextField();
	    dfTextField.setEditable(false);
	    dfTextField.setFont(new Font("Times", Font.PLAIN, 12));
	    dfTextField.setText(" 0 ");
	    
	    JPanel dfPanel=new JPanel();
	    dfPanel.add(dfLabel);
	    dfPanel.add(dfTextField);
	    
		BoxLayout flagRegisters = new BoxLayout(flagPanel, BoxLayout.Y_AXIS);
		flagPanel.setLayout(flagRegisters);
		flagPanel.setBorder(
			BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Flag Registers"),
					BorderFactory.createEmptyBorder(5,5,5,5)));
		flagPanel.add(cfPanel);
		flagPanel.add(zfPanel);
		flagPanel.add(sfPanel);
		flagPanel.add(ofPanel);
		flagPanel.add(pfPanel);
		flagPanel.add(dfPanel);
		
		codeArea = new JTextArea(5, 10);//text code kismi yapilan yer
		codeArea .setFont(new Font("The New Times", Font.PLAIN, 16));
		codeArea .setEditable(true);
		codeArea .setLineWrap(true);
		codeArea .setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(codeArea );
		areaScrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		areaScrollPane.setBorder(
		    BorderFactory.createCompoundBorder(
			BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Code"),
					BorderFactory.createEmptyBorder(5,5,5,5)),
			areaScrollPane.getBorder()));
        
		
		JTextArea bellekArea = new JTextArea(5, 10);//text bellek kismi yapilan yer
		bellekArea.setFont(new Font("The New Times", Font.BOLD, 16));
		bellekArea.setEditable(false);
		bellekArea.setLineWrap(true);
		bellekArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane1 = new JScrollPane(bellekArea);
		areaScrollPane1.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane1.setPreferredSize(new Dimension(150, 220));
		
		JPanel bellekPanel=new JPanel();
		bellekPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Bellek"),
				BorderFactory.createEmptyBorder(5,5,5,5)));
		bellekPanel.add(areaScrollPane1);
		//Create an editor pane
	      
		
		
		JPanel rightPane = new JPanel();//sag panel
		BoxLayout rightBox = new BoxLayout(rightPane, BoxLayout.Y_AXIS);
		rightPane.setLayout(rightBox);
		rightPane.add(bellekPanel);
        rightPane.add(flagPanel);

		//Put everything in the applet
		JPanel leftPane = new JPanel();//sol panel
		BoxLayout leftBox = new BoxLayout(leftPane, BoxLayout.Y_AXIS);
		leftPane.setLayout(leftBox);
		leftPane.add(areaScrollPane);
		leftPane.add(registersPanel);
		
		
		JPanel contentPane = new JPanel();
		BoxLayout box = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		contentPane.setLayout(box);
		contentPane.add(leftPane);
		contentPane.add(rightPane);
		setContentPane(contentPane);
		
		runMenu.addMouseListener(new MouseListener() {

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void mousePressed(MouseEvent e) {
	            // TODO Auto-generated method stub
	        	
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void mouseClicked(MouseEvent e) {
	            // TODO Auto-generated method stub
	        	Functions func=new Functions();
	        	func.getCode(codeArea);
	        	System.out.println("d");
	        	updateRegisters(func.registers,func.flag);
	        }
	    });
		
	    setJMenuBar(menuBar);
	    
	}
	void updateRegisters(Hashtable registers,Hashtable flag)
	{
		String value =(String) registers.get("ax");
		String str[]=new String[3];
		convertion(value,str);
		axTextFieldH.setText(str[0]);
		axTextFieldL.setText(str[1]);
		value =(String) registers.get("bx");
		convertion(value,str);
		bxTextFieldH.setText(str[0]);
		bxTextFieldL.setText(str[1]);
		
		value =(String) registers.get("cx");
		convertion(value,str);
		cxTextFieldH.setText(str[0]);
		cxTextFieldL.setText(str[1]);
		
		value =(String) registers.get("dx");
		convertion(value,str);
		dxTextFieldH.setText(str[0]);
		dxTextFieldL.setText(str[1]);
		
		value =(String) registers.get("cs");
		convertion(value,str);
		csTextField.setText(str[2]);
		
		value =(String) registers.get("ip");
		convertion(value,str);
		ipTextField.setText(str[2]);
		
		value =(String) registers.get("ss");
		convertion(value,str);
		ssTextField.setText(str[2]);
		
		value =(String) registers.get("sp");
		convertion(value,str);
		spTextField.setText(str[2]);
		
		value =(String) registers.get("bp");
		convertion(value,str);
		bpTextField.setText(str[2]);
		
		value =(String) registers.get("si");
		convertion(value,str);
		siTextField.setText(str[2]);
		
		value =(String) registers.get("di");
		convertion(value,str);
		diTextField.setText(str[2]);
		
		value =(String) registers.get("ds");
		convertion(value,str);
		dsTextField.setText(str[2]);
		
		value =(String) registers.get("es");
		convertion(value,str);
		esTextField.setText(str[2]);
		
		String fl=flag.get("cf").toString();
		cfTextField.setText(fl);
		fl=flag.get("zf").toString();
		zfTextField.setText(fl);
		fl=(String)flag.get("sf").toString();
		sfTextField.setText(fl);
		fl=(String)flag.get("of").toString();
		ofTextField.setText(fl);
		fl=(String)flag.get("pf").toString();
		pfTextField.setText(fl);
		fl=(String)flag.get("df").toString();
		dfTextField.setText(fl);
		
		
	}
	void convertion(String str,String [] str1)
	{
		if(str.length()==1)
		{
			str1[0]="00";
			str1[1]="0"+str;
			str1[2]="000"+str;
		}
		else if(str.length()==2)
		{
			str1[0]="00";
			str1[1]=str;
			str1[2]="00"+str;
		}
		else if(str.length()==3)
		{
			str1[0]="0"+str.substring(0, 1);
			str1[1]=str.substring(1,3);
			str1[2]="0"+str;
		}
		else if(str.length()==4)
		{
			str1[0]=str.substring(0,2);
			str1[1]=str.substring(2, 4);
			str1[2]=str;
		}
		
		else{
			str1[0]="00";
			str1[1]="00";
			str1[2]="0000";
		}
	}

}
