import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int PORT = 8765;

        Socket socket = new Socket(serverIP, PORT);

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        Scanner cin = new Scanner(System.in);

        while (true) {
            String request = cin.nextLine();
            output.println(request);
            String answer = input.readLine();
            if (request.equals("read")) {
                answer = answer.replace("--newline--", "\n");
            }
            System.out.println(answer);
            if (request.equals("stop") || request.equals("exit")) {
                System.out.println("Closing the client...\n");
                break;
            }
        }
    }
}
