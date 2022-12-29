package dev_java.week5;

import javax.swing.JFrame;

public class BananaServer3 extends JFrame { // 생성자에서 initDisplay 호출
  String title = null;

  // 생성자
  public BananaServer3() {
    initDisplay();
  }

  public BananaServer3(String title) {
    // 생성자 호출대신에 지변을 전변으로 초기화해서 문제를 해결
    this.title = title; // 파라미터로 넘어온 title이 전변에 치환됨
    initDisplay();
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle(title);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new BananaServer3("생성자 파라미터로 제목을 결정함-초기화");
  }
}