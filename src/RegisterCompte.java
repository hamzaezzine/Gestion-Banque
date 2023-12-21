import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RegisterCompte extends JFrame implements ActionListener {
    Number client_id;
    JLabel title_label, dash_label, image_label,type_compte_label, numero_carte_label, date_expiration_label, pin_label;
    JButton next_btn;
    JTextField numero_carte_field, date_expiration_field, pin_field;
    JComboBox type_compte_combobox;


    RegisterCompte(Number client_id) {
        this.client_id = client_id;
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
        next_btn = new JButton("Suivant");
        next_btn.setBackground(new Color(149, 136, 248));
        next_btn.setForeground(Color.WHITE);
        next_btn.setFont(new Font("Arial", Font.BOLD, 15));
        next_btn.setBounds(510, 290, 110, 30);
        next_btn.addActionListener(this);
        add(next_btn);



        // Fields :  
        
        
        String types[] = {"Compte Courant", "Compte Épargne", "Compte Chèque", "Compte Entreprise", "Compte Jeune", "Compte Étudiant"};
        type_compte_combobox = new JComboBox(types);
        type_compte_combobox.setBounds(290, 125, 330, 25);
        add(type_compte_combobox);
        
        numero_carte_field = new JTextField(50);
        numero_carte_field.setFont(new Font("Arial", Font.BOLD, 15));
        numero_carte_field.setBounds(290, 165, 330, 25);
        add(numero_carte_field);

        date_expiration_field = new JTextField(50);
        date_expiration_field.setFont(new Font("Arial", Font.BOLD, 15));
        date_expiration_field.setBounds(290, 205, 330, 25);
        add(date_expiration_field);

        pin_field = new JTextField(50);
        pin_field.setFont(new Font("Arial", Font.BOLD, 15));
        pin_field.setBounds(290, 245, 330, 25);
        add(pin_field);
        
        genererInfosCarteAleatoires();
        
        setLayout(null);
        setLocation(200, 20);
        setSize(700, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type_compte = (String)type_compte_combobox.getSelectedItem();
        String numero_carte = numero_carte_field.getText();
        String date_expiration = date_expiration_field.getText();
        String pin = pin_field.getText();


        try {
            if (e.getSource() == next_btn) {
                
                if (type_compte_combobox.getSelectedItem() == null || numero_carte_field.getText().isEmpty() || date_expiration_field.getText().isEmpty() || pin_field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tout les champs.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                Conn connectionSQL = new Conn();

                LocalDate currentDate = LocalDate.now();

                String insertCompteQuery = "INSERT INTO compte (date_ouverture, solde, type_id, client_id) VALUES ('" + currentDate + "', 0, " + obtenirIdTypeCompte(type_compte) + ", " + client_id + ")";
                connectionSQL.statement.executeUpdate(insertCompteQuery, Statement.RETURN_GENERATED_KEYS);

                ResultSet generatedKeys = connectionSQL.statement.getGeneratedKeys();
                int compte_id = 0;
                if (generatedKeys.next()) {
                    compte_id = generatedKeys.getInt(1);

                    String insertCarteQuery = "INSERT INTO carte (numero, date_expiration, pin, compte_id) VALUES ('" + numero_carte + "', '" + date_expiration + "', " + pin + ", " + compte_id + ")";
                    connectionSQL.statement.executeUpdate(insertCarteQuery);

                    new Home(compte_id).setVisible(true);
                    setVisible(false);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
    
    private void genererInfosCarteAleatoires() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder("4"); 
        for (int i = 0; i < 15; i++) {
            cardNumber.append(random.nextInt(10));
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 2);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expirationDate = dateFormat.format(calendar.getTime());

        String pin = String.format("%04d", random.nextInt(10000));

        numero_carte_field.setText(cardNumber.toString());
        date_expiration_field.setText(expirationDate);
        pin_field.setText(pin);
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

}
