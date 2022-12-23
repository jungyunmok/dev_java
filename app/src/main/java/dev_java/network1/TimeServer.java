package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream; // 듣기
import java.io.ObjectOutputStream; // 말하기
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

// 서버를 기동하고 클라이언트가 접속해오기를 기다린다 -> 스레드 필요
public class TimeServer extends Thread {
  // 선언부
  // 객체 직렬화가 가능하고 듣기와 쓰기가 가능한 I/O관련 클래스 선언
  ObjectOutputStream oos = null; // 말하기, 소켓이 있어야만 객체생성 가능
  ObjectInputStream ois = null; // 듣기, 소켓이 있어야만 객체생성 가능
  Socket client = null; // 전역변수

  // 생성자
  TimeServer() {
  }

  // 아래 생성자가 필요한 이유는 서버 소켓에 접속해온 클라이언트 소켓을
  // run메소드에서 사용해야하니까 전역변수로 치환해야함
  TimeServer(Socket client) {
    this.client = client;
  }

  // run메소드 재정의 -> 스레드에서 해야할 일을 처리함
  // 부모(스레드)가 가진 메소드와 반드시 선언부가 일치해야함
  // TimeServer is a Thread 관계가 성립 -> 상속처리 가능
  // 스레드 구현 메소드에서 서버소켓에 접속해온 client 소켓을 가지고
  // 말하기와 듣기에 필요한 oos와 ois 객체를 생성함
  // I/O도 지연과 데드락 상태에 빠질 수 있으므로 반드시 예외처리를 할 것
  @Override
  public void run() {
    try {
      oos = new ObjectOutputStream(client.getOutputStream());
      ois = new ObjectInputStream(client.getInputStream());
      while (true) {
        oos.writeObject(getTimeMessage()); // 12:05:45 넘어옴
        try {
          sleep(1000); // 1초동안 멈추기
        } catch (InterruptedException ie) {
          // TODO: handle exception
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  } // end of run

  // 메인메소드
  public static void main(String[] args) {
    // 서버소켓 생성시 파라미터로 포트번호가 필요함
    int port = 4000;
    // 동시에 여러사람이 접속을 시도함
    ServerSocket server = null;
    Socket client = null; // 여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트의 소켓(주소번지)이다
    try {
      server = new ServerSocket(port);
    } catch (IOException ie) {
      System.out.println("Can't bind port: " + port);
      ie.printStackTrace(); // 에러메시지를 라인 번호와 함께 출력(힌트문, 디버깅에 주로 사용)
      try {
        server.close();
      } catch (Exception e) {
        System.exit(0); // 서버 강제 종료
      }
    } // end of try_catch
    System.out.println("TimeServer Started Successfully");

    while (true) {
      try {
        // 클라이언트가 접속해 오기를 기다리다가, 접속(new Socket("192.168.10.71", 4000))하면
        // 아래 메소드가 클라이언트 소켓 정보를 취득함
        client = server.accept();
        System.out.println(client.getInetAddress()); // 클라이언트의 네트워크 정보 확인
        System.out.println("New Client Connected");
        // 스레드 개입이 필요함 -> 1초동안 sleep(1000)(1000은 1초를 의미)을 호출하고 현재 시, 분, 초 정보를 출력
        // 스레드 동작시킴 -> 스레드의 추상메소드 run을 호출해야함
        // 주의: run을 직접 호출하는게 아니라, start()를 호출하면 JVM이 순서를 따져서 출발시킴(콜백)
        TimeServer ts = new TimeServer(client); // run에서 사용하고싶으니 client 넘김
        ts.start(); // run()가 호출됨
        System.out.println("New TimeServer Thread Started");
      } catch (Exception e) {

      }
    }
  }

  // 현재 시간 표시
  public String getTimeMessage() {
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    int sec = cal.get(Calendar.SECOND);
    return (hour < 10 ? "0" + hour : "" + hour) + ":" + (min < 10 ? "0" + min : "" + min) + ":"
        + (sec < 10 ? "0" + sec : "" + sec);
    // return "12:05:45";
  }
}