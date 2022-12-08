package affichage;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.net.UnknownHostException;

import client.*;
import listener.*;

public class Fenetre extends JFrame{
    public Client client;
    public Fenetre() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        setTitle("Fenetre");
		setSize(800, 500);
        setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton music = new JButton("Music");
        JButton photo = new JButton("Photo");
        JButton video  = new JButton("Video");

        client = new Client();
        Listener listen = new Listener(this);
        music.addMouseListener(listen);
        photo.addMouseListener(listen);
        video.addMouseListener(listen);

        panel.add(music);
        panel.add(photo);
        panel.add(video);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args){
        try{
            Fenetre main = new Fenetre();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}