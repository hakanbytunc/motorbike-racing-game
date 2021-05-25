package javaProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Random;
public class Game extends JPanel{
	boolean randomFlag=true;
	Random rand = new Random();
	int randomY = rand.nextInt(560);
	
	private JFrame frame;
	private JPanel panel,panel2;
	private JLabel label1,label2,label3,label4,enemyLabel;
	private ImageIcon image,image1,image2,image3,image4,image5;
	private JTextField score;
	ImageIcon [] roadArray= new ImageIcon[9];
	boolean rightFlag=false;
	boolean leftFlag=false;
	boolean upFlag=false;
	boolean downFlag=false;
	int i=4;
	private static int a=0;
	int speed=400;
	int changex=-400;
	private int xActor=400;
	private int yActor=360;
	private int xCheck=0;
	private int yCheck=0;
	private int randomX=500;

	public void changex(int x)
	  {
		  label2.setBounds(x,0, 2000, 800);  
	  }
	void randomcheck(){
		while(randomFlag){
			if (randomY<-310){
				randomY = rand.nextInt(560);
			}
			else randomFlag=false;
		}
	}


  public void createGUI3(){
	  
	  
	  
	  roadArray[0]=image1=new ImageIcon(getClass().getResource("background1.png"));
	  roadArray[1]=image1=new ImageIcon(getClass().getResource("background2.png"));
	  
	  score=new JTextField("Score: " + a);
	  image2=new ImageIcon(getClass().getResource("200w.gif"));
	  
	  image3=new ImageIcon(getClass().getResource("1.png"));
	  image4=new ImageIcon(getClass().getResource("2.png"));
	  image5=new ImageIcon(getClass().getResource("3.png"));
	  
	  frame = new JFrame("Hang-On ");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel = new JPanel();

	  
	  image=new ImageIcon(getClass().getResource("düz.png"));

	  label1 = new JLabel(image); 
	  label1.setBounds(xActor, yActor, 900, 600); 
	  

	  score.setBounds(10,10, 100, 60);
	  score.setEnabled(false);

	  label2= new JLabel(image1);
	  label2.setBounds(-450,0, 2000, 800); 
	  
	  label4= new JLabel(image2);
	  label4.setBounds(-400,0, 0, 0);
	  
	  enemyLabel = new JLabel(image5);
	  enemyLabel.setBounds(-500,randomY, 400, 600);
	  
	  
	  panel.setLayout(null);  
	  frame.add(enemyLabel);
	  frame.add(label4);
	  frame.add(score);
	  frame.add(label1);
	  frame.add(label2);
	  
	  frame.add(panel);
	  frame.setBounds(400,120,1200,800);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  
 
Thread newThread = new Thread(){
	public void run(){
		while (true){
			enemyLabel.setBounds(randomY,randomX, 400, 600);
			System.out.println("RandomY: "+randomY);
			if(0<randomX && randomX<90){
				enemyLabel.setIcon(null);
			}
			if(90<randomX && randomX<120){
				enemyLabel.setIcon(image3);
			}
			if(120<randomX && randomX<200){
				enemyLabel.setIcon(image4);
			}
			try {
   				Thread.sleep(speed);
   				randomX--;
   				System.out.println("RandomX:"+randomX);
   			  } 
   			  catch (InterruptedException e) {
   				e.printStackTrace();
   			  }	
		}
	}
	
};
newThread.start();
  	  
  	 Thread roadThread =new Thread(){ 
 		  public void run(){
 			  int z=1;
	   			while(true) {
	   				
	   				if(upFlag) {
	   					score.setText("Score: " + a++);
	   					
				    	label2.setIcon(roadArray[z]);
				    	frame.repaint();
				    	if(z==1) {
				    		z=0;
				    	}
				    	else
				    		z=1;
	   				}
	   				if (xCheck<=-310){
	   					System.out.println("Out of road");
	   					label4.setBounds(-850,200, 2000, 800);
	   				}
	   				if (xCheck>=560){
	   					System.out.println("Out of road");
	   					label4.setBounds(0,200, 2000, 800);
	   				}
	   			  try {
	   				Thread.sleep(speed);
	   			  } 
	   			  catch (InterruptedException e) {
	   				// TODO Auto-generated catch block
	   				e.printStackTrace();
	   			  }
	   			 }
 			  }
 	  };
 	 roadThread.start();
	  
	KeyListener keyListener= new KeyListener() {
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void keyReleased(KeyEvent k) {
			// TODO Auto-generated method stub
			int key = k.getKeyCode();
			if (key == KeyEvent.VK_RIGHT) {
				rightFlag=false;
			}
			if (key == KeyEvent.VK_LEFT) {
				leftFlag=false;
			}
		}
		
		public void moveBox(int newX,int newY)
		  {
			label1.setBounds(newX, newY, 900, 600);
			xCheck=newX;
			yCheck=newY;
		  }

		  public void changeLayoutLeft()
		  {
		  	xActor-=10;
		  	if (xActor < -310){xActor+=10;}
		  	System.out.println(xActor);
		  	moveBox(xActor,yActor);
		  	
		  }
		  public void changeLayoutRight()
		  {
		  	xActor+=10;
		  	if (xActor > 560){xActor-=10;}
		  	System.out.println(xActor);
		  	moveBox(xActor,yActor);
		  }
		  
		@Override
		public void keyPressed(KeyEvent k) {
			 int key = k.getKeyCode();
			    if (key == KeyEvent.VK_LEFT) {
			       leftFlag=true;
			       changeLayoutLeft();

			    }
			    if (key == KeyEvent.VK_RIGHT) {
			    	rightFlag=true;
			    	changeLayoutRight();
			    }
			    if (key == KeyEvent.VK_UP) {
			    	upFlag=true;
			    	if(speed>50) {
			    		speed=speed-30;
			    	}
			    	else
			    		speed=50;
			        
			    }
			    if (key == KeyEvent.VK_DOWN) {
			    	downFlag=true;
			    	if (speed<400)
			    		speed=speed+50;
			    	else
			    		speed=400;
			    }		
		}
	};  	  
	frame.addKeyListener(keyListener); 
  }
}