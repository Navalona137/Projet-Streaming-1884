package affichage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;

import listener.*;
import client.*;
import boutton.*;

public class ListPhoto extends JFrame{
    public Client client;
    public String[] messages;
    public JTextField entree;

    public ListPhoto(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        setTitle("Fenetre");
		setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 15, 5, 15));

    //-----------------------------------------------------------------------------------------------------------------------
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("Liste des photos");
        titre.setFont(new Font("Arial", Font.BOLD, 25));
        titrePanel.add(titre);
        panel.add(titrePanel, BorderLayout.NORTH);
    
    //-------------------------------------------------------------------------------------------------------------------------
        JPanel contenu = new JPanel();
        contenu.setLayout(new GridLayout(4, 4, 5, 5));
        contenu.setBorder(new EmptyBorder(5, 5, 5, 5));

        messages = message.split(",");
        Boutton[] label = new Boutton[messages.length];
        for(int i=0; i<messages.length; i++){
            if(i>0){
                String title = i + " - " + messages[i];
                label[i] = new Boutton(title); 
                contenu.add(label[i]);
            }
        }
        panel.add(contenu, BorderLayout.CENTER);

    //-------------------------------------------------------------------------------------------------------------------------------------------
        client = new Client();
        Listner2 listen = new Listner2(this);

        JPanel bouttonPanel = new JPanel();
        bouttonPanel.setLayout(new BorderLayout());
        bouttonPanel.setBackground(Color.gray);

        JPanel retourPanel = new JPanel();
        JButton retour = new JButton("retour");
        retourPanel.add(retour);
        retour.addMouseListener(listen);

        JPanel entreePanel = new JPanel();
        entree = new JTextField("Photo numero : ");
        entreePanel.add(entree);

        JPanel afficherPanel = new JPanel();
        JButton afficher = new JButton("Afficher");
        afficherPanel.add(afficher);
        afficher.addMouseListener(listen);
        
        bouttonPanel.add(afficherPanel, BorderLayout.EAST);
        bouttonPanel.add(entreePanel, BorderLayout.CENTER);
        bouttonPanel.add(retourPanel, BorderLayout.WEST);
        panel.add(bouttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

}