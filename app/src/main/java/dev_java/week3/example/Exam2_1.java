package dev_java.week3.example;

// 두 개의 정수 중에서 큰 숫자를 반환하는 max함수를 구현하세요. 두 개의 정수를 입력 받고 큰 숫자를 출력합니다.
// 출력) 정수(두 개) : 5 8 최대값 : 8
public class Exam2_1 {
  int max(int n1, int n2) {
    return (n1 > n2) ? n1 : n2; // 삼항연산자 사용
  }

  public static void main(String[] args) {
    Exam2_1 ex2 = new Exam2_1();
    // 두 개의 정수 중에서 큰 숫자를 반환하는 함수 호출
    System.out.println(ex2.max(3, 5));
  }
}