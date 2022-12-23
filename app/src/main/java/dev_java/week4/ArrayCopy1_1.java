package dev_java.week4;

import java.util.Arrays;

public class ArrayCopy1_1 {

  public static void main(String[] args) {
    ArrayCopy1 ac1 = new ArrayCopy1();
    System.out.println(Arrays.toString(ac1.fruit));
    System.out.println(Arrays.toString(ac1.fruit2));
    ac1.fruit2 = new String[] { "파인애플", "키위" };
    System.out.println(ac1.fruit2[1]); // NullPointerException
  }
}