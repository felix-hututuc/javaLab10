import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private User client = null;
    private ThreadLocal<Boolean> running = new ThreadLocal<>();

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            running.set(true);
            while (running.get()) {
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter output = new PrintWriter(socket.getOutputStream());

                String request = input.readLine();
                String answer = null;
                if (request != null) {
                    answer = handleRequest(request);
                }

                if (answer != null) {
                    output.println(answer);
                    output.flush();
                    if (answer.equals("Server stopped")) {
                        System.out.println("Exiting server...");
                        System.exit(0);
                    } else if (answer.equals("Bye bye...")) {
                        System.out.println("Client left...");
                        break;
                    }
                }


            }
        } catch (IOException e) {
            System.err.println("Communication error...\n" + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String handleRequest (String request) {
        if (request.startsWith("register ")) {
            return "Server received the request ...";
        } else if (request.startsWith("login ")) {
            return "Server received the request ...";
        } else if (request.startsWith("friend ")) {
            return "Server received the request ...";
        } else if (request.startsWith("send ")) {
            return "Server received the request ...";
        } else if (request.equals("read")) {
            return "Server received the request ...";
        } else if (request.equals("stop")) {
            running.set(false);
            return "Server stopped";
        } else if (request.equals("exit")) {
            running.set(false);
            return "Bye bye...";
        } else {
            return "Unknown command";
        }
    }
}
