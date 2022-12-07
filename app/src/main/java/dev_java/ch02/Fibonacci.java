package dev_java.ch02;

// 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고
// a1에서 a10번째 항까지 출력되도록 해보시오.
public class Fibonacci {
  int i = 0;
  int j = 1;
  int sum = 1;

  void methodA() { // 내가 만든 코드
    for (int count = 1; count <= 10; count++) {
      System.out.println("a" + (count) + ": " + sum);

      sum = i + j;
      i = j;
      j = sum;
    }
  }

  void methodB() {
    int a1 = 1;
    int a2 = 1;
    int a3 = 0;
    System.out.print(a1 + " " + a2 + " ");
    for (int i = 0; i < 8; i++) {
      a3 = a2 + a1;
      System.out.print(a3 + " ");
      a1 = a2;// 두번째 수를 세번째수로
      a2 = a3;// 현재의 수를 첫번째수로
    }
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    f.methodA();
    f.methodB();
  }
}