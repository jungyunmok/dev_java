package dev_java.ch03;

public class Finally1 {
  public static void main(String[] args) {
    int i = 10;
    int j = 2;
    j = 0; // 에러
    j = 5; // 정상실행
    try {
      System.out.println(i / j);
    } catch (ArithmeticException e) {
      System.out.println("에러 발생: " + e.getMessage()); // 에러정보에 대한 정보출력
    } finally { // 연산결과가 정상이라도 finally구간은 무조건 실행이 된다
      System.out.println("finally는 무조건 실행이 된다.");
    }
  }
}