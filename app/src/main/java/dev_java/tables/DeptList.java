package dev_java.tables;

import java.util.Vector;

public class DeptList {
  Vector<DeptVO> vDepts = new Vector<>();

  // 부서 등록-성공하면 1, 실패하면 0 반환
  int deptInsert(DeptVO pdVO) {
    int result = -1;
    boolean isOk = vDepts.add(pdVO); // true
    result = isOk ? 1 : 0; // isOk가 true이니 1 반환
    return result;
  }

  // DeptVO를 쓰지 않았을 경우 파라미터가 길어짐
  // int deptInsert(int deptNo, String deptName, String deptLoc) {
  // int result = -1;
  // return result;
  // }

  // 부서 수정 -> 부서명과 지역만 수정가능
  int deptUpdate(DeptVO pdVO) {
    int result = -1;
    boolean isOk = false;
    for (int i = 0; i < vDepts.size(); i++) {
      if (pdVO.getDeptNo() == vDepts.get(i).getDeptNo()) {
        isOk = vDepts.set(i, pdVO) != null;
      }
    }
    result = isOk ? 1 : 0;
    return result;
  }

  // 부서 삭제
  int deptDelete(int deptNo) {
    int result = -1;
    boolean isOk = false;
    for (int i = 0; i < vDepts.size(); i++) {
      if (deptNo == vDepts.get(i).getDeptNo()) {
        isOk = vDepts.remove(vDepts.get(i));
      }
    }
    result = isOk ? 1 : 0;
    return result;
  }

  // 부서 상세정보
  String deptView(int deptNo) {
    String result = null;
    for (int i = 0; i < vDepts.size(); i++) {
      if (deptNo == vDepts.get(i).getDeptNo()) {
        result = deptNo + "번 부서 정보: " + vDepts.get(i).getDeptName() + ", " + vDepts.get(i).getDeptLoc();
      }
    }
    return result;
  }

  // 전체 조회
  void getDeptList() {
    for (int i = 0; i < vDepts.size(); i++) {
      DeptVO printDVO = vDepts.get(i);
      System.out.println(printDVO.getDeptNo() + ", " + printDVO.getDeptName() + "," + printDVO.getDeptLoc());
    }
    System.out.println();
  }

  // 부서세팅
  void setDdeptList() {
    DeptVO dvo = new DeptVO(10, "개발부", "서울");
    vDepts.add(dvo);
    dvo = new DeptVO(20, "인사부", "인천");
    vDepts.add(dvo);
    dvo = new DeptVO(30, "총무부", "부산");
    vDepts.add(dvo);
  }

  public static void main(String[] args) {
    DeptList deptList = new DeptList();
    deptList.setDdeptList(); // 부서 세팅
    deptList.getDeptList(); // 전체 조회

    DeptVO dvo = new DeptVO(40, "자재부", "대전");
    deptList.deptInsert(dvo); // 부서 등록
    deptList.getDeptList();

    System.out.println(deptList.deptView(10)); // 10번부서 상세정보 출력
    System.out.println();

    deptList.deptDelete(10);// 10번 부서 삭제
    deptList.getDeptList();

    dvo = new DeptVO(20, "자재관리부", "수원");
    deptList.deptUpdate(dvo); // 부서 수정
    deptList.getDeptList();
  }
}