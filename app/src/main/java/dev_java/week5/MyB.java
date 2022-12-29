package dev_java.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// List - java.util.List(Interface) - ArrayList, Vector
public class MyB {
  // lm이 vm보다 받아줄 수 있는 타입의 종류가 많다
  // List는 interface이고, Vector와 ArrayList는 List의 구현체 클래스니까
  void lm(List<String> myNames) {
    System.out.println("==========[List<String>]==========");
    for (String s : myNames) {
      System.out.println(s);
    }
  }

  void vm(Vector<String> myNames) {
    System.out.println("==========[Vector<String>]==========");
    for (String s : myNames) {
      System.out.println(s);
    }
  }

  // JVM에서 제공하는 List에 대해서 구현체클래스가 여러가지 있다
  // 선언부와 생성부의 타입이 서로 다를 수 있다 -> 권장사항
  // 권장하는 이유 -> 2가지 선택지가 있다(아래의 경우 List와 Vector)
  public static void main(String[] args) {
    MyB myB = new MyB();
    ArrayList<String> nickNames = new ArrayList<>();
    nickNames.add("토마토");
    nickNames.add("키위");
    nickNames.add("사과");
    Vector<String> nickNames2 = new Vector<>();
    nickNames2.add("바나나");
    nickNames2.add("포도");
    nickNames2.add("딸기");
    List<String> nickNames3 = new Vector<>();
    nickNames3.add("사자");
    nickNames3.add("호랑이");
    nickNames3.add("표범");
    myB.lm(nickNames);
    myB.lm(nickNames2);
    myB.lm(nickNames3);
    // myB.vm(nickNames); // Vector에 ArrayList를 담을 수 없다
    myB.vm(nickNames2);
    // myB.vm(nickNames3); // List타입이기에 담을 수 없다
    // 범위, scope가 작으니까/타입이 다르니까/Vector가 List보다 더 구체적이니까)
  }
}