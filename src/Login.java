import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel login_label, nomCompte_label, idCompte_label, signup1_label, dash_label, image_login;
    JTextField nomCompte_field, idCompte_field;
    JButton login_btn, effacer_btn, signup_btn;

    Login() {
        setTitle("Gestion des comptes bancaire");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(340, 300, Image.SCALE_SMOOTH );
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        image_login = new JLabel(imageIcon3);
        image_login.setBounds(60, 40, 250, 250);
        add(image_login);

        login_label = new JLabel("AUTHENTIFICATION");
        login_label.setForeground(new Color(149, 136, 248));
        login_label.setFont(new Font("", Font.BOLD, 24));
        login_label.setBounds(430, 45, 400, 50);
        add(login_label);

        dash_label = new JLabel("_______________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Oswald", Font.BOLD, 20));
        dash_label.setBounds(430, 70, 600, 25);
        add(dash_label);

        nomCompte_label = new JLabel("Nom Complet :");
        nomCompte_label.setFont(new Font("Raleway", Font.PLAIN, 18));
        nomCompte_label.setBounds(380, 45, 375, 200);
        add(nomCompte_label);

        idCompte_label = new JLabel("Compte ID :");
        idCompte_label.setFont(new Font("Raleway", Font.PLAIN, 18));
        idCompte_label.setBounds(380, 88, 375, 200);
        add(idCompte_label);
        
        nomCompte_field = new JTextField(15);
        nomCompte_field.setFont(new Font("Arial", Font.PLAIN, 15));
        nomCompte_field.setBounds(540, 132, 180, 30);
        nomCompte_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        add(nomCompte_field);
        
        idCompte_field = new JTextField(15);
        idCompte_field.setFont(new Font("Arial", Font.PLAIN, 15));
        idCompte_field.setBounds(540, 175, 180, 30);
        add(idCompte_field);

        login_btn = new JButton("Se Connecter");
        login_btn.setBackground(new Color(245, 174, 82));
        login_btn.setForeground(Color.WHITE);
        login_btn.setFont(new Font("Arial", Font.BOLD, 15));
        login_btn.setBounds(380, 220, 160, 30);
        login_btn.addActionListener(this);
        add(login_btn);

        effacer_btn = new JButton("Effacer");
        effacer_btn.setBackground(new Color(245, 174, 82));
        effacer_btn.setForeground(Color.WHITE);
        effacer_btn.setFont(new Font("Arial", Font.BOLD, 15));
        effacer_btn.setBounds(560, 220, 160, 30);
        effacer_btn.addActionListener(this);
        add(effacer_btn);

        signup1_label = new JLabel("Créer un nouveau compte");
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
            new Register().setVisible(true);
            setVisible(false);
        } 
        else if (e.getSource() == effacer_btn) {
            nomCompte_field.setText("");
            idCompte_field.setText("");
        } 
        else if (e.getSource() == login_btn) {
            String nomCompte = nomCompte_field.getText();
            String idCompte = idCompte_field.getText();

            if (nomCompte.isEmpty() || idCompte.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Conn connectionSQL = new Conn();

                String compteCheckQuery = "SELECT * FROM compte WHERE compte_id = ?";
                PreparedStatement compteCheckStatement = connectionSQL.connection.prepareStatement(compteCheckQuery);
                compteCheckStatement.setInt(1, Integer.parseInt(idCompte));
                ResultSet compteResultSet = compteCheckStatement.executeQuery();

                if (compteResultSet.next()) {
                    int clientID = compteResultSet.getInt("client_id");
                    String clientCheckQuery = "SELECT * FROM client WHERE client_id = ? AND (CONCAT(nom, ' ', prenom) = ? OR CONCAT(prenom, ' ', nom) = ?)";

                    PreparedStatement clientCheckStatement = connectionSQL.connection.prepareStatement(clientCheckQuery);
                    clientCheckStatement.setInt(1, clientID);
                    clientCheckStatement.setString(2, nomCompte);
                    clientCheckStatement.setString(3, nomCompte);

                    ResultSet clientResultSet = clientCheckStatement.executeQuery();

                    if (clientResultSet.next()) {
                        new Home(Integer.parseInt(idCompte)).setVisible(true);
                        setVisible(false);
                    } 
                    else {
                        JOptionPane.showMessageDialog(this, "Nom Complet incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Compte ID introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de compte valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
