import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args){

        try{

            System.out.println("Waiting for client");

            ServerSocket ss = new ServerSocket(5000);
            Socket soc = ss.accept();

            System.out.println("Connected");


            // Create a BufferedReader to read data sent by the client through the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            // Read a line of text sent by the client and store it in 'str'
            String str = in.readLine();
            System.out.println("Client says : " + str);
            // Print the message received from the client


            // Create a PrintWriter to send data back to the client
            // 'true' enables auto-flush so the message is sent immediately
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
            // Send the same message back to the client

        } catch (Exception e){
            System.out.println(e);
        }

    }
}
