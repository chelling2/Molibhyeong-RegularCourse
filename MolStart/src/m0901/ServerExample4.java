package m0901;
import java.net.*;
class ServerExample4 {
	
    public static void main(String[] args) {
    	
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9632);
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new PerClinetThread(socket);
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
