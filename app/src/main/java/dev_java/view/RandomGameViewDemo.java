package dev_java.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameViewDemo implements ActionListener {
  // 선언부
  // JFrame jf = null; // 게으른 인스턴스화, 선언과 생성을 분리
  JFrame jf = new JFrame(); // 이른 인스턴스화
  JButton jbtn_center = new JButton("중앙"); // 생성자 파라미터는 String
  JButton jbtn_east = new JButton("동쪽");
  JButton jbtn_west = new JButton("서쪽");
  JButton jbtn_south = new JButton("남쪽");
  JButton jbtn_north = new JButton("북쪽");

  // 생성자
  public RandomGameViewDemo() { 
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    // jf = new JFrame(); // 게으른 인스턴스화, 선언과 생성을 분리
    jbtn_center.addActionListener(this);
    jbtn_east.addActionListener(this);
    jbtn_west.addActionListener(this);
    jbtn_south.addActionListener(this);
    jbtn_north.addActionListener(this);
    jf.add("Center", jbtn_center); // 다른 버튼을 비활성화하면 Center가 그 공간을 차지함
    jf.add("East", jbtn_east);
    jf.add("West", jbtn_west);
    jf.add("South", jbtn_south);
    jf.add("North", jbtn_north);
    jf.setSize(300, 400);
    jf.setVisible(true);
  }

  // UI API를 활용하여 공부를 하면
  // 1. 초기화를 활용할 수 있게됨
  // 2. 생성자 역할에 대해 알게됨
  // 3. 사용자 정의 메소드를 많이 만들어볼 수 있음
  // 4. 파라미터와 리턴타입에 대해 확실해짐
  // 5. 전역변수와 지역변수를 구분하여 코딩을 전개하게됨
  // 6. 클래스를 나누는 조건을 갖게됨
  // 7. 이벤트 처리를 사전학습할 수 있음
  // 8. 익명클래스를 활용할 수 있음(익명함수, arrow function등 신 문법을 공부하는데 도움)

  // 메인메소드
  public static void main(String[] args) {
    new RandomGameView();
    // 선언부 없이 생성자만 호출할 수 있다.(인스턴스변수를 재사용할 일이 없다면 괜찮음)
    // new RandomGameView(); // 복제본이 생성됨. 그러나 서로 다른 객체
    // new RandomGameView(); //마찬가지로 복제본이 생성됨. 타입은 동일하지만 다른 객체
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 눌린 버튼의 문자열을 읽어온다
    System.out.println(e.getActionCommand());
    // 눌린 버튼의 주소번지를 가져온다
    System.out.println(e.getSource());
    String label = e.getActionCommand(); // 북쪽, 남쪽, 동쪽, 서쪽, 중앙
    if ("중앙".equals(label)) {
      System.out.println("중앙버튼 클릭");
    } else if ("동쪽".equals(label)) {
      System.out.println("동쪽버튼 클릭");
    } else if ("서쪽".equals(label)) {
      System.out.println("서쪽버튼 클릭");
    } else if ("남쪽".equals(label)) {
      System.out.println("남쪽버튼 클릭");
    } else if ("북쪽".equals(label)) {
      System.out.println("북쪽버튼 클릭");
    }
  }
}