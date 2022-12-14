package dev_java.view.array;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonArray implements ActionListener {
  // 선언부
  JFrame jf = new JFrame(); // setSize(400,300);가로세로 크기지정, setVisible(true);윈도우창에 활성화하기
  JPanel jp_center = new JPanel();
  JTextArea jta_display = new JTextArea(10, 20);
  JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JTextField jtf_input = new JTextField();
  JPanel jp_east = new JPanel();
  JButton jbtn_new = new JButton("새게임");
  JButton jbtn_dap = new JButton("정답");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("종료");

  // 생성자
  public ButtonArray() {
    System.out.println("디폴트생성자 호출");
    // 이벤트 소스와 이벤트 처리를 담당하는 핸들러클래스를 매핑하기
    jtf_input.addActionListener(this); // addActionListener를 해줘야 동작을 감지함!
    jbtn_new.addActionListener(this);
    jbtn_dap.addActionListener(this);
    jbtn_clear.addActionListener(this);
    jbtn_exit.addActionListener(this);
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    System.out.println("화면그리기 호출");
    // 윈도우창 오른쪽 상단 X버튼을 누르면 종료 후 가상머신과 연결 끊기
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jp_center.setLayout(new BorderLayout());
    jp_center.add("Center", jsp_display);
    jp_center.add("South", jtf_input);
    jp_east.setLayout(new GridLayout(4, 1, 2, 2));
    jbtn_new.setBackground(new Color(102, 153, 102)); // 배경색
    jbtn_new.setForeground(new Color(255, 255, 255)); // 글자색
    jbtn_dap.setBackground(new Color(102, 153, 102));
    jbtn_dap.setForeground(new Color(255, 255, 255));
    jbtn_clear.setBackground(new Color(102, 153, 102));
    jbtn_clear.setForeground(new Color(255, 255, 255));
    jbtn_exit.setBackground(new Color(102, 153, 102));
    jbtn_exit.setForeground(new Color(255, 255, 255));
    jp_east.add(jbtn_new); // jp_east 패널에 jbtn_new버튼을 붙임!
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jp_center.setBackground(Color.green);
    jf.add("Center", jp_center);
    jf.add("East", jp_east); // 패널을 없애면 거기에 붙인 버튼들도 같이 안보임
    jf.setSize(300, 400);
    jf.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new ButtonArray();
  }

  @Override
  public void actionPerformed(ActionEvent e) { // 콜백메소드
    // e.getSource()는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환함
    Object obj = e.getSource();
    // 새게임
    if (jbtn_new == obj) {
      jta_display.append("▷▷▷새게임을 시작합니다.◁◁◁\n");
    }
    // 정답
    else if (jbtn_dap == obj) {
      jta_display.append("▶▶▶정답은 000입니다.◀◀◀\n");
    }
    // 화면 지우기
    else if (jbtn_clear == obj) {
      jta_display.setText("");
    }
    // 나가기
    else if (jbtn_exit == obj) {
      // jf.dispose(); // 창 하나씩 따로 닫음
      System.exit(0); // 모든 어플리케이션 닫음
    }
    // 만약 JTextField에서 무언가를 쳤다면
    if (jtf_input == obj) {
      // 사용자가 텍스트필드에 입력한 문자열을 읽어옴
      String input = jtf_input.getText();
      jta_display.append(input + "\n"); //
      jtf_input.setText(""); // input에 입력된 문자열을 지우는 역할
    }
  }
}