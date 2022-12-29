package dev_java.oracle;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class MapTest1 {
  Map<String, Object> rMap = new HashMap<>(); // rMap.size() = 0

  public void setMap() {
    rMap.put("deptno", 10);
    rMap.put("dname", "인사부");
    rMap.put("loc", "서울");
    rMap.put("loc", "부산"); // 같은 키값에 넣으면 기존값은 없어지고 새로운 값으로 대체됨
  }

  public static void main(String[] args) {
    MapTest1 mt1 = new MapTest1();
    mt1.setMap();
    System.out.println(mt1.rMap.size()); // 3

    // Map에서 제공하는 메소드 중에서 Key값을 묶음처리하는 메소드가 있음
    Set<String> set = mt1.rMap.keySet();
    // Set인터페이스가 제공하는 메소드 중에서 toArray() 지원함
    Object obj[] = set.toArray(); // deptno, dname, loc
    for (int i = 0; i < obj.length; i++) { // obj.length는 배열의 원소 수 -> 3(deptno, dname, loc)
      String key = (String) obj[i]; // 배열에서 꺼낸 값은 key값이다 - deptno, dname, loc
      System.out.println("key: " + key); // 3번 출력됨 -> 순서는 랜덤
    }
    System.out.println("====================");

    Iterator<String> iter = set.iterator();
    while (iter.hasNext()) { // 자료구조 안에 값이 있는지 체크해서 있으면 true 반환, 없으면 false 반환
      String key = iter.next();
      // String value = (String)mt1.rMap.get(key);
      Object value = mt1.rMap.get(key);
      System.out.println(key + ": " + value);
    }
  }
}