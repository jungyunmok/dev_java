package dev_java.week3.tables;

import java.util.Vector;

public class Vector2 {
  public static void main(String[] args) {
    Vector<String> v = new Vector<>();
    v.add("사과"); // 인덱스0
    v.add("토마토"); // 인덱스1
    v.add(1, "바나나"); // 인덱스1에 바나나넣기(배열과 다르게 끼워넣기 가능)
    for (int i = 0; i < v.size(); i++) {
      System.out.println(v.get(i)); // 사과, 바나나, 토마토
    }
  }
}