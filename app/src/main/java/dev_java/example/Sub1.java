package dev_java.example;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 기본패키지인 java.lang외에는 모두 import가 필요하다.
// 인터페이스를 implements하면 반드시 추상메소드를 재정의해야한다.(overriding이라고 함)
public class Sub1 implements ActionListener {
  // 선언부-전역변수의 위치
  // 선언에서 결정되는 것 -> 타입
  // 원시형은 필드와 메소드를 가질 수 없다.
  // 원시형은 부르면 값이 나온다.
  // 참조형은 부르면 주소번지가 나온다.
  // 원시형에서는 NullPointerException이 없다(클래스급인 경우에만 따진다)
  // s1.insert(); -> 인스턴스화가 되어야 이렇게 호출가능
  JDialog jdg = new JDialog();
  JButton jbtn = new JButton("입력");
  Main1 m1 = null; // 선언만 했다-null의 의미는 '결정되지 않았다.', 원본을 사용하겠다는 뜻
  // Main1 m1 = new Main1(); // 선언, 생성, 생성자 호출까지 함, 복제본이 만들어짐(원본x)

  // public Sub1() { //디폴트 생성자
  // }

  public Sub1(Main1 m1) {
    System.out.println(m1);
    if (m1 == null) {
      System.out.println("m1은 null입니다. 객체생성이 안 된 상태입니다.");
    }
    // 메인앱이 실행될 때 호출됨
    // Main1 클래스에서 호출됨
    // 입력(주문, 회원가입)을 할 때 호출됨
    this.m1 = m1; // 객체 치환, 전역변수 m1 초기화
    initDisplay();
  }

  public void initDisplay() {
    jbtn.addActionListener(this);
    jdg.add("South", jbtn);
    jdg.setTitle("Sub1");
    jdg.setSize(300, 400);
    jdg.setVisible(true);
  }

  int insert() { // 1-입력성공 / 2-입력실패
    // insert메소드에서 m1접근이 불가하다(지역변수이기에)-this를 이용해 전역변수로 만들어야 접근가능
    return 1;
  }

  // public static void main(String[] args) {
  // new Sub1(null); // Main1 m1 = null의 의미가됨
  // }

  /*
   * 콜백메소드라고 부른다.
   * 저장버튼이 클릭되었을 때 JVM이 이를 감지하고 가로채서 메소드 호출을 해준다.
   * 파라미터인 ActionEvent객체를 통해서 이벤트가 감지된 버튼을 구분할 수 있다.
   * 이 객체는 파라미터에 있으므로 JVM으로부터 주입이 되는 객체이다.
   * 다시말해 개발자가 인스턴스화하지 않고 JVM이 대신 해준다.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // 저장버튼을 눌렀을 때
    Object obj = e.getSource();
    // 반복문을 탈출할 때는 break문을 사용하고
    // 조건문을 탈출할 때는 return을 사용한다.
    if (obj == jbtn) {
      int result = insert();
      if (result == 1) {
        JOptionPane.showMessageDialog(jdg, "입력에 성공하였습니다.");
        m1.refresh();
        jdg.dispose();
      } else if (result == 0) {
        JOptionPane.showMessageDialog(jdg, "입력에 실패하였습니다.");
        return; // actionPerformed를 탈출함
      }
    }
  }
}