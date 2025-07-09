package com.example.SpringBootGrpc.grpceg.services;

import com.example.SpringBootGrpc.grpceg.BirthdayWishGrpc;
import com.example.SpringBootGrpc.grpceg.HelloReply;
import com.example.SpringBootGrpc.grpceg.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BirthdayWishService extends BirthdayWishGrpc.BirthdayWishImplBase {

    @Override
    public void sayHappyBirthday(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello, " + request.getName() + ". Wish you a happy birthday!";
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}