import java.net.*;
//Muhammad Hamza
//2016-UET-NML-CS-28
//           Protocol Syntax
/*
 * Resource//YourInputString...
 */

public class MTServer {
	static int clientRequests=0;
	public MTServer() {
		try
		{
			final int PORT=2222;
			ServerSocket ss=new ServerSocket(PORT);
			System.out.println("Waiting for client request");
			while(true){
				Socket client=ss.accept();
				clientRequests++;
				System.out.println("Server Accepted Request# "+clientRequests);
				MTServerThread ct = new MTServerThread(client);
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
		MTServer obj=new MTServer();
	}
}
