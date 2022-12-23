package dev_java.week4;

import java.util.Vector;

public class A1 {
  int ival = 1;

  public static void main(String[] args) {
    Vector<Integer> vTest = new Vector<>();
    Vector<A1> va1 = new Vector<>();
    A1 a1 = new A1();
    System.out.println(a1);
    a1.ival = 10;
    vTest.add(a1.ival);
    va1.add(a1);
    a1 = null; // 객체가 초기화하면 다음 라인 넘어갈 때 캔디데이트 상태가 됨
    a1 = new A1();
    System.out.println(a1);
    a1.ival = 20;
    vTest.add(a1.ival);
    va1.add(a1);
    System.out.println(vTest.get(0));
    System.out.println(vTest.get(1));
    System.out.println(va1.get(0).ival);
    System.out.println(va1.get(1).ival);
  }
}