package dev_java.ch01;

public class MemberVOMain {
  public static void main(String[] args) {
    MemberVO memberVO = new MemberVO();
    String 사용자아이디 = "tomato";
    System.out.println(사용자아이디);

    // MemberVO클래스에서 mem_id는 접근제한자를 private로 했으므로
    // 외부에서 접근이 불가하다.
    // 그래서 setter 메소드를 제공하고 있다.
    // private로 선언된 변수는 클래스 외부에서 사용이 불가하다.(보안, 캡슐화)
    // System.out.println(memberVO.mem_id); //private 접근 불가
    // memberVO.setMem_id = "tomato"; //privat 접근 불가
    // String set_id = memberVO.setMem_id("apple"); //void이기에 반환불가!
    memberVO.setMem_id("apple");
    String get_id = memberVO.getMem_id(); // 반환형이 있기에 사용가능
    System.out.println(get_id); // apple
    System.out.println(memberVO.getMem_id()); // apple

    // mem_name의 경우 접근 제한자를 public으로 한다면 직접 초기화가 가능하다.
    // memberVO.mem_name = "토마토"; // 직접 초기화
    // String name = memberVO.mem_name;
    // System.out.println(name); // 토마토
    // System.out.println(memberVO.mem_name); // 토마토

    memberVO.setMem_name("이순신"); // setter메소드를 호출하는 것만으로 초기화됨
    System.out.println(memberVO.getMem_name()); // 이순신

    // 아래와 같이 setter메소드를 호출하면 전역변수인 mem_pw에 12345가 초기화됨
    memberVO.setMem_pw("12345");
    // getter메소드를 호출하면 전역변수인 mem_pw에 저장된 값이 출력됨
    // 만일 setter메소드를 호출하지 않으면 null이 출력될 것임
    System.out.println(memberVO.getMem_pw()); // 12345
  }
}
