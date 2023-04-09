import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8809;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String test = in.readLine();
            System.out.println(test);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            test = in.readLine();
            System.out.println(test);
        } catch (IOException e) {
            throw new RuntimeException(e);


        }


    }
}

