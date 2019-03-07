import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread extends Thread{
	private Socket client;
	public EchoThread(Socket client) {
		this.client=client;
	}
	
	public void run()
	{
		try {
			InputStreamReader isr=new InputStreamReader(client.getInputStream());
			BufferedReader br =new BufferedReader(isr);
			String str=br.readLine();

			boolean flage=this.EchoString(str);
			PrintStream ps=new PrintStream(client.getOutputStream());
			ps.println(flage);
			System.out.println();	
		}
		catch (Exception e)
		{}
	}

	private boolean EchoString(String str) {
		if(str.equals("")) {
			System.out.println("Given String is NULL");
			return true;
		}
		System.out.println("The User String is: "+str);
		return true;
	}
}
