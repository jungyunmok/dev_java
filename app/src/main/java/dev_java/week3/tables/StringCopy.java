package dev_java.week3.tables;

public class StringCopy {
  public static void main(String[] args) {
    String str = "Hello";
    String str1 = "Hello";
    System.out.println(str == str1); // true, 주소번지가 같다
    System.out.println(str.equals(str1)); // true, 주소번지가 가리키는 값(Hello)이 같다

    String str2 = new String("Hello");
    String str3 = new String("Hello");
    System.out.println(str2 == str3); // false, new를 사용했기에 주소번지가 다르가
    System.out.println(str2.equals(str3)); // true, 그 안의 값(Hello)은 같다
  }
}