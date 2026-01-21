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
        int num = rNum.nextInt();          //generate a random number, number can be negative also
        num = Math.abs(num);               //abs function will make all num positive
        num = num % 100;                   // it make sure the number is between 0 to 99

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

                out.println(format(str));

                out.println(generateNum());                 //send random number to server


                if (str.equalsIgnoreCase("bye")) break;

                String str2 = in.readLine();
                System.out.println(str2);


            }

            System.out.println("Connection Lost.");

            soc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
