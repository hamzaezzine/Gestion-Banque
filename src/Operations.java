import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Operations extends JFrame implements ActionListener {
    Number compte_id;
    JLabel title_label, image_label, dash_label;
    JButton retour_btn;
    DefaultTableModel tableModel;
    JTable tableau;
    JScrollPane sp;


    Operations(Number compte_id){
        this.compte_id = compte_id;
        setTitle("Operations");

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        image_label = new JLabel(imageIcon6);
        image_label.setBounds(0, 0, 90, 90);
        add(image_label);


        title_label = new JLabel("Operations");
        title_label.setForeground(new Color(149, 136, 248));
        title_label.setFont(new Font("Oswald", Font.BOLD, 22));
        title_label.setBounds(100, 0, 600, 90);
        add(title_label);

        dash_label = new JLabel("__________________________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 1200, 100);
        add(dash_label);


        String[] columnNames = new String[]{"ID Operation", "Montant","Type", "Date", "Time","Libellé", "ID Destinataire"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableau = new JTable(tableModel);

        trouverOperations();
                
        sp = new JScrollPane(tableau);
        sp.setSize(920, 370);
        sp.setLocation(30,100);
        add(sp);
        
        
        retour_btn = new JButton("RETOUR");
        retour_btn.setBackground(new Color(245, 174, 82));
        retour_btn.setForeground(Color.WHITE);
        retour_btn.setFont(new Font("Arial", Font.BOLD, 15));
        retour_btn.setBounds(30, 500, 160, 40);
        retour_btn.addActionListener(this);
        add(retour_btn);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(100, 70);
        setSize(1000, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retour_btn){     
            new Home(compte_id).setVisible(true);
            setVisible(false);
        }
    }
    
    private void trouverOperations() {
        try {
            Conn connection = new Conn();
            String query = "SELECT operation_id, montant, type_id, date_operation, time_operation, libelle, destinataire_id FROM operation WHERE compte_id = " + compte_id;
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int operationId = resultSet.getInt("operation_id");
                String montant = resultSet.getString("montant");
                int typeId = resultSet.getInt("type_id");
                String type = recupererLibelleTypeOperation(typeId);
                String date = resultSet.getString("date_operation");
                String time = resultSet.getString("time_operation");
                String libelle = resultSet.getString("libelle");
                int idDestinataire = resultSet.getInt("destinataire_id");

                tableModel.addRow(new Object[]{operationId, montant, type, date, time, libelle, idDestinataire});
            }
            connection.connection.close();

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String recupererLibelleTypeOperation(int typeId) {
        return switch (typeId) {
            case 1 -> "Dépôt";
            case 2 -> "Retrait";
            case 3 -> "Virement";
            default -> "Unknown Type";
        };
    }


}
