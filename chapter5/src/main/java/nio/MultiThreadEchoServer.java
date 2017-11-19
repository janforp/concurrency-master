package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janita on 2017/11/19- 19:25
 * 该类是:
 */
public class MultiThreadEchoServer {

    private static ExecutorService tp = Executors.newCachedThreadPool();
    static class HandleMsg implements Runnable {
        Socket clientSocket ;
        public HandleMsg(Socket clientSocket) {
            this.clientSocket =  clientSocket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine = null;
                long b = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null) {
                    os.println(inputLine);
                }
                long e = System.currentTimeMillis();
                System.out.println("\n****************** spend :" + (e - b) + "ms");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(is != null) is.close();
                    if ((os != null)) os.close();
                    clientSocket.close();
                }catch (IOException e) {

                }
            }
        }
    }


    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                clientSocket = echoServer.accept();
                System.out.println("\n****************** " + clientSocket.getRemoteSocketAddress() + " connect !");
                tp.execute(new HandleMsg(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
