package org.example.grpc.client;

import com.rpc.yolo.YoloFunGrpc;
import com.rpc.yolo.YoloProto.InitReply;
import com.rpc.yolo.YoloProto.InitRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolverRegistry;

/**
 * @author heyc
 * @version 1.0
 * @date 2022/5/17 16:09
 */
public class YoloClient {

    private YoloFunGrpc.YoloFunBlockingStub yoloFunBlockingStub;

    public YoloClient(String host, int port) {
        //NameResolverRegistry.getDefaultRegistry().register();
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext()
            // 服务发现 和 负载均衡
            // NameResolverProvider spi接口
            //.defaultLoadBalancingPolicy()
            //.defaultLoadBalancingPolicy()
            .build();

        yoloFunBlockingStub = YoloFunGrpc.newBlockingStub(managedChannel);

    }

    public void init() {
        InitRequest request = InitRequest.newBuilder().setId("1").setCfg("ccc").build();
        InitReply initReply = yoloFunBlockingStub.init(request);
        System.out.println(initReply);
    }

}
