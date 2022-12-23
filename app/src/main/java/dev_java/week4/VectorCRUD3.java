package dev_java.week4;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD3 { // 수업시간 코드-DeptVO
  static Vector<DeptVO> vDept = new Vector<>();
  static Scanner s = new Scanner(System.in);

  // 부서 전체 조회
  public void getDeptList() {
    System.out.println("전체 조회 호출");
    for (int i = 0; i < vDept.size(); i++) {
      DeptVO temp = vDept.get(i);
      System.out.print(temp.getDeptNo() + ", " + temp.getDeptName() + ", " + temp.getDeptLoc());
      System.out.println();
    }
    System.out.println();
  }

  // 벡터에 부서정보 추가하기-없는 것을 새로 추가
  public int deptInsert(DeptVO dvo) {
    System.out.println("정보 입력 호출");
    int result = 0;
    boolean isOk = vDept.add(dvo);
    if (isOk)
      result = 1;
    return result;
  }

  // 벡터에 부서정보 수정하기-있는 것을 변경
  public int deptUpdate(DeptVO dvo) {
    System.out.println("deptUpdate 호출: " + dvo.getDeptNo());
    int result = 0;
    System.out.print("수정할 부서번호, 부서명, 지역을 입력하세요(|로 구분) ");
    VectorCRUD3.s = null;
    VectorCRUD3.s = new Scanner(System.in);
    String user = VectorCRUD3.s.next();
    int user_deptno = 0;
    String user_dname = null;
    String user_loc = null;
    // 문자열 3개를 한번에 받아오기위해 StringTokenizer 사용
    StringTokenizer st = new StringTokenizer(user, "|");
    user_deptno = Integer.parseInt(st.nextToken()); // 사용자가 입력한 부서번호
    user_dname = st.nextToken(); // 사용자가 입력한 부서명
    user_loc = st.nextToken(); // 사용자가 입력한 지역
    // 사용자가 입력한 부서번호|부서명|지역을 DeptVO의 멤버변수에 초기화한 것
    DeptVO updVO = DeptVO.builder().deptNo(user_deptno).deptName(user_dname).deptLoc(user_loc).build();
    // 벡터에 들어있는 DeptVO에서 꺼낸 부서번호와 파라미터로 넘겨 받은 부서번호가 일치하면
    // 그 때 가져온 DeptVO의 인덱스가 우리가 삭제하고 추가해야되는 벡터의 인덱스값이 된다
    DeptVO comVO = null;
    for (int i = 0; i < vDept.size(); i++) {
      comVO = vDept.get(i);
      if (updVO.getDeptNo() == comVO.getDeptNo()) {
        vDept.remove(i);
        vDept.add(i, updVO);
        result = 1;
        break;
      }
    }
    return result;
  }

  // 부서 삭제
  public int deptDelete(int deptNo) {
    System.out.println("부서 정보 삭제 호출" + deptNo);
    int result = 0; // 1이면 성공, 0이면 실패
    for (int i = 0; i < vDept.size(); i++) { // 데이터 영속성을 지원하는 오라클이 없어서 벡터로 대신함
      DeptVO temp = vDept.get(i);
      int deptNo2 = 0;
      deptNo2 = temp.getDeptNo();
      System.out.println("입력값과 벡터에서 가져온 값을 비교=> " + deptNo + ", " + deptNo2);
      if (deptNo == deptNo2) { // 파라미터로 넘어온 부서번호와 벡터에서 꺼낸 부서번호를 비교
        DeptVO rmVO = vDept.remove(i);
        if (rmVO != null)
          result = 1;
      }
    }
    return result;
  }

  // 벡터의 부서정보 상세보기-있는 것을 하나 꺼내보기
  public DeptVO deptDetail(int deptNo) {
    System.out.println("부서 정보 상세보기 호출");
    DeptVO temp = null;
    for (int i = 0; i < vDept.size(); i++) {
      temp = vDept.get(i);
      if (deptNo == temp.getDeptNo()) {
        System.out.println(temp.getDeptNo() + "번 부서 상세보기");
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    VectorCRUD3 vCrud = new VectorCRUD3();
    // 입력 테스트
    DeptVO dvo1 = DeptVO.builder().deptNo(10).deptName("개발부").deptLoc("인천").build();
    System.out.println(dvo1.toString());
    int result1 = vCrud.deptInsert(dvo1);
    dvo1 = null; // 기존에 참조하는 객체와 연결을 끊는다
    dvo1 = DeptVO.builder().deptNo(20).deptName("총무부").deptLoc("서울").build();
    System.out.println(dvo1.toString());
    result1 = vCrud.deptInsert(dvo1);
    if (result1 == 1) {
      JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
      vCrud.getDeptList();
    }

    // 수정, 삭제 테스트
    // 수정과 삭제 메뉴 선택 담기
    int result2 = 0;
    int choice = 0; // 디폴트
    System.out.print("수정은 1, 삭제는 2를 입력해주세요. => ");
    choice = VectorCRUD3.s.nextInt();
    if (choice == 1) {
      System.out.print("수정하고자하는 부서번호를 입력해주세요. => ");
      int u_deptNo = VectorCRUD3.s.nextInt();
      // 부서번호만 담고 나머지는 null(디폴트값)
      DeptVO updVO = DeptVO.builder().deptNo(u_deptNo).build();
      result2 = vCrud.deptUpdate(updVO);
      if (result2 == 1) {
        System.out.println("수정처리 되었습니다.");
        vCrud.getDeptList();
      } else {
        System.out.println("수정처리에 실패하였습니다.");
      }
    } else if (choice == 2) {
      System.out.print("삭제할 부서번호를 입력하세요 => ");
      int userInput = VectorCRUD3.s.nextInt();
      int result3 = vCrud.deptDelete(userInput);
      if (result3 == 1) {
        JOptionPane.showMessageDialog(null, "삭제가 되었습니다.");
        vCrud.getDeptList();
      } else {
        System.out.println("삭제처리에 실패하였습니다.");
      }
    }

    // 상세보기 테스트
    System.out.print("상세보기할 부서번호를 입력하세요 => ");
    int userInput2 = s.nextInt();
    DeptVO result4 = vCrud.deptDetail(userInput2);
    System.out.print(result4.deptNo + " " + result4.deptName + " " +
        result4.deptLoc);
    VectorCRUD3.s.close();
  }
}