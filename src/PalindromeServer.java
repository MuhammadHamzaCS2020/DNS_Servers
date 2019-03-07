import java.net.ServerSocket;
import java.net.Socket;

public class PalindromeServer {
	private static int countRequestsPalindrom=0;
	public PalindromeServer() {
		try
		{
			final int PORT=5678;
			ServerSocket ss=new ServerSocket(PORT);
			System.out.println("Waiting for Echo the String");
			while(true){
				Socket client=ss.accept();
				countRequestsPalindrom++;
				System.out.println("Server Accepted Request# "+countRequestsPalindrom);
				PalindromThread ct = new PalindromThread(client);
				ct.start();
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}
	
	public static void main(String[] args) {
		PalindromeServer obj=new PalindromeServer();
	}
}
