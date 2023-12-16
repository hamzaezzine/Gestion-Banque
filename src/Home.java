import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    Number client_id;

    Home(Number client_id){
        this.client_id = client_id;
        System.out.println(client_id);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
