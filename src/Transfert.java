import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transfert extends JFrame implements ActionListener {
    Number compte_id;
    JLabel title_label, image_label, montant_label, compte_destinataire_label, libelle_label,dash_label;
    JTextField montant_field, compte_destinataire_field, libelle_field;
    JButton retour_btn, transfert_btn;

    Transfert(Number compte_id){
        this.compte_id = compte_id;
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
        compte_destinataire_label.setBounds(150, 90, 600, 50);
        add(compte_destinataire_label);

        compte_destinataire_field = new JTextField(20);
        compte_destinataire_field.setFont(new Font("Arial", Font.BOLD, 20));
        compte_destinataire_field.setBounds(150, 130, 390, 30);
        add(compte_destinataire_field);

        montant_label = new JLabel("Montant :");
        montant_label.setFont(new Font("Oswald", Font.PLAIN, 17));
        montant_label.setBounds(150, 170, 600, 50);
        add(montant_label);

        montant_field = new JTextField(20);
        montant_field.setFont(new Font("Arial", Font.BOLD, 20));
        montant_field.setBounds(150, 210, 390, 30);
        add(montant_field);
        
        libelle_label = new JLabel("Libellé :");
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

        transfert_btn = new JButton("TRANSFERT");
        transfert_btn.setBackground(new Color(149, 136, 248));
        transfert_btn.setForeground(Color.WHITE);
        transfert_btn.setFont(new Font("Arial", Font.BOLD, 15));
        transfert_btn.setBounds(380, 340, 160, 40);
        transfert_btn.addActionListener(this);
        add(transfert_btn);
        
        ImageIcon appIcon = new ImageIcon(ClassLoader.getSystemResource("images/appicon.png"));
        setIconImage(appIcon.getImage());


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 460);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retour_btn) {
            new Home(compte_id).setVisible(true);
            setVisible(false);
        } 
        else if (e.getSource() == transfert_btn) {
            String destinataireIdStr = compte_destinataire_field.getText();
            String montantStr = montant_field.getText();
            String libelle = libelle_field.getText();

            if (!destinataireIdStr.isEmpty() && !montantStr.isEmpty()) {
                try {
                    int destinataireId = Integer.parseInt(destinataireIdStr);
                    double montant;

                    try {
                        montant = Double.parseDouble(montantStr);

                        if (montant <= 0) {
                            JOptionPane.showMessageDialog(this, "Le montant est invalide.");
                        } 
                        else if (!estCompteExiste(destinataireId)) {
                            JOptionPane.showMessageDialog(this, "Compte destinataire introuvable.");
                        } 
                        else if (!estSoldeSuffisant(compte_id.intValue(), montant)) {
                            JOptionPane.showMessageDialog(this, "Solde insuffisant.");
                        } 
                        else {
                            soustraireDuSolde(compte_id.intValue(), montant);
                            ajouterSolde(destinataireId, montant);
                            ajouterOperation(compte_id.intValue(), destinataireId, montant, libelle);

                            JOptionPane.showMessageDialog(this, "Transfert réussi !");
                        }
                    } 
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Le montant doit être un nombre valide.");
                    }
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "ID du destinataire doit être un nombre entier.");
                }
            } 
            else {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            }
        }
    }


    private boolean estCompteExiste(int compteId) {
        try {
            Conn connection = new Conn();
            String query = "SELECT * FROM compte WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setInt(1, compteId);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } 
        catch (Exception e) {
            return false;
        }
    }

    private boolean estSoldeSuffisant(int compteId, double amount) {
        try {
            Conn connection = new Conn();
            String query = "SELECT solde FROM compte WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setInt(1, compteId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double solde = resultSet.getDouble("solde");
                return solde >= amount;
            }
            return false;
        } 
        catch (Exception e) {
            return false;
        }
    }

    private void soustraireDuSolde(int compteId, double amount) {
        try {
            Conn connection = new Conn();
            String updateQuery = "UPDATE compte SET solde = solde - ? WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, compteId);

            preparedStatement.executeUpdate();
            connection.connection.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while updating the source account.");
        }
    }

    private void ajouterSolde(int compteId, double amount) {
        try {
            Conn connection = new Conn();
            String updateQuery = "UPDATE compte SET solde = solde + ? WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, compteId);

            preparedStatement.executeUpdate();
            connection.connection.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating the destination account.");
        }
    }

    private void ajouterOperation(int sourceId, int destinationId, double amount, String libelle) {
        try {
            Conn connection = new Conn();
            String insertQuery = "INSERT INTO operation (date_operation, time_operation, compte_id, destinataire_id, montant, libelle, type_id) VALUES (CURDATE(), CURTIME(), ?, ?, ?, ?, 3)";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, sourceId);
            preparedStatement.setInt(2, destinationId);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setString(4, libelle);

            preparedStatement.executeUpdate();
            connection.connection.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the operation.");
        }
    }
}
