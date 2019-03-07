import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class StringLengthThread extends Thread{
	private Socket client;
	public StringLengthThread(Socket client) {
		this.client=client;
	}

	public void run()
	{
		try {
			InputStreamReader isr=new InputStreamReader(client.getInputStream());
			BufferedReader br =new BufferedReader(isr);
			String str=br.readLine();

			int length=this.stringLength(str);
			PrintStream ps=new PrintStream(client.getOutputStream());
			ps.println(length);
			System.out.println();	
		}
		catch (Exception e)
		{}
	}

	public int stringLength(String str) {
		System.out.println("String Length is: "+str.length());
		return str.length();
	}

}
