package dev_java.ch02;

// 문제 2: 1부터 10까지 세면서 짝수의 합을 구하는 프로그램을 작성하시오.
public class Quiz2 {
  int i = 1;
  int count;

  void methodA() { // for문
    for (; i <= 10; i++) {
      if (i % 2 == 0) { // 짝수일 경우
        count += i;
        System.out.println("count: " + count + ", i: " + i); // 과정 표시
      }
    }
    System.out.printf("count: %d, i: %d %n", count, i); // 결과 30, 11
    System.out.println();
  }

  void methodB() { // while문
    i = 1; // 초기화
    count = 0; // 초기화
    while (i <= 10) {
      if (i % 2 == 0) {
        count += i;
        System.out.println("count: " + count + ", i: " + i); // 과정 표시
      }
      i++;
    }
    System.out.println(count); // 결과 30
  }

  public static void main(String[] args) {
    Quiz2 quiz2 = new Quiz2();
    quiz2.methodA(); // 30
    quiz2.methodB(); // 30
  }
}
