import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdateClient extends JFrame implements ActionListener {
    Number compte_id;
    JLabel title_label, dash_label, image_label,nom_label, prenom_label, date_naiss_label, genre_label, adresse_label,email_label, phone_label, nationalite_label, ville_label, code_postal_label;
    JButton update_btn, retour_btn;
    JTextField nom_field, prenom_field, date_naiss_field, adresse_field,email_field, phone_field, nationalite_field, ville_field, code_postal_field;
    JRadioButton male, female;


    UpdateClient(Number compte_id) {
        this.compte_id = compte_id;
        setTitle("Modifier Client Informations");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_label = new JLabel(imageIcon3);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);


        title_label = new JLabel("Modifier Client Informations");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 27));
        title_label.setBounds(90, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("______________________________");
        dash_label.setForeground(new Color(245, 174, 82));
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

        phone_label = new JLabel("Email :");
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
        update_btn = new JButton("Modifier");
        update_btn.setBackground(new Color(149, 136, 248));
        update_btn.setForeground(Color.WHITE);
        update_btn.setFont(new Font("Arial", Font.BOLD, 15));
        update_btn.setBounds(510, 530, 110, 40);
        update_btn.addActionListener(this);
        add(update_btn);

        retour_btn = new JButton("Retour");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(70, 530, 110, 40);
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

        try {
            String query = "SELECT * FROM client WHERE client_id = (SELECT client_id FROM compte WHERE compte_id = ?)";
            PreparedStatement preparedStatement = new Conn().connection.prepareStatement(query);
            preparedStatement.setInt(1, compte_id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nom_field.setText(resultSet.getString("nom"));
                prenom_field.setText(resultSet.getString("prenom"));
                date_naiss_field.setText(resultSet.getString("date_naissance_"));
                adresse_field.setText(resultSet.getString("adresse"));
                email_field.setText(resultSet.getString("email"));
                phone_field.setText(resultSet.getString("numero_telephone"));
                nationalite_field.setText(resultSet.getString("nationalite"));
                ville_field.setText(resultSet.getString("ville"));
                code_postal_field.setText(resultSet.getString("code_postal"));

                String genre = resultSet.getString("genre");
                if ("Homme".equals(genre)) {
                    male.setSelected(true);
                } 
                else if ("Femme".equals(genre)) {
                    female.setSelected(true);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setLocation(200, 50);
        setSize(700, 630);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = nom_field.getText();
        String prenom = prenom_field.getText();
        String date_naiss = date_naiss_field.getText();
        String email = email_field.getText();
        String adresse = adresse_field.getText();
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

        try {
            if (e.getSource() == update_btn) {
                if (nom.isEmpty() || prenom.isEmpty() || date_naiss.isEmpty() || email.isEmpty() || adresse.isEmpty() || phone.isEmpty() || nationalite.isEmpty() || ville.isEmpty() || code_postal.isEmpty() || genre == null) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return; 
                }

                String updateQuery = "UPDATE client SET nom=?, prenom=?, date_naissance_=?, genre=?, adresse=?, email=?, numero_telephone=?, nationalite=?, ville=?, code_postal=? WHERE client_id=(SELECT client_id FROM compte WHERE compte_id = ?)";
                PreparedStatement updateStatement = new Conn().connection.prepareStatement(updateQuery);
                updateStatement.setString(1, nom);
                updateStatement.setString(2, prenom);
                updateStatement.setString(3, date_naiss);
                updateStatement.setString(4, genre);
                updateStatement.setString(5, adresse);
                updateStatement.setString(6, email);
                updateStatement.setString(7, phone);
                updateStatement.setString(8, nationalite);
                updateStatement.setString(9, ville);
                updateStatement.setString(10, code_postal);
                updateStatement.setInt(11, compte_id.intValue());

                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Les informations du client ont été mises à jour avec succès !", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Échec de la mise à jour des informations du client.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == retour_btn) {
                new Compte(compte_id).setVisible(true);
                setVisible(false);
            }
        } 
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
