import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compte extends JFrame implements ActionListener {
    Number compte_id;
    JLabel title_label, image_label, montant_label, dash_label;
    JButton retour_btn;


    Compte(Number compte_id){
        this.compte_id = compte_id;
        setTitle("Compte");

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Operations");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);


        montant_label = new JLabel("Le solde de votre compte est :");
        montant_label.setFont(new Font("Oswald", Font.PLAIN, 17));
        montant_label.setBounds(150, 105, 600, 50);
        add(montant_label);


        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(150, 220, 160, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);




        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 360);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retour_btn){     
            new Home(compte_id).setVisible(true);
            setVisible(false);
        }
    }
}
