package dev_java.network3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// POJO F/W설계-인터페이스중심 코딩 전개-> Spring boot(전자정부프레임워크)기반 MVC패턴
// 자바스크립트(ES5, 6, 7)-NodeJS
// 리액트(객체, 클래스, 리액트훅, 메소드, 파라미터, 리턴타입)
public class TalkServer2 extends JFrame implements ActionListener { // Runnable제거했을 경우
  // 선언부
  TalkServerThread2 tst = null;
  List<TalkServerThread2> globalList = null;
  ServerSocket server = null;
  Socket socket = null;
  JTextArea jta_log = new JTextArea(10, 30);
  JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JButton jbtn_log = new JButton("로그저장");

  // 생성자-클래스이름이 다르면 생성자이름도 변경해줌
  public TalkServer2() {
  }

  // 화면그리기
  public void initDisplay() {
    jbtn_log.addActionListener(this);
    this.add("North", jbtn_log);
    this.add("Center", jsp_log);
    this.setSize(500, 400);
    this.setVisible(true);
  }

  public static void main(String[] args) { // 메인스레드(entry point)
    TalkServer2 ts = new TalkServer2();
    // init을 initDisplay보다 위에 배치하면 계속 기다림-> Runnable을 제거했기에 스레드 하나(메인)
    // ts.init(); // 클라이언트가 접촉해와서 채팅창이 열리더라도 채팅입력에 한계있음(서버창은 안열림)
    ts.initDisplay(); // 메인스레드
    ts.init(); // 서버 대기(사용자, 클라이언트 기다림)
    // 아래 코드에 에러가 발생하는 것은, Runnable을 implements에서 제거했기 때문
    // Thread th = new Thread(ts); // 사용불가

  }

  // @Override // run() 오버라이드 사용불가
  // public void run() {}

  public void init() {
    globalList = new Vector<>();
    boolean isStop = false;
    try {
      server = new ServerSocket(3000);// 서버포트번호 설정하기
      jta_log.append("Server Ready.........\n");// 대기 탐 - 멈춤 - wait
      while (!isStop) { // while문 안으로 진입하는 시기 -> new Socket(ip, port);
        socket = server.accept();
        jta_log.append("client info:" + socket + "\n");
        jta_log.append("client info:" + socket.getInetAddress() + "\n");
        // 자바 String/int/double - 오라클 VARCHAR2, CHAR/number(5)/number(7.2)
        // 이종간의 언어에서 데이터 공유(static)를 목적으로 설계하는 디자인 패턴 -> DTO
        // DeptVO this사용 -> 전역변수 초기화 - ValueObject패턴의 일부(오라클, 자바 연동에 필요)
        // 이벤트 처리시 이벤트처리를 담당하는 클래스를 가리키는 목적으로 this를 사용함
        // ActionListener 구현할 때-> 버튼.addActionListener(this)
        // new xxx(this); -> 클래스 분리할 때, MVC패턴으로 구현할 때
        // 생성자 호출시 파라미터로 들어오는 this는 현재 인스턴스화된 객체를 가리킨다
        // 아래 코드에서 this는 TalkServer2
        // 아래는 객체를 생성하는 것과 동시에 생성자를 호출하는데, 클래스 이름을 바꾸었기에 에러발생
        // 해결방법은 TalkServerThread의 생성자 파라미터 타입을 TalkServer2로 변경하는 것
        TalkServerThread2 tst = new TalkServerThread2(this);
        // TalkServer2가 화면을 만들 때 JFrame을 상속받았다
        // 아래 코드에서 super를 쓰면 상속받은 JFrame
        // TalkServerThread tst = new TalkServerThread(super);
        tst.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 로그를 파일로 저장하기
  }
}