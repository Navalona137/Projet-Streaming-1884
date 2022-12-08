package affichage;

import listener.*;
import client.*;

import java.awt.*;
import javax.swing.*;

public class Photo extends JFrame{
    //public Client client;

    public Photo(String message){
        setTitle("Fenetre");
		setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel table = new JLabel();
        table.setIcon(new ImageIcon(message)); 
        table.setBounds(100,0,0,0);

        Listener listen = new Listener(this);
        JButton retour = new JButton("retour");
        retour.addMouseListener(listen);

        panel.add(retour);
        panel.add(table);

        add(panel);
        setVisible(true);
    }
}