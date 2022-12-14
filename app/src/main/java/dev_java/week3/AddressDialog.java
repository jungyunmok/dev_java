package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class AddressDialog implements ActionListener {
  JDialog jDg = new JDialog();
  AddressBook aBook = null;

  public AddressDialog(AddressBook aBook) {
    this.aBook = aBook;
  }

  public void setDialog(boolean isOk) {
    jDg.setSize(400, 300);
    jDg.setVisible(isOk);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == aBook.jbtn_read) {
      setDialog(true);
      jDg.setTitle("조회");
    } else if (obj == aBook.jbtn_write) {
      setDialog(true);
      jDg.setTitle("입력");
    } else if (obj == aBook.jbtn_update) {
      setDialog(true);
      jDg.setTitle("수정");
    } else if (obj == aBook.jbtn_info) {
      setDialog(true);
      jDg.setTitle("상세보기");
    }
  }
}