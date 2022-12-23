package dev_java.week4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApp extends JFrame implements ActionListener {
  // 선언부
  Vector<String> vSetNum = new Vector<>();
  Vector<Double> vOneNum = new Vector<>();
  double total = 0;
  JTextField jtf_display = new JTextField(10);
  JPanel jp_center = new JPanel();
  JButton jbtn_plus = new JButton("+");
  JButton jbtn_minus = new JButton("-");
  JButton jbtn_mult = new JButton("*");
  JButton jbtn_div = new JButton("/");
  JButton jbtn_equal = new JButton("=");
  JButton jbtn_clear = new JButton("C");
  JButton jbtn_one = new JButton("1");
  JButton jbtn_two = new JButton("2");
  JButton jbtn_three = new JButton("3");
  JButton jbtn_four = new JButton("4");
  JButton jbtn_five = new JButton("5");
  JButton jbtn_six = new JButton("6");
  JButton jbtn_seven = new JButton("7");
  JButton jbtn_eight = new JButton("8");
  JButton jbtn_nine = new JButton("9");
  JButton jbtn_zero = new JButton("0");
  JButton jbtn_dot = new JButton(".");
  Font f = new Font("Paryrus", Font.BOLD, 40);

  // 생성부
  public CalculatorApp() {
    initDisplay();
  }

  // 화면처리기
  public void initDisplay() {
    jbtn_clear.setForeground(Color.BLUE);
    jbtn_plus.setFont(f);
    jbtn_minus.setFont(f);
    jbtn_mult.setFont(f);
    jbtn_div.setFont(f);
    jbtn_equal.setFont(f);
    jbtn_clear.setFont(f);
    jbtn_one.setFont(f);
    jbtn_two.setFont(f);
    jbtn_three.setFont(f);
    jbtn_four.setFont(f);
    jbtn_five.setFont(f);
    jbtn_six.setFont(f);
    jbtn_seven.setFont(f);
    jbtn_eight.setFont(f);
    jbtn_nine.setFont(f);
    jbtn_zero.setFont(f);
    jbtn_dot.setFont(f);
    jp_center.setBackground(Color.cyan);
    jp_center.setLayout(new GridLayout(5, 4, 2, 2));
    jbtn_plus.addActionListener(this);
    jbtn_minus.addActionListener(this);
    jbtn_mult.addActionListener(this);
    jbtn_div.addActionListener(this);
    jbtn_equal.addActionListener(this);
    jbtn_clear.addActionListener(this);
    jbtn_one.addActionListener(this);
    jbtn_two.addActionListener(this);
    jbtn_three.addActionListener(this);
    jbtn_four.addActionListener(this);
    jbtn_five.addActionListener(this);
    jbtn_six.addActionListener(this);
    jbtn_seven.addActionListener(this);
    jbtn_eight.addActionListener(this);
    jbtn_nine.addActionListener(this);
    jbtn_zero.addActionListener(this);
    jbtn_dot.addActionListener(this);
    jp_center.add(jbtn_seven);
    jp_center.add(jbtn_eight);
    jp_center.add(jbtn_nine);
    jp_center.add(jbtn_div);
    jp_center.add(jbtn_four);
    jp_center.add(jbtn_five);
    jp_center.add(jbtn_six);
    jp_center.add(jbtn_mult);
    jp_center.add(jbtn_one);
    jp_center.add(jbtn_two);
    jp_center.add(jbtn_three);
    jp_center.add(jbtn_minus);
    jp_center.add(jbtn_zero);
    jp_center.add(jbtn_dot);
    jp_center.add(jbtn_equal);
    jp_center.add(jbtn_plus);
    jp_center.add(jbtn_clear);
    jtf_display.setEditable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add("North", jtf_display);
    this.add("Center", jp_center);
    this.setTitle("내가 만든 계산기");
    this.setSize(350, 400);
    this.setVisible(true);
  }

  // 연산 작업
  double calc(String str) {
    total = 0;
    if ("+".equals(str)) {
      for (int i = 0; i < vOneNum.size(); i++) {
        total += vOneNum.get(i);
      }
    } else if ("-".equals(str)) {
      total = vOneNum.get(0);
      for (int i = 1; i < vOneNum.size(); i++) {
        total -= vOneNum.get(i);
      }
    } else if ("*".equals(str)) {
      total = vOneNum.get(0);
      for (int i = 1; i < vOneNum.size(); i++) {
        total *= vOneNum.get(i);
      }
    } else if ("/".equals(str)) {
      total = vOneNum.get(0);
      for (int i = 1; i < vOneNum.size(); i++) {
        total /= vOneNum.get(i);
      }
    }
    return total;
  }

  // 숫자세팅
  void setNum() {
    if (vSetNum.size() != 0) {
      String sNum = vSetNum.get(0);
      for (int i = 1; i < vSetNum.size(); i++) {
        sNum += vSetNum.get(i);
      }
      vOneNum.add(Double.parseDouble(sNum));
      vSetNum.clear();
    } else {
      return;
    }
  }

  // = 연산 후 자동 지우기
  void clearDisplay() {
    if (jtf_display.getText().contains("=")) {
      jtf_display.setText(" ");
    }
  }

  public static void main(String[] args) {
    new CalculatorApp();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    // 연산자
    if (obj == jbtn_plus) {
      if (jtf_display.getText().contains("=")) {
        clearDisplay();
        jtf_display.setText(String.valueOf(total));
        vOneNum.add(total);
      }
      jtf_display.setText(jtf_display.getText() + "+");
      setNum();
    } else if (obj == jbtn_minus) {
      if (jtf_display.getText().contains("=")) {
        clearDisplay();
        jtf_display.setText(jtf_display.getText() + total);
        vOneNum.add(total);
      }
      jtf_display.setText(jtf_display.getText() + "-");
      setNum();
    } else if (obj == jbtn_mult) {
      if (jtf_display.getText().contains("=")) {
        clearDisplay();
        jtf_display.setText(jtf_display.getText() + total);
        vOneNum.add(total);
      }
      jtf_display.setText(jtf_display.getText() + "*");
      setNum();
    } else if (obj == jbtn_div) {
      if (jtf_display.getText().contains("=")) {
        clearDisplay();
        jtf_display.setText(jtf_display.getText() + total);
        vOneNum.add(total);
      }
      jtf_display.setText(jtf_display.getText() + "/");
      setNum();
    } else if (obj == jbtn_equal) {
      setNum();
      if (jtf_display.getText().contains("*")) {
        jtf_display.setText(jtf_display.getText() + " = " + calc("*"));
        vOneNum.clear();
      } else if (jtf_display.getText().contains("/")) {
        jtf_display.setText(jtf_display.getText() + " = " + calc("/"));
        vOneNum.clear();
      } else if (jtf_display.getText().contains("+")) {
        jtf_display.setText(jtf_display.getText() + " = " + calc("+"));
        vOneNum.clear();
      } else if (jtf_display.getText().contains("-")) {
        jtf_display.setText(jtf_display.getText() + " = " + calc("-"));
        vOneNum.clear();
      }
    } else if (obj == jbtn_clear) {
      jtf_display.setText("");
      vOneNum.clear();

      // 숫자와 도트
    } else if (obj == jbtn_one) {
      clearDisplay();
      String disNum = "1";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("1");
    } else if (obj == jbtn_two) {
      clearDisplay();
      String disNum = "2";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("2");
    } else if (obj == jbtn_three) {
      clearDisplay();
      String disNum = "3";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("3");
    } else if (obj == jbtn_four) {
      clearDisplay();
      String disNum = "4";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("4");
    } else if (obj == jbtn_five) {
      clearDisplay();
      String disNum = "5";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("5");
    } else if (obj == jbtn_six) {
      clearDisplay();
      String disNum = "6";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("6");
    } else if (obj == jbtn_seven) {
      clearDisplay();
      String disNum = "7";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("7");
    } else if (obj == jbtn_eight) {
      clearDisplay();
      String disNum = "8";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("8");
    } else if (obj == jbtn_nine) {
      clearDisplay();
      String disNum = "9";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("9");
    } else if (obj == jbtn_zero) {
      clearDisplay();
      String disNum = "0";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add("0");
    } else if (obj == jbtn_dot) {
      clearDisplay();
      String disNum = ".";
      jtf_display.setText(jtf_display.getText() + disNum);
      vSetNum.add(".");
    }
  }
}