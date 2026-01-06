import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

    public static String format(String s){
        return ("[" + s.length() + ":" + s + "]");
    }

    public static void main(String[] args){

        try{

            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 5000);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            String str;

            while(true){
                
                System.out.println("Enter Mssg : ");
                str = userInput.readLine();

                out.println(format(str));

                if(str.equals("bye")) break;

                String str2 = in.readLine();
                System.out.println(str2);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

