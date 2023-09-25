package org.${{values.java_package_name_graphql}};

import com.${{values.java_package_name_grpc}}.grpc.HelloRequest;
import com.${{values.java_package_name_grpc}}.grpc.HelloResponse;
import com.${{values.java_package_name_grpc}}.grpc.HelloServiceGrpc;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;


@Component
public class HelloResolver implements GraphQLQueryResolver {
    private  HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public HelloResolver() {
        this.blockingStub = blockingStub;
    }


    public HelloResponse fetchSomethingFromGrpc() {

        // Create a gRPC channel to connect to your gRPC service
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext() // Insecure, use with caution
                .build();

        // Create a gRPC stub for your service
        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
        // Make a gRPC call and return the result
        HelloResponse result = (blockingStub.sayHello(HelloRequest.newBuilder().build())); // Replace with your gRPC method
        // Close the channel when done
        channel.shutdown();
        return result;
    }
}
