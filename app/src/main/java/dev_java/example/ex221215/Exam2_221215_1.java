package dev_java.example.ex221215;

// ***연습문제2***
// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
// *출력)
// *배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
// *음수합 : -24
// *양수합 : 17
public class Exam2_221215_1 {
  int users[] = null;
  int plus;
  int minus;

  // size를 넣으면 그만큼의 랜덤한 숫자가 나오는 메소드
  void setArray(int size) {
    users = new int[size];
    for (int i = 0; i < size; i++) {
      users[i] = (int) (Math.random() * 21) - 10;
      System.out.print(users[i] + " ");
    }
    System.out.println();
  }

  // 각 양수, 음수끼리 더해주는 메소드
  void total() {
    plus = 0;
    minus = 0;
    for (int i = 0; i < users.length; i++) {
      if (users[i] < 0) {
        minus += users[i];
      } else if (users[i] > 0) {
        plus += users[i];
      }
    }
  }

  // 더해진 양수, 음수를 출력하는 메소드
  void result() {
    System.out.println("음수합: " + minus);
    System.out.println("양수합: " + plus);
  }

  public static void main(String[] args) {
    Exam2_221215_1 ex2 = new Exam2_221215_1();
    ex2.setArray(10);
    ex2.total();
    ex2.result();
  }
}