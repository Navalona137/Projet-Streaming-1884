package serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Serveur{ 
    private static ServerSocket server;
    private static int port = 9876;

    private static File myFileAudio = new File("D:/PROG/Java/Mr Naina/Streaming multimedia3/hira");
    private static File[] listeAudio = myFileAudio.listFiles();
    private static int longueurAudio = listeAudio.length;
    private static String music = new String();

    private static File myFilePhoto = new File("D:/PROG/Java/Mr Naina/Streaming multimedia3/photo");
    private static File[] listePhoto = myFilePhoto.listFiles();
    private static int longueurPhoto = listePhoto.length;
    private static String photo = new String();

    private static File myFileVideo = new File("D:/PROG/Java/Mr Naina/Streaming multimedia3/video");
    private static File[] listeVideo = myFileVideo.listFiles();
    private static int longueurVideo = listeVideo.length;
    private static String video = new String();

    private static String nom = new String();

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for the client request");

            Socket socket = server.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message received:" + message);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            if(message.equalsIgnoreCase("music")){
                music = new String();
                for(int i=0; i<longueurAudio; i++){
                    try{
                        music = music + " , " + listeAudio[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(music);
                oos.writeObject(music);
            }
            if(message.equalsIgnoreCase("photo")){
                photo = new String();
                for(int i=0; i<longueurPhoto; i++){
                    try{
                        photo = photo + " , " + listePhoto[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(photo);
                oos.writeObject(photo);
            }
            if(message.equalsIgnoreCase("video")){
                video = new String();
                for(int i=0; i<longueurVideo; i++){
                    try{
                        video = video + " , " + listeVideo[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(video);
                oos.writeObject(video);
            }

            if(message.equalsIgnoreCase("Chanson numero : 1")){
                nom = new String();
                try{
                    nom = listeAudio[0].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Chanson numero : 2")){
                nom = new String();
                try{
                    nom = listeAudio[1].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Chanson numero : 3")){
                nom = new String();
                try{
                    nom = listeAudio[2].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Chanson numero : 4")){
                nom = new String();
                try{
                    nom = listeAudio[3].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            
        //-----------------------------------------------------------------------------------------------------
            if(message.equalsIgnoreCase("Photo numero : 1")){
                nom = new String();
                try{
                    nom = listePhoto[0].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Photo numero : 2")){
                nom = new String();
                try{
                    nom = listePhoto[1].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Photo numero : 3")){
                nom = new String();
                try{
                    nom = listePhoto[2].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Photo numero : 4")){
                nom = new String();
                try{
                    nom = listePhoto[3].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Photo numero : 5")){
                nom = new String();
                try{
                    nom = listePhoto[4].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }
            if(message.equalsIgnoreCase("Photo numero : 6")){
                nom = new String();
                try{
                    nom = listePhoto[5].getPath();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }                    
                System.out.println(nom);
                oos.writeObject(nom);
            }

            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!");
        server.close();
    }
}
