package org.example.grpc.server;

import com.rpc.yolo.YoloFunGrpc;
import com.rpc.yolo.YoloProto.Box;
import com.rpc.yolo.YoloProto.DetectionReply;
import com.rpc.yolo.YoloProto.DetectionRequest;
import com.rpc.yolo.YoloProto.FreeReply;
import com.rpc.yolo.YoloProto.FreeRequest;
import com.rpc.yolo.YoloProto.InitReply;
import com.rpc.yolo.YoloProto.InitRequest;
import io.grpc.stub.StreamObserver;

/**
 * @author heyc
 * @version 1.0
 * @date 2022/5/17 15:56
 */
public class YoloService extends YoloFunGrpc.YoloFunImplBase {

    @Override
    public void init(InitRequest request, StreamObserver<InitReply> responseObserver) {
        System.out.println(request);
        InitReply initReply = InitReply.newBuilder().setResult("OK").build();
        responseObserver.onNext(initReply);
        responseObserver.onCompleted();
    }

    @Override
    public void detection(DetectionRequest request,
        StreamObserver<DetectionReply> responseObserver) {
        DetectionReply detectionReply = DetectionReply.newBuilder().setMsg("OK")
            .addBoxes(Box.newBuilder().setX("1").build()).build();
        responseObserver.onNext(detectionReply);
        responseObserver.onCompleted();
    }

    @Override
    public void free(FreeRequest request, StreamObserver<FreeReply> responseObserver) {
        super.free(request, responseObserver);
    }
}
