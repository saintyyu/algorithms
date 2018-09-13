package communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cdyujing7 on 2018/8/31.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        try {
            serverSocket = new ServerSocket(10000);
            socket = serverSocket.accept();
        } catch (IOException e) {

        }
    }
}
