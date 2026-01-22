import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class client {

    public static String format(String s){
        return ("[" + s.length() + ":" + s + "]");
    }

    public static int generateNum(){
        Random rNum = new Random();
        int num = rNum.nextInt();
        num = Math.abs(num);
        num = num % 100;

        return num;

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

                System.out.print("Enter Mssg : ");
                str = userInput.readLine();

                if (str.equalsIgnoreCase("bye")) break;

                for(int i = 0; i<100000; i++){
                    out.println(format(str));

                    out.println(generateNum());

                    String str2 = in.readLine();
                    System.out.println(str2);
                }


            }

            System.out.println("Connection Lost.");

            soc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
