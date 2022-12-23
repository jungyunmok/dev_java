package dev_java.tables;

import java.util.Vector;

public class Vector1 {
  public static void main(String[] args) {
    Vector v = new Vector(); // <>안의 타입을 명시하지 않음(불편함)
    Vector<String> v2 = new Vector<>(); // 벡터는 오브젝트 단위로 담을 수 있다
    v2.add("안녕");
    v2.add("2");
    Vector<Integer> v3 = new Vector<>(); // 원시형은 안되지만 래퍼클래스는 가능
    Vector<DeptVO> v4 = new Vector<>(); // 3차배열은 안쓴다(직관적x)

    // v.add(1); // 오토박싱, v.add(new Integer(1))와 같음(int를 Integer로)
    v.add("안녕"); // v.get(0)
    v.add(1); // v.get(1)
    System.out.println(v.size()); // 2
    System.out.println(v.get(0)); // 안녕
    System.out.println(v.get(1)); // 1

    String insa = (String) v.get(0); // 타입이 안맞음!, 강제형전환 필요
    System.out.println(insa); // 안녕
    String insa2 = v2.get(0);
    System.out.println(insa2); // 안녕

    if (v.get(1) instanceof Integer) {
      System.out.println("정수형입니다.");
    }
    if (v.get(0) instanceof String) {
      System.out.println("문자열입니다.");
    }
  }
}