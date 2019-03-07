import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
	static int clientRequests=0;
	public EchoServer() {
		try
		{
			final int PORT=1234;
			ServerSocket ss=new ServerSocket(PORT);
			System.out.println("Waiting for Echo the String");
			while(true){
				Socket client=ss.accept();
				clientRequests++;
				System.out.println("Server Accepted Request# "+clientRequests);
				EchoThread ct = new EchoThread(client);
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
		EchoServer obj=new EchoServer();
	}
}
