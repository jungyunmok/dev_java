package dev_java.week4;

import java.util.Vector;

public class VectorCRUD1 {
  static Vector<String[]> vDept = new Vector<>(); // 내가 만든 코드 -> String[] 타입

  // 부서 전체 조회
  public void deptList() {
    System.out.println("부서 정보 전체 조회 호출");
    for (int i = 0; i < vDept.size(); i++) {
      String[] oneRow = vDept.get(i);
      for (int j = 0; j < oneRow.length; j++) {
        System.out.print(oneRow[j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  // 벡터에 부서정보 추가하기-없는 것을 새로 추가
  public int deptInsert(String[] str) {
    System.out.println("부서 정보 입력 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    boolean isOk = vDept.add(str);
    if (isOk) {
      result = 1;
    }
    return result;
  }

  // 벡터에 부서정보 수정하기-있는 것을 변경
  public int deptUpdate(int deptNo, String[] str) {
    System.out.println("부서 정보 수정 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    for (int i = 0; i < vDept.size(); i++) {
      String[] oneRow = vDept.get(i);
      if (deptNo == Integer.parseInt(oneRow[0])) {
        vDept.set(i, str);
      }
    }
    boolean isOk = vDept.contains(str);
    if (isOk) {
      result = 1;
    }
    return result;
  }

  // 벡터에 부서정보 삭제하기-있는 것을 삭제
  public int deptDelete(int deptNo) {
    System.out.println("부서 정보 삭제 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    for (int i = 0; i < vDept.size(); i++) {
      String[] oneRow = vDept.get(i);
      if (deptNo == Integer.parseInt(oneRow[0])) {
        vDept.remove(i);
        boolean isOk = vDept.contains(vDept.get(i));
        if (!isOk) {
          result = 1;
        }
      }
    }
    return result;
  }

  // 벡터의 부서정보 상세보기-있는 것을 하나 꺼내보기
  public String[] deptDetail(int deptNo) {
    System.out.println("부서 정보 상세보기 호출");
    String[] oneRow = new String[3];
    for (int i = 0; i < vDept.size(); i++) {
      oneRow = vDept.get(i);
      if (deptNo == Integer.parseInt(oneRow[0])) {
        oneRow = vDept.get(i);
      }
    }
    return oneRow;
  }

  public static void main(String[] args) {
    VectorCRUD1 vCrud = new VectorCRUD1();
    // 입력 테스트
    String[] oneRow = { "10", "개발부", "인천" };
    String[] oneRow2 = { "20", "자재부", "대전" };
    String[] oneRow22 = { "20", "경영부", "부산" };
    String[] oneRow3 = { "30", "영업부", "서울" };

    int result1 = vCrud.deptInsert(oneRow);
    int result2 = vCrud.deptInsert(oneRow2);
    int result3 = vCrud.deptInsert(oneRow3);
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    vCrud.deptList();

    // 수정 테스트
    int result4 = vCrud.deptUpdate(20, oneRow22);
    System.out.println(result4);
    vCrud.deptList();

    // 삭제 테스트
    int result5 = vCrud.deptDelete(20);
    System.out.println(result5);
    vCrud.deptList();

    // 상세보기 테스트
    String[] result6 = vCrud.deptDetail(10);
    for (int i = 0; i < result6.length; i++) {
      System.out.print(result6[i] + " ");
    }
  }
}