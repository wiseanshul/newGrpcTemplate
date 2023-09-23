package org.${{values.grpc_package_name}}.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.stereotype.Service;

@GRpcService
public class HelloServiceImpl extends com.example.grpc.HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(com.example.grpc.HelloRequest request, StreamObserver<com.example.grpc.HelloResponse> responseObserver) {
        String greeting = "Hello, " + request.getName() + "!!!!!";
        com.example.grpc.HelloResponse response = com.example.grpc.HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
