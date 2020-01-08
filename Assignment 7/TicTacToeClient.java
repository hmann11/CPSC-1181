import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author hmann11
 *
 *This clas creates a client for the server and interacts with the server to play the game.
 */
public class TicTacToeClient {
  private String host;
  private int serverPort;
/*
 * Main constructor for the client.
 */
  TicTacToeClient(String host, int serverPort) {
    this.host = host;
    this.serverPort = serverPort;
  }

  public static void main(String[] args) throws IOException {
    int serverPort = 22222;
    String host = "localhost";

    new TicTacToeClient(host, serverPort).connect();
  }


  private void writeInt(DataOutputStream out, String s) throws IOException {
    out.writeUTF(s);
    out.flush();
  }

  private String readMessage(DataInputStream input) throws IOException {
    return input.readUTF();
  }

  public void connect() throws IOException {
    try (
        Socket socket = new Socket(this.host, this.serverPort);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    ) {
      Scanner s = new Scanner(System.in);
      while (true) {
    	  System.out.println("> "+readMessage(in));
    	  System.out.print("> ");
        if (s.hasNextLine()) {
          try {
            String n = s.nextLine();

           
            writeInt(out, n);

     
            System.out.println(readMessage(in));
            System.out.println(">");
          } catch (NumberFormatException e) {
            System.out.println("Invalid number");
          }
        }
      }
    }
  }
}
