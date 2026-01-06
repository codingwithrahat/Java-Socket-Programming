import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args){

        try{

            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 5000);

            // Create a BufferedReader to read input from the user (keyboard)
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Mssg : ");
            // Read a line of text entered by the user and store it in 'str'
            String str = userInput.readLine();

            // Create a PrintWriter to send data to the server through the socket
            // 'true' enables auto-flush, so messages are sent immediately
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
            // Send the user’s input message to the server


            // Create a BufferedReader to read data coming from the server through the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str2 = in.readLine();
            System.out.println("Server Recived : " + str2);
            // Print the message received from the server

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

