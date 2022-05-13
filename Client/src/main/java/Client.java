import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int PORT = 8100;

        Socket socket = new Socket(serverIP, PORT);

        BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        Scanner cin = new Scanner(System.in);

        while (true) {
            String request = cin.nextLine();
            if (request.equals("exit")) {
                System.out.println("Closing the client...\n");
                break;
            }
            output.write(request);
            String answer = input.readLine();
            System.out.println(answer);
        }
    }
}
