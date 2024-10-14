import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message = "Клиент";
            out.println(message);

            String response = in.readLine();
            System.out.println("Ответ от сервера: " + response);
        } catch (Exception e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
