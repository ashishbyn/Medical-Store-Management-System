import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*; 
import java.util.*; 
import java.awt.geom.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.*;
class Delete extends JFrame   implements ActionListener
{
            JButton btndelete,btnexit,btnnext,btnback,btnshow,btnhome;				
			JLabel jlabname,jlabmfg,jlabexpire,jlabprice,jlabquantity;
            JLabel jlabname1,jlabmfg1,jlabexpire1,jlabprice1,jlabquantity1;				
            JPanel p1;
			JFrame frame1;

			
			public Delete()
		{
			
			super();			
			
			btndelete = new JButton("Delete");
			btnexit = new JButton("Exit");
			btnnext = new JButton("Next");
			btnshow=new JButton("Show");
			btnback = new JButton("Back");
			btnhome = new JButton("Home");
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
         setContentPane(new JLabel(new ImageIcon("aa.jpg")));
         setLayout(new FlowLayout());
			
			
			
			
		
			
			/*jlabname = new JLabel("Medicine Name:");
			jlabmfg = new JLabel("MFG Date:");
			jlabexpire = new JLabel("Expiry Date:");
			jlabprice = new JLabel("Price:");
			jlabquantity = new JLabel("Quantity:");
			
			
			jlabname1 = new JLabel("");
			jlabmfg1 = new JLabel("");
			jlabexpire1 = new JLabel("");
			jlabprice1 = new JLabel("");
			jlabquantity1 = new JLabel("");*/
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			          		
			
			 
			
		   Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			
			btndelete.addActionListener(this);
			btnexit.addActionListener(this);
			btnnext.addActionListener(this);
            btnshow.addActionListener(this);
			btnback.addActionListener(this);	
             btnhome.addActionListener(this);			
			/*
			jlabname.setBounds(450,500,120,40);
			jlabname.setFont(new Font("Serif", Font.BOLD, 24));
			jlabname.setForeground(Color.red);
			
			jlabmfg.setBounds(650,500,120,40);
			jlabmfg.setFont(new Font("Serif", Font.BOLD, 24));
			jlabmfg.setForeground(Color.red);
			
			jlabexpire.setBounds(850,500,120,40);
			jlabexpire.setFont(new Font("Serif", Font.BOLD, 24));
			jlabexpire.setForeground(Color.red);
			
			jlabprice.setBounds(1050,500,120,40);
			jlabprice.setFont(new Font("Serif", Font.BOLD, 24));
			jlabprice.setForeground(Color.red);
			
			jlabquantity.setBounds(1250,500,120,40);
			jlabquantity.setFont(new Font("Serif", Font.BOLD, 24));
			jlabquantity.setForeground(Color.red);
			
			
			
			
			jlabname1.setBounds(450,600,120,40);
			jlabname1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabname1.setForeground(Color.red);
			
			jlabmfg1.setBounds(650,600,120,40);
			jlabmfg1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabmfg1.setForeground(Color.red);
			
			jlabexpire1.setBounds(850,600,120,40);
			jlabexpire1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabexpire1.setForeground(Color.red);
			
			jlabprice1.setBounds(1050,600,120,40);
			jlabprice1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabprice1.setForeground(Color.red);
			
			jlabquantity1.setBounds(1250,600,120,40);
			jlabquantity1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabquantity1.setForeground(Color.red);
			*/
			
			
			
			
			
			
			
			
			
			btndelete.setBounds(860,350,100,40);
			btndelete.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnexit.setBounds(980,350,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnnext.setBounds(1700,900,100,40);
			btnnext.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			btnshow.setBounds(1130,350,100,40);
			btnshow.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnback.setBounds(100,900,100,40);
			btnback.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnhome.setBounds(1400,900,100,40);
			btnhome.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			/*this.add(jlabname);
			this.add(jlabmfg);
			this.add(jlabexpire);
			this.add(jlabprice);
			this.add(jlabquantity);
			
			this.add(jlabname1);
			this.add(jlabmfg1);
			this.add(jlabexpire1);
			this.add(jlabprice1);
			this.add(jlabquantity1);
			*/
			
			
			
			
			this.add(btndelete);
			this.add(btnexit);	
            this.add(btnnext);	
            this.add(btnshow);	
            this.add(btnback);
this.add(btnhome);				
			
			this.setVisible(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
			
			
		}
		
	public void actionPerformed(ActionEvent e)
	{	
if(e.getSource()==btnhome) 	
	{

      this.setVisible(false);
   Home a=new Home();
   a.setVisible(true);
	}
			

if(e.getSource()==btndelete) 	
	{
		 String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
try{
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");	
	PreparedStatement  st1 = con.prepareStatement("delete from emp151257 where expire<='"+date+"'");	
    PreparedStatement  st = con.prepareStatement("select * from emp151257 where expire<='"+date+"'");
	ResultSet rs=st.executeQuery();
	if(rs.next())
	{
		JOptionPane.showMessageDialog(p1,"Record Found");
		st1.executeUpdate();
		JOptionPane.showMessageDialog(p1,"Record is deleted successfully.");
	} 
	else
	{
		JOptionPane.showMessageDialog(p1,"No Record Found");
	}
	con.close();	
	}
    catch(Exception e1)
    {
		 JOptionPane.showMessageDialog(p1,"No Record Found");
	}

	}
	
	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(e.getSource()==btnback)
	{
   this.setVisible(false);
   Update a=new Update();
   a.setVisible(true);
	}
	
	if(e.getSource()==btnnext)
	{
   this.setVisible(false);
   Bill u=new Bill();
   u.setVisible(true);
   
	} 
	if(e.getSource()==btnshow)
	{
		
     TableFromMySqlDatabase a=new TableFromMySqlDatabase();
     a.setVisible(true);
	 a.setSize(1200,1200);
		
	}
	}
	
	public static void main(String args[])throws Exception
	{
		Delete ls = new Delete();
		
	}	
			
			
}