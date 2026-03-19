package server.ch01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    public static void main(String[] args) {
        // 소켓 통신을 하기 위한 서버 측 테스트 코드 1
        // (내 IP주소는 당연히 알고있음)
        // 포트 번호를 열고 클라이언트에 연결 요청을 기다리는 서버 소켓
        // IP : 192.168.4.16

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            // accept() - 클라이언트가 연결할 때까지 이 줄에서 멈춤(블로킹된 상태)
            Socket clientSocket =  serverSocket.accept();
            // 1.코드가 아래로 안내려감 (블로킹)
            System.out.println("클라이언트가 연결됐습니다.");
            // 2. 소켓 객체가 생성이 되면 (accept()) 이 소켓이 클라이언트 소켓과 연결되어 있는 소켓이다.

            // I/O 단원에서 배운 그대로
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // 클라이언트가 보낸 한 줄을 읽음
            String message = reader.readLine();
            // 내 서버 측 콘솔 창에 출력
            System.out.println("클라이언트 메세지 : " + message);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println("오류 발생 : 포트 5000이 이미 사용중이거나 연결에 실패했습니다.");
        }


    } // end of main
} // end of class
