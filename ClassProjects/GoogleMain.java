import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class GoogleMain throws Exception{
	public static void main(String[] args) {
		try {
			Socket s = new Socket("google.com", 80);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("GET/\n");
			System.out.println(dis.readUTF());
		} finally {
		}
	}
}
