package dev_java.week4;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTable7Dialog_1 extends JDialog implements ActionListener {
  // 선언부
  DeptTable7_1 dt7 = null;
  JPanel jp_center = new JPanel();
  JScrollPane jsp_center = new JScrollPane(jp_center);
  JPanel jp_south = new JPanel();
  JLabel jlb_deptNo = new JLabel("부서번호");
  JTextField jtf_deptNo = new JTextField(10);
  JLabel jlb_deptName = new JLabel("부서명");
  JTextField jtf_deptName = new JTextField(20);
  JLabel jlb_deptLoc = new JLabel("지역");
  JTextField jtf_deptLoc = new JTextField(20);
  JButton jbtn_check = new JButton("중복검사");
  // jp_south속지에 버튼 붙임
  JButton jbtn_save = new JButton("저장");
  JButton jbtn_close = new JButton("닫기");
  JButton jbtn_sample = new JButton("자동입력");
  // DeptVO 선언
  DeptVO pdVO = null;

  // 생성자
  public JTable7Dialog_1(DeptTable7_1 dt7) {
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
    jbtn_check.setBounds(210, 20, 90, 20);
    jlb_deptName.setBounds(20, 45, 100, 20);
    jtf_deptName.setBounds(120, 45, 150, 20);
    jlb_deptLoc.setBounds(20, 70, 100, 20);
    jtf_deptLoc.setBounds(120, 70, 150, 20);
    jp_center.add(jlb_deptNo);
    jp_center.add(jtf_deptNo);
    jp_center.add(jbtn_check);
    jp_center.add(jlb_deptName);
    jp_center.add(jtf_deptName);
    jp_center.add(jlb_deptLoc);
    jp_center.add(jtf_deptLoc);
    jp_south.add(jbtn_save);
    jp_south.add(jbtn_close);
    jp_south.add(jbtn_sample);
    jbtn_save.addActionListener(this);
    jbtn_close.addActionListener(this);
    jbtn_sample.addActionListener(this);
    jbtn_check.addActionListener(this);
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

  // 아래 메소드는 DeptTable7_1에서 호출됨
  // actionPerformed에서 이벤트(입력, 수정, 상세보기)가 발생되면 호출됨
  public void set(String title, boolean isView, DeptVO pdVO, boolean isEdit) {
    this.setTitle(title);
    this.setVisible(isView);
    this.pdVO = pdVO;
    setValue(pdVO);
    setEditable(isEdit);
  }

  // 입력 혹은 수정일때는 true로 처리하고
  // 상세보기일때는 false를 주어서 read only로 만든다
  private void setEditable(boolean isEdit) {
    jtf_deptNo.setEditable(isEdit);
    jtf_deptName.setEditable(isEdit);
    jtf_deptLoc.setEditable(isEdit);
    jbtn_sample.setVisible(isEdit);
    jbtn_save.setVisible(isEdit);
    jbtn_check.setVisible(isEdit);
  }

  public void setValue(DeptVO pdVO) {
    // 입력을 위한 윈도우 설정-모든 값을 빈문자열로 세팅
    // 상세조회, 수정시는 받은 값으로 세팅
    if (pdVO == null) {
      setDeptNo("");
      setDeptName("");
      setDeptLoc("");
    } else {
      setDeptNo(String.valueOf(pdVO.getDeptNo()));
      setDeptName(pdVO.getDeptName());
      setDeptLoc(pdVO.getDeptLoc());
    }
  } // end of setValue

  // 메인
  public static void main(String[] args) {
    new JTable7Dialog_1(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_save) {
      // pdVO가 존재하면 수정모드, 그렇지 않으면 입력모드
      // 다이얼로그 화면에서 저장버튼 하나로 입력, 수정처리
      // 부모창에서 버튼이 눌려졌을때 set메소드 호출하는데
      // 입력이면 세번째 파라미터에 null을 입력
      // 수정이면 JTable에 선택된 로우의 인덱스 추출해서
      // 세번째 파라미터에null 대신 입력한다
      if (pdVO != null) { // 수정모드
        for (int i = 0; i < DeptTable7_1.vData.size(); i++) {
          DeptVO comVO = DeptTable7_1.vData.get(i);
          // dt7에서 받아온 부서번호와 벡터에서 꺼낸 부서번호가 같은가
          if (pdVO.getDeptNo() == comVO.getDeptNo()) {
            DeptVO updVO = DeptVO.builder().deptNo(Integer.parseInt(getDeptNo())).deptName(getDeptName())
                .deptLoc(getDeptLoc()).build();
            DeptTable7_1.vData.remove(i);
            DeptTable7_1.vData.add(i, updVO);
            break;
          }
        }
        dt7.refreshData();
        this.dispose();

      } else { // 입력모드
        DeptVO insVO = DeptVO.builder().deptNo(Integer.parseInt(jtf_deptNo.getText())).deptName(jtf_deptName.getText())
            .deptLoc(jtf_deptLoc.getText()).build();
        System.out.println(insVO.getDeptNo() + ", " + insVO.getDeptName() + ", " + insVO.getDeptLoc());
        // System.out.println("before: " + DeptTable7_1.vData.size());
        DeptTable7_1.vData.add(insVO);
        // System.out.println("after: " + DeptTable7_1.vData.size());
        dt7.refreshData();
        this.dispose();
      } // end of save
    } else if (obj == jbtn_sample) {
      setDeptNo("30");
      setDeptName("운영부");
      setDeptLoc("세종");
    } else if (obj == jbtn_check) {
      boolean isOk = true;
      try {
        for (int i = 0; i < DeptTable7_1.vData.size(); i++) {
          DeptVO comVO = DeptTable7_1.vData.get(i);
          if (Integer.parseInt(jtf_deptNo.getText()) == comVO.getDeptNo()) {
            JOptionPane.showMessageDialog(this, "중복된 부서 번호입니다!", "중복확인 결과", JOptionPane.WARNING_MESSAGE, null);
            isOk = false;
          }
        }
        if (jtf_deptNo.getText().isEmpty()) {
          JOptionPane.showMessageDialog(this, "값을 입력해주세요.", "입력값 없음", JOptionPane.ERROR_MESSAGE, null);
        } else if (isOk) {
          JOptionPane.showMessageDialog(this, "중복되지 않은 부서번호입니다.", "중복확인 결과", JOptionPane.INFORMATION_MESSAGE, null);
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "값을 입력해주세요.", "입력값 없음", JOptionPane.ERROR_MESSAGE, null);
      }
    } else if (obj == jbtn_close) {
      this.dispose();
    }
  }
}