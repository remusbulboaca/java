import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

@SuppressWarnings("ALL")
public class GameClient {

    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;

    public GameClient(String adress,int port){
        try{
            socket = new Socket(adress,port);
            System.out.println("Connected");

            input = new BufferedReader(new InputStreamReader(System.in));

            out = new DataOutputStream(socket.getOutputStream());
        }catch (UnknownHostException u){
            System.out.println(u);
        }
        catch (IOException i){
            System.out.println(i);
        }

        String line="";
        while(!line.equals("exit")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            }catch (IOException i){
                System.out.println(i);
            }
        }

        try{
            input.close();
            /*out.close();
            socket.close();
             */
        }catch (IOException i){
            System.out.println(i);
        }
    }

    public static void main(String Args[]){
        GameClient client = new GameClient("127.0.0.1",5000);
    }
}
