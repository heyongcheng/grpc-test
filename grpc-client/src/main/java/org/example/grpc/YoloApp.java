package org.example.grpc;

import org.example.grpc.client.YoloClient;
import org.example.grpc.server.GrpcServer;

/**
 * @author heyc
 * @version 1.0
 * @date 2022/5/17 16:16
 */
public class YoloApp {

    public static void main(String[] args) {
        try {
            int port = 8000;
            new GrpcServer(port).start();
            new YoloClient("localhost", port).init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
