import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
        String serverAddress = "100.98.227.34";
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("[*] Conectat la serverul TCP.");

            while (true) {
                System.out.print("Client Java: ");
                String message = scanner.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = in.readLine();
                if (response == null || response.equalsIgnoreCase("exit")) {
                    System.out.println("Python Server: exit");
                    break;
                }
                System.out.println("Python Server: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}