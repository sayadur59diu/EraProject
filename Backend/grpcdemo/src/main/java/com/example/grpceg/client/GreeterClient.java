package com.example.grpceg.client;


import com.example.grpceg.GreeterGrpc;
import com.example.grpceg.GreeterProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import com.example.grpceg.BirthdayWishGrpc;

@Component

public class GreeterClient {
    @GrpcClient("greeter")
    private GreeterGrpc.GreeterBlockingStub greeterStub;
    
    @GrpcClient("greeter")
    private BirthdayWishGrpc.BirthdayWishBlockingStub bdayStub;

    public String sayHello(String name) {
        GreeterProto.HelloRequest req = GreeterProto.HelloRequest.newBuilder().setName(name).build();
        GreeterProto.HelloReply rep = greeterStub.sayHello(req);
        return rep.getMessage();
    }
    
    public String sayWelcome(String name) {
        GreeterProto.HelloRequest req = GreeterProto.HelloRequest.newBuilder().setName(name).build();
        GreeterProto.HelloReply rep = greeterStub.sayWelcome(req);
        return rep.getMessage();
    }
    
    public String sayHappyBirthday(String name) {
        GreeterProto.HelloRequest req = GreeterProto.HelloRequest.newBuilder().setName(name).build();
        GreeterProto.HelloReply rep = bdayStub.sayHappyBirthday(req);
        return rep.getMessage();
    }
    
}
