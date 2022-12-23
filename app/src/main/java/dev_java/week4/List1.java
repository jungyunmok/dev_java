package dev_java.week4;

// 자바에서 제공하는 자료구조는 java.util 폴더에 있음
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class List1 {
  public static void main(String[] args) {
    // 아래는 new 생성부에 인터페이스가 와서 에러 -> 구현체 클래스가 와야함
    // List<String> nameList = new List<>();
    // DefaultTableModel객체에 데이터셋을 추가하는 메소드를 제공하는 것이 Vector
    List<String> nameList = new Vector<>(); // Vector는 멀티스레드에 안전-속도 느림
    List<String> nameList2 = new ArrayList<>(); // ArrayList는 싱글스레드에 안전(멀티x)-속도 빠룸

    System.out.println(nameList.size()); // 초기값 0
    boolean isOk = nameList.add("이순신");
    System.out.println(nameList.size()); // 1
    System.out.println(nameList.get(0)); // 이순신
    System.out.println(isOk); // true
  }
}