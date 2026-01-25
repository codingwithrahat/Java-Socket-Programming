import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try{
            Socket soc = new Socket("localhost", 5000);

            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out =  new PrintWriter(soc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            System.out.print(in.readLine() + " ");
            String name = userIn.readLine();
            out.println(name);

            System.out.print(in.readLine() + " ");


            Thread readThread = new Thread(new Runnable(){
                public void run(){
                    try{
                        String mssg;

                        while(true){
                            mssg = in.readLine();

                            if(mssg == null){
                                System.out.println("\nServer Disconnected");
                                break;
                            }else{
                                System.out.println("\n" + mssg);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
            readThread.start();


            String str;
            while(true){
                userIn.readLine();

                System.out.print("Enter Mssg : ");

                str = userIn.readLine();
                out.println(str);

                if(str.equalsIgnoreCase("bye")) break;


            }

            soc.close();
            System.out.println("Disconnected from Server");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
