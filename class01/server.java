import java.net.ServerSocket; // Import ServerSocket class to create a server
import java.net.Socket;       // Import Socket class to handle client connections

public class server {
    public static void main(String[] args){

        try{
            // Print a message to indicate the server is waiting for a client
            System.out.println("Waiting for client");

            // Create a ServerSocket that listens on port 5000
            // ServerSocket waits for clients to connect to this port
            ServerSocket ss = new ServerSocket(5000);

            // The accept() method waits until a client connects
            // When a client connects, it returns a Socket object for communication
            Socket soc = ss.accept();

            // Print a message to indicate that a client has connected successfully
            System.out.println("Connected");

            // After use, it's good practice to close the socket and server
            // soc.close();
            // ss.close();

        } catch (Exception e){
            // If any exception occurs (like port is already in use), print it
            System.out.println(e);
        }

    }
}
