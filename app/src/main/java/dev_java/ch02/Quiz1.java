package dev_java.ch02;

// 문제 1: 1부터 10까지의 합을 구하는 프로그램을 작성하시오.
public class Quiz1 {
  // 1씩 세는 변수 i, 합을 담을 변수 count 선언 및 초기화
  int i = 1; // 전역변수
  int count; // 초기화 생략, 디폴트값 0

  void methodA() { // for문
    for (; i <= 10; i++) { // 초기화(위의 전역변수가 있기에 생략함); 조건식; 증감연산자
      count += i;
      System.out.println("count: " + count + ", i: " + i);
    }
    System.out.println("count: " + count);
    System.out.println();
  }

  void methodB() { // while문
    i = 1; // 다른 메소드의 영향 없애기위해 초기화
    count = 0; // 초기화
    while (i <= 10) {
      count += i;
      System.out.println("count: " + count + ", i: " + i);
      i++;
    }
    System.out.println("count: " + count);
  }

  public static void main(String[] args) {
    Quiz1 quiz1 = new Quiz1();
    quiz1.methodA(); // 55
    quiz1.methodB(); // 55
  }
}