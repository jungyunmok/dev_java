package dev_java.ch01;

// java.lang패키지 외 클래스들은 모두 import문을 추가해야함(하지않으면 컴파일에러)
// 클래스의 구성요소 2가지(변수'필드, 메소드)
// 필드+메소드 => 클래스 정의
// 클래스를 인스턴스화하면 메모리(램)에 로딩이 된다.
// 클래스를 인스턴스화하는 이유는 변수와 메소드를 호출하기 위해서이다.
// 인스턴스화.메소드명();
// 인스턴스화.메소드명(파라미터1);
// 인스턴스화.메소드명(파라미터1, 파라미터2, ...);
// 인스턴스화.전역변수(원시형+참조형 모두 가능);
// static은 하나다, 원본을 복사할 수 없다.
import java.util.Scanner;

public class ScannerExam1 {
  public static void main(String[] args) {
    // 생성자이든 메소드이든 파라미터의 개수, 타입은 반드시 지켜야한다.
    Scanner scanner = new Scanner(System.in); // 생성부의 파라미터 자리는 시스템의 입력장치정보
    System.out.println("0~9 사이의 숫자를 입력해주세요.");
    String user = scanner.nextLine();
    scanner.close();

    // int의 wrapper Integer
    int i_user = Integer.parseInt(user);
    System.out.println(user + 1);
    System.out.println(i_user + 1);
  }
}