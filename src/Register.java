
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame implements ActionListener {

    JLabel title_label, dash_label, image_label,nom_label, prenom_label, date_naiss_label, genre_label, adresse_label,email_label, phone_label, nationalite_label, ville_label, code_postal_label;
    JButton next_btn, retour_btn;
    JTextField nom_field, prenom_field, date_naiss_field, adresse_field,email_field, phone_field, nationalite_field, ville_field, code_postal_field;
    JRadioButton male, female;


    Register() {

        setTitle("S'inscrire nouveau client");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_label = new JLabel(imageIcon3);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);


        title_label = new JLabel("S'inscrire nouveau client ");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 27));
        title_label.setBounds(140, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("______________________________");
        dash_label.setForeground(new Color(149, 136, 248));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(90, 0, 600, 100);
        add(dash_label);


        // Labels : 
        nom_label = new JLabel("Nom :");
        nom_label.setFont(new Font("Raleway", Font.BOLD, 17));
        nom_label.setBounds(70, 110, 200, 50);
        add(nom_label);

        prenom_label = new JLabel("Prenom :");
        prenom_label.setFont(new Font("Raleway", Font.BOLD, 17));
        prenom_label.setBounds(70, 150, 200, 50);
        add(prenom_label);

        date_naiss_label = new JLabel("Date de naissance :");
        date_naiss_label.setFont(new Font("Raleway", Font.BOLD, 17));
        date_naiss_label.setBounds(70, 190, 200, 50);
        add(date_naiss_label);

        genre_label = new JLabel("Genre :");
        genre_label.setFont(new Font("Raleway", Font.BOLD, 17));
        genre_label.setBounds(70, 230, 200, 50);
        add(genre_label);

        adresse_label = new JLabel("Adresse : ");
        adresse_label.setFont(new Font("Raleway", Font.BOLD, 17));
        adresse_label.setBounds(70, 270, 200, 50);
        add(adresse_label);

        email_label = new JLabel("Numero de Telephone :");
        email_label.setFont(new Font("Raleway", Font.BOLD, 17));
        email_label.setBounds(70, 310, 200, 50);
        add(email_label);

        phone_label = new JLabel(" Email :");
        phone_label.setFont(new Font("Raleway", Font.BOLD, 17));
        phone_label.setBounds(70, 350, 200, 50);
        add(phone_label);

        nationalite_label = new JLabel("Nationalite :");
        nationalite_label.setFont(new Font("Raleway", Font.BOLD, 17));
        nationalite_label.setBounds(70, 390, 200, 50);
        add(nationalite_label);

        ville_label = new JLabel("Ville :");
        ville_label.setFont(new Font("Raleway", Font.BOLD, 17));
        ville_label.setBounds(70, 430, 200, 50);
        add(ville_label);
        
        code_postal_label = new JLabel("Code Postal :");
        code_postal_label.setFont(new Font("Raleway", Font.BOLD, 17));
        code_postal_label.setBounds(70, 470, 200, 50);
        add(code_postal_label);
        
        
        // Buttons :
        next_btn = new JButton("Suivant");
        next_btn.setBackground(new Color(149, 136, 248));
        next_btn.setForeground(Color.WHITE);
        next_btn.setFont(new Font("Arial", Font.BOLD, 15));
        next_btn.setBounds(510, 530, 110, 30);
        next_btn.addActionListener(this);
        add(next_btn);

        retour_btn = new JButton("Retour");
        retour_btn.setBackground(new Color(149, 136, 248));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(70, 530, 110, 30);
        retour_btn.addActionListener(this);
        add(retour_btn);

        // Fields : 
        nom_field = new JTextField(50);
        nom_field.setFont(new Font("Arial", Font.BOLD, 15));
        nom_field.setBounds(290, 125, 330, 25);
        add(nom_field);

        prenom_field = new JTextField(50);
        prenom_field.setFont(new Font("Arial", Font.BOLD, 15));
        prenom_field.setBounds(290, 165, 330, 25);
        add(prenom_field);

        date_naiss_field = new JTextField(50);
        date_naiss_field.setFont(new Font("Arial", Font.BOLD, 15));
        date_naiss_field.setBounds(290, 205, 330, 25);
        add(date_naiss_field);

        male = new JRadioButton("Homme");
        male.setFont(new Font("Raleway", Font.PLAIN, 15));
        male.setBackground(Color.WHITE);
        male.setBounds(290, 245, 90, 20);
        add(male);

        female = new JRadioButton("Femme");
        female.setFont(new Font("Raleway", Font.PLAIN, 15));
        female.setBackground(Color.WHITE);
        female.setBounds(400, 245, 80, 20);
        add(female);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);
        
        
        adresse_field = new JTextField(50);
        adresse_field.setFont(new Font("Arial", Font.BOLD, 15));
        adresse_field.setBounds(290, 288, 330, 25);
        add(adresse_field);
        

        email_field = new JTextField(50);
        email_field.setFont(new Font("Arial", Font.BOLD, 15));
        email_field.setBounds(290, 365, 330, 25);
        add(email_field);
        

        phone_field = new JTextField(50);
        phone_field.setFont(new Font("Arial", Font.BOLD, 15));
        phone_field.setBounds(290, 325, 330, 25);
        add(phone_field);

        nationalite_field = new JTextField(50);
        nationalite_field.setFont(new Font("Arial", Font.BOLD, 15));
        nationalite_field.setBounds(290, 405, 330, 25);
        add(nationalite_field);

        ville_field = new JTextField(50);
        ville_field.setFont(new Font("Arial", Font.BOLD, 15));
        ville_field.setBounds(290, 447, 330, 25);
        add(ville_field);
        
        code_postal_field = new JTextField(50);
        code_postal_field.setFont(new Font("Arial", Font.BOLD, 15));
        code_postal_field.setBounds(290, 487, 330, 25);
        add(code_postal_field);



        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setLocation(200, 20);
        setSize(700, 630);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = nom_field.getText();
        String prenom = prenom_field.getText();
        String date_naiss = date_naiss_field.getText();
        String email = email_field.getText();
        String phone = phone_field.getText();
        String nationalite = nationalite_field.getText();
        String ville = ville_field.getText();
        String code_postal = code_postal_field.getText();
        String genre = null;
        if (male.isSelected()){
            genre = "Homme";
        }
        else if (female.isSelected()){
            genre = "Femme";
        }

        System.out.println("nom: "+ nom);
        System.out.println("prenom: "+ prenom);
        System.out.println("date_naiss: "+ date_naiss);
        System.out.println("email: "+ email);
        System.out.println("phone: "+ phone);
        System.out.println("nationalite: "+ nationalite);
        System.out.println("ville: "+ ville);
        System.out.println("code_postal: "+ code_postal);
        System.out.println("genre: "+ genre);

        try{

            if (e.getSource() == next_btn) {
                new RegisterCompte().setVisible(true);
                setVisible(false);
            }
            if (e.getSource() == retour_btn){
                new Login().setVisible(true);
                setVisible(false);
            }
        }
        catch (Exception e1){
            System.out.println(e1);
        }

    }

}
