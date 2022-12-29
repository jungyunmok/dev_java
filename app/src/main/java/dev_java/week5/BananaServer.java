package dev_java.week5;

import javax.swing.JFrame;

public class BananaServer extends JFrame { // 생성자에서 initDisplay 호출
  // 생성자
  public BananaServer() {
    initDisplay();
  }

  public BananaServer(String title) {
    super(title);
    initDisplay(title);
    // 아래 코드의 this는 BananaServer를 가리키는 것
    // this(title); //자기자신 호출하므로 에러
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("바나나톡");
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public void initDisplay(String title) { // 메소드 오버로딩
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle(title);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  // this는 클래스 쪼개기, 즉 화면과 로직의 분리 또는
  // 하나의 클래스를 여러개의 클래스로 나누어(분업) 처리할 때만 필요함
  public static void main(String[] args) {
    // new BananaServer();
    // 생성자 파라미터에는 this말고도 다른 타입을 사용할 수 있다
    new BananaServer("생성자 파라미터로 제목을 결정함-초기화");
  }
}

/*
 * 관전 포인트
 * initDisplay를 메인메소드에서 호출하는 것과 생성자 안에서 호출하는 것이 가능하다
 * 그렇다면 둘의 차이는?
 * 키위톡은 메인메소드에서 initDisplay 호출
 * 바나나톡은 생성자에서 initDisplay 호출
 */