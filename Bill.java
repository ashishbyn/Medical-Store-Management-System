import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*;  
import java.util.logging.*;
import java.util.*; 
import javax.swing.table.DefaultTableModel;
import java.lang.*;
class Bill extends JFrame   implements ActionListener
{
            JButton btnadd,btnprintbill,btntotal,btnsearch,btnexit,btnhome;
			JTextField jtfmedicine,jtfmedicine1,jtfprice,jtfquantity,jtftotal;			
			JLabel jlabmedicine1,jlabprice,jlabquantity,jlabtotal;	
			JFrame frame1;
			static JTable table;
			JPanel p1;	
			String[] columnNames = {"Medicine Name", "MFG Date", "Expiry Date", "Price","Quantity"};	
			
			
		public Bill()
		{
			super();			
			btnadd = new JButton("ADD");
			btnprintbill = new JButton("Bill");
			btntotal = new JButton("Total");
			btnsearch = new JButton("Search");
			btnexit = new JButton("Exit");
			btnhome = new JButton("Home");
			p1=new JPanel(new GridLayout(5,2));	

			
			ImageIcon image = new ImageIcon("p3.jpg");
          setSize(650,600);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);		
         setLayout(new BorderLayout());
         setContentPane(new JLabel(new ImageIcon("b1.jpg")));
         setLayout(new FlowLayout());
			
			
			jtfmedicine = new JTextField();
			jtfmedicine1 = new JTextField();
			jtfprice = new JTextField();
			jtfquantity = new JTextField();
			jtftotal = new JTextField();
		
			
			
			jlabmedicine1 = new JLabel("Medicine Name:");
			jlabprice = new JLabel("Price:");
			jlabquantity = new JLabel("Quantity:");
			jlabtotal = new JLabel("Total:");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//jpfpass.setToolTipText("Enter your Password");             		
			//jtfuser.setToolTipText("Enter your Username");              	
			Image icon = Toolkit.getDefaultToolkit().getImage("E:\\phar.png");    
            this.setIconImage(icon);  
			
			
			btnadd.addActionListener(this);
			btnprintbill.addActionListener(this);
			btntotal.addActionListener(this);
			btnsearch.addActionListener(this);
			btnexit.addActionListener(this);
			btnhome.addActionListener(this);
			
			
			jlabmedicine1.setBounds(450,450,120,40);
			jlabmedicine1.setFont(new Font("Serif", Font.PLAIN, 24));
			jlabprice.setBounds(450,500,120,40);
			jlabprice.setFont(new Font("Serif", Font.PLAIN, 24));
			jlabquantity.setBounds(450,550,120,40);
			jlabquantity.setFont(new Font("Serif", Font.PLAIN, 24));
			jlabtotal.setBounds(450,600,120,40);
			jlabtotal.setFont(new Font("Serif", Font.PLAIN, 24));
			
			
			jtfmedicine.setBounds(640,250,700,40);
			jtfmedicine.setFont(new Font("Serif", Font.PLAIN, 20));
			jtfmedicine1.setBounds(640,450,500,40);
			jtfmedicine1.setFont(new Font("Serif", Font.PLAIN, 20));
			jtfprice.setBounds(640,500,500,40);
			jtfprice.setFont(new Font("Serif", Font.PLAIN, 20));
			jtfquantity.setBounds(640,550,500,40);
			jtfquantity.setFont(new Font("Serif", Font.PLAIN, 20));
			jtftotal.setBounds(640,600,500,40);
			jtftotal.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			btnadd.setBounds(740,665,100,40);
			btnadd.setFont(new Font("Serif", Font.PLAIN, 20));
			btnprintbill.setBounds(860,665,100,40);
			btnprintbill.setFont(new Font("Serif", Font.PLAIN, 20));
			btntotal.setBounds(980,665,100,40);
			btntotal.setFont(new Font("Serif", Font.PLAIN, 20));
			btnsearch.setBounds(1340,250,100,40);
			btnsearch.setFont(new Font("Serif", Font.PLAIN, 20));
			btnexit.setBounds(1650,900,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			btnhome.setBounds(1500,900,100,40);
			btnhome.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			this.add(jlabmedicine1);
			this.add(jlabprice);
			this.add(jlabquantity);
			this.add(jlabtotal);			
			this.add(jtfmedicine);
			this.add(jtfmedicine1);
			this.add(jtfprice);
			this.add(jtfquantity);
			this.add(jtftotal);
			this.add(btnadd);
			this.add(btnprintbill);
			
			this.add(btnsearch);
			this.add(btnhome);
			this.add(btnexit);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
			this.setVisible(true);
		  
			
		}
		
	public void actionPerformed(ActionEvent ae)
	{	

		if(ae.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(ae.getSource()==btnhome)
	{
   this.setVisible(false);
   Home a=new Home();
   a.setVisible(true); 
	}
	if(ae.getSource()==btnsearch)
	{
  String v1=jtfmedicine.getText();

frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String textvalue = jtfmedicine.getText();
String medicine= "";
String mfg= "";
String expire= "";
String price = "";
String quantity = "";
frame1.add(scroll);

frame1.setVisible(true);
frame1.setSize(400,300);

    try
	{
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");	
	PreparedStatement ps = con.prepareStatement("select * from emp151257 where medicine_name='"+v1+"'");	
    ResultSet rs=ps.executeQuery();
	int i=0;
while(rs.next())
{

medicine = rs.getString("medicine_name");
mfg = rs.getString("mfg");
expire = rs.getString("expire");
price = rs.getString("price"); 
quantity = rs.getString("quantity"); 

model.addRow(new Object[]{medicine,mfg,expire,price,quantity});

i++; 
}
if(i==1)
{

JOptionPane.showMessageDialog(null," Record Found");


}
else
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
}


}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
	

	}
	if(ae.getSource()==btnadd)
	{

String v2=jtfmedicine1.getText();
int v3=Integer.parseInt(jtfprice.getText());
int v4=Integer.parseInt(jtfquantity.getText());
int v5=v3*v4;
int v6=0;
jtftotal.setText(""+v5);
	
	try
		{	
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");
    PreparedStatement st=con.prepareStatement("insert into emp(medicine_name,price,quantity,total) values(?,?,?,?)");	
	PreparedStatement st2=con.prepareStatement("select emp151257.quantity from emp151257,emp where emp.medicine_name='"+v2+"' and emp.medicine_name=emp151257.medicine_name");
	
	Statement st3 = con.createStatement();
    ResultSet rs1=st3.executeQuery("select price from emp151257 where medicine_name='"+v2+"'");
	 
	if (rs1.next()) 					
				{                   
				 		
	int c2=rs1.getInt(1);
	if(c2==v3)
	{
	st.setString(1,v2);
    st.setInt(2,v3);
    st.setInt(3,v4);
    st.setInt(4,v5);  
	st.executeUpdate();
	JOptionPane.showMessageDialog(null,"Item is added to your Bill"); 	
	
	ResultSet rs=st2.executeQuery();
	while(rs.next())
	{
		int c=rs.getInt(1);
		int s=c-v4;
		PreparedStatement st1=con.prepareStatement("update emp151257,emp set emp151257.quantity='"+s+"' where emp.medicine_name='"+v2+"' and emp.medicine_name=emp151257.medicine_name ");
		st1.executeUpdate();
		//JOptionPane.showMessageDialog(p1,"quantity is,"+c+"");
		
	}  

jtfmedicine1.setText("");
jtfprice.setText("");
jtfquantity.setText("");
jtftotal.setText("");
	}
	else{
		JOptionPane.showMessageDialog(null, "Please check your price","Error",JOptionPane.ERROR_MESSAGE); 
		jtfmedicine1.setText("");
jtfprice.setText("");
jtfquantity.setText("");
jtftotal.setText("");
	}
				}      	
    	//int c1=rs.getInt(1);
		//v6=c1-v4;
//st1.executeUpdate();		
	
	con.close();

}

catch(Exception e1)
{
JOptionPane.showMessageDialog(p1,"Error in submitting data!");
	}
}

if(ae.getSource()==btnprintbill)
{

int sum=0;
	try
		{	
	Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish","root","tiger");
	PreparedStatement st=con.prepareStatement("select SUM(total) from emp");
	PreparedStatement st1=con.prepareStatement("delete from emp");
	ResultSet rs = st.executeQuery();        
    if(rs.next())
    {
    	
    	int c=rs.getInt(1);
		sum=sum+c;
    	JOptionPane.showMessageDialog(p1,"you have to pay,"+sum+""); 
		
        TableFromMySql a=new TableFromMySql();
     a.setVisible(true);
	 a.setSize(800,800);
	 st1.executeUpdate();
    }
	
	
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(p1,e1);
}



}


	


} 
	
	public static void main(String args[])throws Exception	
	{
		Bill ls = new Bill();
	}	
			
			
}