package m0901;
// �� Ŭ���̾�Ʈ ���ӿ� ���� �ϳ��� �۵��ϴ� ������ Ŭ���� 


import java.io.*;
import java.net.*;
import java.util.*;
class PerClinetThread extends Thread {
	
    // ArrayList ��ü�� ���� �����尡 �����ϰ� ������ �� �ִ� ����ȭ�� ����Ʈ�� ����ϴ�.
    static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

    Socket socket;
    PrintWriter writer;
    PerClinetThread(Socket socket) {
        this.socket= socket;
        try {
            writer = new PrintWriter(socket.getOutputStream());
            list.add(writer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void run() {
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
	    
            // ���ŵ� ù��° ���ڿ��� ��ȭ������ ����ϱ� ���� ����
            name = reader.readLine();           
            sendAll("#" + name + "���� �����̽��ϴ�");
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                sendAll(name + ">" + str);  // ���ŵ� �޽��� �տ� ��ȭ���� �ٿ��� ��� Ŭ���̾�Ʈ�� �۽�
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            list.remove(writer);
            sendAll("#" + name + "���� �����̽��ϴ�"); // ����ڰ� ä���� �����ߴٴ� �޽����� ��� Ŭ���̾�Ʈ�� �����ϴ�.
            try {
                socket.close();
            }
            catch (Exception ignored) {
            }
        }
    }
	
    // ������ ����Ǿ� �ִ� ��� Ŭ���̾�Ʈ�� �Ȱ��� �޽����� �����ϴ�.
    private void sendAll(String str) {  
        for (PrintWriter writer : list) {
            writer.println(str);
            writer.flush();
        }
    }
}
