package dev_java.ch01;

public class MemberAction {
  // 회원가입을 처리하는 메소드 선언하기(회원가입 성공 -> 1 반환 / 회원가입 실패 -> 0 반환)
  public int memberinsert(String mem_id, String mem_pw, String mem_name) {
    System.out.println("memberinsert 호출-파라미터 3개");
    System.out.println(mem_id + ", " + mem_pw + ", " + mem_name);
    int result = -1; // End of File(없다를 나타낼 때 -1로 표현하기도함)
    result = 1;
    return result;

  }

  public int memberinsert(MemberVO memberVO) {
    System.out.println("memberinsert 호출-파라미터 1개");
    System.out.println(memberVO.getMem_id() + ", " + memberVO.getMem_pw() + "," + memberVO.getMem_name());
    int result = -1;
    result = 0;
    return result;
  }

  public static void main(String[] args) {
    // insert here-memberinsert 메소드를 호출하시오.
    MemberAction memberAction = new MemberAction();
    int result = memberAction.memberinsert("apple", "123", "사과");

    if (result == 1) {
      System.out.println("회원가입 성공");
    } else {
      System.out.println("회원가입 실패");
    }

    MemberVO memberVO = new MemberVO();
    memberVO.setMem_id("tomato");
    memberVO.setMem_pw("456");
    memberVO.setMem_name("토마토");
    memberAction.memberinsert(memberVO);

    if (result == 1) {
      System.out.println("회원가입 성공");
    } else {
      System.out.println("회원가입 실패");
    }
  }
}
