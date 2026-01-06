import java.io.IOException;  // Import IOException to handle input/output errors
import java.net.Socket;      // Import Socket class to connect to the server

public class client {
    public static void main(String[] args){

        try{
            // Print a message indicating the client program has started
            System.out.println("Client Started");

            // Create a Socket object to connect to the server
            // "localhost" means the server is running on the same machine
            // 5000 is the port number the server is listening on
            Socket soc = new Socket("localhost", 5000);

            // After use, it's good practice to close the socket
            // soc.close();

        } catch (Exception e) {
            // If an exception occurs (e.g., server not running), print the error
            System.out.println(e);
        }

    }
}
