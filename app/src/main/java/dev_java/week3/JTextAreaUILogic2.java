package dev_java.week3;

public class JTextAreaUILogic2 {
  JTextAreaUI2 jUI2 = null;

  public JTextAreaUILogic2(JTextAreaUI2 jUI2) {
    this.jUI2 = jUI2;
  }

  public void account(String input) {
    jUI2.jta.append("UILogic: " + input + "\n");
  }
}