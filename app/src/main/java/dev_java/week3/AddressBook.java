package dev_java.week3;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class AddressBook {
  // 선언부
  AddressDialog aDialog = new AddressDialog(this);
  JFrame jf = new JFrame();
  JPanel jp_north = new JPanel();
  JPanel jp_center = new JPanel();
  JTable jt_center = new JTable();
  JButton jbtn_read = new JButton("조회");
  JButton jbtn_write = new JButton("입력");
  JButton jbtn_update = new JButton("수정");
  JButton jbtn_info = new JButton("상세보기");

  // 생성자
  public AddressBook() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    jbtn_read.addActionListener(aDialog);
    jbtn_write.addActionListener(aDialog);
    jbtn_update.addActionListener(aDialog);
    jbtn_info.addActionListener(aDialog);
    jp_center.setBackground(Color.LIGHT_GRAY);
    jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
    jp_north.add(jbtn_read);
    jp_north.add(jbtn_write);
    jp_north.add(jbtn_update);
    jp_north.add(jbtn_info);
    jp_center.add(jt_center);
    jf.add("North", jp_north);
    jf.add("Center", jt_center);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500, 400);
    jf.setTitle("주소록 ver 1.0");
    jf.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new AddressBook();
  }
}