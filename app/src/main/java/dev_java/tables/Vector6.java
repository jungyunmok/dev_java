package dev_java.tables;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Vector6 {
  Vector<String[]> vDepts = new Vector<>();
  String deptsArr[][] = { { "10", "개발부", "서울", "010-123-4567" },
      { "20", "인사부", "인천", "010-234-5678" },
      { "30", "총무부", "부산", "010-345-6789" }
  };

  // 배열을 벡터에 넣는 메소드
  void vSet() {
    for (int i = 0; i < deptsArr.length; i++) {
      vDepts.add(deptsArr[i]);
    }
  }

  // 배열을 출력하는 메소드
  void vPrint() {
    for (int i = 0; i < vDepts.size(); i++) {
      System.out.println(Arrays.toString((vDepts.get(i))));
    }
    System.out.println("==========");
  }

  // 스캐너로 입력된 번호의 행을 삭제하는 메소드
  void vRemove() {
    Scanner s = new Scanner(System.in);
    System.out.print("삭제하고싶은 배열 번호 입력: ");
    int i = s.nextInt();
    if (i <= vDepts.size()) {
      System.out.println("삭제된 배열:" + Arrays.toString((vDepts.get(i - 1))));
      vDepts.remove(i - 1);
    } else {
      System.out.println("잘못된 입력입니다! 올바른 범위의 숫자를 입력해주세요.");
    }
    s.close();
    System.out.println("==========");
  }

  // 스캐너로 입력된 부서번호의 행을 삭제하는 메소드
  void vRemoveDeptNo(String num) {
    String[] oneRow = new String[vDepts.size()];
    for (int i = 0; i < vDepts.size(); i++) {
      oneRow = vDepts.get(i); // vDepts을 oneRow에 담음
      if (num.equals(oneRow[0])) { // 만약 부서번호와 입력값이 같다면
        vDepts.remove(i); // 그 행을 지움
      }
    }
    if (!(num.equals(oneRow[0]))) {
      System.out.println("해당하는 부서 번호가 없습니다.");
    }
  }

  public static void main(String[] args) {
    Vector6 v6 = new Vector6();
    v6.vSet();
    v6.vPrint();

    // 방법1-행번호로 지우기
    v6.vRemove();
    v6.vPrint();

    // 방법2-부서번호로 지우기
    Scanner s = new Scanner(System.in);
    System.out.print("삭제할 부서번호: ");
    String num = s.nextLine();
    v6.vRemoveDeptNo(num);
    s.close();
    v6.vPrint();

  }
}