package dev_java.ch03;

public class Test1_1 {
  public static void main(String[] args) {
    String str = null;
    if (str.equals("exit")) { // NullPointerException 발생!
      System.out.println("변수가 앞에 위치");
    }
    if ("exit".equals(str)) { // 안터지고 작동함 -> 앞에 상수를 둬야한다
      System.out.println("상수가 앞에 위치");
    }
  }
}