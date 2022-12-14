package dev_java.week3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentScore_2 implements ActionListener {
  // 선언부
  StudentScoreLogic_2 sLogic = new StudentScoreLogic_2(this);
  JFrame jf = new JFrame();
  // north, south 패널
  JPanel jp_north = new JPanel();
  JPanel jp_south = new JPanel();
  JLabel jlb_north = new JLabel("성적처리인원수: ");
  JLabel jlb_num = new JLabel("명 ");
  JTextField jtf_north = new JTextField(20);
  // 버튼만들기
  JButton jbtn_new = new JButton("만들기");
  JButton jbtn_calc = new JButton("연산");
  JButton jbtn_sample = new JButton("3명 샘플");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("종료");
  // 테이블 설정
  String[] header = { "이름", "국어", "영어", "수학", "총점", "평균", "석차" };
  String[][] datas = new String[3][7];
  DefaultTableModel dtm = new DefaultTableModel(datas, header);
  JTable jtb = new JTable(dtm);
  JScrollPane jsp = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  // 생성자
  public StudentScore_2() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    // 패널에 버튼, 텍스트추가
    jp_north.add(jlb_north);
    jp_north.add(jtf_north);
    jp_north.add(jlb_num);
    jp_north.add(jbtn_new);
    jp_south.add(jbtn_calc);
    jp_south.add(jbtn_sample);
    jp_south.add(jbtn_clear);
    jp_south.add(jbtn_exit);
    // 패널 레이아웃
    jp_north.setLayout(new FlowLayout(FlowLayout.CENTER));
    jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
    // 텍스트, 버튼 크기설정
    jtf_north.setPreferredSize(new Dimension(50, 30));
    jbtn_new.setPreferredSize(new Dimension(80, 30));
    jbtn_calc.setPreferredSize(new Dimension(80, 30));
    jbtn_sample.setPreferredSize(new Dimension(90, 30));
    jbtn_clear.setPreferredSize(new Dimension(80, 30));
    jbtn_exit.setPreferredSize(new Dimension(80, 30));
    // 텍스트 오른쪽 정렬
    jtf_north.setHorizontalAlignment(JTextField.RIGHT);
    // 이벤트 리스너 연결
    jtf_north.addActionListener(this);
    jbtn_new.addActionListener(this);
    jbtn_calc.addActionListener(this);
    jbtn_sample.addActionListener(this);
    jbtn_clear.addActionListener(this);
    jbtn_exit.addActionListener(this);
    // 창닫기 버튼 클릭시 종료처리
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // JFrame에 추가
    jf.add("North", jp_north);
    jf.add("South", jp_south);
    jf.setTitle("성적 처리");
    jf.setSize(450, 300);
    jf.setVisible(true);
  }

  public static void main(String[] args) {
    new StudentScore_2();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_new) { // 만들기
      sLogic.jTable();
      sLogic.newTable();
    } else if (obj == jbtn_calc) { // 연산
      sLogic.calcTable();
    } else if (obj == jbtn_sample) { // 3명 샘플
      sLogic.jTable();
      sLogic.sampleTable();
    } else if (obj == jbtn_clear) { // 지우기
      sLogic.clearTable();
    } else if (obj == jbtn_exit) { // 종료
      System.exit(0);
    }
  }
}