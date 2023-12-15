import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel login_label, numCart_label, numPin_label, signup1_label, label5, image_login;
    JTextField numCart_field;
    JPasswordField password_field;
    JButton login_btn, effacer_btn, signup_btn;

    Login() {
        setTitle("Gestion des comptes bancaire");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(340, 300, Image.SCALE_SMOOTH );
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_login = new JLabel(imageIcon3);
        image_login.setBounds(60, 40, 250, 250);
        add(image_login);

        login_label = new JLabel("ACCOUNT LOGIN");
        login_label.setForeground(new Color(149, 136, 248));
        login_label.setFont(new Font("", Font.PLAIN, 28));
        login_label.setBounds(430, 45, 400, 50);
        add(login_label);

        label5 = new JLabel("_______________________________");
        label5.setForeground(new Color(149, 136, 248));
        label5.setFont(new Font("Oswald", Font.BOLD, 20));
        label5.setBounds(430, 70, 600, 25);
        add(label5);

        numCart_label = new JLabel("Numero de Carte :");
        numCart_label.setFont(new Font("Raleway", Font.PLAIN, 18));
        numCart_label.setBounds(380, 45, 375, 200);
        add(numCart_label);

        numPin_label = new JLabel("Numero de PIN :");
        numPin_label.setFont(new Font("Raleway", Font.PLAIN, 18));
        numPin_label.setBounds(380, 88, 375, 200);
        add(numPin_label);
        
        numCart_field = new JTextField(15);
        numCart_field.setFont(new Font("Arial", Font.PLAIN, 15));
        numCart_field.setBounds(540, 132, 180, 30);
        numCart_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        add(numCart_field);

        password_field = new JPasswordField(15);
        password_field.setFont(new Font("Arial", Font.BOLD, 15));
        password_field.setBounds(540, 175, 180, 30);
        add(password_field);

        login_btn = new JButton("Se Connecter");
        login_btn.setBackground(new Color(12, 88, 198));
        login_btn.setForeground(Color.WHITE);
        login_btn.setFont(new Font("Arial", Font.BOLD, 15));
        login_btn.setBounds(380, 220, 160, 30);
        login_btn.addActionListener(this);
        add(login_btn);

        effacer_btn = new JButton("Effacer");
        effacer_btn.setBackground(new Color(12, 88, 198));
        effacer_btn.setForeground(Color.WHITE);
        effacer_btn.setFont(new Font("Arial", Font.BOLD, 15));
        effacer_btn.setBounds(560, 220, 160, 30);
        effacer_btn.addActionListener(this);
        add(effacer_btn);

        signup1_label = new JLabel("Vous n'avez pas de compte?");
        signup1_label.setFont(new Font("Arial", Font.ITALIC, 15));
        signup1_label.setBounds(380, 275, 300, 20);
        add(signup1_label);

        signup_btn = new JButton("S'inscrire");
        signup_btn.setBackground(new Color(149, 136, 248));
        signup_btn.setForeground(Color.WHITE);
        signup_btn.setFont(new Font("Arial", Font.BOLD, 15));
        signup_btn.setBounds(380, 295, 340, 30);
        signup_btn.addActionListener(this);
        add(signup_btn);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 150);
        setSize(800, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signup_btn) {    
//            new Signup().setVisible(true);
//            setVisible(false);
        }else if (e.getSource()==effacer_btn){  
            numCart_field.setText("");
            password_field.setText("");
        }

        try {

            if (e.getSource()==login_btn){
                System.out.println("login");
            }
        }
        catch(Exception e1){
            System.out.println("Error : " +e1);
        }
    }


}
