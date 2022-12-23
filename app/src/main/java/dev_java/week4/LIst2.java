package dev_java.week4;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class LIst2 {
  public static void main(String[] args) {
    // 자료구조를 지원하는 클래스들은 오브젝트의 존재유무, 포함여부,
    // 비어있는지 혹은 채워져 있는지 확인할 수 있는 api를 제공하고있디
    List<String> fruitList = new Vector<>();
    fruitList.add("사과");
    fruitList.add("토마토");

    boolean isExist = fruitList.contains("바나나");
    System.out.println(isExist); // false

    isExist = fruitList.contains("토마토");
    if (isExist) { // 들어있다
      System.out.println("들어있다");
    } else {
      System.out.println("들어있지 않다");
    }

    boolean isEmpty = fruitList.isEmpty();
    System.out.println(isEmpty); // false

    // Vector나 ArrayList는 오브젝트 추가, 추출 기능을 제공한다
    // Iterator는 그 안에 오브젝트의 존재유무에 중점을 둔다
    Iterator<String> iter = fruitList.iterator();
    while (iter.hasNext()) {
      String fName = iter.next();
      System.out.println(fName);
    }

    Iterator iter2 = fruitList.iterator();
    while (iter2.hasNext()) {
      // 다이아몬드 연산자<>에 타입을 명시적으로 작성하는 걸 권장
      String fName = (String) iter2.next(); // 제너릭타입을 지정하지 않으면 에러
      System.out.println(fName);
    }

    // 아래와 같이 사용할 수 없다.
    // Vector의 제네릭 타입이 String이니까 타입에러
    // Iterator<Object> iter3 = fruitList.iterator();
    Iterator<String> iter4 = fruitList.iterator(); // 타입을 맞춰야함
  }
}

// 사과
// 토마토

// 사과
// 토마토