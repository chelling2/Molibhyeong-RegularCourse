package m0901;
import java.net.*;
import java.io.*;
class SenderThread extends Thread {
    Socket socket;
    String name;
    SenderThread(Socket socket, String name) { 
        this.socket = socket;
        this.name = name;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
	    // ���� ���� ������ ��ȭ�� �۽��Ѵ�.
	    writer.println(name);
            writer.flush();
           
	   // Ű����� �Էµ� �޽����� ������ �۽� 
	    while (true) {
                String str = reader.readLine();
                if (str.equals("bye"))
                    break;
                writer.println(str);
                writer.flush();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
