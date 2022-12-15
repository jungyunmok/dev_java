package dev_java.week3.tables;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DeptTable2 extends JFrame { // DeptTable1 is a JFrame
  // 선언부
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[1][3];
  DefaultTableModel dmt_dept = new DefaultTableModel(datas, header);

  // 생성자
  public DeptTable2() {
    initDisplay();
  }

  public DeptTable2(String title) {
  }

  public DeptTable2(int i) {
  }

  // 화면그리기
  public void initDisplay() {
    this.setTitle("부서관리 시스템 Ver1.0");
    this.setSize(500, 400);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new DeptTable2(null); // String의 디폴트값 null, 2번째 생성자 호출
    new DeptTable2(5); // 3번째 생성자 호출
  }
}