package dev_java.week3;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaUI {
   // 선언부
   JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this); // 로직 분리
   JTextAreaUIEvent jTextAreaUIEvent = new JTextAreaUIEvent(this); // 이벤트핸들러 분리
   // 인터페이스는 반드시 구현체 클래스가 있어야 한다.
   // 단독으로 인스턴스화할 수 없다.
   // ActionListener al = new ActionListener(); //단독으로 인스턴스화 불가!
   // 선언부와 생성부의 타입이 다르다. 그렇기에 다형성이 가능함(폴리모피즘)재사용성을 높이고 결합도는 낮춘다.
   // ActionListener al = new JTextAreaUI(); //이렇게는 가능!
   JFrame jf = new JFrame();
   JTextArea jta = new JTextArea(10, 20);
   JTextField jtf = new JTextField(10);

   // 디폴트 생성자는 생략이 가능하다. -> JVM이 대신 생성해줌
   // 생성자도 메소드처럼 호출이 가능하다. 하지만 메소드와 다르게 리턴타입이 없다
   // 인스턴스화(호출) 될 때 생성된다.
   public JTextAreaUI() { // 디폴트 생성자 선언
      initDisplay();
   }

   public void initDisplay() { // UI를 그린다(이벤트처리)
      // 이벤트 소스와 이벤트 핸들러 클래스 매핑(매칭)하기
      jtf.addActionListener(jTextAreaUIEvent); // ()에 이벤트핸들러를 가리키는 인스턴스변수명이 와야함
      // 멀티라인 작성 가능한 컴포넌트의 배경색 설정
      jta.setBackground(Color.cyan);
      // JFrame은 디폴트 레이아웃이 BorderLayout이라서 동, 서, 남, 북, 중앙 배치 가능
      jf.add("Center", jta); // JTextArea는 중앙에 배치
      jf.add("South", jtf); // JTextField는 남쪽에 배치
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우창 x버튼 클릭 시 자원회수
      jf.setSize(400, 300); // 윈도우창 가로 세로 크기 설정
      jf.setVisible(true); // 화면을 출력함
   }

   public static void main(String[] args) { // 가장먼저 호출됨-entry point
      new JTextAreaUI(); // 생성자가 호출되고 그 안에서 화면그리는 메소드 호출
   }
}