package dev_java.basic1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExam1 {
  public static void main(String[] args) {
    // List따로 Map따로 사용하는 경우보다는 주로 List<Map<>>꼴로 많이 사용됨
    // 오라클에서 제공하는 테이블 구조에서 튜플을 구성하 때 Map을 사용 가능함
    // Member테이블 기준-id, pw, nickname
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> pMap = new HashMap<>();
    pMap.put("mem_id", "kiwi");
    pMap.put("mem_pw", "123");
    pMap.put("mem_nick", "나초보");
    System.out.println(pMap);
    list.add(pMap); // list.get(0)

    pMap = new HashMap<>(); // 새로운 주소번지가 할당됨
    pMap.put("mem_id", "tomato");
    pMap.put("mem_pw", "123");
    pMap.put("mem_nick", "나신입");
    System.out.println(pMap);
    list.add(pMap); // list.get(1)

    pMap = new HashMap<>();
    pMap.put("mem_id", "banana");
    pMap.put("mem_pw", "123");
    pMap.put("mem_nick", "나일등");
    System.out.println(pMap);
    list.add(pMap); // list.get(2)

    // Map의 키값은 DB테이블의 컬럼명과 통일하기 -> 권장
    // 키값을 출력-mem_id, mem_pw, mem_nick
    // Object key[] = pMap.keySet().toArray();
    // for (Object s : key) {
    // System.out.print(s.toString() + ": ");
    // System.out.println(pMap.get(s));
    // }
    for (int i = 0; i < list.size(); i++) {
      Map<String, Object> rMap = list.get(i);
      System.out.println(rMap.get("mem_id") + ", " + rMap.get("mem_pw") + ", " + rMap.get("mem_nick"));
    }
  }
}