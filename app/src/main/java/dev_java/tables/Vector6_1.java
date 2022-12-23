package dev_java.tables;

import java.util.Scanner;
import java.util.Vector;

public class Vector6_1 {
  Vector<String[]> vDepts = new Vector<>();
  String depts[][] = { { "10", "개발부", "서울", "010-123-4567" },
      { "20", "인사부", "인천", "010-234-5678" },
      { "30", "총무부", "부산", "010-345-6789" }
  };

  void initVector() {
    for (int i = 0; i < depts.length; i++) {
      vDepts.add(depts[i]); // 벡터에 담기는 것은 1차배열(컬럼의 수는 바뀔 수 있다.)
    }
  }

  void initVectorPrint() {
    for (int i = 0; i < vDepts.size(); i++) {
      String[] oneRow = vDepts.get(i);
      // System.out.println(oneRow.toString()); // 주소번지 출력
      for (int j = 0; j < oneRow.length; j++) {
        System.out.print(oneRow[j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Vector6_1 v6 = new Vector6_1();
    // initVector 메소드를 경유하지 않았으므로 size는 0이다
    v6.initVector();
    System.out.println(v6.vDepts.size()); // 메소드를 경유한 후 0 -> 3
    // vDepts.get(0) -> {"10", "개발부", "서울", "010-123-4567"}
    v6.initVectorPrint();

    System.out.print("삭제하고자 하는 부서번호를 입력하세요 ==> ");
    Scanner s = new Scanner(System.in);
    int deptNo = s.nextInt();
    for (int i = 0; i < v6.vDepts.size(); i++) {
      String[] oneRow = v6.vDepts.get(i);
      if (deptNo == Integer.parseInt(oneRow[0])) {
        v6.vDepts.remove(i);
      }
    }
    s.close();

    // 삭제한 뒤 남은 정보 출력
    v6.initVectorPrint();
  }
}