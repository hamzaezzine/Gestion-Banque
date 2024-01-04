import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Retrait extends JFrame implements ActionListener {
    Number compte_id;
    JLabel image_label, title_label, dash_label;
    JButton btn_100, btn_200, btn_300, btn_400, btn_500, btn_600, btn_700, btn_800, btn_900, btn_1000, retour_btn, autre_btn;

    Retrait(Number compte_id){
        this.compte_id = compte_id;
        setTitle("Retrait");


        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Retrait");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);

        
        
        btn_100 = new JButton("100 DH");
        btn_100.setBackground(new Color(149, 136, 248));
        btn_100.setForeground(Color.WHITE);
        btn_100.setFont(new Font("Arial", Font.BOLD, 20));
        btn_100.setBounds(20, 100, 250, 40);
        btn_100.addActionListener(this);
        add(btn_100);

        btn_200 = new JButton("200 DH");
        btn_200.setBackground(new Color(149, 136, 248));
        btn_200.setForeground(Color.WHITE);
        btn_200.setFont(new Font("Arial", Font.BOLD, 20));
        btn_200.setBounds(20, 160, 250, 40);
        btn_200.addActionListener(this);
        add(btn_200);

        btn_300 = new JButton("300 DH");
        btn_300.setBackground(new Color(149, 136, 248));
        btn_300.setForeground(Color.WHITE);
        btn_300.setFont(new Font("Arial", Font.BOLD, 20));
        btn_300.setBounds(20, 220, 250, 40);
        btn_300.addActionListener(this);
        add(btn_300);

        btn_400 = new JButton("400 DH");
        btn_400.setBackground(new Color(149, 136, 248));
        btn_400.setForeground(Color.WHITE);
        btn_400.setFont(new Font("Arial", Font.BOLD, 20));
        btn_400.setBounds(20, 280, 250, 40);
        btn_400.addActionListener(this);
        add(btn_400);

        btn_500 = new JButton("500 DH");
        btn_500.setBackground(new Color(149, 136, 248));
        btn_500.setForeground(Color.WHITE);
        btn_500.setFont(new Font("Arial", Font.BOLD, 20));
        btn_500.setBounds(20, 340, 250, 40);
        btn_500.addActionListener(this);
        add(btn_500);


        dash_label = new JLabel("_____________________________________");
        dash_label.setForeground(new Color(149, 136, 248));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(20, 360, 700, 100);
        add(dash_label);
        
        dash_label = new JLabel("_____________________________________");
        dash_label.setForeground(new Color( 245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(20, 350, 700, 100);
        add(dash_label);


        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 20));
        retour_btn.setBounds(20, 460, 250, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);

        

        btn_600 = new JButton("600 DH");
        btn_600.setBackground(new Color(149, 136, 248));
        btn_600.setForeground(Color.WHITE);
        btn_600.setFont(new Font("Arial", Font.BOLD, 20));
        btn_600.setBounds(390, 100, 250, 40);
        btn_600.addActionListener(this);
        add(btn_600);

        btn_700 = new JButton("700 DH");
        btn_700.setBackground(new Color(149, 136, 248));
        btn_700.setForeground(Color.WHITE);
        btn_700.setFont(new Font("Arial", Font.BOLD, 20));
        btn_700.setBounds(390, 160, 250, 40);
        btn_700.addActionListener(this);
        add(btn_700);

        btn_800 = new JButton("800 DH");
        btn_800.setBackground(new Color(149, 136, 248));
        btn_800.setForeground(Color.WHITE);
        btn_800.setFont(new Font("Arial", Font.BOLD, 20));
        btn_800.setBounds(390, 220, 250, 40);
        btn_800.addActionListener(this);
        add(btn_800);

        btn_900 = new JButton("900 DH");
        btn_900.setBackground(new Color(149, 136, 248));
        btn_900.setForeground(Color.WHITE);
        btn_900.setFont(new Font("Arial", Font.BOLD, 20));
        btn_900.setBounds(390, 280, 250, 40);
        btn_900.addActionListener(this);
        add(btn_900);

        btn_1000 = new JButton("1000 DH");
        btn_1000.setBackground(new Color(149, 136, 248));
        btn_1000.setForeground(Color.WHITE);
        btn_1000.setFont(new Font("Arial", Font.BOLD, 20));
        btn_1000.setBounds(390, 340, 250, 40);
        btn_1000.addActionListener(this);
        add(btn_1000);



        autre_btn = new JButton("AUTRE");
        autre_btn.setBackground(new Color(245, 174, 82));
        autre_btn.setForeground(Color.WHITE);
        autre_btn.setFont(new Font("Arial", Font.BOLD, 20));
        autre_btn.setBounds(390, 460, 250, 40);
        autre_btn.addActionListener(this);
        add(autre_btn);

        ImageIcon appIcon = new ImageIcon(ClassLoader.getSystemResource("images/appicon.png"));
        setIconImage(appIcon.getImage());
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 600);
        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_100 || e.getSource() == btn_200 || e.getSource() == btn_300 ||
            e.getSource() == btn_400 || e.getSource() == btn_500 || e.getSource() == btn_600 ||
            e.getSource() == btn_700 || e.getSource() == btn_800 || e.getSource() == btn_900 ||
            e.getSource() == btn_1000) {
            retraitFixe(e);
        } 
        else if (e.getSource() == autre_btn) {
            retraitPersonnalise();
        } 
        else if (e.getSource() == retour_btn) {
            new Home(compte_id).setVisible(true);
            setVisible(false);
        }
}

    private void retraitFixe(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();

        String amountStr = buttonText.replaceAll("[^0-9]", "");

        try {
            double withdrawalAmount = Double.parseDouble(amountStr);
            if (estSoldeSuffisant(withdrawalAmount)) {
                retirerDuSolde(compte_id.intValue(), withdrawalAmount);
                JOptionPane.showMessageDialog(this, "Retrait de " + withdrawalAmount + " DH réussi!");
            } 
            else {
                JOptionPane.showMessageDialog(this, "Solde insuffisant pour le retrait de " + withdrawalAmount + " DH.");
            }
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de conversion du montant de retrait.");
        }
    }

    private void retraitPersonnalise() {
        String customAmountStr = JOptionPane.showInputDialog(this, "Veuillez saisir le montant de retrait :");

        if (customAmountStr != null && !customAmountStr.isEmpty()) {
            try {
                double customWithdrawalAmount = Double.parseDouble(customAmountStr);
                if (customWithdrawalAmount <= 0) {
                    JOptionPane.showMessageDialog(this, "Le montant est invalide.");
                } 
                else if (estSoldeSuffisant(customWithdrawalAmount)) {
                    retirerDuSolde(compte_id.intValue(), customWithdrawalAmount);
                    JOptionPane.showMessageDialog(this, "Retrait de " + customWithdrawalAmount + " DH réussi!");
                } 
                else {
                    JOptionPane.showMessageDialog(this, "Solde insuffisant pour le retrait de " + customWithdrawalAmount + " DH.");
                }
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Montant de retrait non valide. Veuillez saisir un nombre valide.");
            }
        }
    }

    private boolean estSoldeSuffisant(double withdrawalAmount) {
        try {
            Conn connection = new Conn();
            String query = "SELECT solde FROM compte WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setInt(1, compte_id.intValue());

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double currentBalance = resultSet.getDouble("solde");
                return currentBalance >= withdrawalAmount;
            }
            connection.connection.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while checking the balance.");
        }
        return false;
    }

    private void retirerDuSolde(int compteId, double withdrawalAmount) {
        try {
            Conn connection = new Conn();
            
            String updateCompteQuery = "UPDATE compte SET solde = solde - ? WHERE compte_id = ?";
            PreparedStatement updateCompteStatement = connection.connection.prepareStatement(updateCompteQuery);
            updateCompteStatement.setDouble(1, withdrawalAmount);
            updateCompteStatement.setInt(2, compteId);
            updateCompteStatement.executeUpdate();

            String insertOperationQuery = "INSERT INTO operation (date_operation, time_operation, libelle, montant, type_id, compte_id) VALUES (CURDATE(), CURTIME(), 'retrait d''espèces', ?, 2, ?)";
            PreparedStatement insertOperationStatement = connection.connection.prepareStatement(insertOperationQuery);
            insertOperationStatement.setDouble(1, withdrawalAmount);
            insertOperationStatement.setInt(2, compteId);
            insertOperationStatement.executeUpdate();

            connection.connection.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating the database.");
        }
    }

}
