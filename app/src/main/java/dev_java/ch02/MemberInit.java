package dev_java.ch02;

public class MemberInit {
  int i;
  int hap;

  // 디폴트 생성자라고 부른다-디폴트 생성자는 파라미터를 결정해줄 필요 없으니 생략하면
  // JVM이 대신 생성해줘 전변들을 초기화시킴
  public MemberInit() {
    System.out.println("디폴트 생성자 호출 성공 " + i + ", " + hap); // 0, 0
  }

  public MemberInit(int i, int hap) {
    this.i = i;
    this.hap = hap;
    System.out.println("파라미터가 두 개인 생성자 호출 성공 " + this.i + ", " + this.hap); // 1, 0 전역변수 i와 hap
  }

  public static void main(String[] args) {
    MemberInit m1 = new MemberInit(); // 9번 생성자 호출(메소드 오버로딩 메카니즘에 따른다)
    MemberInit m2 = new MemberInit(1, 0); // 13번 생성자 호출
  }
}