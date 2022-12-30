package dev_java.week5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;

public class RepaintEx extends JFrame implements ActionListener {
  Container con = this.getContentPane();
  JPanel jp_north = new JPanel();
  JPanel jp_center = new JPanel();
  JTextArea jta = new JTextArea("기본 JTextArea", 10, 20);
  JButton jbtn1 = new JButton("기본창");
  JButton jbtn2 = new JButton("대화방");
  JButton jbtn3 = new JButton("con");

  public RepaintEx() {
    initDisplay();
  }

  public void initDisplay() {
    jbtn1.addActionListener(this);
    jbtn2.addActionListener(this);
    jbtn3.addActionListener(this);
    jp_north.add("North", jbtn1);
    jp_north.add("North", jbtn2);
    jp_north.add("North", jbtn3);
    jp_center.add(jta);
    this.add("North", jp_north);
    this.add("Center", jp_center);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBackground(Color.GREEN);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  void view1() {
    jp_center.removeAll();
    jp_center.setBackground(Color.MAGENTA);
    this.revalidate();
  }

  void view2() {
    jp_center.removeAll();
    jp_center.setBackground(Color.ORANGE);
    this.revalidate();
  }

  void view3() {
    con.removeAll();
    JPanel jp1 = new JPanel();
    this.add("Center", jp1);
    jp1.setBackground(Color.blue);
    this.revalidate();
  }

  public static void main(String[] args) {
    new RepaintEx();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn1) {
      view1();
    } else if (obj == jbtn2) {
      view2();
    } else if (obj == jbtn3) {
      view3();
    }
  }
}