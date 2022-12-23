package dev_java.week4;

import java.util.Vector;

public class Mother {
  Money m = new Money(10000);

  public static void main(String[] args) {
    Vector<Mother> v = new Vector<>();
    Mother m1 = new Mother();
    v.add(m1);
    v.get(0).m.setMoney(20000);

    Mother m2 = new Mother();
    v.add(m2);
    v.get(1).m.setMoney(25000);
    v.get(1).m.pay(7000);

    Mother m3 = new Mother();
    v.add(m3);
    v.get(2).m.setMoney(30000);

    // for (Mother m : v) {
    // System.out.println(m);
    // }
    // System.out.println();

    for (int i = 0; i < v.size(); i++) {
      Mother mot = v.get(i);
      System.out.println(mot.m.getMoney());
    }
  }
}