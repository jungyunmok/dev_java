package dev_java.ch03;

public class Q56_elseIf {
  public static void main(String[] args) {
    String str = "null"; // 문자열 "null"
    if (str == null) { // null값일 경우!
      System.out.println("null");
    }
    // else if로 써야 정상출력됨, else는 뒤에 조건x!!
    // } else (str.length() == 0) { // "null"의 길이는 4이니 false
    // System.out.println("zero");
    else {
      System.out.println("some");
    } // 이대로 실행하면 문법에러(컴파일에러)-else뒤에 조건, else가 2개이기에
    // 만약 중간이 else if라면 정상적으로 some이 출력됨
  }
}
