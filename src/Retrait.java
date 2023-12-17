import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Retrait extends JFrame implements ActionListener {
    Number client_id;
    JLabel image_label, title_label, dash_label;
    JButton btn_100, btn_200, btn_300, btn_400, btn_500, btn_600, btn_700, btn_800, btn_900, btn_1000, retour_btn, autre_btn;
    String pin;

    Retrait(Number client_id){
        this.client_id = client_id;
        System.out.println(client_id);
        

        setTitle("Retrait");


        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Retrait");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);

        
        
        btn_100 = new JButton("100 DH");
        btn_100.setBackground(new Color(149, 136, 248));
        btn_100.setForeground(Color.WHITE);
        btn_100.setFont(new Font("Arial", Font.BOLD, 20));
        btn_100.setBounds(20, 100, 250, 40);
        btn_100.addActionListener(this);
        add(btn_100);

        btn_200 = new JButton("200 DH");
        btn_200.setBackground(new Color(149, 136, 248));
        btn_200.setForeground(Color.WHITE);
        btn_200.setFont(new Font("Arial", Font.BOLD, 20));
        btn_200.setBounds(20, 160, 250, 40);
        btn_200.addActionListener(this);
        add(btn_200);

        btn_300 = new JButton("300 DH");
        btn_300.setBackground(new Color(149, 136, 248));
        btn_300.setForeground(Color.WHITE);
        btn_300.setFont(new Font("Arial", Font.BOLD, 20));
        btn_300.setBounds(20, 220, 250, 40);
        btn_300.addActionListener(this);
        add(btn_300);

        btn_400 = new JButton("400 DH");
        btn_400.setBackground(new Color(149, 136, 248));
        btn_400.setForeground(Color.WHITE);
        btn_400.setFont(new Font("Arial", Font.BOLD, 20));
        btn_400.setBounds(20, 280, 250, 40);
        btn_400.addActionListener(this);
        add(btn_400);

        btn_500 = new JButton("500 DH");
        btn_500.setBackground(new Color(149, 136, 248));
        btn_500.setForeground(Color.WHITE);
        btn_500.setFont(new Font("Arial", Font.BOLD, 20));
        btn_500.setBounds(20, 340, 250, 40);
        btn_500.addActionListener(this);
        add(btn_500);


        dash_label = new JLabel("_____________________________________");
        dash_label.setForeground(new Color(149, 136, 248));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(20, 360, 700, 100);
        add(dash_label);
        
        dash_label = new JLabel("_____________________________________");
        dash_label.setForeground(new Color( 245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(20, 350, 700, 100);
        add(dash_label);


        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 20));
        retour_btn.setBounds(20, 460, 250, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);

        

        btn_600 = new JButton("600 DH");
        btn_600.setBackground(new Color(149, 136, 248));
        btn_600.setForeground(Color.WHITE);
        btn_600.setFont(new Font("Arial", Font.BOLD, 20));
        btn_600.setBounds(390, 100, 250, 40);
        btn_600.addActionListener(this);
        add(btn_600);

        btn_700 = new JButton("700 DH");
        btn_700.setBackground(new Color(149, 136, 248));
        btn_700.setForeground(Color.WHITE);
        btn_700.setFont(new Font("Arial", Font.BOLD, 20));
        btn_700.setBounds(390, 160, 250, 40);
        btn_700.addActionListener(this);
        add(btn_700);

        btn_800 = new JButton("800 DH");
        btn_800.setBackground(new Color(149, 136, 248));
        btn_800.setForeground(Color.WHITE);
        btn_800.setFont(new Font("Arial", Font.BOLD, 20));
        btn_800.setBounds(390, 220, 250, 40);
        btn_800.addActionListener(this);
        add(btn_800);

        btn_900 = new JButton("900 DH");
        btn_900.setBackground(new Color(149, 136, 248));
        btn_900.setForeground(Color.WHITE);
        btn_900.setFont(new Font("Arial", Font.BOLD, 20));
        btn_900.setBounds(390, 280, 250, 40);
        btn_900.addActionListener(this);
        add(btn_900);

        btn_1000 = new JButton("1000 DH");
        btn_1000.setBackground(new Color(149, 136, 248));
        btn_1000.setForeground(Color.WHITE);
        btn_1000.setFont(new Font("Arial", Font.BOLD, 20));
        btn_1000.setBounds(390, 340, 250, 40);
        btn_1000.addActionListener(this);
        add(btn_1000);



        autre_btn = new JButton("AUTRE");
        autre_btn.setBackground(new Color(245, 174, 82));
        autre_btn.setForeground(Color.WHITE);
        autre_btn.setFont(new Font("Arial", Font.BOLD, 20));
        autre_btn.setBounds(390, 460, 250, 40);
        autre_btn.addActionListener(this);
        add(autre_btn);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 600);
        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_100){     
            System.out.println("btn_100");
        }
        else if (e.getSource() == btn_200) {
            System.out.println("btn_200");
        }
        else if (e.getSource() == btn_300) {
            System.out.println("btn_300");
        }
        else if (e.getSource() == btn_400) {
            System.out.println("btn_400");

        }
        else if (e.getSource() == btn_500) {
            System.out.println("btn_500");
        }
        else if (e.getSource() == btn_600) {
            System.out.println("btn_600");
        }
        else if (e.getSource() == btn_700) {
            System.out.println("btn_700");
        }
        else if (e.getSource() == btn_800) {
            System.out.println("btn_800");

        }
        else if (e.getSource() == btn_900) {
            System.out.println("btn_900");
        }
        else if (e.getSource() == btn_1000) {
            System.out.println("btn_1000");
        }
        else if (e.getSource() == retour_btn) {        
            new Home(client_id).setVisible(true);
            setVisible(false);
        }
        else if (e.getSource()==autre_btn){
            System.out.println("autre_btn");
        }
    }
    
}
