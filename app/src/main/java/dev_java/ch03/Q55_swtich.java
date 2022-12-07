package dev_java.ch03;

public class Q55_swtich {
  public static void main(String[] args) {
    Integer i = new Integer(1) + new Integer(2); // i는 3
    switch (i) {
      case 3:
        System.out.println("three"); // 3이니까 three 출력
        break; // switch문을 나감
      default:
        System.out.println("other");
        break;
    }
  }
}
