package org.example.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * @author heyc
 * @version 1.0
 * @date 2022/5/17 16:03
 */
public class GrpcServer {

    private Server server;

    public GrpcServer(int port) {
        server = ServerBuilder.forPort(port)
            .addService(new YoloService())
            .build();
    }

    public void start() throws IOException {
        server.start();
        //blockUntilShutdown();
    }

    public void shutdown() {
        server.shutdown();
    }

    private void blockUntilShutdown() {
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
