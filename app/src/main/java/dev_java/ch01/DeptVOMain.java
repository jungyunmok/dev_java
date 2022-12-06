package dev_java.ch01;

public class DeptVOMain {
  public static void main(String[] args) {
    DeptVO deptVO = new DeptVO(); // DeptVo클래스가 인스턴스화, 객체의 선언과 생성, Heap 영역에 생성됨
    deptVO.deptNo = 10;
    deptVO.deptName = "개발1팀";
    System.out.println(deptVO.deptNo); // 10
    System.out.println(deptVO.deptName); // 개발1팀
    System.out.println(deptVO.deptNo); // 10
    deptVO = new DeptVO(); // 변수 선언이 아니라(앞에 타입이 없기에 선언 아님!), 새로운 객체를 생성한 것!, 주소번지가 달라짐
    deptVO.deptNo = 30;
    deptVO.deptName = "개발2팀";
    System.out.println(deptVO.deptNo); // 30
    System.out.println(deptVO.deptName); // 개발2팀
    System.out.println(deptVO.loc); // null
  }
}

// 10
// 개발1팀
// 10
// 30
// 개발2팀
// null