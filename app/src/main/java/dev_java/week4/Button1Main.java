package dev_java.week4;

// java.lang 패키지가 아닌 것은 모두 import 사용함
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

class Button1 extends JFrame {
  // 선언부
  Button1Event bEvent = new Button1Event(this); // 상속, 추상클래스, 인터페이스 중심 코딩 전개 필요
  // 게으른 인스턴스화
  // 북쪽 배치
  JButton jbtn_ins = null; // 선언만 했다.(생성자 호출x)
  // 이른 인스턴스화
  // 남쪽 배치
  JButton jbtn_upd = new JButton("수정"); // 선언 및 생성(+생성자 호출까지 일어남)

  // 생성자
  Button1() {
    System.out.println("Button1 디폴트 생성자 호출" + jbtn_ins);
    // 생성자 안에서 버튼 객체 생성 -> 시점에 따라 NullPointerException 발생 가능성 생김
    initDisplay(); // new Button1()이 호출되면 자동으로 호출됨
    System.out.println("initDisplay 호출 완료==> " + (jbtn_ins == null)); // true, jbtn_ins는 null
    jbtn_ins = new JButton("입력");
    System.out.println("입력버튼 생성 완료==> " + (jbtn_ins == null)); // false, jbtn_ins는 null이 아님!
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    // 동쪽 배치
    JButton jbtn_del = new JButton("삭제");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    if (jbtn_ins != null) { // null이 아니라면 jbtn_ins추가, null이면 그냥 지나침
      this.add("North", jbtn_ins);
    }
    this.add("South", jbtn_upd);
    this.add("East", jbtn_del);
    jbtn_upd.addActionListener(bEvent);
    this.setSize(400, 300);
    this.setVisible(true);
  }
}

// ActionListener의 구현체 클래스이다(이벤트 핸들러 클래스이다)
// 인터페이스는 추상메소드만 가진다.
class Button1Event implements ActionListener {
  Button1 button1 = null;
  // Button1 button1 = new Button1; // 원본이 아니라 복사본이 만들어짐!

  Button1Event(Button1 button1) {
    this.button1 = button1;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    // 수정 버튼을 눌렀을 때
    if (obj == button1.jbtn_upd) {
      System.out.println("수정버튼 클릭");
    }
  }
}

public class Button1Main {
  public static void main(String[] args) {
    // new를 쓰면 서로 다른 객체가 생성됨
    Button1 b1 = new Button1();
    // Button1 b2 = new Button1();
    // Button1 b3 = new Button1();
  }
}