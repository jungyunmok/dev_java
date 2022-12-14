package dev_java.ch03;

public class Test2 {
  void methodA() {
    int i = 1;
    while (i <= 10) {
      if (i % 3 == 0) {
        System.out.println(i + ": 3의 배수입니다.");
      } else if (i % 3 != 0) {
        System.out.println(i + ": 3의 배수가 아닙니다.");
      }
      i++;
    } // end of while
  } // end of methodA()

  void methodB() {
    for (int i = 1; i <= 10; i++) {
      switch (i % 3) {
        case 0:
          System.out.println(i + ": 3의 배수입니다.");
          break;
        case 1, 2:
          System.out.println(i + ": 3의 배수가 아닙니다.");
          break;
      }
    }
  }

  public static void main(String[] args) {
    Test2 t2 = new Test2();
    t2.methodA();
    System.out.println("==========");
    t2.methodB();
  }
}