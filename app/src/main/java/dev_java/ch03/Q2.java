package dev_java.ch03;

public class Q2 {
  int i = 1;

  void methodA() {
    while (i <= 20) {
      if (i % 5 == 0) {
        System.out.println(i + ": 5의 배수입니다.");
      } else {
        System.out.println(i + ": 5의 배수가 아닙니다.");
      }
      i++;
    }
  }

  void methodB() { // for, switch문으로 변경
    for (i = 0; i <= 20; i++) {
      switch (i) {
        case 5:
        case 10:
        case 15:
        case 20:
          System.out.println(i + ": 5의 배수입니다.");
          break;
        default:
          System.out.println(i + ": 5의 배수가 아닙니다.");
      }
    }
  }
  public static void main(String[] args) {
    Q2 q = new Q2();
    q.methodA();
    System.out.println("========");
    q.methodB();
  }
}