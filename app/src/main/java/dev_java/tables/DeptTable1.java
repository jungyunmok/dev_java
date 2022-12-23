package dev_java.tables;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// 이른 인스턴스화, 게으른 인스턴스화 -> 나눠보기 추가 연습
// 어떤 클래스를 상속받을 때에는 extends 예약어를 사용한다.
// A is a B 관계이면 상속으로 처리한다.
// 소나타는 자동차이다 -> 상속관계
// 작은 범위는 큰 범위다
// 부모클래스가 가진 변수와 메소드도 사용 가능하다. -> 자손이 더 많이 누릴 수 있다.
public class DeptTable1 extends JFrame { // DeptTable1 is a JFrame
  // 선언부
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[1][3];
  // this는 사용되는 클래스 영역에서 선언된 클래스를 카리킨다
  // 그러면 여기서는 DeptTable1 타입인 것
  // 그런데 DefaultTableModel은 자바에서 제공되는 클래스이다(생성자도 정해져 있음)
  // 생성자는 메소드 오버로딩 규칙을 따른다(파라미터의 개수나 타입이 달라야함)
  // this를 파라미터에 넣는다면, 제공되는 생성자에 없음 -> 결국 사용 못함 -> 컴파일 에러(문법에러 발생)
  DefaultTableModel dmt_dept = new DefaultTableModel(datas, header); // DefaultTableModel 생성자 호출
  JTable jtb_dept = new JTable(dmt_dept);
  JScrollPane jsp_dept = new JScrollPane(jtb_dept,
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JPanel jp_north = new JPanel();
  JButton jtbn_sel = new JButton("선택");
  JButton jtbn_ins = new JButton("입력");
  JButton jtbn_upd = new JButton("수정");
  JButton jtbn_del = new JButton("삭제");

  // 생성자
  public DeptTable1() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
    // 버튼 색 설정
    jtbn_sel.setBackground(new Color(158, 9, 9));
    jtbn_sel.setForeground(Color.WHITE);
    jtbn_ins.setBackground(new Color(19, 99, 57));
    jtbn_ins.setForeground(Color.WHITE);
    jtbn_upd.setBackground(new Color(54, 54, 54));
    jtbn_upd.setForeground(Color.WHITE);
    jtbn_del.setBackground(new Color(7, 84, 170));
    jtbn_del.setForeground(Color.WHITE);
    // 버튼 추가
    jp_north.add(jtbn_sel);
    jp_north.add(jtbn_ins);
    jp_north.add(jtbn_upd);
    jp_north.add(jtbn_del);
    // this(상속받은 JFrame)에 추가
    this.add("North", jp_north);
    this.add("Center", jsp_dept);
    this.setTitle("부서관리 시스템 Ver1.0");
    this.setSize(500, 400);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new DeptTable1();
  }
}