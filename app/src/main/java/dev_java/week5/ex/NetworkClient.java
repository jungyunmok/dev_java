package dev_java.week5.ex;

import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {
	public void client() {
		int port = 3000;
		String serverIP = null;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket("192.168.20.34", port);
			System.out.println("NetworkClient socket " + socket);
		} catch (Exception e) {
			System.out.println("NetworkClient client " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client();
	}

}