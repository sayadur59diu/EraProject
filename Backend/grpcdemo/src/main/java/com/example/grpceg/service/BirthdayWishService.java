
package com.example.grpceg.service;


import com.example.grpceg.BirthdayWishGrpc;
import com.example.grpceg.GreeterProto;
import com.example.grpceg.GreeterProto.HelloReply;
import com.example.grpceg.GreeterProto.HelloRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class BirthdayWishService extends BirthdayWishGrpc.BirthdayWishImplBase {

	@Override
	public void sayHappyBirthday(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		 String message = "Hello, " + request.getName() + ". Wish you a happy birthday!";
	        GreeterProto.HelloReply reply = GreeterProto.HelloReply.newBuilder().setMessage(message).build();
	        responseObserver.onNext(reply);
	        responseObserver.onCompleted();
	}
    
    
}