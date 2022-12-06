package dev_java.ch02;

// 배열(부서번호'사원번호)
public class DeptList {
  // int[] deptnos; // 배열 선언, 이대로 쓰면 NullPointerException 발생
  // deptnos=new int[3]; // 배열 생성
  // int[] deptnos = new int[3]; //배열 선언과 생성
  // int[] deptnos = new int[] { 0, 0, 1 }; // 배열 선언, 생성, 초기화
  // int[] deptnos = {0, 0, 0}; //배열을 생성할 때 new예약어를 쓰지 않을수도 있다.
  int[] deptnos = new int[3];

  void methodA() {
    int com = (int) (Math.random() * 10);
    // com = (int) (Math.random()); // 항상 0(기본 double타입에 0.0~0.9 사이의 수를 int로 형변환)
    double com2 = Math.random() * 10;
    System.out.println(com + ", " + com2);

    for (int i = 0; i < 3; i++) { // 기본 for문
      deptnos[i] = com;
      System.out.println(deptnos[i]);
    }
    System.out.println();

    for (int i : deptnos) { // 개선된 for문
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    DeptList deptList = new DeptList();
    deptList.methodA();
  }
}