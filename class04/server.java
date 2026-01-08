import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args){

        try{

            System.out.println("Waiting for client");

            ServerSocket ss = new ServerSocket(5000);
            Socket soc = ss.accept();

            System.out.println("Connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            String str;

            while(true){

                str = in.readLine();

                if(str == null ||str.equalsIgnoreCase("bye")) break;

                char[] s = str.toCharArray();

                boolean flag = false;

                if(s.length >= 5 && s[0] == '[' && s[s.length - 1] == ']'){
                    int colidx = -1;

                    for(int i = 1; i< s.length - 1; i++){
                        if(s[i] == ':'){
                            colidx = i;
                            break;
                        }
                    }

                    if(colidx != -1){
                        String num = "";

                        for(int i = 1; i<colidx; i++) {
                            num += s[i];
                        }

                        int len = 0;

                        for(int i = 0; i<num.length(); i++){
                            len = (len * 10) + (num.charAt(i) - '0');
                        }

                        int cnt = 0;

                        for(int i = colidx + 1; i<s.length - 1; i++){
                            cnt++;
                        }

                        if(len == cnt){
                            flag = true;
                        }

                    }

                }

                if(flag){
                    System.out.println("Client syas : " + str);
                    out.println("Mssg Accepted : " + str);
                }else{
                    out.println("Error");
                    System.out.println("Invalid Format");
                }
            }
            
            System.out.println("Connection Off");

            ss.close();
            soc.close();


        } catch (Exception e){
            System.out.println(e);
        }

    }
}
