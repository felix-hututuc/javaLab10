import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private User client = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try (BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

                 BufferedWriter output = new BufferedWriter(
                         new OutputStreamWriter(socket.getOutputStream()))
            ) {

                String request = input.readLine();
                String answer = null;
                if (request != null) {
                    answer = handleRequest(request);
                }

                if (answer != null) {
                    output.write(answer);
                }

            } catch (IOException e) {
                System.err.println("Communication error...\n" + e);
            }
        }
    }

    private String handleRequest (String request) {
        if (request.startsWith("register ")) {
            return "Server received the request ... \n";
        } else if (request.startsWith("login ")) {
            return "Server received the request ... \n";
        } else if (request.startsWith("friend ")) {
            return "Server received the request ... \n";
        } else if (request.startsWith("send ")) {
            return "Server received the request ... \n";
        } else if (request.equals("read")) {
            return "Server received the request ... \n";
        } else if (request.equals("stop")) {
            return "Server stopped\n";
        } else {
            return "Unknown command\n";
        }
    }
}
