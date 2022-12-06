package dev_java.ch01;

public class String1 {

  public static void main(String[] args) {
    // String 클래스는 new를 사용하지 않고 객체를 생성하면 이미 같은 값이 존재할 때
    // 기존의 값을 참조한다.
    // 참조형 타입인 경우에만 주소번지를 비교할 수 있다.
    // 원시형 변수는 주소번지를 비교할 수 없다.
    // 참조형 변수는 new를 사용하므로 무조건 새로운 객체가 생성된다.
    String s1 = "안녕";
    String s2 = "안녕";
    String s3 = new String("안녕");
    String s4 = new String("안녕");

    // s1과 s2의 주소번지는 같을까? true
    System.out.println(s1 == s2);

    // s3과 s4의 주소번지는 같을까? false
    System.out.println(s3 == s4);

    // s3의 문자열이 s4와 같을까? true
    System.out.println(s3.equals(s4));
  }
}