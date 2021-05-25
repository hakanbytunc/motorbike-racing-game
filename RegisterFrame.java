package javaProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame {



  private JFrame frame;
  private JPanel panel;
  private JLabel label1,label2,label3,label4;
  private JTextField jTextField,jTextField2,jTextField3;


  
  
  public void createGUI2(){
	  
	  label2 = new JLabel("Username:");
	  label2.setBounds(20,140,150,30);
	  JTextField jTextField = new JTextField();
	  jTextField.setBounds(140,140,150,30);
	  
	  label3 = new JLabel("Password");
	  label3.setBounds(20,230,150,30);
	  JPasswordField jTextField2 = new JPasswordField();
	  jTextField2.setBounds(140,230,150,30);
	  
  
	  ActionListener actionListener = new ActionListener() {
	      public void actionPerformed(ActionEvent actionEvent) {
	        String command = actionEvent.getActionCommand();
	        if(command.equals("First")){
	        	String name, pw;
	        	name=jTextField.getText();
	        	pw=jTextField2.getText();
	        	User u = new User(name,pw);
	        	User.UserList.add(u);
	        	frame.dispose();
	        	

	        	
	        	
	        	
	        	
	        	
	        }
	        else if(command.equals("Second")) {
	        	frame.dispose();
	        	
	        }
	        
	      }
	    };	  
	  
	  

  
  frame = new JFrame("Register System");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  panel = new JPanel();
  panel.setLayout(null);
  label1 = new JLabel("Enter Register Information");  
  label1.setBounds(100, 50, 170, 50);    
  panel.add(label1);   
  frame.add(panel);
  frame.setSize(400,500);
  frame.setVisible(true);
  
  
 
  
  
  JButton button1 = new JButton("Save");
  button1.setActionCommand("First");
  button1.setBounds(140,400,100,30);
  JButton button2 = new JButton("Cancel");
  button2.setActionCommand("Second");
  button2.setBounds(260,400,100,30);
  
  button1.addActionListener(actionListener);
  button2.addActionListener(actionListener);
  

  
  panel.add(label2);
  panel.add(jTextField);
  panel.add(jTextField2);
  panel.add(label3);
  panel.add(button1);
  panel.add(button2);

 
  }
  
  
}