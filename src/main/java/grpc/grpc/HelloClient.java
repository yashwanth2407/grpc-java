package grpc.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class HelloClient {
    public static void main(String[] args) {
        String target = "localhost:9090";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder().setName("World").build();

        try {
            HelloReply response = stub.sayHello(request);
            System.out.println("Received: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
        } finally {
        	
        }
    }
}
