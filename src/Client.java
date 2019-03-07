
import java.io.*;
import java.net.*;
//Muhammad Hamza
//2016-UET-NML-CS-28

//           Protocol Syntax
//           For Signin: i//username//password
// 			 For signup: u//username//password//DoB//department
import java.util.Scanner;
public class Client {
	final int PORT=2222;
	final String IP="localhost";

	public Client() throws IOException {
		Socket client =new Socket(IP,PORT);
		PrintWriter pw=new PrintWriter(client.getOutputStream(),true);

		String string=null;
		String resources=null;
		Scanner input=new Scanner(System.in);
		
		System.out.println("For Check Resources R1,R2,R3");
		resources=input.next();
		System.out.println("Enter the String: ");
		string = input.next();
		pw.println(resources+"//"+string);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println(br.readLine());
		
	}

	public static void main(String args[]) throws IOException{
		Client obj=new Client();
	}
}