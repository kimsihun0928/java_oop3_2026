package server.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// exit 를 Server와 Client 둘 다 입력해야 스레드가 끝남
// Server 에서 exit --> Server 의 writeThread 종료, client  의 readThread 종료
// client 에서 exit --> client 의 writeThread 종료, Server 의 readThread 종료
// ---> 둘 중 하나만 exit 한다고 프로세스 전체가 끝나진 않음

public class MultiServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("클라이언트의 연결 요청을 기다립니다...");
            Socket clientSocket = serverSocket.accept();

            System.out.println("===== 서버 실행 =====");

            ///  // 소켓과 연결된 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            ///  //

            ///  키보드와 연결할 스트림
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드 : 클라이언트 메세지를 계속 수신
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String clientMessage;
                        while((clientMessage = reader.readLine()) != null) {
                            if("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트가 연결을 종료했습니다.");
                                break;
                            }
                            System.out.println("클라이언트 메세지 > " + clientMessage);
                        }

                    } catch (IOException e) {
                        System.err.println("클라이언트와 연결이 끊겼습니다.");
                    }
                }
            });

            // 쓰기 스레드 : 키보드 입력을 받아 클라이언트에게 전송
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverMessage;
                        while ((serverMessage = keyboardReader.readLine()) != null) {
                            writer.println(serverMessage); // \n 개행문자 포함
                            if("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료했습니다.");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });


            readThread.start(); // 읽기 스레드 시작
            writeThread.start(); // 쓰기 스레드 시작

            readThread.join(); // 읽기 스레드 가 종료까지 대기
            writeThread.join(); // 쓰기 스레드가 종료까지 대기

            /**
             *  join() <== 이 스레드가 끝날 때까지 기다려줘 라는 의미
             *  Thread.sleep() 이 "N초 동안 잠깐 잠들어 멈춰" 라면
             *  join() 은 저 스레드가 끝날 때까지 멈춰 이다.
             *
             *  join() 이 없으면
             *  main 스레드가 바로 try 블록을 벗어남
             *  소켓 자동 close()
             *  아직 실행중인 readThread, writeThread 가  닫힌 소켓으로 통신 시도를 하게됨 --> 오류 발생
             */

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    } // end of main
} // end of class
