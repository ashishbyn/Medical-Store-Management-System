import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Project extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;


    //Images Path In Array
    String[] list = {
                      "aa.jpg",
                      "b1.jpg",
                      "b2.jpg",
                      "cc.jpg",
                      "dd.jpg",
                      "j.jpg",
                      "pp.jpg"
                    };
    
    public Project(){
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(0, 0, 1920, 1080);



        //Call The Function SetImageSize
        SetImageSize(6);
        

       //set a timer
        tm = new Timer(2000,new ActionListener() 
		{

            //@Override
            public void actionPerformed(ActionEvent e) 
			{
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);       
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

public static void main(String[] args){ 
      
    new Project();
}
}
