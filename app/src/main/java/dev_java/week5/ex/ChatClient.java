package dev_java.week5.ex;

import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
  public void client() {
    int port = 3000;
    String serverIP = "127.0.0.1";
    // java.net, java.io -> 인터넷 회선 장애 문제발생 위험을 지님
    // io 생성시에 소켓을 통해 인스턴스화를 하니까 의존관계에 있다
    // 이런 패키지는 반드시 예외처리 할 것(Thread도 마찬가지 -> 인터셉트를 당할 수 있다)
    // Object마다 lock flag값이 있어서 스레드가 점유하면 잠금처리 -> 다른 스레드는 사용불가
    // 데드락상태에 빠질 수 있다(안에서 잠금으로 다른 스레드가 사용불가한 상태
    // 한정된 자원을 여러 사람이 이용하기 위해 제공되는 클래스가 Thread
    // Thread.sleep(), join, yield, intercept ...
    try {
      System.out.println(InetAddress.getLocalHost().getHostAddress());
      Socket socket = new Socket(serverIP, port);
    } catch (Exception e) {
      // 에러메세지에 대한 history를 기억하고 라인번호와 함께 이력을 출력해줌
      // 디버깅 때 꼭 필요
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ChatClient cc = new ChatClient();
    cc.client();
  }
}