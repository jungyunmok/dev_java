package dev_java.week3;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

public class AddressBook_2 implements ActionListener {
  // 선언부
  // 이미지 경로 선언
  String imgPath = "D:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\address\\";
  // 툴바 및 타이틀 이미지 설정
  ImageIcon titlIcon = new ImageIcon(imgPath + "memo.png");
  JToolBar jtb = new JToolBar();
  // JFrame 생성
  JFrame jf_addr = new JFrame();
  // 메뉴바 구성하기
  JMenuBar jmb = new JMenuBar();
  JMenu jm_file = new JMenu("File");
  JMenuItem jmi_db = new JMenuItem("DB연동확인");
  JMenuItem jmi_all = new JMenuItem("전체조회");
  JSeparator js_exit = new JSeparator(); // 메뉴 분리선
  JMenuItem jmi_exit = new JMenuItem("종료");
  JMenu jm_edit = new JMenu("Edit");
  JMenuItem jmi_ins = new JMenuItem("입력");
  JMenuItem jmi_upd = new JMenuItem("수정");
  JMenuItem jmi_del = new JMenuItem("삭제");
  JMenuItem jmi_read = new JMenuItem("상세보기");
  // 버튼만들기
  JButton jbtn_ins = new JButton();
  JButton jbtn_upd = new JButton();
  JButton jbtn_del = new JButton();
  JButton jbtn_read = new JButton();
  // BorderLayout 중앙에 테이블(주소록 목록) 추가하기
  // JTable Header에 들어갈 문자열 선언
  String[] header = { "번호", "이름", "H.P" };
  // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요함
  String[][] datas = new String[3][3];
  // JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스를 선언함
  // JTable에 보여지는 실제 데이터는 DefaultTableModel클래스를 통해 제어해야함을 의미
  DefaultTableModel dtm_addr = new DefaultTableModel(datas, header);
  // 데이터셋을 JTable 생성시 파라미터로 매칭하기
  JTable jtb_addr = new JTable(dtm_addr);
  // DefaultTableModel의 로우수가 많아지는 경우 스크롤바를 추가해야함
  // JScrollPane은 스크롤바를 품고있는 일종의 속지로 생각함
  // 첫번째 파라미터는 양식을 가진 JTable이고 두번째는 수직 스크롤바 정책, 세번쨰는 수평 스크롤바 정책을 정해줌
  JScrollPane jsp_addr = new JScrollPane(jtb_addr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  AddressDialog_2 aDialog = new AddressDialog_2();

  // 생성자
  public AddressBook_2() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    jm_file.setMnemonic('F'); // F에 밑줄, alt F로 선택가능
    jm_edit.setMnemonic('E'); // E에 밑줄, alt E로 선택가능
    jbtn_ins.setIcon(new ImageIcon(imgPath + "new.gif"));
    jbtn_ins.setToolTipText("입력");
    jbtn_upd.setIcon(new ImageIcon(imgPath + "update.gif"));
    jbtn_upd.setToolTipText("수정");
    jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
    jbtn_del.setToolTipText("삭제");
    jbtn_read.setIcon(new ImageIcon(imgPath + "detail.gif"));
    jbtn_read.setToolTipText("상세보기");

    // JPanel은 FlowLayout이 기본값인데 사용자 정의 크기와 위치를 위해
    // // 레이아웃을 뭉갠다.(null로 초기화 후 좌표값으로 조정)
    // jp_north.setLayout(null);
    // jbtn_all.setBounds(20, 20, 120, 30);
    // 기본 왼쪽정렬
    // jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
    // 버튼추가
    jtb.add(jbtn_ins);
    jtb.add(jbtn_upd);
    jtb.add(jbtn_del);
    jtb.add(jbtn_read);
    // 이벤트 소스와 이벤트 핸들러 클래스 매칭
    jmi_all.addActionListener(this);
    jmi_exit.addActionListener(this);
    jmi_ins.addActionListener(this);
    jmi_upd.addActionListener(this);
    jmi_read.addActionListener(this);
    jbtn_ins.addActionListener(this);
    jbtn_upd.addActionListener(this);
    jbtn_del.addActionListener(this);
    jbtn_read.addActionListener(this);
    // 창닫기 버튼 클릭시 종료처리
    jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // JFrame에 추가하기
    jf_addr.add("North", jtb);
    jf_addr.add("Center", jsp_addr);
    jf_addr.setTitle("주소록 ver 1.0");
    jmb.add(jm_file);
    jm_file.add(jmi_db);
    jm_file.add(jmi_all);
    jm_file.add(js_exit);
    jm_file.add(jmi_exit);
    jmb.add(jm_edit);
    jm_edit.add(jmi_ins);
    jm_edit.add(jmi_upd);
    jm_edit.add(jmi_del);
    jm_edit.add(jmi_read);
    jf_addr.setJMenuBar(jmb);
    jf_addr.setIconImage(titlIcon.getImage()); // AddressBook 팝업창 아이콘 바꾸기
    aDialog.jDg.setIconImage(titlIcon.getImage()); // AddressDialog 팝업창 아이콘 바꾸기
    jf_addr.setSize(500, 450);
    jf_addr.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new AddressBook_2();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jmi_all) { // 전체조회를 누를 경우
      String members[][] = {
          { "1", "이순신", "010-1111-2222" },
          { "2", "강감찬", "010-3333-4444" },
          { "3", "김춘추", "010-5555-6666" }
      };
      // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제하고 그 뒤에 출력함
      while (dtm_addr.getRowCount() > 0) {
        dtm_addr.removeRow(0);
      }
      for (int i = 0; i < members.length; i++) {
        Vector<String> oneRow = new Vector<>(); // <>은 제네릭
        oneRow.add(members[i][0]);
        oneRow.add(members[i][1]);
        oneRow.add(members[i][2]);
        dtm_addr.addRow(oneRow);
      }
      // 익명 클래스 문법사용-자바 람다식, 자바스크립트 Arrow Function문법, 코틀린 문법과 유사
      // 스크롤바가 항상 아래있도록 설정
      jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
        public void adjustmentValueChanged(AdjustmentEvent e) {
          JScrollBar jsb = (JScrollBar) e.getSource();
          jsb.setValue(jsb.getMaximum());
        }
      });
    } else if (obj == jmi_exit) { // 종료
      // jf_addr.dispose(); // 그 창만 닫음
      System.exit(0); // 전부 다 닫음
    } else if (obj == jbtn_ins || obj == jmi_ins) { // 입력버튼을 누를 경우
      aDialog.setDialodg(jmi_ins.getText(), true);
    } else if (obj == jbtn_upd || obj == jmi_upd) { // 수정버튼을 누를 경우
      aDialog.setDialodg(jmi_upd.getText(), true);
    } else if (obj == jbtn_del || obj == jmi_del) { // 삭제버튼을 누를 경우

    } else if (obj == jbtn_read || obj == jmi_read) { // 상세보기버튼을 누를 경우
      aDialog.setDialodg(jmi_read.getText(), true);
    }
  }
}