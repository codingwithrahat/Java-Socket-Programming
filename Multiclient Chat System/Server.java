import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

public class Server{
    private static List<cHandle> clients = new ArrayList<>();

    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server Startted! Waiting for clients...");

            while(true){
                Socket soc = ss.accept();
                System.out.println("New Connection from : " + soc.getInetAddress());

                cHandle client = new cHandle(soc);
                clients.add(client);
                client.start();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void  sendAll(String mssg, cHandle sender){
        for(cHandle client : clients){
            if(client != sender){
                client.sendMssg(mssg);
            }
        }
    }

}

class cHandle extends Thread{
    private Socket soc;
    private BufferedReader in;
    private PrintWriter out;
    private String name;


    public cHandle(Socket soc) {
        this.soc = soc;

        try{
            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            out = new PrintWriter(soc.getOutputStream(), true);
        }catch(Exception e){
            System.out.println(e);
        }


    }

    public void sendMssg (String mssg){
        out.println(mssg);
    }

    public void run() {
        try {
            out.println("Enter your name :");
            name = in.readLine();

            out.println(name + ", You are successfully connected!");

            System.out.println(name + " Connected to Server");

            Server.sendAll(name + " has joined the chat", this);

            String str;

            while (true) {
                str = in.readLine();

                if (str == null || str.equalsIgnoreCase("bye")) break;

                System.out.println("[" + name + "]: " +  str);

                Server.sendAll("[" + name + "]: " +  str, this);

            }

            System.out.println(name + " Disconnected");
            Server.sendAll(name + " has left the chat", this);
            soc.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }




}

