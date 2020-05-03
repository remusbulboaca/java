import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public GameServer(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client accepted.");
            /*input de la client*/
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            ClientThread clientThread = new ClientThread(in,socket);
        }catch (IOException i){
            System.out.println(i);
        }
    }
    public static void main(String Args[]){
        GameServer gameServer = new GameServer(5000);
    }
}
