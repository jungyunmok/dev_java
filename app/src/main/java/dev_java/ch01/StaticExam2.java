package dev_java.ch01;

class Static3 {
  int i;
  static int j;

  void methodA() {
    System.out.println("non-static 변수 i  methodA에서 호출가능  ===> " + i);
    System.out.println("non-static methodA()  호출 ===> " + j);
  }

  static void methodB() {
    Static3 static3 = new Static3();
    System.out.println("non-static 변수 i methodB에서 호출 =>" + static3.i); // 인스턴스화 후 호출가능
    // System.out.println("non-static 변수 i methodB에서 호출 불가 ===> "+i);
    System.out.println("static methodB() 호출 ===> " + j);
  }
}

public class StaticExam2 {
  public static void main(String[] args) {
    Static3 static3 = new Static3();
    static3.methodA();
    Static3.methodB();
  }
}