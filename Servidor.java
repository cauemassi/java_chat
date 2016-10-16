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
				System.out.println("--------------");
				ObjectOutputStream obSaida = new ObjectOutputStream(cliente.getOutputStream());
				System.out.println("Escreveu");
				obSaida.writeObject("Olaaaa");
				System.out.println("Mandou");
				String test = (String) obEntrada.readObject(); //problema para receber
				System.out.println("Mensagem do cliente: "+test);				
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