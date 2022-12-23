package dev_java.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

// List -> 순서가 있다, 정렬한다(2차 가공), 느리다, 추가하면 맨 뒤에 채운다
// index가 다르면 중복값 저장이 가능하다
public class VectorCRUD2 { // 수업시간 코드-String[]
  static Vector<String[]> vDept = new Vector<>(); // static이 있기에 복제x, 원본이 공유됨

  // 부서 전체 조회
  public void getDeptList() {
    System.out.println("부서 정보 전체 조회 호출");
    for (int i = 0; i < vDept.size(); i++) {
      String[] oneRow = new String[3];
      for (int j = 0; j < oneRow.length; j++) {
        oneRow = vDept.get(i);
        System.out.print(oneRow[j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  // 벡터에 부서정보 추가하기-없는 것을 새로 추가
  // pass by value로 호출하는 경우 주소번지를 받아옴(원본을 받는 것)
  public int deptInsert(String[] userDept) { // 파라미터는 지역변수(메소드 영역 안에서만 사용)
    System.out.println("부서 정보 입력 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    boolean isOk = vDept.add(userDept);
    if (isOk)
      result = 1; // 실행문 1개라서 {} 생략
    return result;
  }

  /**********
   * @param deptNo     수정하고자하는 부서번호
   * @param user_dname 수정하고자하는 부서명
   * @param user_loc   수정하고자하는 지 역
   * @return 1이면 수정성공, 0이면 수정실패
   **********/
  // 벡터에 부서정보 수정하기-있는 것을 변경
  public int deptUpdate(int deptNo, String user_dname, String user_loc) {
    System.out.println("부서 정보 수정 호출" + user_dname + ", " + user_loc);
    int result = 0; // 1이면 성공, 0이면 실패
    here: for (int i = 0; i < vDept.size(); i++) {
      String[] row = vDept.get(i); // i는 row의 인덱스
      // if() 여기는 벡터에서 꺼낸 배열을 갖는다
      // if() 여기는 화면에서 가져온 배열과 벡터에서 꺼낸 배열을 비교한다
      int deptNo2 = Integer.parseInt(row[0]);
      if (deptNo2 == deptNo) {
        String[] updRow = { row[0], user_dname, user_loc };
        // Vector를 사용하면 배열의 단점 보완(길이, 타입고정)
        // Vector<Object>
        vDept.remove(i); // i번째 자리를 삭제하고
        vDept.add(i, updRow); // 삭제된 자리에 추가
        result = 1;
        // break문만 사용 시 가장 가까운 for문을 탈출
        // 만약 라벨을 달아놓으면 그 for문 전체를 빠져나간다
        break here; // 라벨을 단 here을 탈출함
      }
    }
    getDeptList();
    return result;
  }

  // 벡터에 부서정보 삭제하기-있는 것을 삭제
  // 벡터에 있는 부서 정보 중에서 어떤 로우를 삭제할지 부서번호를 받아와야함
  // 사용자로부터 받아와야하는 값
  // 받아오는 건 int형, 부서번호는 String타입
  // 형전환 필요 -> null이오면 NumberFormatException 발생 가능성
  // 방어코드 작성 필요함(null에대한 이슈는 프로그래밍에서 중요 문제)
  public int deptDelete(int deptNo) {
    System.out.println("부서 정보 삭제 호출");
    int result = 0; // 1이면 성공, 0이면 실패
    for (int i = 0; i < vDept.size(); i++) {
      String[] oneRow = vDept.get(i);
      int deptNo2 = 0;
      // 예외 발생에 대한 우려 방어코드 작성
      if (oneRow[0] != null) { // null체크(이것까지도 프레임워크에서 처리해야함)
        deptNo2 = Integer.parseInt(oneRow[0]);
      }
      // 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기
      // System.out.println("입력받은 값, 가져온 값 => " + deptNo + ", " + deptNo2);
      if (deptNo == deptNo2) {
        // 삭제할 벡터의 로우값이 필요 -> 벡터의 size를 통해 찾아냄
        // 변수 i가 인덱스 값에 해당
        // remove 메소드의 파라미터가 int인 경우에 대해서만 삭제된 벡터의 제네릭
        // 반환값을 가지고 처리 여부 확인 가능
        String[] deleteRow = vDept.remove(i); // 삭제한 String[] 반환
        System.out.println("삭제된 배열은 => " + Arrays.toString(deleteRow));
        // boolean isOk = vDept.remove(oneRow); // 삭제여부 boolean 반환
        if (deleteRow != null) {
          System.out.println("삭제 처리 되었습니다.");
          // 삭제처리가 성공한 경우(deleteRow에 값이 있을 경우) 반환값 1 리턴
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
    VectorCRUD2 vCrud = new VectorCRUD2();
    // 입력 테스트
    String[] oneRow = { "10", "개발부", "인천" }; // 제네릭 타입으로 쓸 예정
    int result1 = vCrud.deptInsert(oneRow);
    String[] oneRow2 = { "20", "총무부", "서울" };
    result1 = vCrud.deptInsert(oneRow2);
    if (result1 == 1) {
      JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
      vCrud.getDeptList();
      // return; // 조건문 안의 return문은 해당 메소드 블록을 빠져나간다
    }

    // 수정 테스트
    Scanner s = new Scanner(System.in);
    System.out.print("수정할 부서번호, 부서명, 지역을 입력하세요(|로 구분) ");
    String user = s.nextLine();
    int user_deptno = 0;
    String user_dname = null;
    String user_loc = null;
    StringTokenizer st = new StringTokenizer(user, "|");
    user_deptno = Integer.parseInt(st.nextToken()); // 사용자가 입력한 부서번호
    user_dname = st.nextToken(); // 사용자가 입력한 부서명
    user_loc = st.nextToken(); // 사용자가 입력한 지역
    int result2 = vCrud.deptUpdate(user_deptno, user_dname, user_loc);
    if (result2 == 1) {
      JOptionPane.showMessageDialog(null, "수정 되었습니다.");
    }
    System.out.println();

    // 삭제 테스트
    System.out.print("삭제할 부서번호를 입력하세요 => ");
    int userInput = s.nextInt();
    int result3 = vCrud.deptDelete(userInput);
    if (result3 == 1) {
      JOptionPane.showMessageDialog(null, "삭제가 되었습니다.");
      vCrud.getDeptList();
    }
    s.close();

    // 상세보기 테스트
    String[] result4 = vCrud.deptDetail(10);
    for (int i = 0; i < result4.length; i++) {
      System.out.print(result4[i] + " ");
    }
  }
}