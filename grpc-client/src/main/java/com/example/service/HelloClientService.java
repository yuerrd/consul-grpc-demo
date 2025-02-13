package com.example.service;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {
    private final HelloServiceGrpc.HelloServiceBlockingStub stub;

    public HelloClientService(ManagedChannelBuilder<?> channelBuilder) {
        this.stub = HelloServiceGrpc.newBlockingStub(channelBuilder.build());
    }

    public String sayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return stub.sayHello(request).getMessage();
    }
}