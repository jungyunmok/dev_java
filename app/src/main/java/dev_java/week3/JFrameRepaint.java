package dev_java.week3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

// 공부-가비지 컬렉터, Candidate상태, System.gc(); -쓰레기값 치우기
public class JFrameRepaint extends JFrame implements ActionListener {
  JPanel jp = new JPanel();
  JTextArea jta = new JTextArea("여기는 JTextArea", 10, 20);
  JButton jbtn = new JButton("화면변경");

  public JFrameRepaint() {
    initDisplay();
  }

  public void initDisplay() {
    jbtn.addActionListener(this);
    jp.setLayout(new BorderLayout());
    jp.add("Center", jta);
    this.add("Center", jp);
    this.add("North", jbtn);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new JFrameRepaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn) {
      Container con = this.getContentPane();
      if (jp != null) {
        con.remove(jp);
        con.remove(jbtn);
      }
      JPanel jp1 = new JPanel();
      jp1.setBackground(Color.ORANGE);
      this.add("Center", jp1); // JFrame을 상속받았기에 this로 JFrame기능 사용
      con.revalidate();
    }
  } // end of actionPerformed
} // end of JFrameRepaint