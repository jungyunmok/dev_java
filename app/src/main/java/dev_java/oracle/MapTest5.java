package dev_java.oracle;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MapTest5 {
  public static void main(String[] args) {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> rMap = new HashMap<>();
    rMap.put("mem_id", "tomato");
    System.out.println(rMap); // {mem_id=tomato}
    list.add(rMap);

    rMap = new HashMap<>();
    rMap.put("mem_id", "apple");
    System.out.println(rMap); // {mem_id=apple}
    list.add(rMap);

    // insert here 굳이 tomato를 출력하려면?
    System.out.println(list.get(0).get("mem_id")); // tomato
    System.out.println(list.get(1).get("mem_id")); // apple

    rMap = new HashMap<>();
    System.out.println(rMap); // {}
  };
}