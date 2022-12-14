package dev_java.week3;

public class Main {
  int i = 1;

  public static void main(String[] args) {
    Sub sub = new Sub(); // 디폴트 생성자 호출
    System.out.println(sub.j); // j는 전역변수
    sub.methodA();
  }
}