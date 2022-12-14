package dev_java.view.array;

public class AccountSample {
  ButtonArray_2 ba2 = null; // 생성은 x,초기화, 원래 주소번지가 필요한 것

  public AccountSample(ButtonArray_2 ba2) {
    this.ba2 = ba2;
  }

  public String account() {
    return "낮춰라";
  }

  public void account2() {
    String msg = "낮춰라"; // 상수
    // jta_display는 ButtonArray_2에서 생성된 객체인데
    // 굳이 AccountSample
    ba2.jta_display.append(msg + "\n");
  }
}
