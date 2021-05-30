package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {
//        System.out.println("Client is running...");
//        Socket socket = new Socket("localhost", 6000);

//        //Send data to the server
//        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//        dataOutputStream.writeBytes("Hello from the client! \n");
//        dataOutputStream.writeBytes("exit\n");
//
//        //Get the data from the server
//        InputStream inputStream = socket.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String receivedData = bufferedReader.readLine();
//
//        System.out.println("Data received from server : " + receivedData);

        Client client = new Client();
        client.start();

        client.sendMessage("Hello from the client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine.");
        client.sendMessage("Thank you.");

        Scanner scanner = new Scanner(System.in);
        String clientMessage = "";

        while (clientMessage != "exit") {
            clientMessage = scanner.nextLine();
            client.sendMessage(clientMessage);
        }

        System.out.println("Client finished the execution...");

    }
}
