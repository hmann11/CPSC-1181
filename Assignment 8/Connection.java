import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Connection {
	private final Socket socket;
	private final DataInputStream input;
	private final DataOutputStream output;
	
	public Connection(Socket socket)throws IOException{
		this.socket=socket;
		this.input=new DataInputStream(socket.getInputStream());
		this.output=new DataOutputStream(socket.getOutputStream());
	}

	public int readInt()throws IOException{
		return this.input.readInt();
		
	}
	public String readUTF()throws IOException{
		return this.input.readUTF();
	}
	public void writeInt(int i) throws IOException{
		this.output.writeInt(i);
		this.output.flush();
	}
	public void writeUTF(String s)throws IOException{
		this.output.writeUTF(s);
		this.output.flush();
		
	}
	public void writeMessage(Message m)throws IOException{
		this.writeInt(ChatroomProtocol.MESSAGE);
		this.writeUTF(m.getMessageAuthor());
		this.writeUTF(m.getMessageContent());
		
	}
	
	public void close() {
		try {
			this.socket.close();
		}catch(Exception e) {
			
		}
	}
}
