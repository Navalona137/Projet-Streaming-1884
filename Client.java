package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client{ 
    public InetAddress host = InetAddress.getLocalHost();
    public Socket socket = null;
    public ObjectOutputStream oos = null;
    public ObjectInputStream ois = null;

    public Client() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        socket = new Socket(host.getHostName(), 9876);
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public String listenInput() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        ois = new ObjectInputStream(socket.getInputStream());
        return (String) ois.readObject();
    }

}
