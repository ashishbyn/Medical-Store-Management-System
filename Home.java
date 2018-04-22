import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*;
import java.util.*; 

class Home extends JFrame   implements ActionListener
{
            JButton btnadd,btnsearch,btnupdate,btndelete,btnexit,btnbill;			
		
			
			
		public Home()
		{
			
			super();			
			btnadd = new JButton("ADD");
			btnsearch = new JButton("Search");
			btnupdate = new JButton("Update");
			btndelete = new JButton("Delete");
			btnexit = new JButton("Exit");
			btnbill = new JButton("Bill");
			
			
			
			
			
	 
        setSize(650,600);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);		
         setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon("cc.jpg")));
         setLayout(new FlowLayout());
			
			
			
			
			
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			btnadd.addActionListener(this);
			btnsearch.addActionListener(this);
			btnupdate.addActionListener(this);
			btndelete.addActionListener(this);
             btnexit.addActionListener(this);
 btnbill.addActionListener(this);				 
			
			
			
			
			
			
			btnadd.setBounds(750,300,100,40);
			btnadd.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnsearch.setBounds(750,400,100,40);
			btnsearch.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnupdate.setBounds(750,500,100,40);
			btnupdate.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btndelete.setBounds(750,600,100,40);
			btndelete.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnbill.setBounds(750,700,100,40);
			btnbill.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnexit.setBounds(750,800,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			this.add(btnadd);
			this.add(btnsearch);
			this.add(btnupdate);	
            this.add(btndelete);
            this.add(btnexit);
            this.add(btnbill);				
			this.setVisible(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
			
			
		}
		
	public void actionPerformed(ActionEvent e)
	{	 

if(e.getSource()==btnadd) 	
	{
this.setVisible(false);
   Add a=new Add();
   a.setVisible(true);
	}
	if(e.getSource()==btnbill) 	
	{
this.setVisible(false);
   Bill a=new Bill();
   a.setVisible(true);
	}
	
	if(e.getSource()==btnsearch)
	{
  this.setVisible(false);
   Search a=new Search();
   a.setVisible(true);
	}
	if(e.getSource()==btnupdate)
	{
   this.setVisible(false);
   Update u=new Update();
   u.setVisible(true);
	}
	
	if(e.getSource()==btndelete)
	{
		this.setVisible(false);
   Delete b=new Delete();
   b.setVisible(true);	
	} 
	if(e.getSource()==btnexit)
	{
		 System.exit(0);   	
	} 
	}
	

	
	public static void main(String args[])throws Exception	
	{
		Home ls = new Home();
	}	
			
			
}