package dev_java.oracle;

import java.util.List;
import java.util.ArrayList;
import dev_java.week4.DeptVO;;

public class ListExam1 {
  public static void main(String[] args) {
    List<DeptVO> deptList = new ArrayList<>();
    DeptVO dVO = DeptVO.builder().deptNo(10).deptName("총무부").deptLoc("서울").build();
    deptList.add(dVO);
    dVO = DeptVO.builder().deptNo(20).deptName("인사부").deptLoc("부산").build();
    deptList.add(dVO);
    dVO = DeptVO.builder().deptNo(30).deptName("개발부").deptLoc("제주").build();
    deptList.add(dVO);

    for (DeptVO rdVO : deptList) {
      System.out.println(rdVO.getDeptNo() + ", " + rdVO.getDeptName() + ", " + rdVO.getDeptLoc());
    }
    System.out.println("====================");
    for (int i = 0; i < deptList.size(); i++) {
      DeptVO rdVO = deptList.get(i);
      System.out.println(rdVO.getDeptNo() + ", " + rdVO.getDeptName() + ", " + rdVO.getDeptLoc());
    }
  }
}