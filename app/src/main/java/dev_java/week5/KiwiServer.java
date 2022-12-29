package dev_java.week5;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable { // 메인메소드에서 initDisplay 호출
  // 생성자
  public KiwiServer() {
    System.out.println("KiwiServer 디폴트 생성자 호출");
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("키위톡");
    this.setSize(400, 300);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    KiwiServer ks = new KiwiServer();
    ks.initDisplay();
    Thread th = new Thread(ks);
    th.start();
  }

  @Override
  public void run() {
    System.out.println("run 호출 성공");
    // 스레드
    // 경합(선착순)이 벌어지는 일
    // 지연(대기)이 필요한 일
    // 일반메소드로 처리할 때와 다른 점
    // 1. 보장받는다 -> 늦게라도 실행됨 (일반메소드는 어플리케이션이 종료되면 보장X)
    // 2. 개별적으로 동작을 할 수 있다
  }
}