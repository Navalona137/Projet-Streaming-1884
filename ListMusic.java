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
import javazoom.jl.player.Player;
import java.io.*;

import listener.*;
import client.*;
import boutton.*;

public class ListMusic extends JFrame{
    public Client client;
    public String[] messages;
    public JTextField entree;
    private Player player;

    public ListMusic(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        setTitle("Fenetre");
		setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 15, 5, 15));

    //-----------------------------------------------------------------------------------------------------------------------
        JPanel titrePanel = new JPanel();
        JLabel titre = new JLabel("Liste des chansons");
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
        Listner listen = new Listner(this);

        JPanel bouttonPanel = new JPanel();
        bouttonPanel.setLayout(new BorderLayout());
        bouttonPanel.setBackground(Color.gray);

        JPanel retourPanel = new JPanel();
        JButton retour = new JButton("retour");
        retourPanel.add(retour);
        retour.addMouseListener(listen);

        JPanel entreePanel = new JPanel();
        entree = new JTextField("Chanson numero : ");
        entreePanel.add(entree);

        JPanel playPanel = new JPanel();
        JButton play = new JButton("play");
        JButton pause = new JButton("pause");
        JButton stop = new JButton("stop");
        playPanel.add(play);
        playPanel.add(pause);
        playPanel.add(stop);
        play.addMouseListener(listen);
        pause.addMouseListener(listen);
        stop.addMouseListener(listen);

        bouttonPanel.add(playPanel, BorderLayout.EAST);
        bouttonPanel.add(entreePanel, BorderLayout.CENTER);
        bouttonPanel.add(retourPanel, BorderLayout.WEST);
        panel.add(bouttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void play(String path){
        try{
            FileInputStream zik = new FileInputStream(path);
            BufferedInputStream play = new BufferedInputStream(zik);
            player = new Player(play);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }.start();
    }

    public void stop(){
        System.out.println("efa akaiky");
        if(player!=null){
            System.out.println("tafiditra");
            player.close();
        }
    }

}