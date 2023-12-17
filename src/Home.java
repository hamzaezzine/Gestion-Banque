import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    Number compte_id;

    JLabel image_label, image_bg_label, title_label, dash_label;
    JButton retrait_btn, depot_btn,  transfert_btn, solde_btn, operations_btn, pin_btn, sortie_btn;
    String pin;

    Home(Number compte_id){
        this.compte_id = compte_id;
        System.out.println(compte_id);
        

        setTitle("Accueil");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(300, 260, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_bg_label = new JLabel(imageIcon3);
        image_bg_label.setBounds(0, 100, 390, 360);
        add(image_bg_label);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Accueil");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);


        retrait_btn = new JButton("RETAIT");
        retrait_btn.setBackground(new Color(149, 136, 248));
        retrait_btn.setForeground(Color.WHITE);
        retrait_btn.setFont(new Font("Arial", Font.BOLD, 20));
        retrait_btn.setBounds(390, 100, 250, 40);
        retrait_btn.addActionListener(this);
        add(retrait_btn);

        depot_btn = new JButton("DEPOT");
        depot_btn.setBackground(new Color(149, 136, 248));
        depot_btn.setForeground(Color.WHITE);
        depot_btn.setFont(new Font("Arial", Font.BOLD, 20));
        depot_btn.setBounds(390, 160, 250, 40);
        depot_btn.addActionListener(this);
        add(depot_btn);

        transfert_btn = new JButton("TRASFERT");
        transfert_btn.setBackground(new Color(149, 136, 248));
        transfert_btn.setForeground(Color.WHITE);
        transfert_btn.setFont(new Font("Arial", Font.BOLD, 20));
        transfert_btn.setBounds(390, 220, 250, 40);
        transfert_btn.addActionListener(this);
        add(transfert_btn);

        solde_btn = new JButton("SOLDE");
        solde_btn.setBackground(new Color(149, 136, 248));
        solde_btn.setForeground(Color.WHITE);
        solde_btn.setFont(new Font("Arial", Font.BOLD, 20));
        solde_btn.setBounds(390, 280, 250, 40);
        solde_btn.addActionListener(this);
        add(solde_btn);

        operations_btn = new JButton("OPERATIONS");
        operations_btn.setBackground(new Color(149, 136, 248));
        operations_btn.setForeground(Color.WHITE);
        operations_btn.setFont(new Font("Arial", Font.BOLD, 20));
        operations_btn.setBounds(390, 340, 250, 40);
        operations_btn.addActionListener(this);
        add(operations_btn);

        pin_btn = new JButton("MODIFIER PIN");
        pin_btn.setBackground(new Color(149, 136, 248));
        pin_btn.setForeground(Color.WHITE);
        pin_btn.setFont(new Font("Arial", Font.BOLD, 20));
        pin_btn.setBounds(390, 400, 250, 40);
        pin_btn.addActionListener(this);
        add(pin_btn);

        sortie_btn = new JButton("SORTIE");
        sortie_btn.setBackground(new Color(245, 174, 82));
        sortie_btn.setForeground(Color.WHITE);
        sortie_btn.setFont(new Font("Arial", Font.BOLD, 20));
        sortie_btn.setBounds(390, 460, 250, 40);
        sortie_btn.addActionListener(this);
        add(sortie_btn);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 600);
        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retrait_btn){     
            new Retrait(compte_id).setVisible(true);
            setVisible(false);
        }
        else if (e.getSource() == depot_btn) {
            new Depot(compte_id).setVisible(true);
            setVisible(false);        
        }
        else if (e.getSource() == transfert_btn) {
            new Transfert(compte_id).setVisible(true);
            setVisible(false);  
           
        }
        else if (e.getSource() == solde_btn) {
            new Solde(compte_id).setVisible(true);
            setVisible(false);  

        }
        else if (e.getSource() == operations_btn) {
            System.out.println("operations_btn");
        }
        else if (e.getSource() == pin_btn) {        
            System.out.println("pin_btn");
        }
        else if (e.getSource()==sortie_btn){
            System.exit(0);
        }
    }
}
