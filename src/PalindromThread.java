import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class PalindromThread extends Thread{

	private Socket client;
	public PalindromThread(Socket client) {
		this.client=client;
	}
	
	public void run()
	{
		try {
			InputStreamReader isr=new InputStreamReader(client.getInputStream());
			BufferedReader br =new BufferedReader(isr);
			String str=br.readLine();

			PrintStream ps=new PrintStream(client.getOutputStream());
			ps.println(this.checkPalindrom(str));
			System.out.println();	
		}
		catch (Exception e)
		{}
	}

	private String checkPalindrom(String str) {
		boolean flage=true;
		if(!str.equals("")) {
			int length=str.length()-1;
			//System.out.println(length);
			for(int i=0; i<length/2; i++) {
				if(str.charAt(i)!=str.charAt(length)) {
					//System.out.println("Not");
					flage=false;
				}
				length--;
			}
			//System.out.println("YES");
		}
		return ""+flage;
	}
}
