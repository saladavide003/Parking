package it.itsrizzoli;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App
{
    static int portNumber = 1234;
    ParkingManager pm =
    public static void main(String[] args)
    { System.out.println("Server started!");


        ServerSocket serverSocket = null;
        serverSocket = getServerSocket();

        Socket clientSocket = null;
        clientSocket = accept(serverSocket);
        ClientHandler ch = new ClientHandler(clientSocket);
        ch.handle();

    }


    private static Socket accept(ServerSocket serverSocket) {
        Socket clientSocket;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientSocket;
    }

    private static ServerSocket getServerSocket() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serverSocket;
    }
}