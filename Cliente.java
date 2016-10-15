import java.net.Socket;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cliente{
	public static void main(String args[]){
		Socket cliente;
		String fala;
		Scanner teclado = new Scanner(System.in);
		int num = 0;
		try{
			while(num == 0){
				cliente = new Socket("192.168.1.38",10000);
				System.out.println("Sucesso ao entrar na porta 10000\nDigite uma mensagem para o servidor!");
				fala = teclado.nextLine();
				ObjectOutputStream obSaida = new ObjectOutputStream(cliente.getOutputStream());
				obSaida.writeChars(fala);	
				obSaida.close();
				cliente.close();
				ObjectInputStream obEntrada = new ObjectInputStream(cliente.getInputStream());
				String s = obEntrada.readLine();
				System.out.println(s);
				System.out.println("Digite 0 para mandar outra mensagem pro servidor e 1 para sair");
				num = Integer.parseInt(teclado.nextLine());
			}
			
		}
		catch(Exception ex){
			System.out.println("ERRO ---- ");
			ex.printStackTrace();
		
		}		
	}
	
	public void falando(){
		System.out.println("Ola eu sou o cliente!");
		
	}


}