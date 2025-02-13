package com.example.config;

import io.grpc.ManagedChannelBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    @Bean
    public ManagedChannelBuilder<?> grpcChannelBuilder(ConsulDiscoveryClient discoveryClient) {
        ServiceInstance instance = discoveryClient.getInstances("grpc-server")
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No gRPC server available"));

        return ManagedChannelBuilder.forAddress(instance.getHost(), instance.getPort())
                .usePlaintext();
    }
}