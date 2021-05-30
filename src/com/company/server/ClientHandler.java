package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {

        this.client = socket;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000); //wait for 5 seconds before executing the rest of the code
            //Receive data
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null) {

                System.out.println("Client says: " + inputData);

                Scanner scanner = new Scanner(System.in);
                String serverMessage = "";

                //send data to client
                //also you can use scanner class to capture input
                switch (inputData) {
                    case "Hello from the client.":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine, How are you? \n");
                        break;
                    case "I'm fine.":
                        outputStream.writeBytes("Okay good to know. \n");
                        break;
                    case "Thank you.":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        while (serverMessage != "exit") {
                            serverMessage = scanner.nextLine();
                            outputStream.writeBytes(serverMessage + "\n");
                        }
                }

                if (inputData.equals("exit")) {
                    break;
                }

            }

            client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
}
