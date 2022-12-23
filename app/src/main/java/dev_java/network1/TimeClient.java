package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
  Socket socket = null;
  ObjectOutputStream oos = null;
  ObjectInputStream ois = null;
  JLabel jlb_timer = null;

  public TimeClient() {
  }

  // JLabel에 타이머 띄우기
  public TimeClient(JLabel jlb_timer) {
    this.jlb_timer = jlb_timer;
  }

  @Override
  public void run() {
    // 서버로부터 읽어온 시간 정보를 담기
    String timeMsg = null;
    try {
      // 아래의 코드가 실행되자마자 TimeServer의 ServerSocket이 accept()를 호출하여
      // 클라이언트 소켓 정보를 서버가 취득함
      socket = new Socket("192.168.10.71", 4000);
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
      while (true) {
        try {
          while ((timeMsg = (String) ois.readObject()) != null) {
            System.out.println(timeMsg);
            jlb_timer.setText(timeMsg);
          } // end of inner while
          sleep(1000);
        } catch (Exception e) {

        }
      } // end of outter while
    } catch (IOException ie) {
      System.out.println("타임서버에 접속할 수 없습니다.");
    } finally {
      try {
        oos.close();
        ois.close();
        socket.close();
      } catch (Exception e) {

      }
    }
  }

  public static void main(String[] args) {
    // 선언부와 생성부의 이름이 다를 수 있다 -> 그래야 다형성 구현이 가능함
    // 자바에서는 new 다음에 오는 이름으로 객체가 생성된다
    Thread th = new TimeClient();
    th.start(); // run() 호출됨
  }
}

/*
 * TimeServer에서 제공하는 현재 시간 정보를 읽어오는 클래스 구현
 * 그런데 스레드를 상속받은 이유는, 1초마다 읽어와야 하기에
 * sleep(1000)을 호출해야함 그러니 스레드를 사용해야함
 * 1초마다 계속 읽어와야하니 무한루프를 돌린다 -> 장치(핸드폰)를 종료할때까지
 */