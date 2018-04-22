import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*;  
//import java.util.logging.*;
import java.util.*; 
//import javax.imageio.ImageIO;
//import java.lang.NumberFormatException;
class Add extends JFrame   implements ActionListener
{
            JButton btnadd,btnreset,btnexit,btnhome;
			JTextField jtfname,jtfmfg,jtfexpire,jtfprice,jtfquantity;			
			JLabel jlabname,jlabmfg,jlabexpire,jlabprice,jlabquantity;	
JPanel p1;			
			
			
		public Add()
		{
			
			super();			
			btnadd = new JButton("ADD");
			btnreset = new JButton("Reset");
			btnexit = new JButton("Exit");
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
         setContentPane(new JLabel(new ImageIcon("cc.jpg")));
         setLayout(new FlowLayout());
			
			
			jtfname = new JTextField();
			jtfmfg = new JTextField();
			jtfexpire = new JTextField();
			jtfprice = new JTextField();
			jtfquantity = new JTextField();
			
			
			jlabname = new JLabel("Medicine Name:");
			jlabmfg = new JLabel("MFG Date:");
			jlabexpire = new JLabel("Expiry Date:");
			jlabprice = new JLabel("Price:");
			jlabquantity = new JLabel("Quantity:");
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			          		
			jtfname.setToolTipText("Enter Medicine Name");
            jtfmfg.setToolTipText("Enter Manufacturing Date");
            jtfexpire.setToolTipText("Enter Expiry Date ");
            jtfprice.setToolTipText("Enter price");
            jtfquantity.setToolTipText("Enter Medicine Quantity");
			
			Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			btnadd.addActionListener(this);
			btnreset.addActionListener(this);
			btnexit.addActionListener(this);
			btnhome.addActionListener(this);		
			
			jlabname.setBounds(450,400,120,40);
			jlabname.setFont(new Font("Serif", Font.BOLD, 24));
			jlabname.setForeground(Color.red);
			
			jlabmfg.setBounds(450,450,120,40);
			jlabmfg.setFont(new Font("Serif", Font.BOLD, 24));
			jlabmfg.setForeground(Color.red);
			
			jlabexpire.setBounds(450,500,120,40);
			jlabexpire.setFont(new Font("Serif", Font.BOLD, 24));
			jlabexpire.setForeground(Color.red);
			
			jlabprice.setBounds(450,550,120,40);
			jlabprice.setFont(new Font("Serif", Font.BOLD, 24));
			jlabprice.setForeground(Color.red);
			
			jlabquantity.setBounds(450,600,120,40);
			jlabquantity.setFont(new Font("Serif", Font.BOLD, 24));
			jlabquantity.setForeground(Color.red);
			
			
			
			jtfname.setBounds(640,400,500,40);
			jtfname.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfmfg.setBounds(640,450,500,40);
			jtfmfg.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfexpire.setBounds(640,500,500,40);
			jtfexpire.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfprice.setBounds(640,550,500,40);
			jtfprice.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfquantity.setBounds(640,600,500,40);
			jtfquantity.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			btnadd.setBounds(740,665,100,40);
			btnadd.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnreset.setBounds(860,665,100,40);
			btnreset.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnexit.setBounds(980,665,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnhome.setBounds(1500,900,100,40);
			btnhome.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			this.add(jlabname);
			this.add(jlabmfg);
			this.add(jlabexpire);
			this.add(jlabprice);
			this.add(jlabquantity);
			
			this.add(jtfname);
			this.add(jtfmfg);
			this.add(jtfexpire);
			this.add(jtfprice);
			this.add(jtfquantity);
			
			this.add(btnadd);
			this.add(btnreset);
			this.add(btnexit);	
            this.add(btnhome);				
			this.setVisible(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
			
			
		}
		
	public void actionPerformed(ActionEvent e)
	{	 

if(e.getSource()==btnreset) 	
	{
jtfname.setText(""); 

jtfmfg.setText("");  
jtfexpire.setText("");  
jtfprice.setText("");  
jtfquantity.setText("");
	}
	
	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(e.getSource()==btnhome)
	{
   this.setVisible(false);
   Home a=new Home();
   a.setVisible(true); 
	}
	
	if(e.getSource()==btnadd)
	{
		String v1=jtfname.getText();
		String v2=jtfmfg.getText();
		String v3=jtfexpire.getText();
		String v4=jtfprice.getText();
		String v5=jtfquantity.getText();
		
	try
		{	
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");
    PreparedStatement st=con.prepareStatement("insert into emp151257(medicine_name,mfg,expire,price,quantity) values(?,?,?,?,?)");
	
	st.setString(1,v1);
    st.setString(2,v2);
    st.setString(3,v3);
    st.setString(4,v4);
    st.setString(5,v5);
	
	
st.executeUpdate();
JOptionPane.showMessageDialog(p1,"Data is successfully inserted into database.");
con.close();


}
catch(Exception e1)
{
JOptionPane.showMessageDialog(p1,"Error in submitting data!");
}		
	}
	
	
	} 

	
	public static void main(String args[])throws Exception	
	{
		Add ls = new Add();
	}	
			
			
}