package org.${{values.java_package_name_grpc}}.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.stereotype.Service;

@GRpcService
public class HelloServiceImpl extends com.${{values.java_package_name_grpc}}.grpc.HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(com.${{values.java_package_name_grpc}}.grpc.HelloRequest request, StreamObserver<com.${{values.java_package_name_grpc}}.grpc.HelloResponse> responseObserver) {
        String greeting = "Hello, " + request.getName() + "!!!!!";
        com.${{values.java_package_name_grpc}}.grpc.HelloResponse response = com.${{values.java_package_name_grpc}}.grpc.HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
