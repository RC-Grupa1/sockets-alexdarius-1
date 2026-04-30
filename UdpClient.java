import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        String serverAddress = "100.98.227.34";
        int port = 5001;

        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverIp = InetAddress.getByName(serverAddress);
            byte[] buffer = new byte[1024];

            System.out.println("[*] Client UDP pornit.");

            while (true) {
                System.out.print("Client Java: ");
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes("UTF-8");

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIp, port);
                socket.send(sendPacket);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
                System.out.println("Python Server: " + response);

                if (response.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
