package dev_java.oracle;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class MapTest2 {
  List<Map<String, Object>> list = new ArrayList<>();
  Map<String, Object> rMap = new HashMap<>();

  public void setMap() {
    rMap.put("deptno", 10);
    rMap.put("dname", "인사부");
    rMap.put("loc", "서울");
    list.add(rMap);
    rMap = new HashMap<>();
    rMap.put("deptno", 20);
    rMap.put("dname", "개발부");
    rMap.put("loc", "부산");
    list.add(rMap);
    rMap = new HashMap<>();
    rMap.put("deptno", 30);
    rMap.put("dname", "총무부");
    rMap.put("loc", "제주");
    list.add(rMap);
  }

  public void mapPrint() {
    // 각 로우안에 key가 3개있다(컬럼-deptno, dname, loc)
    // Map m1 = get(0); 컬럼3개, Map m2 = get(1);컬럼 3개, Map m3 = get(2);컬럼 3개
    // 아래에서 반복해야 하는 건 List이다(ArrayList)
    for (int i = 0; i < list.size(); i++) { // 반복해서 처리할 것은 로우값
      Map<String, Object> m1 = list.get(i);
      // 컬럼의 수를 반복해서 출력하기
      Object[] keys = m1.keySet().toArray();
      for (int j = 0; j < keys.length; j++) {
        String key = (String) keys[j];
        System.out.print(m1.get(key) + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    MapTest2 mt2 = new MapTest2();
    mt2.setMap();
    // Map의 size는 세로방향(컬럼의 수)이다
    System.out.println(mt2.rMap.size()); // 3
    mt2.mapPrint();
  }
}