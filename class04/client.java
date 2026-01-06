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

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Mssg : ");
            String str = userInput.readLine();

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str2 = in.readLine();
            System.out.println(str2);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

