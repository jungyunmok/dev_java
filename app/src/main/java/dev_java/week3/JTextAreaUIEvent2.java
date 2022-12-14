package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUIEvent2 implements ActionListener {
  JTextAreaUI2 jUI2 = null;

  public JTextAreaUIEvent2(JTextAreaUI2 jUI2) {
    this.jUI2 = jUI2;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (jUI2.jtf == obj) {
      String input = jUI2.jtf.getText();
      jUI2.getTextArea().append("JTextAreaUI원본: " + input + "\n");
      jUI2.jLogic2.account(input);
      jUI2.jtf.setText("");
    }
  }
}