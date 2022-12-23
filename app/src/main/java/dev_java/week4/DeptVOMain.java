package dev_java.week4;

public class DeptVOMain {
  public static void main(String[] args) {
    // DeptVO dVo = DeptVO.builder(); //builder()로 설정 안했기에 오류
    DeptVO dVo1 = DeptVO.builder().deptName("총무부").build(); // 순서 상관없음
    DeptVO dVo2 = DeptVO.builder().deptNo(20).deptName("총무부").deptLoc("부산").build();
    System.out.println(dVo1.getDeptNo() + ", " + dVo1.getDeptName() + ", " + dVo1.getDeptLoc());
    System.out.println(dVo2.getDeptNo() + ", " + dVo2.getDeptName() + ", " + dVo2.getDeptLoc());
  }
}