import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*;  
import java.util.*; 
import javax.swing.border.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;



class SignUp extends JFrame   implements ActionListener
{
            JButton btnadd,btnreset,btnexit,btnsign;
			JTextField jtffirstname,jtflname,jtfuname,jtfemail;			
			JLabel jlabfname,jlablname,jlabuname,jlabpass,jlabemail,jlabp3,jlabp2;
           JPasswordField jpfpass;			
           JPanel p1;
// AudioClip click;		   
			
			
		public SignUp(String Name)
		{
			
			super(Name);			
			btnadd = new JButton("Sign Up");
			btnreset = new JButton("Reset");
			btnexit = new JButton("Exit");	
            btnsign = new JButton("Sign In");				
			p1=new JPanel(new GridLayout(5,2));
			
			
		 
			
            
			
			/*ImageIcon image = new ImageIcon("p3.jpg");
            JLabel imageLabel = new JLabel(image); 
            add(imageLabel);
			imageLabel.setBounds(10, 20, 550, 600);
            imageLabel.setVisible(true);			  
			Container c = this.getContentPane();
            c.setBackground(Color.pink);*/
			
			
			
	 
        setSize(650,600);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);		
         setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon("pp.jpg")));
         setLayout(new FlowLayout());
		 
		 
		 
		 ImageIcon image = new ImageIcon("P.jpg");
            JLabel imageLabel = new JLabel(image); 
            add(imageLabel);
			imageLabel.setBounds(90,0, 1600, 135);
            imageLabel.setVisible(true);
			
			/*ImageIcon image1 = new ImageIcon("w.jpg");
            JLabel imageLabel1 = new JLabel(image1); 
            add(imageLabel1);
			imageLabel1.setBounds(50,0, 450, 303);
            imageLabel1.setVisible(true);*/
			
			
			jtffirstname = new JTextField();
			jtflname = new JTextField();
			jtfuname = new JTextField();
			jpfpass = new JPasswordField();
			jtfemail = new JTextField();
			
			
			jlabfname = new JLabel("First Name:");
			jlablname = new JLabel("Last Name:");
			jlabuname = new JLabel("Username:");
			jlabpass = new JLabel("Password:");
			jlabemail = new JLabel("Email-id:");
			jlabp3 = new JLabel(" ");
			jlabp2 = new JLabel("");
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			          		
			jtffirstname.setToolTipText("Enter First Name");
            jtflname.setToolTipText("Enter Last Name");
            jtfuname.setToolTipText("Username  ");
            jpfpass.setToolTipText("Password");
            jtfemail.setToolTipText("Enter Email-Address");
			
			Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			btnadd.addActionListener(this);
			btnreset.addActionListener(this);
			btnexit.addActionListener(this);
			btnsign.addActionListener(this);
			
			
			jlabfname.setBounds(490,400,120,40);
			jlabfname.setFont(new Font("Serif", Font.BOLD, 22));
			jlabfname.setForeground(Color.red);
			
			jlablname.setBounds(490,450,120,40);
			jlablname.setFont(new Font("Serif", Font.BOLD, 22));
			jlablname.setForeground(Color.red);
			
			jlabuname.setBounds(490,500,120,40);
			jlabuname.setFont(new Font("Serif", Font.BOLD, 22));
			jlabuname.setForeground(Color.red);
			
			jlabpass.setBounds(490,550,120,40);
			jlabpass.setFont(new Font("Serif", Font.BOLD, 22));
			jlabpass.setForeground(Color.red);
			
			jlabemail.setBounds(490,600,120,40);
			jlabemail.setFont(new Font("Serif", Font.BOLD, 22));
			jlabemail.setForeground(Color.red);
			
			
			jlabp3.setBounds(100,20,120,40);
			jlabp3.setFont(new Font("Serif", Font.BOLD, 24));
			jlabp3.setForeground(Color.red);
			jlabp3.setHorizontalAlignment(JLabel.CENTER);
			//jlabp3.setBackground(Color.blue);	
            //jlabp3.setOpaque(true);	
//jlabp3.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));			
			
			
			jlabp2.setBounds(400,300,120,40);
			jlabp2.setFont(new Font("Dialog", Font.BOLD, 20));
			jlabp2.setForeground(Color.red);
			
			
			jtffirstname.setBounds(640,400,500,40);
			jtffirstname.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtflname.setBounds(640,450,500,40);
			jtflname.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfuname.setBounds(640,500,500,40);
			jtfuname.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jpfpass.setBounds(640,550,500,40);
			jpfpass.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfemail.setBounds(640,600,500,40);
			jtfemail.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			btnadd.setBounds(740,665,100,40);
			btnadd.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			btnreset.setBounds(860,665,100,40);
			btnreset.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnexit.setBounds(980,665,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnsign.setBounds(1700,50,100,40);
			btnsign.setFont(new Font("Serif", Font.PLAIN, 22));
			btnsign.setBackground(Color.BLUE);
			btnsign.setForeground(Color.WHITE);
			btnsign.setFocusPainted(false);
		     //btnsign.setBorderPainted(false);
			 btnsign.setBorder(new LineBorder(Color.BLACK));
			
			
			
			
			
			this.add(jlabfname);
			this.add(jlablname);
			this.add(jlabuname);
			this.add(jlabpass);
			this.add(jlabemail);
			
			this.add(jlabp3);
			this.add(jlabp2);
			
			this.add(jtffirstname);
			this.add(jtflname);
			this.add(jtfuname);
			this.add(jpfpass);
			this.add(jtfemail);
			
			this.add(btnadd);
			this.add(btnreset);
			this.add(btnexit);
            this.add(btnsign);    			
			this.setVisible(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
			
			
		}
		
	public void actionPerformed(ActionEvent e)
	{	 

if(e.getSource()==btnreset) 	
	{
		/*
		URL urlClick = SignUp.class.getResource("c.wav");
            click = Applet.newAudioClip(urlClick);
			click.play();*/
            
			 
jtffirstname.setText(""); 

jtflname.setText("");  
jtfuname.setText("");  
jpfpass.setText("");  
jtfemail.setText("");

	}
	if(e.getSource()==btnsign)
	{
    this.setVisible(false);
   LoginScreen a=new LoginScreen();
   a.setVisible(true); 
  
	}
	
	
	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	
	
	if(e.getSource()==btnadd)
	{
		String v1=jtffirstname.getText();
		String v2=jtflname.getText();
		String v3=jtfuname.getText();
		String v4=jpfpass.getText();
		String v5=jtfemail.getText();
		
	try
		{	
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");
    PreparedStatement st=con.prepareStatement("insert into emp151255(fname,lname,uname,pass,email) values(?,?,?,?,?)");
	
	st.setString(1,v1);
    st.setString(2,v2);
    st.setString(3,v3);
    st.setString(4,v4);
    st.setString(5,v5);
	 if(v1.isEmpty())
   {
	JOptionPane.showMessageDialog(p1,"Error in submitting data!");   
   }
   else if(v2.isEmpty())
	   {
	JOptionPane.showMessageDialog(p1,"Error in submitting data!");   
   }
   else if(v3.isEmpty())
	   {
	JOptionPane.showMessageDialog(p1,"Error in submitting data!");   
   }
   else if(v4.isEmpty())
	   {
	JOptionPane.showMessageDialog(p1,"Error in submitting data!");   
   }
   else if(v5.isEmpty())
	   {
	JOptionPane.showMessageDialog(p1,"Error in submitting data!");   
   }
   else{
	
st.executeUpdate();
JOptionPane.showMessageDialog(p1,"SignUp Successfully.");
con.close();
this.setVisible(false);
   LoginScreen a=new LoginScreen();
   a.setVisible(true);
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
		SignUp ls = new SignUp("WELCOME TO MSDMS");
	}	
			
			
}