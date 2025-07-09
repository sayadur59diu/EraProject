package com.example.SpringBootGrpc.grpceg.client;

import com.example.SpringBootGrpc.grpceg.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component

public class GreeterClient {
    @GrpcClient("greeter")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    @GrpcClient("greeter")
    private BirthdayWishGrpc.BirthdayWishBlockingStub bdayStub;

    public String sayHello(String name) {
       HelloRequest req = HelloRequest.newBuilder().setName(name).build();
        HelloReply rep = greeterStub.sayHello(req);
        return rep.getMessage();
    }

    public String sayWelcome(String name) {
        HelloRequest req = HelloRequest.newBuilder().setName(name).build();
        HelloReply rep = greeterStub.sayWelcome(req);
        return rep.getMessage();
    }

    public String sayHappyBirthday(String name) {
        HelloRequest req = HelloRequest.newBuilder().setName(name).build();
        HelloReply rep = bdayStub.sayHappyBirthday(req);
        return rep.getMessage();
    }

}
