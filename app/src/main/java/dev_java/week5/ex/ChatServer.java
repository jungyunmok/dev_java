package dev_java.week5.ex;

import java.net.ServerSocket;
import java.net.Socket;

// 단일상속만 되니까 인터페이스(다중상속 가능) 지원함
// 인터페이스를 통한 스레드 구현방법
public class ChatServer implements Runnable {
  // 메인스레드이다
  public static void main(String[] args) {
    System.out.println("main 시작");
    ChatServer cs = new ChatServer();
    Thread th = new Thread(cs);
    th.start();
    System.out.println("main 끝");
  }

  @Override
  public void run() {
    System.out.println("run 호출 성공");
    int port = 3000;
    ServerSocket server = null;
    try {
      server = new ServerSocket(port);
      // 대기상태 ...
      System.out.println("서버 소켓 생성 완료 - 클라이언트 소켓 접속 대기중...");
      while (true) {
        // 아래코드가 진행되는 시점
        // ChatClient에서 new Socket("서버IP", 3000); 하면 대기상태 풀림
        Socket client = server.accept();
        System.out.println("클라이언트측: " + client.getInetAddress()); // 접속한 클라이언트 정보 출력
        // 금융권에서 주로 사용(oos, ois) -> 보안강화 / 직렬화기법 / 마샬링, 언마샬링구간
        // 말하기 - ObjectOutputStream -> writeObject(); 네트워크 전송 일어남 - 패킷
        // 듣기 - ObjectInputStream -> readObject();
        break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}