package dev_java.week5;

import javax.swing.JFrame;

public class BananaServer2 extends JFrame { // 생성자에서 initDisplay 호출
  // 생성자
  public BananaServer2() {
    initDisplay();
  }

  public BananaServer2(String title) {
    super(title); // 이 코드가 this.setTitle()역할을 대신함
    initDisplay();
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    // 파라미터 생성자로 title을 추가했을 때 이 정보를 initDisplat에서
    // setTitle에 사용하고싶다면
    new BananaServer2("생성자 파라미터로 제목을 결정함-초기화");
  }
}