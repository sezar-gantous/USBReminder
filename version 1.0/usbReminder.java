/*
sezar gantous
Jun 8 2012
version 0.1
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Integer;
import java.awt.Toolkit;
import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;


public class usbReminder extends JFrame{

		// const \\
      String start = "Start";
      String stop  = "Stop";
      String intro = "         Click Start to set and click Stop to stop.";
      String labelString =   "Remind me every: ";
      String cbString = "Also start a browser";
      String Radio1 = "1 min";
      String Radio5 = "5 min";
      String Radio10 = "10 min";
      String Radio20 = "20 min";
      String Radio3_browser = "3 min";
      String Radio6_browser = "6 min";
      String Radio12_browser = "12 min";
      String Radio17_browser = "17 min";
      String OnStopMessage = " Are you sure you wnat to stop your reminder ?";
      String startted_str = " You must stop first!!";
      String more_ = "More..";
      String about_ = "About";
  
      boolean checked = false;
      boolean started = false;
  

     // Buttons \\
	private JButton startButton;
	private JButton stopButton;
	private JButton moreButton;
	private JButton aboutButton;
	

  
      // radio button \\
 	private JRadioButton _1min_Radio; 
	private JRadioButton _5min_Radio;
	private JRadioButton _10min_Radio;
	private JRadioButton _20min_Radio;
	private JRadioButton _3minBrowser_Radio;
	private JRadioButton _6minBrowser_Radio;
	private JRadioButton _12minBrowser_Radio;
	private JRadioButton _17minBrowser_Radio;
	
	
	   // Button Groups  \\
	   ButtonGroup reminder;
		ButtonGroup browser_reminder;
	
     // lables \\  
	private JLabel label1;
	private JLabel label2;
	
	

     // checkbox \\
	private JCheckBox checkbox1;
	
	
	  // Timers \\
	Timer timer1;
	Timer timer2;
	
	
	
	
	
	  // constructor 
	public  usbReminder(){
	  super("USB Reminder");
	  
	  /*creating containers*/
	         // All containers will be added to mainContainer \\
       Container mainContainer = getContentPane();           
             //setting thelow layout to a grid layout
         mainContainer.setLayout(new GridLayout(3,0,4,4));
		 
		           // this will contain the start and stop buttons \\
	    Container grid_Start_Stop_Buttons = new Container();           
                 //setting the layout to a grid layout
         grid_Start_Stop_Buttons.setLayout(new FlowLayout());

	
	     //this will contain the more and about buttons
	Container gridOtherButtons = new Container();
	  gridOtherButtons.setLayout(new FlowLayout());

	  
	      //this will contain the radio buttons
	 final JPanel gridRadio = new JPanel();
	    gridRadio.setLayout(new GridLayout(2,4));
	  final JPanel gridRadioBrowser = new JPanel();
	    gridRadioBrowser.setLayout(new GridLayout(2,4));

	      //this will contain a horizontal Separator
	    final JPanel gridS = new JPanel();
	      gridS.setLayout(new GridLayout(1,1,4,4));
	  
	  
	  
	  
	  
	  
	  /*creating radio buttons (and label)*/
          //this one will be selected by defaul
	 _1min_Radio = new JRadioButton(Radio1);
	_1min_Radio.setActionCommand("1");
	_1min_Radio.setSelected(true);
	_1min_Radio.setMnemonic(KeyEvent.VK_1);
      
        _5min_Radio = new JRadioButton(Radio5);
	_5min_Radio.setActionCommand("5");
	_5min_Radio.setMnemonic(KeyEvent.VK_2);

	_10min_Radio = new JRadioButton(Radio10);
	_10min_Radio.setActionCommand("10");
        _10min_Radio.setMnemonic(KeyEvent.VK_3); 
	
	_20min_Radio = new JRadioButton(Radio20);
	_20min_Radio.setActionCommand("20");
        _20min_Radio.setMnemonic(KeyEvent.VK_4); 
 		
		
	_3minBrowser_Radio = new JRadioButton(Radio3_browser);
	_3minBrowser_Radio.setSelected(true);
	_3minBrowser_Radio.setActionCommand("3");
        _3minBrowser_Radio.setMnemonic(KeyEvent.VK_5);
        _3minBrowser_Radio.setEnabled(false);
	
	
	_6minBrowser_Radio = new JRadioButton(Radio6_browser);
	_6minBrowser_Radio.setActionCommand("6");
        _6minBrowser_Radio.setMnemonic(KeyEvent.VK_6); 	
	_6minBrowser_Radio.setEnabled(false);

	
	_12minBrowser_Radio = new JRadioButton(Radio12_browser);
	_12minBrowser_Radio.setActionCommand("12");
        _12minBrowser_Radio.setMnemonic(KeyEvent.VK_7); 	
	_12minBrowser_Radio.setEnabled(false);	


	_17minBrowser_Radio = new JRadioButton(Radio17_browser);
	_17minBrowser_Radio.setActionCommand("17");
        _17minBrowser_Radio.setMnemonic(KeyEvent.VK_8); 	
	_17minBrowser_Radio.setEnabled(false);	  
	  

	  
	  
	    /*groupping the radio buttons*/
	  reminder = new ButtonGroup();
 	 reminder.add(_1min_Radio);
	 reminder.add(_5min_Radio);
	 reminder.add(_10min_Radio);
	 reminder.add(_20min_Radio);
	
	 browser_reminder = new ButtonGroup();
	browser_reminder.add(_3minBrowser_Radio);
	browser_reminder.add(_6minBrowser_Radio);
	browser_reminder.add(_12minBrowser_Radio);
	browser_reminder.add(_17minBrowser_Radio);
	
	
	
	

	  
	  //add radio buttons to panels
	  gridRadio.add(_1min_Radio);
	  gridRadio.add(_5min_Radio);
	  gridRadio.add(_10min_Radio);
	  gridRadio.add(_20min_Radio);
         
       
	  gridS.add(new JSeparator());

	    gridRadioBrowser.add(_3minBrowser_Radio);
	    gridRadioBrowser.add(_6minBrowser_Radio);
	    gridRadioBrowser.add(_12minBrowser_Radio);
	    gridRadioBrowser.add(_17minBrowser_Radio);







	
	   /* creating buttons with mnemonic*/
	   startButton = new JButton(start);
	   startButton.setMnemonic(KeyEvent.VK_S);

	   stopButton = new JButton(stop);
	   stopButton.setMnemonic(KeyEvent.VK_Q);
	   
	   moreButton = new JButton(more_);

	   aboutButton = new JButton(about_);
	   
	   /* adding buttons to the container grid_Start_Stop_Buttons*/
	   grid_Start_Stop_Buttons.add(startButton);
	   grid_Start_Stop_Buttons.add(stopButton);

	   
	           /* adding buttons to the container gridOtherButtons*/
	    gridOtherButtons.add(moreButton);
	    gridOtherButtons.add(aboutButton);



	    label2 = new JLabel(labelString);



	      startButton.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
				  if(!started)
				  { 
							Object[] temp = {
												label2,		
												gridRadio,
												  gridS,
												checkbox1,
												gridRadioBrowser
											  };
				 
						int answer = JOptionPane.showConfirmDialog(startButton,temp,"USB Reminder Setup ",JOptionPane.YES_NO_OPTION);
							if(answer == JOptionPane.YES_OPTION)
							{
								int minute = 0;
									
									ButtonModel selection = reminder.getSelection();
									
									if(checkbox1.isSelected())
									{
									ButtonModel selection2 = browser_reminder.getSelection();
										minute = Integer.parseInt(selection2.getActionCommand());
										
									}
																 // this will always work becuase getActionCammond will always return a number..
									timeStart( Integer.parseInt(selection.getActionCommand()),minute );
								started = true;
								
									
							}
				  }
				  else
				  {
					JOptionPane.showMessageDialog(startButton," You have to click stop first before you can start new proses!");
				  }
		    }

	      });


  
	    stopButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
				timer1.cancel();
				if(checkbox1.isSelected())
				{ 
					timer2.cancel();
				}
		    started = false;
		}
	    });    

	  

	    moreButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    String message = "These are keyboard shortcuts.\n";
			  message +="\n To start:  Alt + s";
		          message +="\n To stop:  Alt + q";
			  message += "\n 1 min:     Alt + 1";
			  message +="\n 5 min:     Alt + 2";
			  message +="\n 10 min:   Alt + 3";
			  message +="\n 20 min:   Alt + 4";
			  message +="\n 3 min:     Alt + 5";
			  message +="\n 6 min:     Alt + 6";
			  message +="\n 12 min:   Alt + 7";
			  message +="\n 17 min:   Alt + 8";

		    JOptionPane.showMessageDialog(moreButton,message);
		 }
	    });


	     aboutButton.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
		        String message = "This application was cearted by Sezar Gantous.";
			 message += "\n Date:                     Jun 08 2012";
			  message +="\n Version:                1.0 (Jun08  2012)";
			  message +="\n\n If you are like me - keep forgetting your precious USB(any storage device really) in the computer \nfor whatever reason-then this program will make sure you wont forget it.";
			  message += "\n\n I developed this application to merly help you to remember not to forget your USB.";
			  message +="\n\n If you have any comments or suggestions please let me know at:\n sganouts@learn.senecac.on.ca or sezar_8_11@hotmail.com";

		    JOptionPane.showMessageDialog(moreButton,message);
		     }
	      }); 




	   
	   
	   
	  
	  	    /* creating label */
        label1 = new JLabel(intro);
		
		
	  


	  /* creating checkboxs */
	  checkbox1 = new JCheckBox(cbString);


		//enable and disable the browser radio buttons
	  checkbox1.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e)
	      {
		  if(checkbox1.isSelected())
		    {
			  _3minBrowser_Radio.setEnabled(true);
			  _6minBrowser_Radio.setEnabled(true);
			  _12minBrowser_Radio.setEnabled(true);
		      	  _17minBrowser_Radio.setEnabled(true);
		    }
		    else
		    {
			  _3minBrowser_Radio.setEnabled(false);
			  _6minBrowser_Radio.setEnabled(false);
			  _12minBrowser_Radio.setEnabled(false);
		      	  _17minBrowser_Radio.setEnabled(false);
		    }
	      }
	  });
	  
	  
	  
	  /*adding all containers to mainContainer*/
	  mainContainer.add(gridOtherButtons);
	  mainContainer.add(label1);
	  mainContainer.add(grid_Start_Stop_Buttons);
	  
	   /*setting the window size and visiblity*/
	  setSize(300,200);
	  setResizable(false);
      setVisible(true);
	  
	  
	  }
	

      public void timeStart(int minute, int minute2)
      {

          timer1 = new Timer();

	  timer1.schedule(new ReminderTask(), 0,  minute*60*1000);

		if(minute2 != 0)
		{
			timer2 = new Timer();
			timer2.schedule(new ReminderTaskBrowser(), 0,  minute2*60*1000);
		}
    }

	
	
	
	
	
	class ReminderTaskBrowser extends TimerTask {

        public void run() {    

         		try{
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://matrix.senecac.on.ca/~sganouts/USBReminder.html");
					}
				    catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(null,ioe.getMessage() );
					}
            
        }
    }
	
	
	
    class ReminderTask extends TimerTask {

        public void run() {    

         		//JOptionPane.showMessageDialog(null,"Don't forget your USB !!!");
				
				// I had to do it this way to make the Message on top of running programs
				 JOptionPane pane = new JOptionPane("Don't forget your USB !!!");
				JDialog dialog = pane.createDialog("USB Reminder");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
            
        }
    }
	
	
	
	
	
	public static void main (String[] args){
      usbReminder start = new usbReminder();
       start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}