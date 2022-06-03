import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class GRPCServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(3000).addService(new House.HouseService()).addService(ProtoReflectionService.newInstance()).build();

        server.start();
        System.out.println("Server running on port " + server.getPort());
        server.awaitTermination();
    }
}
