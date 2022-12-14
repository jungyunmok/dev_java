package dev_java.week3;

public class Sub_2 {

  public static void main(String[] args) {
    Main_2 m2 = new Main_2(); // 인스턴스화, Main_2의 디폴트 생성자에 getisOk를 넣었기에 null이 아닌 값이 나옴!
    for (int i = 0; i < m2.isOk.length; i++) {
      System.out.println(m2.isOk[i]);
    }
    System.out.println("==========");
    for (boolean isOk : m2.isOk) {
      System.out.println(isOk);
    }
  }
}
