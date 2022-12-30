package dev_java.week6;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class S1 {
  int age = 30;
}

class S2 {
  String animal = "사자";
  int leg = 4;
}

class S3 {
  // 복습-3개짜리 클래스 설계
}

public class MapTest1 {
  List<Map<String, Object>> list = null;

  public static void main(String[] args) {
    S1 s1 = new S1();
    System.out.println(s1.age); // 30
    Map<String, Object> map1 = new HashMap<>();
    Map<String, String> map1_1 = new HashMap<>();
    Map<String, Object> map2 = new Hashtable<>();
    map1.put("s1", s1);
    // map1_1.put("s1", s1); // 타입이 다른 값을 담을 수 없다

    System.out.println(map1.get("s1")); // 객체 주소가 출력됨
    S1 s1_1 = (S1) map1.get("s1"); // 그 주소를 s2에 넣어줌, 강제형변환
    System.out.println(s1_1.age); // 30, 해당 주소의 age변수 호출

    S2 s2 = new S2();
    map2.put("s2", s2);
    S2 s2_1 = (S2) map2.get("s2");
    System.out.println(s2_1.animal); // 사자
    System.out.println(s2_1.leg); // 4
    
    if (s2_1.animal instanceof String) {
      System.out.println(s2_1.animal + "는 문자열입니다."); // 사자는 문자열입니다.
    }
    // Deprecated
    if (new Integer(s2_1.leg) instanceof Integer) {
      System.out.println(s2_1.leg + "는 정수형 입니다."); // 4는 정수형 입니다.
    }
  }
}