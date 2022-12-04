import java.lang.*;
import java.net.*;
import java.io.*;

class Server1 {
    public static void main(String args[]) throws Exception {
        System.out.println("Server Application is Running....");

        String s1 = null, s2 = null;
        Socket s = null;
        ServerSocket ss = null;
        BufferedReader br = null, brK = null;
        PrintStream ps = null;
        try {
            ss = new ServerSocket(1100);
            s = ss.accept();

            System.out.println("Connection Successfull");

            brK = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            ps = new PrintStream(s.getOutputStream());

            while ((s1 = br.readLine()) != null) {
                System.out.println("Client Says : " + s1);
                System.out.println("Enter Message for Client :");
                s2 = brK.readLine();
                ps.println(s2);
            }
        } catch (Exception obj) {
        }

        try {

            br.close();
            brK.close();
            ps.close();
        }

        catch (Exception obj) {
        }
    }
}
