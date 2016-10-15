import java.lang.*;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mensagem implements Runnable{
	private String mensagem;
	private Socket porta;
	public void setMensagem(String m){
		this.mensagem = mensagem;
	}
	public void setPorta(){
		
	}
	
	public String getMensagem(){
		return this.mensagem;
	}
	public void run(){

		
	}
	
	public static void main(String args[]){
		System.out.println("Vamos testar threads!");

	}
}