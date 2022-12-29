package dev_java.oracle;

import java.util.Map;
import java.util.HashMap;

public class MapTest4 {
  public static void main(String[] args) {
    Map<String, Object> rMap = new HashMap<>();
    rMap.put("mem_id", "tomato");
    System.out.println(rMap);
    rMap = new HashMap<>(); // 새로운 객체가 생성됨(타입만 같음)
    rMap.put("mem_id", "apple");
    System.out.println(rMap);
    rMap = new HashMap<>();
    System.out.println(rMap);
  };
}

// {mem_id=tomato}
// {mem_id=apple}
// {}