import java.net.ServerSocket;
import java.net.Socket;

public class StringLengthServer {
	static int clientRequests=0;
	public StringLengthServer() {
		try
		{
			final int PORT=2244;
			ServerSocket ss=new ServerSocket(PORT);
			System.out.println("Waiting for Echo the String");
			while(true){
				Socket client=ss.accept();
				clientRequests++;
				System.out.println("Server Accepted Request# "+clientRequests);
				StringLengthThread ct = new StringLengthThread(client);
				ct.start();
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}

	// Main Function
	public static void main(String args[]){
		StringLengthServer obj=new StringLengthServer();
	}
}
