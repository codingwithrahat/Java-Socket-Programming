import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class server {


    static int cntCorrect = 0;                             //use static cz these are global variable
    static int cntWrong = 0;

    public static double rate(){                          //success rate function
        int sum = cntCorrect + cntWrong;

        if(sum == 0) return 0.0;                          // avoid division by zero

        return ((cntCorrect * 100.0) / sum);
    }



    public static void main(String[] args){

        try{

            System.out.println("Waiting for client");

            ServerSocket ss = new ServerSocket(5000);
            Socket soc = ss.accept();

            System.out.println("Connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            String str, strNum;

            while(true){

                str = in.readLine();

                if (str == null || str.equalsIgnoreCase("bye")) {
                    break;
                }

                strNum = in.readLine();                  //socket can only read string

                int rNum = Integer.parseInt(strNum);     //convert string to int


                if(rNum >= 80){

                    // Show the percentage of correct & error
                    System.out.println("Correct : " + (rNum) + "%" + " || " + "Error : " + (100 - rNum) + "%");

                    cntCorrect++;

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
                        System.out.println("Client Syas : " + str);
                        out.println("Mssg Accepted : " + str);
                    }else{
                        out.println("Error");
                        System.out.println("Invalid Format");
                    }


                }else{

                    // Show the percentage of correct & error
                    System.out.println("Correct : " + (rNum) + "%" + " || " + "Error : " + (100 - rNum) + "%");
                    System.out.println("ERROR IS MORE THAN 20%");
                    cntWrong++;
                    out.println("Error");
                }


                double sucRate = rate();
                System.out.println("Sucess rate: " + sucRate);

            }

            System.out.println("Connection Close");

            ss.close();
            soc.close();


        } catch (Exception e){
            System.out.println(e);
        }

    }
}
