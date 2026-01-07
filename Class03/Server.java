import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{

            System.out.println("Waiting for client");

            ServerSocket ss = new ServerSocket(5000);

            Socket soc = ss.accept();

            System.out.println("connected to client");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            String str;

            while(true){

                str = in.readLine();

                System.out.println("Client Says : " + str);

                if(str == null || str.equalsIgnoreCase("bye")) break;

                out.println("Server Received : " + str);

            }

            System.out.println("Connection Off");

            ss.close();
            soc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
