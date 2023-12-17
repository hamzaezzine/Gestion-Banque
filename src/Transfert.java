import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transfert extends JFrame implements ActionListener {
    Number client_id;
    JLabel title_label, image_label, montant_label, compte_destinataire_label, libelle_label,dash_label;
    JTextField montant_field, compte_destinataire_field, libelle_field;
    JButton retour_btn, depot_btn;


    Transfert(Number client_id){
        this.client_id = client_id;
        System.out.println(client_id);


        setTitle("Transfert de fonds");

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Transfert de fonds");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);


        compte_destinataire_label = new JLabel("Saisissez l'id de compte destinataire :");
        compte_destinataire_label.setFont(new Font("Oswald", Font.PLAIN, 17));
        compte_destinataire_label.setBounds(150, 100, 600, 50);
        add(compte_destinataire_label);


        compte_destinataire_field = new JTextField(20);
        compte_destinataire_field.setFont(new Font("Arial", Font.BOLD, 20));
        compte_destinataire_field.setBounds(150, 140, 390, 30);
        add(compte_destinataire_field);

        
        montant_label = new JLabel("Montant :");
        montant_label.setFont(new Font("Oswald", Font.PLAIN, 17));
        montant_label.setBounds(150, 180, 600, 50);
        add(montant_label);


        montant_field = new JTextField(20);
        montant_field.setFont(new Font("Arial", Font.BOLD, 20));
        montant_field.setBounds(150, 220, 390, 30);
        add(montant_field);
        
        libelle_label = new JLabel("libellé :");
        libelle_label.setFont(new Font("Oswald", Font.PLAIN, 17));
        libelle_label.setBounds(150, 250, 600, 50);
        add(libelle_label);


        libelle_field = new JTextField(20);
        libelle_field.setFont(new Font("Arial", Font.BOLD, 20));
        libelle_field.setBounds(150, 290, 390, 30);
        add(libelle_field);
        
        
        
        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(150, 340, 160, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);

        depot_btn = new JButton("TRANSFERT");
        depot_btn.setBackground(new Color(149, 136, 248));
        depot_btn.setForeground(Color.WHITE);
        depot_btn.setFont(new Font("Arial", Font.BOLD, 15));
        depot_btn.setBounds(380, 340, 160, 40);
        depot_btn.addActionListener(this);
        add(depot_btn);



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 460);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retour_btn){     
            new Home(client_id).setVisible(true);
            setVisible(false);
        }
        else if (e.getSource() == depot_btn) {
            System.out.println("TRANSFER");
        }
    }

}
