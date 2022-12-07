package dev_java.ch03;

import java.util.Arrays;

public class Array3 {
  public static void main(String[] args) {
    int i[] = { 1, 2, 3 }; // 선언, 생성, 초기화
    int j[]; // 선언만하고 생성은안됨
    j = i; // j에 i대입, 동시에 같은 객체 사용 가능(공유가능)
    int k[]; // 선언, 공간할당x
    k = new int[3]; // 생성, 디폴트값 0
    // k = new int[] { 1, 2, 3 }; // 생성과 초기화해줌
    j = k; // 다시 k 대입
    // insert here
    System.out.println(i);
    System.out.println(j); // k와 같은 주소번지
    System.out.println(k);
    System.out.println(Arrays.toString(i));
    System.out.println(Arrays.toString(j));
    System.out.println(Arrays.toString(k));
    System.out.println(i.length);
    System.out.println(j.length);
    System.out.println(k.length); // 배열의 길이 length

    String s1 = "안녕";
    String s2 = s1;
    System.out.println(s2);
    System.out.println(s2.length()); // 문자열의 길이 length()
  }
}
