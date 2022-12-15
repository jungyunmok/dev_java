package dev_java.week3.example;

import java.util.Random;

// ***연습문제2***
// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
// *출력)
// *배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
// *음수합 : -24
// *양수합 : 17
public class Exam2_221215_1 {
  Random random = new Random();

  void methodA() {
    int users[] = new int[10];
    for (int i = 0; i < users.length; i++) {
      users[i] = (int) (Math.random() * 21) % 22 - 10;
      System.out.print(users[i] + " ");
    }
  }

  public static void main(String[] args) {
    Exam2_221215_1 ex2 = new Exam2_221215_1();
    ex2.methodA();
  }
}