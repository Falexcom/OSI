import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostname = "netology.homework";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(in.readLine());
            String name = console.readLine();
            out.println(name);

            System.out.println(in.readLine());
            String isChild = console.readLine();
            out.println(isChild);

            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
