import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Servidor{
	public static void main(String args[]){
		ServerSocket server;
		Socket cliente;
		try{		
			server = new ServerSocket(10000);
			while(true){				
				System.out.println("Server aberto na porta 10000\nEsperando conexao...");				
				cliente = server.accept();
				System.out.println("Cliente conectado no servidor"+cliente.getInetAddress().toString());
				ObjectInputStream obEntrada = new ObjectInputStream(cliente.getInputStream());
				String test = obEntrada.readLine();
				System.out.println("Mensagem do cliente: "+ test);
				ObjectOutputStream obSaida = new ObjectOutputStream(cliente.getOutputStream());
				obSaida.writeChars("Mensagem recebida");
				obSaida.close();
				obEntrada.close();
				cliente.close();
				
			}
		}
		catch(Exception ex){
			System.out.println("Erro ao abrir servidor");
			ex.printStackTrace();
		}
	
	}

}