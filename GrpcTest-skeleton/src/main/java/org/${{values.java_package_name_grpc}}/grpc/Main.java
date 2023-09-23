package org.${{values.java_package_name_grpc}}.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
    @Bean
    public Server grpcServer(HelloServiceImpl helloService) {
        return ServerBuilder
                .forPort(8080)
                .addService(helloService)
                .build();
    }
}
