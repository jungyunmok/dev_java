package dev_java.week4;

import java.util.Map;
import java.util.Vector;

public class Vector1_2 {
  public static void main(String[] args) {
    // 2중(outter = Vector -> size(), inner = String[] -> length) for문으로 처리
    // Vector는 끼워넣기가 가능, 수정에대한 API제공은 없다-클라우드 기반 데이터베이스 제품들이 이런방식
    Vector<String[]> v = new Vector<>();
    // Vector<Map<String, Object>> v3 = new Vector<>(); // 실무 사용 패턴!
    // 현재 크기는 0
    String temp[] = { "10", "개발부", "서울" };
    v.add(temp); // 인덱스0에 끼워넣기
    temp = new String[] { "20", "총무부", "인천" };
    v.add(temp); // 인덱스1에 끼워넣기

    // for (int i = 0; i < v.size(); i++) { // row의 수, 2번 반복됨
    // String[] result = v.get(i);
    // for (int j = 0; j < temp.length; j++) { // column의 수, 3번 반복됨
    // System.out.print(result[j] + " ");
    // }
    // System.out.println();
    // }

    // 단일 for문으로 처리 가능
    Vector<String> v2 = new Vector<>();
  }
}