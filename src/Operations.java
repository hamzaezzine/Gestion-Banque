import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Operations extends JFrame implements ActionListener {
    Number client_id;
    JLabel title_label, image_label, dash_label;
    JButton retour_btn;
    DefaultTableModel tableModel;
    JTable tableau;
    JScrollPane sp;


    Operations(Number client_id){
        this.client_id = client_id;
        System.out.println(client_id);


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

        dash_label = new JLabel("__________________________________");
        dash_label.setForeground(new Color(245, 174, 82));
        dash_label.setFont(new Font("Raleway", Font.PLAIN, 30));
        dash_label.setBounds(100, 0, 700, 100);
        add(dash_label);


        String[] columnNames = new String[]{"ID", "Montant","Type", "Date", "Libellé", "id du destinataire", "Compte du destinataire"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableau = new JTable(tableModel);

        //ajouter des ligne dans le tableau
        tableModel.addRow(new Object[] { "1", "340", "Virement", "12/14/2002","transfer", "QWERT Rachid"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        tableModel.addRow(new Object[] { "M1349141", "kamal", "Alaoui", "12/14/2002","aa.@gmail", "Homme"});
        
        sp = new JScrollPane(tableau);
        sp.setSize(620, 370);
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
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==retour_btn){     
            new Home(client_id).setVisible(true);
            setVisible(false);
        }
    }
}
