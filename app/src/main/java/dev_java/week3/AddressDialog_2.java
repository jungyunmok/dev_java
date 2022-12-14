package dev_java.week3;

import javax.swing.JDialog;

public class AddressDialog_2 {
  JDialog jDg = new JDialog();

  public AddressDialog_2() {
    initDisplay();
  }

  public void initDisplay() {
    jDg.setSize(400, 300);
    jDg.setVisible(false); // 상수
  }

  public void setDialodg(String title, boolean isView) { // 변수로 대체
    jDg.setTitle(title);
    jDg.setVisible(isView);
  }
}