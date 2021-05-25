package javaProject;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class Frame {
	 private JFrame frame;
	 private JPanel panel;
	 private JLabel label1,label2;
	 private ImageIcon image,image1;

	  
	  public void createGUI(){
		  ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        String command = actionEvent.getActionCommand();
		        if(command.equals("First")){
		        	
		        	for(User f : User.UserList) {
		        		if (f.flag==true) {
		        			frame.dispose();
		        			Game Game =new Game();
				        	Game.createGUI3();
		        			
		        		}
		        	}

		        }
		        if(command.equals("Second")) {
		        	
		        	LoginFrame LoginFrame =new LoginFrame();
		        	LoginFrame.createGUI1();
		        	
		        	
		        }
		        if(command.equals("Thirth")) {

		        	RegisterFrame RegisterFrame=new RegisterFrame();
		        	RegisterFrame.createGUI2();
		        	
		        	
		        }
		        
		        if(command.equals("Fourth")) {
		        	System.exit(0);
		        }
		      }
		    };
		  
		  
	  frame = new JFrame("CSE212 - Hang On");

	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel = new JPanel();
	  panel.setLayout(null); 
	  frame.add(panel);
	  
	  image=new ImageIcon(getClass().getResource("logo1.gif"));
	  label1 = new JLabel(image);  
	  label1.setBounds(130, 30, 900, 600);  

	  
	  image1=new ImageIcon(getClass().getResource("login.png"));
	  label2 = new JLabel(image1);  
	  label2.setBounds(390, 360, 1000, 600);  
	 

	  panel.add(label1);   
	  panel.add(label2); 
	  frame.setBounds(400,120,1200,800);
	  panel.setBackground(Color.black);

	  
	  
	  
	  JMenuBar menubar =new JMenuBar();
	  frame.setJMenuBar(menubar);
	 
	  JMenuItem Game =new JMenuItem ("Game"); 
	  menubar.add(Game);
	  Game.setActionCommand("First");
	  
	  
	  
	  JMenu User =new JMenu ("User"); 
	  menubar.add(User);
	  
	  JMenuItem Login =new JMenuItem ("Login"); 
	  User.add(Login);
	  Login.setActionCommand("Second");
	  
	  JMenuItem Register =new JMenuItem ("Register"); 
	  User.add(Register);
	  Register.setActionCommand("Thirth");
	  
	  JMenuItem Quit =new JMenuItem ("Quit"); 
	  menubar.add(Quit);
	  Quit.setActionCommand("Fourth");
	  
	  Game.addActionListener(actionListener);
	  
	  Login.addActionListener(actionListener);
	  Register.addActionListener(actionListener);
	 
	  Quit.addActionListener(actionListener);
	  
	  frame.setVisible(true);
	  frame.setResizable(false);


	  }
}
