package dev_java.week3;

public class JTextAreaUILogic {
  // 여기서 직접 인스턴스화하면 복제본이 만들어짐-복제본에 출력된다
  // 메모리 StackOverFlow발생-서버가 중지됨
  // JTextArea jta = new JTextArea(10, 20); // 복제본이 생성되서 원본작동x + 서버부담
  JTextAreaUI jtaUI = null;

  public JTextAreaUILogic(JTextAreaUI u1) {
    // 생성자 안에서 JTextAreaUI의 JTextArea원본과 전역변수를 초기화해줘야함
    this.jtaUI = u1;
  }

  public void account(String input) {
    // JTextAreaUI클래스에 정의된 주소번지(원본)를 사용
    jtaUI.jta.append("UILogic: " + input + "\n");
  }
}