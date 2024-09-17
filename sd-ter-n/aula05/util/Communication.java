import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {

    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Communication(Socket socket) {
        try {

            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {

            System.out.println("Erro");
            System.out.println(e.getMessage());
        }
    }

    public void Send(Object object) {

        try {

            output.writeObject(object);

        } catch (Exception e) {

            System.out.println("Deu erro ao enviar" + e.getMessage());
        }
    }

    public Object receive() {

        try {

            return input.readObject();

        } catch (Exception e) {

            System.out.println("Deu erro ao receber" + e.getMessage());
            return null;
        }
    }

}
