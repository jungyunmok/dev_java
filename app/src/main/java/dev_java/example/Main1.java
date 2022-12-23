package dev_java.example;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main1 {
  // 선언부
  JFrame jf = new JFrame();
  Sub1 s1 = new Sub1(this);
  // Sub1 s1 = new Sub1();

  // 디폴트 생성자 안에서 화면을 그리는 initDisplay가 호출되고있다.
  // 이 메소드는 화면을 그리는 메소드이다.
  // 화면을 여러개 연다면? -> 인스턴스화로 복제본을 생성(생성자에서 메소드호출 되도록)
  public Main1() {
    initDisplay(); // Main1생성자에 메소드를 넣어, 인스턴스화를 하기만해도 initDisplay를 호출
  }

  // 화면그리기
  public void initDisplay() {
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setTitle("Main1");
    jf.setSize(300, 200);
    jf.setVisible(true);
    System.out.println("initDisplay 호출");
  }

  public void refresh() {
    System.out.println("refresh() 호출 완료");
    JOptionPane.showMessageDialog(jf, "새로고침이 처리되었습니다.");
  }

  public static void main(String[] args) {
    // Main1 m1 = new Main1(); // 인스턴스화, 호출 가능
    new Main1(); // 인스턴스화(메모리에 상주됨)-변수나 메소드를 사용할 수 있는 상태, 그러나 호출 불가능
    // initDisplay(); //non-static메소드를 static영역에서 호출 불가
    // m1.initDisplay(); // m1과 도트연산자로 메소드 호출가능
    // new Main1().initDisplay(); // 34, 35, 38번줄에서 화면 호출-창 3개 호출
  }
}

/*
 * 디폴트 생성자는 생략이 가능하다.
 * 파라미터가 있는 생성자는 생략이 불가하다.
 * 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자도 생략 불가하다.
 * 인스턴스화할 때 생성부의 이름으로 객체가 생성된다.
 * 이때 파라미터 자리에 인자를 추가할 수 있다.-여러개의 생성자를 선언할 수 있다.
 * 메소드 오버로딩
 * 파라미터의 개수가 다르거나 타입이 달라야한다.
 */