import java.io.IOException;
import java.net.Socket;

public class Client {
  protected Socket connect() throws IOException {
    return new Socket("localhost", ChatroomServer.PORT);
  }
}
