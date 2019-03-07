
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MTServerThread extends Thread {
	private Socket client;
	final String IP="localhost";
	// Constructor...
	public MTServerThread(Socket s){
		this.client = s;
	}
	// Eun Overwrite Function...
	public void run()
	{
		try {
			InputStreamReader isr=new InputStreamReader(client.getInputStream());
			BufferedReader br =new BufferedReader(isr);
			String str=br.readLine();

			PrintStream ps=new PrintStream(client.getOutputStream());
			//ps.println(this.clientRequestParsing(str));
			ps.println(this.clientRequest(str));
			System.out.println();	
		}
		catch (Exception e)
		{}
	}

	private String clientRequest(String str) throws UnknownHostException, IOException {
		String[] clientData=str.split("//");

		if(clientData[0].charAt(1)==49){

			Socket clnt =new Socket(IP,1234);
			// Writting Data on the PORT no 1234
			PrintWriter pw=new PrintWriter(clnt.getOutputStream(),true);
			pw.println(clientData[1]);

			// Reading Data from PORT no 1234
			InputStreamReader ISR=new InputStreamReader(clnt.getInputStream());
			BufferedReader br =new BufferedReader(ISR);
			String serverResponse=br.readLine();
			return serverResponse;
		}
		else if(clientData[0].charAt(1)==50){
			// Writting Data on the PORT no 5678
			Socket clnt =new Socket(IP,5678);
			PrintWriter pw=new PrintWriter(clnt.getOutputStream(),true);
			pw.println(clientData[1]);

			// Reading Data from PORT no 5678
			InputStreamReader ISR=new InputStreamReader(clnt.getInputStream());
			BufferedReader br =new BufferedReader(ISR);
			String serverResponse=br.readLine();
			return serverResponse;
		}
		else if(clientData[0].charAt(1)==51) {
			// Writting Data on the PORT no 2244
			Socket clnt =new Socket(IP,2244);
			PrintWriter pw=new PrintWriter(clnt.getOutputStream(),true);
			pw.println(clientData[1]);

			// Reading Data from PORT no 2244
			InputStreamReader ISR=new InputStreamReader(clnt.getInputStream());
			BufferedReader br =new BufferedReader(ISR);
			String serverResponse=br.readLine();
			return serverResponse;
		}
		else {
			System.out.println("Something Went Wrong");
		}
		return "FALSE";
	}
}
