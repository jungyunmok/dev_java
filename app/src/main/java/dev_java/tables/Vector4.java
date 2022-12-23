package dev_java.tables;

import java.util.Vector;

public class Vector4 {
  void methodA() {
    String fruits[] = { "키위", "포도", "사과" };
    Vector<String> vFruits = new Vector<>();
    for (int i = 0; i < fruits.length; i++) {
      vFruits.add(i, fruits[i]);
    }

    // 인덱스1에 토마토 추가 -> 1번 이후는 하나씩 밀림
    vFruits.add(1, "토마토");

    // 포도 삭제 (포도는 원래 인덱스1 -> 토마토 추가되서 인덱스2로 밀림 -> 인덱스2삭제)
    // vFruits.remove(2);

    // vFruits 출력
    for (int i = 0; i < vFruits.size(); i++) {
      // if문으로 "포도"가 포함되어있다면 지우도록 설정
      if (vFruits.contains("포도")) {
        vFruits.remove("포도");
      }
      System.out.print(vFruits.get(i) + " ");
    }
  }

  void methodB() {
    // 좋아하는 과일만 골라서 Vector에 담기
    String fruits[] = { "키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아" };
    Vector<String> vFruits = new Vector<>();
    for (int i = 0; i < fruits.length; i++) {
      vFruits.add(i, fruits[i]);
    }

    // vFruits 출력
    for (int i = 0; i < vFruits.size(); i++) {

      if (vFruits.contains("사과") || vFruits.contains("파인애플")) {
        vFruits.remove("사과");
        vFruits.remove("파인애플");
      }
      System.out.print(vFruits.get(i) + " ");
    }
  }

  void methodC() {
    // 과일가게의 진열 상품
    String fruits[] = { "키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아" };
    // 내가 사고싶은 과일이름
    String myFruits[] = { "딸기", "체리", "바나나", "살구", "키위" };
    // 구입할 과일만 골라서 Vector에 담기
    Vector<String> vFruits = new Vector<>();
    for (int i = 0; i < fruits.length; i++) {
      for (int j = 0; j < myFruits.length; j++) {
        if (fruits[i].equals(myFruits[j])) {
          vFruits.add(fruits[i]);
        }
      }
    } // end of for
    // 구매한 과일 출력
    System.out.print("구매한 과일: ");
    for (String f : vFruits) {
      System.out.print(f + " ");
    }
  }

  public static void main(String[] args) {
    Vector4 v4 = new Vector4();
    v4.methodA();
    System.out.println("\n=====");
    v4.methodB();
    System.out.println("\n=====");
    v4.methodC();
  }
}