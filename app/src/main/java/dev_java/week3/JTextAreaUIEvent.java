package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUIEvent implements ActionListener {
  JTextAreaUI jtaUI = null;

  public JTextAreaUIEvent(JTextAreaUI u1) {
    // 생성자 안에서 JTextAreaUI의 JTextArea원본과 전역변수를 초기화해줘야함
    this.jtaUI = u1;
  }

  // annotation-문법제약을 갖고있다-선언부가 일치해야한다.
  @Override
  public void actionPerformed(ActionEvent e) { // callback 추상메소드, 이벤트가 감지됐을 때 호출됨
    // 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
    // getSource메소드의 소유주(ActionEvent클래스)
    Object obj = e.getSource();
    if (jtaUI.jtf == obj) { // JTextField에 엔터를 쳤는가?
      // JTextField에 입력한 문자열받기
      String input = jtaUI.jtf.getText();
      jtaUI.jta.append("JTextAreaUI원본: " + input + "\n"); // 원본에서 찍히는지 확인
      jtaUI.jtaUILogic.account(input); // Logic에서 가져온 값
      jtaUI.jtf.setText("");
    }
  }
}