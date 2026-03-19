package server.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5002)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨");

            // 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 쓰기
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // 기능
            writer.println("채팅을 입력하세요. ([종료] 입력 시 연결 종료)");
            while (true) {
                String message = reader.readLine();
                if (message.equals("종료")) {
                    System.out.println("클라이언트가 연결을 종료하였습니다.");
                    break;
                }
                System.out.println("클라이언트가 보낸 메세지 : " + message);
                String myMessage = br.readLine();
                writer.println(myMessage);
            }

        } catch (IOException e) {
            System.out.println("오류 발생 : " + e.getMessage());
        }
    }

}
