package dev_java.week3.tables;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
// ActionListener-인터페이스(단독으로 인스턴스화가 불가, 구현체 클래스가 필요함)
// 추상 메소드를 선언하고있다.
// ActionListener al = new DeptTable3(); -> 선언부와 생성부가 다를 수 있다(이럴때만 다형성이 가능함)
// 선언부와 생성부가 다르다 -> 동일한 메소드를 호출했는데 다른 기능이 처리되었다(다형성)
// 추상클래스도 구현체클래스가 필요하다 - this
// Duck myDuck = new WoodDuck(); -> myDuck.fly(); -> 비행x
// Duck herDuck = new RubberDuck(); -> herDuck.fly(); -> 비행x
// Duck himDuck = new MallardDuck(); -> himDuck.fly(); -> 비행가능!
public class DeptTable3 extends JFrame implements ActionListener { // DeptTable1 is a JFrame
  // 선언부
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[0][3]; // 디폴트값 null
  // this는 사용되는 클래스 영역에서 선언된 클래스를 카리킨다
  // 그러면 여기서는 DeptTable1 타입인 것
  // 그런데 DefaultTableModel은 자바에서 제공되는 클래스이다(생성자도 정해져 있음)
  // 생성자는 메소드 오버로딩 규칙을 따른다(파라미터의 개수나 타입이 달라야함)
  // this를 파라미터에 넣는다면, 제공되는 생성자에 없음 -> 결국 사용 못함 -> 컴파일 에러(문법에러 발생)
  DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); // DefaultTableModel 생성자 호출
  JTable jtb_dept = new JTable(dtm_dept);
  JScrollPane jsp_dept = new JScrollPane(jtb_dept,
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JPanel jp_north = new JPanel();
  JButton jtbn_sel = new JButton("조회");
  JButton jtbn_ins = new JButton("입력");
  JButton jtbn_upd = new JButton("수정");
  JButton jtbn_del = new JButton("삭제");
  // 부서목록 조회에 들어갈 샘플 데이터 생성
  String[][] depts = {
      { "10", "개발부", "서울" },
      { "20", "인사부", "인천" },
      { "30", "총무부", "부산" }
  };

  // 생성자
  public DeptTable3() {
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
    // 이벤트리스너 연결
    jtbn_sel.addActionListener(this);
    jtbn_ins.addActionListener(this);
    jtbn_upd.addActionListener(this);
    jtbn_del.addActionListener(this);
    // this(상속받은 JFrame)에 추가
    this.add("North", jp_north);
    this.add("Center", jsp_dept);
    this.setTitle("부서관리 시스템 Ver1.0");
    this.setSize(500, 400);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new DeptTable3();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jtbn_sel) { // 조회버튼을 눌렀을 때
      while (dtm_dept.getRowCount() > 0) { // 먼저 원래 있던 것들을 지우기
        dtm_dept.removeRow(0);
      }
      for (int x = 0; x < depts.length; x++) {
        Vector<String> oneRow = new Vector<>(); // 벡터로 한 열씩 담기
        oneRow.add(depts[x][0]); // 부서번호
        oneRow.add(depts[x][1]); // 부서명
        oneRow.add(depts[x][2]); // 지역
        dtm_dept.addRow(oneRow);
      }
      for (int i = 0; i < depts.length; i++) {
        for (int j = 0; j < depts[i].length; j++) {
          // System.out.print(depts[i][j] + " "); // ln을 빼서 i인덱스의 j를 연이어 출력
          dtm_dept.setValueAt("여기", 1, 1); // 내용 수정 setValueAt
          System.out.println(dtm_dept.getValueAt(i, j)); // 내용 출력
        } // end of inner for문
        System.out.println();
      } // end of outter for문
      // DefaultTableModel에 데이터 초기화하기
    } else if (obj == jtbn_ins) {
      String[] temp = { "", "", "" };
      Vector<Object> oneRow = new Vector<>();
      oneRow.add(temp[0]);
      dtm_dept.addRow(oneRow);
    } else if (obj == jtbn_upd) {

    } else if (obj == jtbn_del) {
      int indexR = jtb_dept.getSelectedRow(); // 선택한 row
      int indexC = jtb_dept.getSelectedColumn(); // 선택한 column

      // Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
      // System.out.println(deptno);
      String deptinfo = (String) dtm_dept.getValueAt(indexR, indexC);
      System.out.println(deptinfo);

      // 하나씩 지우기
      dtm_dept.setValueAt("", indexR, indexC);

      // 한 행씩 지우기
      // dtm_dept.removeRow(indexR);
    }
  }
}