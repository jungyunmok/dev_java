package dev_java.week4;

import java.util.Vector;

public class VectorCRUD1_2 {
  static Vector<DeptVO> vDept = new Vector<>(); // 내가 만든 코드 -> DeptVO 타입

  // 부서 전체 조회
  public void deptList() {
    System.out.println("부서 정보 전체 조회 호출");
    for (int i = 0; i < vDept.size(); i++) {
      DeptVO temp = vDept.get(i);
      System.out.print(temp.deptNo + " " + temp.deptName + " " + temp.deptLoc);
      System.out.println();
    }
    System.out.println();
  }

  // 벡터에 부서정보 추가하기-없는 것을 새로 추가
  public int deptInsert(DeptVO deptVo) {
    System.out.println("부서 정보 입력 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    boolean isOk = vDept.add(deptVo);
    if (isOk) {
      result = 1;
    }
    return result;
  }

  // 벡터에 부서정보 수정하기-있는 것을 변경
  public int deptUpdate(DeptVO deptVo) {
    System.out.println("부서 정보 수정 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    for (int i = 0; i < vDept.size(); i++) {
      DeptVO temp = vDept.get(i);
      if (deptVo.getDeptNo() == temp.getDeptNo()) {
        System.out.println("수정 전=> " + temp.deptNo + " " + temp.deptName + " " + temp.deptLoc);
        System.out.println("수정 후=> " + deptVo.deptNo + " " + deptVo.deptName + " " + deptVo.deptLoc);
        vDept.set(i, deptVo);
      }
    }
    boolean isOk = vDept.contains(deptVo);
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
      DeptVO temp = vDept.get(i);
      if (deptNo == temp.getDeptNo()) {
        System.out.println("삭제할 부분=> " + temp.deptNo + " " + temp.deptName + " " + temp.deptLoc);
        vDept.remove(i);
        boolean isOk = vDept.contains(temp);
        if (!isOk) {
          result = 1;
        }
      }
    }
    return result;
  }

  // 벡터의 부서정보 상세보기-있는 것을 하나 꺼내보기
  public void deptDetail(int deptNo) {
    System.out.println("부서 정보 상세보기 호출");
    for (int i = 0; i < vDept.size(); i++) {
      DeptVO temp = vDept.get(i);
      if (deptNo == temp.deptNo) {
        System.out.print(temp.deptNo + " " + temp.deptName + " " + temp.deptLoc);
      }
    }
  }

  public static void main(String[] args) {
    VectorCRUD1_2 vCrud = new VectorCRUD1_2();
    // 입력 테스트
    DeptVO oneRow = new DeptVO(10, "개발부", "인천");
    int result = vCrud.deptInsert(oneRow);
    System.out.println(result);
    oneRow = new DeptVO(20, "총무부", "경기");
    result = vCrud.deptInsert(oneRow);
    System.out.println(result);
    oneRow = new DeptVO(30, "영업부", "서울");
    result = vCrud.deptInsert(oneRow);
    System.out.println(result);
    vCrud.deptList();

    // 수정 테스트
    oneRow = new DeptVO(20, "자재부", "부산");
    int result4 = vCrud.deptUpdate(oneRow);
    System.out.println(result4);
    vCrud.deptList();

    // 삭제 테스트
    int result5 = vCrud.deptDelete(10);
    System.out.println(result5);
    vCrud.deptList();

    // 상세보기 테스트
    vCrud.deptDetail(20);
  }
}