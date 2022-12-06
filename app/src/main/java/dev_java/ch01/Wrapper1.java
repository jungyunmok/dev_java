package dev_java.ch01;

public class Wrapper1 {

  public static void main(String[] args) {
    Integer i = new Integer(10);
    int j = i;
    System.out.println(i + 1); // int 11
    System.out.println(j + 1); // int 11

    String x = String.valueOf(j); // int를 String으로 바꿔줌
    // String y = j; // 컴파일 에러, 타입이 다름!
    String y = x;
    System.out.println(y + 1); // String 101

    if (y instanceof String) {
      System.out.println("y는 String 타입입니다.");
    }
    if (i instanceof Integer) {
      System.out.println("i는 integer타입입니다.");
    }
  }
}