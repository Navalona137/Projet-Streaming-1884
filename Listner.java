package listener;

import java.awt.event.*;
import javax.swing.*;

import affichage.*;

public class Listner implements MouseListener{
    public ListMusic listMusic;
    
    public Listner(ListMusic lm){
        this.listMusic = lm;
    }

    public void mouseClicked(MouseEvent e){
        JButton scr = (JButton)e.getSource();

        if(scr.getText() == "retour"){
            try{
                System.out.println("mandeh");
                listMusic.setVisible(false);
                listMusic.dispose();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        //-----------------------------------------------------------------------------------------------------
        if(scr.getText() == "play"){
            if(listMusic.entree.getText().equals("Chanson numero : 1")){ 
                try{
                    listMusic.client.oos.writeObject(listMusic.entree.getText());
                    String message = listMusic.client.listenInput();
                    System.out.println("Message received:" + message);
                    listMusic.play(message);
                    listMusic.client.ois.close();
                    listMusic.client.oos.close();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listMusic.entree.getText().equals("Chanson numero : 2")){ 
                try{
                    listMusic.client.oos.writeObject(listMusic.entree.getText());
                    String message = listMusic.client.listenInput();
                    System.out.println("Message received:" + message);
                    listMusic.play(message);
                    listMusic.client.ois.close();
                    listMusic.client.oos.close();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listMusic.entree.getText().equals("Chanson numero : 3")){ 
                try{
                    listMusic.client.oos.writeObject(listMusic.entree.getText());
                    String message = listMusic.client.listenInput();
                    System.out.println("Message received:" + message);
                    listMusic.play(message);
                    listMusic.client.ois.close();
                    listMusic.client.oos.close();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listMusic.entree.getText().equals("Chanson numero : 4")){ 
                try{
                    listMusic.client.oos.writeObject(listMusic.entree.getText());
                    String message = listMusic.client.listenInput();
                    System.out.println("Message received:" + message);
                    listMusic.play(message);
                    listMusic.client.ois.close();
                    listMusic.client.oos.close();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        if(scr.getText() == "stop"){
            try{
                listMusic.stop();
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