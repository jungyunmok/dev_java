package dev_java.week4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev_java.network1.TimeClient;

public class DeptTable7_1 extends JFrame implements ActionListener {
  // 선언부
  // 파라미터의 this는 DeptTable7_1 타입이고 main에서 호출된 생성자로
  // 현재 메모리에 로딩 중인 객체를 가리킨다
  // JTable7Dialog에서 부서번호, 부서명, 지역을 입력한 후 저장버튼을 누르면
  // Vector에 추가하고 추가된 로우를 포함하는 Vector가 부모창에
  // 새로 리프레쉬(재사용>부모클래스에 구현) 되어야 하니까 jtd를 호출해야함
  JTable7Dialog_1 jtd7 = new JTable7Dialog_1(this);
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[0][3];
  DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
  JTable jtb_dept = new JTable(dtm_dept);
  JScrollPane jsp_dept = new JScrollPane(jtb_dept,
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JPanel jp_north = new JPanel();
  JButton jtbn_sel = new JButton("조회");
  JButton jtbn_ins = new JButton("입력");
  JButton jtbn_upd = new JButton("수정");
  JButton jtbn_del = new JButton("삭제");
  JButton jtbn_det = new JButton("상세보기");
  JLabel jlb_timer = new JLabel("현재시간");

  // DeptVO 벡터 선언 및 생성
  static Vector<DeptVO> vData = new Vector<>(); // vData.size() = 0

  // 생성자
  public DeptTable7_1() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    // 타이머 라벨 붙이기
    Thread th = new TimeClient(jlb_timer);
    th.start();
    this.add("South", jlb_timer);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
    // 버튼 색 설정
    jtbn_sel.setBackground(new Color(150, 100, 150));
    jtbn_sel.setForeground(Color.WHITE);
    jtbn_ins.setBackground(new Color(19, 99, 57));
    jtbn_ins.setForeground(Color.WHITE);
    jtbn_upd.setBackground(new Color(7, 84, 170));
    jtbn_upd.setForeground(Color.WHITE);
    jtbn_del.setBackground(new Color(200, 50, 50));
    jtbn_del.setForeground(Color.WHITE);
    jtbn_det.setBackground(new Color(250, 200, 50));
    jtbn_det.setForeground(Color.WHITE);
    // 버튼 추가
    jp_north.add(jtbn_sel);
    jp_north.add(jtbn_ins);
    jp_north.add(jtbn_upd);
    jp_north.add(jtbn_del);
    jp_north.add(jtbn_det);
    // 이벤트리스너 연결
    jtbn_sel.addActionListener(this);
    jtbn_ins.addActionListener(this);
    jtbn_upd.addActionListener(this);
    jtbn_del.addActionListener(this);
    jtbn_det.addActionListener(this);
    // this(상속받은 JFrame)에 추가
    this.add("North", jp_north);
    this.add("Center", jsp_dept);
    this.setTitle("부서관리 시스템 Ver1.0");
    this.setSize(500, 400);
    this.setVisible(true);
  }

  // 새로고침-Vector에 담긴것 출력하기
  // 입력, 수정화면에서 저장 버튼을 누르면 Vector에 String[]을 추가하고
  // 그 다이얼로그 화면은 닫히고 부모창은 새로고침 처리한다
  // 다이얼로그 창에서 부모클래스의 refreshData메소드를 호출해야함
  // 그러니 인스턴스화할 때 파라미터에 this를 넘겨서 사용할 수 있도록 할 것(NullPointerException발생하지 않도록)
  public void refreshData() {
    System.out.println("refreshData 호출");
    if (DeptTable7_1.vData.size() <= 0) {
      JOptionPane.showMessageDialog(this, "조회결과가 없습니다.", "WARNING", JOptionPane.ERROR_MESSAGE);
      return; // refreshData() 탈출
    }
    System.out.println("DeptTable7_1: " + vData.size());

    // 입력, 수정 전에 조회된 정보는 삭제함
    while (dtm_dept.getRowCount() > 0) {
      dtm_dept.removeRow(0);
    }

    // 벡터의 크기만큼 반복하면서 dtm_dept 데이터셋에 vData추가
    for (int i = 0; i < vData.size(); i++) {
      DeptVO oneRow = vData.get(i);
      Vector<Object> vOne = new Vector<>();
      vOne.add(oneRow.getDeptNo());
      vOne.add(oneRow.getDeptName());
      vOne.add(oneRow.getDeptLoc());
      dtm_dept.addRow(vOne);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jtbn_sel) { // 조회버튼을 눌렀을 때
      refreshData();

    } else if (obj == jtbn_ins) { // 입력버튼을 눌렀을 때
      jtd7.set("입력", true, null, true);

    } else if (obj == jtbn_upd) { // 수정버튼을 눌렀을 때
      int index = jtb_dept.getSelectedRow();
      if (index == -1) { // -1은 end of file의 의미
        JOptionPane.showMessageDialog(this, "수정을 원하는 부서를 선택하세요.", "불러오기 실패", JOptionPane.ERROR_MESSAGE);
      } else {
        // 어떤 row를 수정할지 확인
        // JTable 목록에서 선택한 로우의 index값을 가져옴
        // 데이터셋객체로 벡터를 사용중이니 벡터에서 꺼낸 값으로 String[] 초기화
        // 테이블의 양식 폼인 JTable 이벤트로 얻어옴
        DeptVO pdVO = vData.get(index);
        jtd7.set("수정", true, pdVO, true);
      }
    } else if (obj == jtbn_del) { // 삭제를 눌렀을 때
      int index = jtb_dept.getSelectedRow();
      if (index == -1) { // -1은 end of file의 의미
        JOptionPane.showMessageDialog(this, "삭제를 원하는 부서를 선택하세요.", "불러오기 실패", JOptionPane.ERROR_MESSAGE);
      } else {
        vData.remove(index);
        refreshData();
      }
    } else if (obj == jtbn_det) { // 상세보기를 눌렀을 때
      int index = jtb_dept.getSelectedRow();
      if (index == -1) {
        JOptionPane.showMessageDialog(this, "상세보기를 원하는 부서를 선택하세요.", "불러오기 실패", JOptionPane.ERROR_MESSAGE);
        return;
      } else {
        DeptVO pdVO = vData.get(index);
        jtd7.set("상세보기", true, pdVO, false);
      }
    }
  }

  // 메인메소드
  public static void main(String[] args) {
    new DeptTable7_1();
  }
}