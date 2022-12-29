package dev_java.week5;

public class ServerTest {
  public static void main(String[] args) {
    // 아래 중에서 생성자 안에 메소드 호출 구문이 있는것은 BananaServer
    // 인스턴스화를 하면 (디폴트)생성자도 호출된다
    BananaServer bs = new BananaServer();

    // 인스턴스화를 하면 (디폴트)생성자도 호출된다
    KiwiServer ks = new KiwiServer();
  }
}
