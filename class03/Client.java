import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try{

            System.out.println("Client Started");

            Socket soc = new Socket("localhost", 5000);

            BufferedReader inpurUser = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));


            String str;

            while(true){

                System.out.print("Enter Mssg : ");

                str = inpurUser.readLine();

                out.println(str);

                if(str.equalsIgnoreCase("bye")) break;

                System.out.println(in.readLine());


            }

            System.out.println("Connection Lost");

            soc.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
