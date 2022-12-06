package dev_java.ch01;

// 자료구조의 일부로 사용함
// 회원정보를 관리하기 위한 목적으로 설계-그래서 main메소드는 포함x
public class MemberVO {
  private String mem_id = null;
  private String mem_pw = null;
  private String mem_name = null;

  // setter는 write, save
  // setter메소드를 활용하여 전역변수 mem_id를 초기화한다.
  public void setMem_id(String mem_id) {
    this.mem_id = mem_id; // 자기자신 this -> 전역변수
  }

  // getter는 read, listening
  public String getMem_id() {
    return mem_id;
  }

  public void setMem_pw(String mem_pw) {
    this.mem_pw = mem_pw;
  }

  public String getMem_pw() {
    return this.mem_pw;
  }

  public void setMem_name(String mem_name) {
    this.mem_name = mem_name;
  }

  public String getMem_name() {
    return this.mem_name;
  }

  public static void main(String[] args) {
    MemberVO memberVO = new MemberVO();
    System.out.println(memberVO.mem_id); // 같은 클래스 내에서는 private도 접근 가능
    System.out.println(memberVO.mem_pw);
    System.out.println(memberVO.mem_name);
  }
}
