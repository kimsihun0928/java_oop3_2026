package client.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5002)) {

            System.out.println("서버와 연결되었습니다. 채팅을 시작합니다.");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String response = reader.readLine();
                System.out.println("서버 메세지 : " + response);
                String myMessage = br.readLine();
                writer.println(myMessage);
                if (myMessage.equals("종료")) {
                    break;
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("서버 측을 알 수 없습니다.");
        } catch (IOException e) {
            System.err.println("서버 측에 연결할 수 없습니다.");
        }


    }

}
