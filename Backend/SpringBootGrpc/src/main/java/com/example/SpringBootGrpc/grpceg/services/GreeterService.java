package com.example.SpringBootGrpc.grpceg.services;

import com.example.SpringBootGrpc.grpceg.GreeterGrpc;
import com.example.SpringBootGrpc.grpceg.GreeterProto;

import com.example.SpringBootGrpc.grpceg.HelloReply;
import com.example.SpringBootGrpc.grpceg.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello, " + req.getName() + "!";
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayWelcome(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        String message = "Welcome, " + req.getName() + "!";
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}