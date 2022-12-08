package listener;

import java.awt.event.*;
import javax.swing.*;

import affichage.*;

public class Listner2 implements MouseListener{
    public ListPhoto listPhoto;
    
    public Listner2(ListPhoto lp){
        this.listPhoto = lp;
    }

    public void mouseClicked(MouseEvent e){
        JButton scr = (JButton)e.getSource();

        if(scr.getText() == "retour"){
            try{
                System.out.println("mandeh");
                listPhoto.setVisible(false);
                listPhoto.dispose();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        //-----------------------------------------------------------------------------------------------------------
        if(scr.getText() == "Afficher"){
            if(listPhoto.entree.getText().equals("Photo numero : 1")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listPhoto.entree.getText().equals("Photo numero : 2")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listPhoto.entree.getText().equals("Photo numero : 3")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }    
            if(listPhoto.entree.getText().equals("Photo numero : 4")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listPhoto.entree.getText().equals("Photo numero : 5")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(listPhoto.entree.getText().equals("Photo numero : 6")){ 
                try{
                    listPhoto.client.oos.writeObject(listPhoto.entree.getText());
                    String message = listPhoto.client.listenInput();
                    System.out.println("Message received:" + message);
                    listPhoto.client.ois.close();
                    listPhoto.client.oos.close();
                    Photo photo = new Photo(message); 
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
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