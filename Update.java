import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*; 
import java.util.*; 
class Update extends JFrame   implements ActionListener
{
            JButton btnexit,btnnext,btnback,btnupdate,btnhome;
			JTextField jtfprice,jtfquantity,jtfname;	
			JLabel jlabprice,jlabquantity,jlabname1;			
            JPanel p1;			
			
			
		public Update()
		{
			
			super();			
			
			
			btnexit = new JButton("Exit");
			btnnext = new JButton("Next");			
			btnback = new JButton("Back");
			btnupdate = new JButton("Update");
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
         setContentPane(new JLabel(new ImageIcon("dd.jpg")));
         setLayout(new FlowLayout());
			
			
			jtfname = new JTextField();
			jtfprice = new JTextField();
			jtfquantity = new JTextField();			
						
			
			jlabprice = new JLabel("New Price:");
			jlabquantity = new JLabel("New Quantity:");
			jlabname1 = new JLabel("Medicine Name:");	
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			          		
			
             jtfname.setToolTipText("Enter Medicine Name");
            jtfprice.setToolTipText("Enter New price");
            jtfquantity.setToolTipText("Enter New Medicine Quantity");			
			 
			
		   Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			
			
			btnexit.addActionListener(this);
			btnnext.addActionListener(this);            
			btnback.addActionListener(this);
            btnupdate.addActionListener(this);	
btnhome.addActionListener(this);			
			
			

             jlabname1.setBounds(500,400,120,40);
			jlabname1.setFont(new Font("Serif", Font.BOLD, 24));
			jlabname1.setForeground(Color.red);				

			
			
			jlabprice.setBounds(500,500,120,40);
			jlabprice.setFont(new Font("Serif", Font.BOLD, 24));
			jlabprice.setForeground(Color.red);
			
			jlabquantity.setBounds(500,600,120,40);
			jlabquantity.setFont(new Font("Serif", Font.BOLD, 24));
			jlabquantity.setForeground(Color.red);
			
			
			jtfname.setBounds(640,400,300,40);
			jtfname.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfprice.setBounds(640,500,300,40);
			jtfprice.setFont(new Font("Serif", Font.PLAIN, 20));
			
			jtfquantity.setBounds(640,600,300,40);
			jtfquantity.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			
			
			
			
			
			
			
			
			btnexit.setBounds(980,500,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnnext.setBounds(1700,900,100,40);
			btnnext.setFont(new Font("Serif", Font.PLAIN, 20));			
			
			btnback.setBounds(100,900,100,40);
			btnback.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnupdate.setBounds(980,400,100,40);
			btnupdate.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnhome.setBounds(1400,900,100,40);
			btnhome.setFont(new Font("Serif", Font.PLAIN, 20));
			
				
			this.add(jlabprice);
			this.add(jlabquantity);
			this.add(jlabname1);
			
			
			this.add(jtfprice);
			this.add(jtfquantity);				
			this.add(jtfname);
			
			
			
			
			
			this.add(btnexit);	
            this.add(btnnext);	            	
            this.add(btnback);
            this.add(btnupdate);
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
		

	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(e.getSource()==btnback)
	{
   this.setVisible(false);
   Search a=new Search();
   a.setVisible(true);
	}
	
	if(e.getSource()==btnnext)
	{
   this.setVisible(false);
   Delete b=new Delete();
   b.setVisible(true);
   
	} 
	
	
	if(e.getSource()==btnupdate)
	{
   
   String v1=jtfprice.getText();
   int v2=Integer.parseInt(jtfquantity.getText());
   String v3=jtfname.getText();
   
   

    try{
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");
	Statement st1 = con.createStatement();
    ResultSet rs=st1.executeQuery("select quantity from emp151257 where medicine_name='"+v3+"'");
	 
	if (rs.next()) 					
				{
					
                    
				 JOptionPane.showMessageDialog(p1,"Medicine Found!");			
	int c=rs.getInt(1);
	int s=c+v2;	
	PreparedStatement st=con.prepareStatement("update emp151257 set price='"+v1+"',quantity='"+s+"' where medicine_name='"+v3+"'");
   
	st.executeUpdate();                    
	JOptionPane.showMessageDialog(p1,"Update Successfully!");
	jtfname.setText("");
	jtfprice.setText("");
	jtfquantity.setText("");
	con.close();				 
					
                
				}				
				
				
	
				
				else
				{
                    JOptionPane.showMessageDialog(p1,"Medicine is not Found!");
					jtfname.setText("");
					jtfprice.setText("");
					jtfquantity.setText("");
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
		Update ls = new Update();
	}	
			
			
}