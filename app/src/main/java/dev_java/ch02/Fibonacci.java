package dev_java.ch02;

// 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고
// a1에서 a10번째 항까지 출력되도록 해보시오.
public class Fibonacci {
  int i = 0;
  int j = 1;
  int sum = 1;

  void methodA() {
    for (int count = 1; count <= 10; count++) {
      System.out.println("a" + (count) + ": " + sum);

      sum = i + j;
      i = j;
      j = sum;
    }
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    f.methodA();
  }
}