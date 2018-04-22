import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*;  
import java.util.logging.*;
import java.util.*; 
class LoginScreen extends JFrame   implements ActionListener
{
            JButton btnlogin,btnreset,btnexit;
			JTextField jtfuser;
			JPasswordField jpfpass;
			JLabel jlabuser,jlabpass;
			JPanel p1;
		
			
			
			
			
		public LoginScreen()
		{
			super();			
			btnlogin = new JButton("Login");
			btnreset = new JButton("Reset");
			btnexit = new JButton("Exit");
			p1=new JPanel(new GridLayout(5,2));
			
			
			
         setSize(650,600);		   
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);		
         setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon("j.jpg")));
         setLayout(new FlowLayout());
		 
		 
		 
		 
		 
		 ImageIcon image = new ImageIcon("e.png");
            JLabel imageLabel = new JLabel(image); 
            add(imageLabel);
			imageLabel.setBounds(590, 25, 550, 600);
            imageLabel.setVisible(true);	
			
			
			
			
			
			jtfuser = new JTextField();
			jpfpass = new JPasswordField();
			
			jlabuser = new JLabel("Username:");
			jlabpass = new JLabel("Password:");
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jpfpass.setToolTipText("Enter your Password");             		
			jtfuser.setToolTipText("Enter your Username");              	
			Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
            this.setIconImage(icon);  
			
			
			btnlogin.addActionListener(this);
			btnreset.addActionListener(this);
			btnexit.addActionListener(this);
			
			jlabuser.setBounds(500,450,120,40);
			jlabuser.setFont(new Font("Serif", Font.BOLD, 24));
			jlabuser.setForeground(Color.red);
			jlabpass.setBounds(500,500,120,40);
			jlabpass.setFont(new Font("Serif", Font.BOLD, 24));
			jlabpass.setForeground(Color.red);
			
			
			
			jtfuser.setBounds(640,450,500,40);
			jtfuser.setFont(new Font("Serif", Font.PLAIN, 20));
			jpfpass.setBounds(640,500,500,40);
			jpfpass.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			btnlogin.setBounds(720,560,100,40);
			btnlogin.setFont(new Font("Serif", Font.BOLD, 20));
			btnreset.setBounds(840,560,100,40);
			btnreset.setFont(new Font("Serif", Font.BOLD, 20));
			btnexit.setBounds(960,560,100,40);
			btnexit.setFont(new Font("Serif", Font.BOLD, 20));
			
			
			this.add(jlabuser);
			this.add(jlabpass);			
			this.add(jtfuser);
			this.add(jpfpass);
			this.add(btnlogin);
			this.add(btnreset);
			this.add(btnexit);			
			this.setVisible(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  
			
		}
		
	public void actionPerformed(ActionEvent e)
	{	
	
	if(e.getSource()==btnreset) 	
	{
jtfuser.setText(""); 

jpfpass.setText("");  

	}
	
	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(e.getSource()==btnlogin)
	{
		
	try 
	{                            
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");  
                Statement st = con.createStatement();
                String user=jtfuser.getText();
                String passw=jpfpass.getText();
				
                ResultSet res = st.executeQuery("select uname,pass from emp151255 where uname='" + user + "' and pass='" + passw + "'");
				
                if (res.next()) 					
				{
                    JOptionPane.showMessageDialog(p1,"Login Sucessfull.");
					this.setVisible(false);
					Home a=new Home();
					a.setVisible(true);					
                } 
				
				else
				{
                    JOptionPane.showMessageDialog(p1,"Invalid User Name/Passw");
					jtfuser.setText("");
					jpfpass.setText("");
					
                }              
				
	            }
				
				
            catch(Exception e1)
{
JOptionPane.showMessageDialog(p1,"Error in submitting data!");
}		
	}
	}
			
	
	
	public static void main(String args[])throws Exception	
	{
		LoginScreen ls = new LoginScreen();
	}	
			
			
}