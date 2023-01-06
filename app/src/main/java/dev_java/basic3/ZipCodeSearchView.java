package dev_java.basic3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dev_java.util.DBConnectionMgr;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ZipCodeSearchView extends JFrame implements ItemListener, FocusListener, ActionListener, MouseListener {
  // 선언부
  // 사용자가 선택한 zdo
  String zdo = null;
  // 사용자가 선택한 sigu
  String sigu = null;
  // 사용자가 선택한 dong
  String dong = null;

  // DB에서 가져온 zdos[]
  String[] zdos = null;
  // 사DB에서 가져온 sigus[]
  String[] sigus = null;
  // DB에서 가져온 dongs[]
  String[] dongs = null;
  // 중분휴(sigu), 소분류(dong)
  String totals[] = { "전체" };
  // 북쪽에 붙이는 속지 패널 - 콤보박스3개, JTextfield, JButton 붙임
  // FlowLayout-배치역할, 중앙에서 좌우로 펼쳐지면서 배치가 됨
  // JPanel jp_north = new JPanel(); // 디폴트 레이아웃이 FlowLayout
  JPanel jp_north = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 생성자를 이용해 위치를 왼쪽으로 바꿈
  JComboBox jcb_zdo = null;
  JComboBox jcb_sigu = null;
  JComboBox jcb_dong = null;
  //////////////////// [[DB 연동 시작]] ////////////////////
  // 물리적으로 떨어져있는 오라클 서버에 접속하는데 필요한 공통 코드
  DBConnectionMgr dbMgr = new DBConnectionMgr(); // Driverclass, 커넥션정보가 들어있음
  Connection con = null; // 인터페이스
  PreparedStatement pstmt = null; // 인터페이스 - 동적쿼리처리
  ResultSet rs = null; // 오라클서버의 커서를 조작하는 인터페이스 - next(), previous() 제공
  //////////////////// [[DB 연동 끝]] ////////////////////

  // 동이름을 입력받는 텍스트필드와 조회버튼 추가
  // 생성자 파라미터 자리를 이용하면 추가적인 메소드 호출 없이도 해당화면에대한
  // 추가적인 초기화 작업이 가능하니까 코드의 양을 줄일 수 있다
  // 이른 인스턴스화이다
  JTextField jtf_search = new JTextField("동이름을 입력하세요", 20);
  JButton jbtn_search = new JButton("조회");

  // 테이블 생성
  String[] cols = { "우편번호", "주소" };
  String[][] data = new String[0][3];
  DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
  JTable jtb_zipcode = new JTable(dtm_zipcode);
  JTableHeader jth_zipcode = jtb_zipcode.getTableHeader();
  JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

  // 멤버십 선언
  Membership membership = null;

  // 생성자
  public ZipCodeSearchView() {
    jtf_search.addFocusListener(this);
    jtf_search.addActionListener(this);
    jbtn_search.addActionListener(this);
    zdos = getZDOList();
    jcb_zdo = new JComboBox<>(zdos);
    jcb_sigu = new JComboBox<>(totals);
    jcb_dong = new JComboBox<>(totals);
    jcb_zdo.addItemListener(this);
    jcb_sigu.addItemListener(this);
    jcb_dong.addItemListener(this);
    jtb_zipcode.addMouseListener(this);
  }

  public ZipCodeSearchView(Membership membership) {
    // this 뒤에 괄호가 있으면 자기자신의 디폴트 생성자 호출
    this(); // 나 자신의 디폴트 생성자 호출
    this.membership = membership;
    this.initDisplay();
  }

  // 대분류 정보 초기화에 필요한 DB조회하기 구현
  public String[] getZDOList() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT '전체' ZDO FROM DUAL ");
    sql.append("UNION ALL ");
    sql.append("SELECT zdo ");
    sql.append("  FROM (  SELECT DISTINCT (ZDO) ZDO ");
    sql.append("    FROM zipcode_t ");
    sql.append("    ORDER BY ZDO ASC)");
    try {
      // con의 주소번지가 확인되면 오라클서버와 연결통로가 확보된 것
      con = dbMgr.getConnection();
      pstmt = con.prepareStatement(sql.toString());
      // 오라클에서 생성된 테이블의 커서 디폴트위치는 항상 isTop이다
      rs = pstmt.executeQuery();
      Vector<String> v = new Vector<>();
      while (rs.next()) {
        String zdo = rs.getString("zdo");
        v.add(zdo);
      }
      zdos = new String[v.size()];
      v.copyInto(zdos);
    } catch (SQLException se) {
      System.out.println(se.toString());
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // 사용한 자원 반납하기 - 생성된 역순으로 할 것
        // 생략해도 언젠가 반납은 이루어짐, 명시적으로 반납처리 권장
        // 왜냐하면 오라킁 서버에서 커넥션을 강제로 종료시켜버리니까
        dbMgr.freeConnection(con, pstmt, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return zdos;
  } // end of getZDOList

  // 중분류 정보 초기화에 필요한 DB조회하기 구현
  public String[] getSIGUList(String zdo) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT '전체' sigu FROM DUAL ");
    sql.append("UNION ALL ");
    sql.append("SELECT sigu ");
    sql.append("  FROM (  SELECT DISTINCT (sigu) sigu ");
    sql.append("    FROM zipcode_t ");
    sql.append("    WHERE zdo = ? ");
    sql.append("    ORDER BY sigu ASC)");
    try {
      con = dbMgr.getConnection();
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, zdo);
      rs = pstmt.executeQuery();
      Vector<String> v = new Vector<>(); // copyInto() 사용하기위해 벡터사용
      while (rs.next()) {
        String sigu = rs.getString("sigu");
        v.add(sigu);
      }
      // sigu콤보박스에 들어갈 배열 생성하기
      sigus = new String[v.size()];
      // 벡터에 들어있는 값 String 배열에 복사하기
      v.copyInto(sigus);
    } catch (SQLException se) {
      System.out.println(se.toString());
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        dbMgr.freeConnection(con, pstmt, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sigus;
  }

  // 소분류 정보 초기화에 필요한 DB조회하기 구현
  public String[] getDONGList(String sigu) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT '전체' DONG FROM DUAL ");
    sql.append("UNION ALL ");
    sql.append("SELECT DONG ");
    sql.append("  FROM (  SELECT DISTINCT (DONG) DONG ");
    sql.append("    FROM zipcode_t ");
    sql.append("    WHERE sigu = ? ");
    sql.append("    ORDER BY DONG ASC) ");
    try {
      con = dbMgr.getConnection();
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, sigu);
      rs = pstmt.executeQuery();
      Vector<String> v = new Vector<>();
      while (rs.next()) {
        String dong = rs.getString("dong");
        v.add(dong);
      }
      dongs = new String[v.size()];
      v.copyInto(dongs);
    } catch (SQLException se) {
      System.out.println(se.toString());
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        dbMgr.freeConnection(con, pstmt, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dongs;
  }

  // 화면처리부
  public void initDisplay() {
    jth_zipcode.setBackground(Color.orange);
    jth_zipcode.setFont(new Font("맑은고딕", Font.BOLD, 15));
    jth_zipcode.getColumnModel().getColumn(0).setPreferredWidth(100); // 우편번호 간격
    jth_zipcode.getColumnModel().getColumn(1).setPreferredWidth(500); // 주소 간격
    // 그리드 색상 설정
    jtb_zipcode.setGridColor(Color.red);
    // 윈도우창 닫기 버튼 - 자원 회수하기
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jp_north.add(jcb_zdo);
    jp_north.add(jcb_sigu);
    jp_north.add(jcb_dong);
    jp_north.add(jtf_search);
    jp_north.add(jbtn_search);
    this.add("North", jp_north);
    this.add("Center", jsp_zipcode);
    this.setSize(630, 400);
    this.setVisible(false);
  }

  // 조회버튼 눌렀을 때 새로고침
  public void refreshData(String zdo, String dong) {
    System.out.println("refreshData 호출 성공");
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT zipcode, address ");
    sql.append("  FROM zipcode_t ");
    sql.append("  WHERE 1 = 1 ");
    // zod가 존재할 경우
    if (zdo != null && zdo.length() > 0) { // 빈 문자열이 아닌 것도 필터링
      sql.append("    AND zdo = ? ");
    }
    // dong이 존재할 경우
    if (dong != null && dong.length() > 0) {
      sql.append("    AND dong LIKE ? || '%'");
    }
    int i = 1;
    try {
      con = dbMgr.getConnection(); // 오라클 서버와 연결
      // 들어있는 타입과 형전환이 잘못 선택되면 ClassCastingException 발생 가능
      pstmt = con.prepareStatement(sql.toString()); // 들어있는 타입이 String이니까 형변환 문제없음
      if (zdo != null && zdo.length() > 0) {
        pstmt.setString(i++, zdo);
      }
      if (dong != null && dong.length() > 0) {
        pstmt.setString(i++, dong);
      }
      // 입력, 수정, 삭제인 경우에는 executeUpdate()를 사용하고 리턴타입은 int
      // 조회인 경우에는 executeQuery()를 사용하고 리턴타입은 ResultSet
      // 테이블을 생성할 때는 execute()를 사용함
      // 업무가 바뀌더라도 변하는 건 테이블명과 컬럼명만 변함 -> 다른건 그대로 재사용가능
      // -> ORM솔루션(myBatis) -> JPA기술(Hibernate-쿼리문이 없음) 출현, 활용
      rs = pstmt.executeQuery();
      List<Map<String, Object>> zipList = new ArrayList<>();
      Map<String, Object> rMap = null;
      while (rs.next()) {
        rMap = new HashMap<>();
        rMap.put("zipcode", rs.getString("zipcode"));
        rMap.put("address", rs.getString("address"));
        zipList.add(rMap);
      }
      // 컬렉션에서 제공하는 클래스는 주소번지를 출력하더라도 그 구조안에 있는 값들이 출력됨
      System.out.println(zipList);
      // 화면 처리하기 - 테이블 새로고침하기
      // 조회결과가 나온 경우
      if (zipList.size() > 0) {
        // 조회를 연속하여 요청할 경우 기존에 조회된 화면은 지워주기
        while (dtm_zipcode.getRowCount() > 0) { // JTable은 양식일 뿐, 실제데이터는 DefaultTableModel
          dtm_zipcode.removeRow(0);
        } // end of while
        // 새로 조회된 결과 출력
        for (int x = 0; x < zipList.size(); x++) {
          Map<String, Object> rMap2 = zipList.get(x);
          Vector<String> oneRow = new Vector<>();
          oneRow.add(0, rMap2.get("zipcode").toString());
          oneRow.add(1, rMap2.get("address").toString());
          dtm_zipcode.addRow(oneRow);
        } // end of for
      }
    } catch (SQLException se) {
      System.out.println(se.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 사용한 자원은 반드시 명시적으로 반납할 것(안하면 JVM이 언젠가는 해줌)
      // 그 시간을 앞당기는 코드
      dbMgr.freeConnection(con, pstmt, rs);
    }
  } // end of refreshData()

  // 메인메소드
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    ZipCodeSearchView zcsv = new ZipCodeSearchView();
    zcsv.initDisplay();
  }

  @Override
  public void itemStateChanged(ItemEvent ie) {
    // 이벤트가 감지되는 소스 가져오기
    Object obj = ie.getSource();
    // ZDO 콤보박스인지 확인
    if (obj == jcb_zdo) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("선택한 ZDO: " + zdos[jcb_zdo.getSelectedIndex()]);
        zdo = zdos[jcb_zdo.getSelectedIndex()];
        sigus = getSIGUList(zdo);
        // 대분류가 경정이 되었을 때 sigus를 초기화 해줘야 함
        // 기존에 디폴트로 전체 상수값을 널어두었으니 이것을 삭제하고
        // 새로운 DB서버에서 읽어온 값으로 아이템을 추가해야한다.
        jcb_sigu.removeAllItems();
        for (int i = 0; i < sigus.length; i++) {
          jcb_sigu.addItem(sigus[i]);
        }
      }
    }
    // sigu 콤보박스인지 확인
    else if (obj == jcb_sigu) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("선택한 SIGU: " + sigus[jcb_sigu.getSelectedIndex()]);
        sigu = sigus[jcb_sigu.getSelectedIndex()];
        dongs = getDONGList(sigu);
        jcb_dong.removeAllItems();
        for (int i = 0; i < dongs.length; i++) {
          jcb_dong.addItem(dongs[i]);
        }
      }
    }
    // dong 콤보박스인지 확인
    else if (obj == jcb_dong) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("선택한 DONG: " + dongs[jcb_dong.getSelectedIndex()]);
        if (!"전체".equals(dongs[jcb_dong.getSelectedIndex()])) {
          jtf_search.setText(dongs[jcb_dong.getSelectedIndex()]);
        }
      }
    }
  }

  @Override
  public void focusGained(FocusEvent e) {
    if (e.getSource() == jtf_search) {
      jtf_search.setText("");
    }
  }

  // 아래의 메소드는 구현할 필요가 없지만 지우면 에러 발생 -> 추상메소드니까
  // 인터페이스를 implements하면 반드시 구현체 클래스가 되어야하므로
  // 인터페이스가 소지한 모든 추상메소드를 구현해야한다.
  @Override
  public void focusLost(FocusEvent e) {
    // JVM은 중괄호로만 묶여있어도 구현으로 본다
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    // 조회버튼을 눌렀을 때
    if (jbtn_search == obj || jtf_search == obj) {
      String myDong = jtf_search.getText();
      refreshData(zdo, myDong);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // 더블클릭을 했을 때
    if (e.getClickCount() == 2) {
      // JTable에서 사용자가 선택한 로우의 index값을 담기
      int index = jtb_zipcode.getSelectedRow(); // 한 개 선택
      // int[] index = jtb_zipcode.getSelectedRows(); // 여러 개 선택
      for (int i = 0; i < dtm_zipcode.getRowCount(); i++) {
        if (jtb_zipcode.isRowSelected(i)) {
          String address = dtm_zipcode.getValueAt(i, 1).toString();
          membership.jtf_zipcode.setText(String.valueOf(dtm_zipcode.getValueAt(i, 0)));
          membership.jtf_address.setText(address);
        }
      }
      dispose();
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }
}