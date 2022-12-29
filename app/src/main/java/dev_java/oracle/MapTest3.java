package dev_java.oracle;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// 회원정보 담기
public class MapTest3 {
  public static void main(String[] args) {
    List<Map<String, Object>> list = new ArrayList<>();
    System.out.println(list); // []
    // 회원아이디, 이름, 비밀번호, 성별
    // mem_id, mem_name, mem_pw, mem_gender
    // tomato, 토마토, 123, 남자
    // banana, 바나나, 456, 여자
    // kiwi, 키위, 789, 남자
    Map<String, Object> pMap = new HashMap<>();
    pMap.put("mem_id", "tomato");
    pMap.put("mem_name", "토마토");
    pMap.put("mem_pw", 123);
    pMap.put("mem_gender", "남자");
    list.add(pMap);
    System.out.println(pMap); // {mem_gender=남자, mem_pw=123, mem_name=토마토, mem_id=tomato}
    System.out.println(list); // [{mem_gender=남자, mem_pw=123, mem_name=토마토, mem_id=tomato}]
    System.out.println(list.get(0)); // Map출력
    System.out.println(list.get(0).get("mem_name")); // 토마토, Map의 "mem_name"키 값 출력
    System.out.println(list.get(0).get("mem_pw")); // 123, Map의 "mem_pw"키 값 출력
    pMap = new HashMap<>();
    pMap.put("mem_id", "banana");
    pMap.put("mem_name", "바나나");
    pMap.put("mem_pw", 456);
    pMap.put("mem_gender", "여자");
    list.add(pMap);
    pMap = new HashMap<>();
    pMap.put("mem_id", "kiwi");
    pMap.put("mem_name", "키위");
    pMap.put("mem_pw", 789);
    pMap.put("mem_gender", "남자");
    list.add(pMap);
  }
}