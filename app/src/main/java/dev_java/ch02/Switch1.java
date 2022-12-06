package dev_java.ch02;

public class Switch1 {

  public static void main(String[] args) {
    String bread = "도우넛";

    switch (bread) {
      case "소보로": { // switch값으로 int뿐만 아니라 String타입도 가능
        int protocol = 100; // 중괄호 안에서 지역변수처럼 사용 가능
        System.out.println("소보로빵 입니다." + protocol);
        break;
      }
      case "도우넛": {
        int protocol = 200;
        System.out.printf("%s빵 입니다. %d %n", bread, protocol);
        break;
      }
      default:
        System.out.println("원하는 빵이 없습니다.");
        break;
    }
  } // end of switch
}
