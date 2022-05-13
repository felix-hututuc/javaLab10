import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8765;

    public Server() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        Server myServer = new Server();
    }
}
