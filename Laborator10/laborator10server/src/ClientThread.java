import java.io.*;
import java.net.Socket;

public class ClientThread {
    private DataOutputStream out = null;
    public ClientThread(DataInputStream in, Socket socket) {

        try {
            String line = "";
            while (!line.equals("stop")) {
                try {
                    line = in.readUTF();
                    System.out.println("Comanda primita: " + line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
