import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCompte extends JFrame implements ActionListener {
    Number compte_id;
    JLabel title_label, dash_label, image_label,type_compte_label, numero_carte_label, date_expiration_label, pin_label;
    JButton retour_btn, modifier_btn;
    JTextField numero_carte_field, date_expiration_field, pin_field;
    JComboBox type_compte_combobox;


    UpdateCompte(Number compte_id) {
        this.compte_id = compte_id;
        setTitle("Modifier Compte Client");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_label = new JLabel(imageIcon3);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);


        title_label = new JLabel("Modifier Compte Client");
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
        type_compte_label = new JLabel("Type Compte :");
        type_compte_label.setFont(new Font("Raleway", Font.BOLD, 17));
        type_compte_label.setBounds(70, 110, 200, 50);
        add(type_compte_label);

        numero_carte_label = new JLabel("Numero de la Carte :");
        numero_carte_label.setFont(new Font("Raleway", Font.BOLD, 17));
        numero_carte_label.setBounds(70, 150, 200, 50);
        add(numero_carte_label);

        date_expiration_label = new JLabel("Date d'expiration :");
        date_expiration_label.setFont(new Font("Raleway", Font.BOLD, 17));
        date_expiration_label.setBounds(70, 190, 200, 50);
        add(date_expiration_label);

        pin_label = new JLabel("PIN :");
        pin_label.setFont(new Font("Raleway", Font.BOLD, 17));
        pin_label.setBounds(70, 230, 200, 50);
        add(pin_label);

        
        // Buttons :
        retour_btn = new JButton("Retour");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(70, 290, 110, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);

        modifier_btn = new JButton("Modifier");
        modifier_btn.setBackground(new Color(149, 136, 248));
        modifier_btn.setForeground(Color.WHITE);
        modifier_btn.setFont(new Font("Arial", Font.BOLD, 15));
        modifier_btn.setBounds(510, 290, 110, 40);
        modifier_btn.addActionListener(this);
        add(modifier_btn);


        // Fields : 
        String types[] = {"Compte Courant", "Compte Épargne", "Compte Chèque", "Compte Entreprise", "Compte Jeune", "Compte Étudiant"};
        type_compte_combobox = new JComboBox(types);
        type_compte_combobox.setBounds(290, 125, 330, 25);
        add(type_compte_combobox);
        
        numero_carte_field = new JTextField(50);
        numero_carte_field.setFont(new Font("Arial", Font.BOLD, 15));
        numero_carte_field.setBounds(290, 165, 330, 25);
        numero_carte_field.setEditable(false);
        add(numero_carte_field);

        date_expiration_field = new JTextField(50);
        date_expiration_field.setFont(new Font("Arial", Font.BOLD, 15));
        date_expiration_field.setBounds(290, 205, 330, 25);
        add(date_expiration_field);

        pin_field = new JTextField(50);
        pin_field.setFont(new Font("Arial", Font.BOLD, 15));
        pin_field.setBounds(290, 245, 330, 25);
        add(pin_field);
        
        try {
            String query = "SELECT carte.numero, carte.date_expiration, carte.pin, type_compte.type_compte " +
                               "FROM carte " +
                               "JOIN compte ON carte.compte_id = compte.compte_id " +
                               "JOIN type_compte ON compte.type_id = type_compte.type_id " +
                               "WHERE compte.compte_id = ?";
            Conn connectionSQL = new Conn();
            PreparedStatement preparedStatement = connectionSQL.connection.prepareStatement(query);
            preparedStatement.setInt(1, compte_id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(query);
            if (resultSet.next()) {
                String typeCompte = resultSet.getString("type_compte");
                type_compte_combobox.setSelectedItem("Compte "+typeCompte);
                String numeroCarte = resultSet.getString("numero");
                numero_carte_field.setText(numeroCarte);
                String dateExpiration = resultSet.getString("date_expiration");
                date_expiration_field.setText(dateExpiration);
                String pin = resultSet.getString("pin");
                pin_field.setText(pin);
                
                System.out.println(pin);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type_compte = (String)type_compte_combobox.getSelectedItem();
        int type_compte_id = obtenirIdTypeCompte(type_compte);
        String date_expiration = date_expiration_field.getText();
        String pin = pin_field.getText();


        try {
            if (e.getSource() == modifier_btn) {
                if (!estPINValid(pin)) {
                    JOptionPane.showMessageDialog(this, "Le PIN doit contenir 4 chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!estDateValid(date_expiration)) {
                    JOptionPane.showMessageDialog(this, "Format de date d'expiration incorrect. Utilisez le format AAAA-MM-JJ.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String updateCompteQuery = "UPDATE compte SET type_id = ? WHERE compte_id = ?";
                Conn connectionSQL = new Conn();
                PreparedStatement updateCompteStatement = connectionSQL.connection.prepareStatement(updateCompteQuery);
                updateCompteStatement.setInt(1, type_compte_id);
                updateCompteStatement.setInt(2, compte_id.intValue());
                int rowsAffectedCompte = updateCompteStatement.executeUpdate();

                String updateCarteQuery = "UPDATE carte SET date_expiration = ?, pin = ? WHERE compte_id = ?";
                PreparedStatement updateCarteStatement = connectionSQL.connection.prepareStatement(updateCarteQuery);
                updateCarteStatement.setString(1, date_expiration);
                updateCarteStatement.setString(2, pin);
                updateCarteStatement.setInt(3, compte_id.intValue());
                int rowsAffectedCarte = updateCarteStatement.executeUpdate();

                if (rowsAffectedCompte > 0 && rowsAffectedCarte > 0) {
                    JOptionPane.showMessageDialog(this, "Informations mises à jour avec succès !");
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Échec de la mise à jour des informations.");
                }
                
            }
            if (e.getSource() == retour_btn) {
                new Compte(compte_id).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
        
    private int obtenirIdTypeCompte(String type_compte) {
        return switch (type_compte) {
            case "Compte Courant" -> 1;
            case "Compte Épargne" -> 2;
            case "Compte Chèque" -> 3;
            case "Compte Entreprise" -> 4;
            case "Compte Jeune" -> 5;
            case "Compte Étudiant" -> 6;
                
            default -> 1;
        };
    }  
    
    private boolean estPINValid(String pin) {
        return pin.matches("\\d{4}");
    }

    private boolean estDateValid(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}

