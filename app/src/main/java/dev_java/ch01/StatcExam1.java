package dev_java.ch01;

class Static1 {
  int i;
}

class Static2 {
  static int i;
}

public class StatcExam1 {
  public static void main(String[] args) {
    Static1 static1 = new Static1(); // static이 없는기에 인스턴스화
    System.out.println(static1.i);
    System.out.println(Static2.i); // static int이기에 바로 호출가능
  }
}
