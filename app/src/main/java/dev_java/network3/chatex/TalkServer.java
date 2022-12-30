package dev_java.network3.chatex;

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

public class TalkServer extends JFrame implements Runnable, ActionListener {
  // 선언부
  TalkServerThread tst = null;
  List<TalkServerThread> globalList = null;
  List<Room> roomList = null;
  ServerSocket server = null;
  Socket socket = null;
  JTextArea jta_log = new JTextArea(10, 30);
  JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JButton jbtn_log = new JButton("로그저장");

  // 생성자
  public TalkServer() {
  }

  // 화면그리기
  public void initDisplay() {
    jbtn_log.addActionListener(this);
    this.add("North", jbtn_log);
    this.add("Center", jsp_log);
    this.setSize(500, 400);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    TalkServer ts = new TalkServer();
    ts.initDisplay();
    Thread th = new Thread(ts);
    th.start();
  }

  @Override
  public void run() {
    globalList = new Vector<>();
    boolean isStop = false;
    try {
      server = new ServerSocket(3000);
      jta_log.append("Server Ready.........\n");
      while (!isStop) {
        socket = server.accept();
        jta_log.append("client info:" + socket + "\n");
        jta_log.append("client info:" + socket.getInetAddress() + "\n");
        TalkServerThread tst = new TalkServerThread(this);
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