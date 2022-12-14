package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonUIEvent implements ActionListener {
  JButtonUI jbUI = null;

  public JButtonUIEvent(JButtonUI jButtonUI) {
    this.jbUI = jButtonUI;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbUI.jbtn_south) {
      System.out.println(jbUI.jbtn_south.getText() + "버튼 클릭");
    }
  }
}