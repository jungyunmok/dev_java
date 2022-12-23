package dev_java.tables;

import java.util.Vector;

public class Vector3 {
  public static void main(String[] args) {
    // 객체는 생성되었으나 방은 없다
    Vector<Integer> v = new Vector<>();
    // 그렇기에 0이 출력
    System.out.println("사이즈 " + v.size()); // 0
    // 비어있으니 true
    System.out.println(v.isEmpty()); // true
    System.out.println("==========");

    // add해야 공간이 생기고 그 안에 값을 넣음, 인덱스0
    v.add(1);
    // 다시 1을 추가하고 변수에 대입, 인덱스1
    boolean isExist = v.add(1);
    // 사이즈는 2
    System.out.println("사이즈 " + v.size()); // 2
    // 인덱스0에 든 건 1
    System.out.println("인덱스0의값 " + v.get(0)); // 1
    // 인덱스1에 든 건 1
    System.out.println("인덱스1의값 " + v.get(1)); // 1
    // 벡터안에 값이 들어가있음
    System.out.println(isExist); // true
    // 비어있지 않음
    System.out.println(v.isEmpty()); // false
    // 값 1이 들어있음
    System.out.println(v.contains(1)); // true
    // 값 2는 들어있지 않음
    System.out.println(v.contains(2)); // false
    System.out.println("==========");

    // 인덱스1의 값에 2를 추가
    v.add(1, 2);
    // 값 2가 들어있음
    System.out.println(v.contains(2)); // true
    // 인덱스1에 2가 들어감
    System.out.println("인덱스1의값 " + v.get(1)); // 2
    // 인덱스2에 1이 들어감
    System.out.println("인덱스2의값 " + v.get(2)); // 1
    System.out.println("==========");

    // 인덱스 1의 값 2를 지움
    System.out.println(v.remove(1)); // 2
    // 크기는 2
    System.out.println("사이즈 " + v.size()); // 2
    // 하지만 2는 들어있지 않음
    System.out.println(v.contains(2)); // false
  }
}