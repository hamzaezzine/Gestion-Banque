import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Solde extends JFrame implements ActionListener{
    Number client_id;
    JLabel title_label, image_label, montant_label, dash_label, solde_label;
    JButton retour_btn;


    Solde(Number client_id){
        this.client_id = client_id;
        setTitle("Solde");

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);



        title_label = new JLabel("Solde");
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

        solde_label = new JLabel();
        solde_label.setFont(new Font("Arial", Font.BOLD, 20));
        solde_label.setBounds(150, 160, 390, 30);
        add(solde_label);
        
        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(150, 220, 160, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);


        afficherSolde();

        ImageIcon appIcon = new ImageIcon(ClassLoader.getSystemResource("images/appicon.png"));
        setIconImage(appIcon.getImage());

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(200, 70);
        setSize(700, 360);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retour_btn){     
            new Home(client_id).setVisible(true);
            setVisible(false);
        }
    }
    
    private void afficherSolde() {
        try {
            Conn connection = new Conn();
            String query = "SELECT solde FROM compte WHERE compte_id = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setInt(1, client_id.intValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double solde = resultSet.getDouble("solde");
                solde_label.setText(String.format("%.2f DH", solde));
            }

            connection.connection.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the solde.");
        }
    }
}
