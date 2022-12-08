package listener;

import java.awt.event.*;
import javax.swing.*;

import affichage.*;
import client.*;

public class Listener implements MouseListener{
    public Fenetre fen;
    public Photo photo;

    public Listener(Fenetre f){
        this.fen = f;
    }

    public Listener(Photo ph){
        this.photo = ph;
    }

    public void mouseClicked(MouseEvent e){
        JButton scr = (JButton)e.getSource();

        if(scr.getText() == "Music"){
            try{
                fen.client.oos.writeObject("music");
                String message = fen.client.listenInput();
                fen.client.ois.close();
                fen.client.oos.close();
                ListMusic music = new ListMusic(message);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        if(scr.getText() == "Photo"){
            try{
                fen.client.oos.writeObject("photo");
                String message = fen.client.listenInput();
                fen.client.ois.close();
                fen.client.oos.close();
                ListPhoto photo = new ListPhoto(message);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        if(scr.getText() == "Video"){
            try{
                fen.client.oos.writeObject("video");
                String message = fen.client.listenInput();
                fen.client.ois.close();
                fen.client.oos.close();
                ListVideo video = new ListVideo(message);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        if(scr.getText() == "retour"){
            try{
                photo.setVisible(false);
                photo.dispose();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

    } 

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    } 

    public void mousePressed(MouseEvent e){

    } 

    public void mouseReleased(MouseEvent e){

    }
}