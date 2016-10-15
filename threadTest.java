import java.lang.*;

public class threadTest implements Runnable{
	private int id;
	public void setId(int id){
		this.id = id;
	}
	public void run(){
		for(int i = 0; i < 100;i++){
			System.out.println("Programa "+id+" executando: "+i);
		}
	}
	
	public static void main(String args[]){
		System.out.println("Vamos testar threads!");
		threadTest p1 = new threadTest();  
		p1.setId(1);
 
		Thread t1 = new Thread(p1);
		t1.start();
     
		threadTest p2 = new threadTest();  
		p2.setId(2);
 
		Thread t2 = new Thread(p2);
		t2.start(); 
	}
}