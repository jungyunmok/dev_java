package dev_java.week4;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTable7Dialog extends JDialog implements ActionListener {
  // 선언부
  DeptTable7 dt7 = null;
  JPanel jp_center = new JPanel();
  JScrollPane jsp_center = new JScrollPane(jp_center);
  JPanel jp_south = new JPanel();
  JLabel jlb_deptNo = new JLabel("부서번호");
  JTextField jtf_deptNo = new JTextField(10);
  JLabel jlb_deptName = new JLabel("부서명");
  JTextField jtf_deptName = new JTextField(20);
  JLabel jlb_deptLoc = new JLabel("지역");
  JTextField jtf_deptLoc = new JTextField(20);
  // jp_south속지에 버튼 붙임
  JButton jbtn_save = new JButton("저장");
  JButton jbtn_close = new JButton("닫기");
  // String[] 선언
  String[] oneRow = null;

  // 생성자
  public JTable7Dialog(DeptTable7 dt7) {
    this.dt7 = dt7;
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    // 레이아웃 설정
    jp_center.setLayout(null);
    jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
    jlb_deptNo.setBounds(20, 20, 80, 20);
    jtf_deptNo.setBounds(120, 20, 80, 20);
    jlb_deptName.setBounds(20, 45, 100, 20);
    jtf_deptName.setBounds(120, 45, 150, 20);
    jlb_deptLoc.setBounds(20, 70, 100, 20);
    jtf_deptLoc.setBounds(120, 70, 150, 20);
    jp_center.add(jlb_deptNo);
    jp_center.add(jtf_deptNo);
    jp_center.add(jlb_deptName);
    jp_center.add(jtf_deptName);
    jp_center.add(jlb_deptLoc);
    jp_center.add(jtf_deptLoc);
    jp_south.add(jbtn_save);
    jp_south.add(jbtn_close);
    jbtn_save.addActionListener(this);
    jbtn_close.addActionListener(this);
    this.add("Center", jsp_center);
    this.add("South", jp_south);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("상세보기");
    this.setSize(400, 360);
    this.setVisible(false);
  }

  // 각 컬럼(부서집합-부서번호, 부서명, 지역)의 값들을
  // 설정하거나 읽어오는 getter/setter 메소드
  public String getDeptNo() {
    return jtf_deptNo.getText();
  }

  public void setDeptNo(String deptNo) {
    jtf_deptNo.setText(deptNo);
  }

  public String getDeptName() {
    return jtf_deptName.getText();
  }

  public void setDeptName(String deptName) {
    jtf_deptName.setText(deptName);
  }

  public String getDeptLoc() {
    return jtf_deptLoc.getText();
  }

  public void setDeptLoc(String deptLoc) {
    jtf_deptLoc.setText(deptLoc);
  }

  // 아래 메소드는 DeptTable7에서 호출됨
  // actionPerformed에서 이벤트(입력, 수정, 상세보기)가 발생되면 호출됨
  // 메소드의 파라미터 자리는 Call by Value에 의해서 결정됨
  public void set(String title, boolean isView, String[] oneRow) {
    this.setTitle(title);
    this.setVisible(isView);
    this.oneRow = oneRow;
    setValue(oneRow);
  }

  public void setValue(String[] oneRow) {
    // 입력을 위한 윈도우 설정-모든 값을 빈문자열로 세팅
    // 상세조회, 수정시는 배열로 받은 값으로 세팅
    if (oneRow == null) {
      setDeptNo("");
      setDeptName("");
      setDeptLoc("");
    } else {
      setDeptNo(oneRow[0]);
      setDeptName(oneRow[1]);
      setDeptLoc(oneRow[2]);
    }
  } // end of setValue

  // 메인
  public static void main(String[] args) {
    new JTable7Dialog(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_save) {
      // oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드
      if (oneRow != null) { // 수정모드
        int index = dt7.jtb_dept.getSelectedRow();
        String[] oneRow = { jtf_deptNo.getText(), jtf_deptName.getText(), jtf_deptLoc.getText() };
        DeptTable7.vData.set(index, oneRow);
        dt7.refreshData();
        this.dispose();

      } else { // 입력모드
        String[] oneRow = { getDeptNo(), getDeptName(), getDeptLoc() };
        System.out.println(oneRow[0] + ", " + oneRow[1] + ", " + oneRow[2]);
        // System.out.println("before: " + DeptTable7.vData.size());
        DeptTable7.vData.add(oneRow);
        // System.out.println("after: " + DeptTable7.vData.size());
        dt7.refreshData();
        this.dispose();
      }
    } else if (obj == jbtn_close) {
      this.dispose();
    }
  }
}