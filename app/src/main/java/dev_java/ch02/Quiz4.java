package dev_java.ch02;

// 문제 4: 구구단 2~9단 출력
public class Quiz4 {
  int i;
  int dan;

  void methodA() {
    for (dan = 2; dan < 10; dan++) {
      for (i = 1; i < 10; i++) {
        System.out.println(dan + " x " + i + " = " + dan * i);
      }
    }
  }

  public static void main(String[] args) {
    Quiz4 quiz4 = new Quiz4();
    quiz4.methodA();
  }
}