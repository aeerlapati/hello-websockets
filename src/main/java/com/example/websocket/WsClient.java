package com.example.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

/**
 * Hello world!
 */
public class WsClient{

    public static boolean messageFlag = false;
    public static void main(String[] args) throws Exception {
        //        WebSocketImpl.DEBUG = true;
                run("ws://localhost:8887");
            }
            
            private static void run(String url) throws URISyntaxException, InterruptedException {

                WebSocketClient client = new WebSocketClient(new URI(url), new Draft_6455()) {
                    @Override
                    public void onOpen(ServerHandshake handshake) {
                        System.out.println("onOpen: " + getURI());
                    }
        
                    @Override
                    public void onMessage(String message) {
                        System.out.println("onMessage: " + message);
                        this.send("received");
                    }
        
                    @Override
                    public void onError(Exception ex) {
                        System.out.println("onError");
                        ex.printStackTrace();
                    }
        
                    @Override
                    public void onClose(int code, String reason, boolean remote) {
                        System.out.println(String.format("onClose(code: %s, reason: %s, remote: %s)", code, reason, remote));
                    }
                };
                client.connect();
        
                System.out.println("Will close in 1 seconds");
                Thread.sleep(10000L);
                client.close();

}
}