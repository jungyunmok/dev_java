package dev_java.week3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameView_2 implements ActionListener {
  RandomGameLogic_2 rgLogic = new RandomGameLogic_2(this);
  // 선언부
  JFrame jf = new JFrame();
  JLabel jl = new JLabel("1~9 사이의 숫자를 입력해주세요.");
  // 중앙에 붙임
  JTextArea jta_display = new JTextArea(10, 20);
  JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  // 남쪽에 붙임
  JTextField jtf_input = new JTextField(5);

  // 생성자
  public RandomGameView_2() {
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    // 이벤트 리스너 연결
    jtf_input.addActionListener(this);
    jta_display.setEditable(false);
    // JFrame에 추가
    jf.add("Center", jsp_display);
    jf.add("South", jtf_input);
    jf.add("North", jl);
    // 라벨 중앙 정렬
    jl.setHorizontalAlignment(JLabel.CENTER);
    // 창닫기 버튼 클릭시 종료처리
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jtf_input.requestFocus();
    jf.setSize(300, 400);
    jf.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new RandomGameView_2();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jtf_input) {
      rgLogic.gameMethod();
    }
  }
}