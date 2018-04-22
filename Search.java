import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;  
import java.io.*; 
import java.util.*; 
import java.awt.geom.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
class Search extends JFrame   implements ActionListener
{
            JButton btnsearch,btnreset,btnexit,btnnext,btnback,btnhome;
			JTextField jtfsearch;								
            JPanel p1;	
			JFrame frame1;
			static JTable table;
			String[] columnNames = {"Medicine Name", "MFG Date", "Expiry Date", "Price","Quantity"};


 
			
			
		public Search()
		{
			
			super();			
			
			btnreset = new JButton("Reset");
			btnexit = new JButton("Exit");
			btnnext = new JButton("Next");
			btnsearch = new JButton("Search");
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
			
			
			
			
			jtfsearch = new JTextField();
			
			
			
			
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			          		
			
			 jtfsearch.setToolTipText("Enter Medicine Name");
			
		   Image icon = Toolkit.getDefaultToolkit().getImage("phar.png");    
           this.setIconImage(icon);  
			
			
			
			btnreset.addActionListener(this);
			btnexit.addActionListener(this);
			btnnext.addActionListener(this);
            btnsearch.addActionListener(this);
			btnback.addActionListener(this);
             btnhome.addActionListener(this);					
			
			
			
			
			jtfsearch.setBounds(640,250,700,40);
			jtfsearch.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			
			
			btnreset.setBounds(860,350,100,40);
			btnreset.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnexit.setBounds(980,350,100,40);
			btnexit.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnnext.setBounds(1700,900,100,40);
			btnnext.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			btnsearch.setBounds(1340,250,100,40);
			btnsearch.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnback.setBounds(100,900,100,40);
			btnback.setFont(new Font("Serif", Font.PLAIN, 20));
			
			btnhome.setBounds(1400,900,100,40);
			btnhome.setFont(new Font("Serif", Font.PLAIN, 20));
			
			
			
			
			this.add(jtfsearch);
			
			
			this.add(btnreset);
			this.add(btnexit);	
            this.add(btnnext);	
            this.add(btnsearch);	
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
		

if(e.getSource()==btnreset) 	
	{

jtfsearch.setText("");
	}
	
	if(e.getSource()==btnexit)
	{
   System.exit(0);   
	}
	if(e.getSource()==btnback)
	{
   this.setVisible(false);
   Add a=new Add();
   a.setVisible(true);
	}
	
	if(e.getSource()==btnnext)
	{
   this.setVisible(false);
   Update u=new Update();
   u.setVisible(true);
   
	} 
	if(e.getSource()==btnsearch)
	{
		
		String v1=jtfsearch.getText();

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
String textvalue = jtfsearch.getText();
String medicine= "";
String mfg= "";
String expire= "";
String price = "";
String quantity = "";
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
frame1.setDefaultCloseOperation( EXIT_ON_CLOSE );
 
   
   
    try{
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
	}

	

	
	public static void main(String args[])throws Exception	
	{
		Search ls = new Search();
		
	}	
			
			
}