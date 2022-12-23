package dev_java.tables;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// JDialog도 디폴트가 BorderLayout임-JP_center를 중앙에 배치
public class JTable7Dialog extends JDialog {
  // 선언부
  JPanel jp_center = new JPanel();
  JScrollPane jsp_center = new JScrollPane(jp_center);
  JPanel jp_south = new JPanel();
  JLabel jlb_deptNo = new JLabel("부서번호");
  JTextField jtf_deptNo = new JTextField(10);
  JLabel jlb_deptName = new JLabel("부서명");
  JTextField jtf_deptName = new JTextField(20);
  JLabel jlb_deptLoc = new JLabel("지역");
  JTextField jtf_deptLoc = new JTextField(20);
  // jp_south속지에 버튼 붙임
  JButton jbtn_save = new JButton("저장");
  JButton jbtn_close = new JButton("닫기");

  // 생성자
  public JTable7Dialog() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    // 레이아웃 설정
    jp_center.setLayout(null);
    jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
    jlb_deptNo.setBounds(20, 20, 80, 20);
    jtf_deptNo.setBounds(120, 20, 80, 20);
    jlb_deptName.setBounds(20, 45, 100, 20);
    jtf_deptName.setBounds(120, 45, 150, 20);
    jlb_deptLoc.setBounds(20, 70, 100, 20);
    jtf_deptLoc.setBounds(120, 70, 150, 20);
    jp_center.add(jlb_deptNo);
    jp_center.add(jtf_deptNo);
    jp_center.add(jlb_deptName);
    jp_center.add(jtf_deptName);
    jp_center.add(jlb_deptLoc);
    jp_center.add(jtf_deptLoc);
    jp_south.add(jbtn_save);
    jp_south.add(jbtn_close);
    this.add("Center", jsp_center);
    this.add("South", jp_south);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(400, 360);
    this.setVisible(true);
  }

  // 메인
  public static void main(String[] args) {
    new JTable7Dialog();
  }
}