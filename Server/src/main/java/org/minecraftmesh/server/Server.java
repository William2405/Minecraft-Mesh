package org.minecraftmesh.server;

public class Server extends Thread {

	public static void main(String[] args) {
		(new Server("Minecraft-Server")).start();
	}

	public Server(String threadName) {
		super(threadName);
	}
	
	private boolean startServer() {
		return true;
	}
	
	public void stopServer() {
		
	}
	
	@Override
	public void run() {
		
	}

}
